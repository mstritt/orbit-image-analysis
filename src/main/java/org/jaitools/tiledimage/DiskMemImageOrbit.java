
package org.jaitools.tiledimage;

import com.actelion.research.orbit.imageAnalysis.utils.OrbitUtils;
import org.jaitools.CollectionFactory;
import org.jaitools.tilecache.DiskMemTileCache;

import javax.media.jai.TiledImage;
import java.awt.*;
import java.awt.image.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A tiled image class similar to JAI's standard {@code TiledImage} that uses a
 * {@code DiskMemTileCache} to manage its data. Image tiles are cached in memory 
 * and, if the volume of image data is greater than available memory, also on disk
 * as temporary files. When a tile is accessed it is swapped into memory if not 
 * already resident. Thus, very large images can be handled, albeit at the cost of
 * disk I/O.
 * <p>
 * By default, each {@code DiskMemImage} uses its own tile cache but it is also
 * possible for images to share a common tile cache as shown here:
 * <pre><code>
 *     DiskMemImage image1 = new DiskMemImage(...);
 *     image1.useCommonTileCache(true);
 *
 *     DiskMemImage image2 = new DiskMemImage(...);
 *     image2.useCommonTileCache(true);
 *
 *     DiskMemImage image3 = new DiskMemImage(...);
 * </code></pre>
 * In the example above, image1 and image2 will share a common tile cache while
 * image3 will use a separate, exclusive tile cache. You can test whether an
 * image is using the common cache like this:
 * <pre><code>
 *     boolean usingCommonCache = image.isUsingCommonTileCache();
 * </code></pre>
 * The memory capacity of the common cache can be set like this:
 * <pre><code>
 *     long memCapacity = 128 * 1024 * 1024; // 128 Mb
 *     DiskMemImage.getCommonCache().setMemoryCapacity(memCapacity);
 * </code></pre>
 *
 * @see DiskMemTileCache
 * 
 * @author Michael Bedward
 * @since 1.0
 * @version $Id: DiskMemImage.java 1825 2011-06-24 06:18:54Z michael.bedward $
 *
 *
 * Modifications for Orbit: Extend TiledImage, not PlanarImage, skip logging in tile not resident Exception
 * - synchronized WritableRaster getWritableTile
 * - synchronized void releaseWritableTile
 *
 */
public class DiskMemImageOrbit
        extends TiledImage
        implements WritableRenderedImage {

    /**
     * The default memory capacity of the common tile cache in bytes
     * default:  (256L * 1024 * 1024 = 256 Mb)
     */
    public static final long DEFAULT_COMMON_CACHE_SIZE = OrbitUtils.DISK_IMAGE_CACHE;
    
    /** TileCache which will be shared bewtween all Images */
    private static DiskMemTileCache commonCache = null;

    /**
     * Get the common tile cache. This method has the side effect of
     * creating the common cache if it does not already exist (ie. it
     * never returns {@code null}).
     *
     * @return the common tile cache
     *
     * @see #isUsingCommonCache()
     * @see #setUseCommonCache(boolean)
     */
    public static DiskMemTileCache getCommonTileCache() {
        if (commonCache == null) {
            commonCache = createNewCache();
        }
        return commonCache;
    }

    /**
     * Sets a new common cache. If a common cache has already been
     * initialized (either with this method or via {@linkplain #setUseCommonCache})
     * this method does nothing.
     *
     * @param newCache the cache instance to use as the common tile
     *        cache for {@code DiskMemImage} objects ({@code null}
     *        arguments are ignored)
     */
    public static void setCommonTileCache(DiskMemTileCache newCache) {
        if (newCache != null && commonCache == null) {
            commonCache = newCache;
        }
    }

    /**
     * Creates a new tile cache.
     *
     * @return a new instance of {@code DiskMemTileCache}
     */
    private static DiskMemTileCache createNewCache() {
        Map<String, Object> cacheParams = new HashMap<String, Object>();
        cacheParams.put(DiskMemTileCache.KEY_INITIAL_MEMORY_CAPACITY, Long.valueOf(DEFAULT_COMMON_CACHE_SIZE));
        cacheParams.put(DiskMemTileCache.KEY_ALWAYS_DISK_CACHE, Boolean.FALSE);
        DiskMemTileCache cache = new DiskMemTileCache(cacheParams);
        cache.setDiagnostics(false);

        return cache;
    }

    /**
     * The tile cache in use by this image. It may or may not be the 
     * common tile cache. Ahthough this is a {@code protected} field,
     * it is recommended that sub-classes use {@linkplain #getTileCache()}
     * for general purposes.
     */
    protected DiskMemTileCache tileCache;

    /**
     * Defines the valid range of tile x and y coordinates.
     */
    protected Rectangle tileGrid;

    /**
     * A 2D array with dimensions corresponding to the tile grid width
     * and height that records, for each tile, the number of writers
     * that have the tile checked out currently
     */
    protected int[][] numWriters;

    /**
     * The number of tiles that are currently checked out
     * for writing
     *
     * @see #getWritableTileIndices()
     */
    protected int numTilesInUse;

    /**
     * The amount of memory (in bytes) required to hold
     * the data for an image tile
     */
    protected long tileMemorySize;

    /**
     * The set of tile observers currently registered with
     * this image
     */
    protected Set<TileObserver> tileObservers;

    /**
     * Creates a new image with default values for origin (0, 0), 
     * x and y tile offsets (0) and {@code ColorModel}
     * ({@code null}).
     *
     * @param width image width
     * @param height image height
     * @param tileSampleModel a {@code SampleModel} specifying the dimensions
     *        data type etc. for image tiles
     */
    public DiskMemImageOrbit(
            int width, int height,
            SampleModel tileSampleModel) {

        this(0, 0,           // minX, minY
             width, height,
             0, 0,           // tileGridXOffset, tileGridYOffset
             tileSampleModel,
             null            // ColorModel
             );
    }


    /**
     * Creates a new image with default values for origin (0, 0) and
     * tile offsets (0).
     *
     * @param width image width
     * @param height image height
     * @param tileSampleModel the {@code SampleModel}
     * @param colorModel the {@code ColorModel}
     */
    public DiskMemImageOrbit(
            int width, int height,
            SampleModel tileSampleModel,
            ColorModel colorModel) {

        this(0, 0,           // minX, minY
             width, height,
             0, 0,           // tileGridXOffset, tileGridYOffset
             tileSampleModel,
             colorModel
             );
    }


    /**
     * Creates a new image with default values for tile offsets (0)
     * and {@code ColorModel} ({@code null})
     *
     * @param minX x coordinate of the upper-left image pixel
     * @param minY y coordinate of the upper-left image pixel
     * @param width image width
     * @param height image height
     * @param tileSampleModel the {@code SampleModel}
     */
    public DiskMemImageOrbit(
            int minX, int minY,
            int width, int height,
            SampleModel tileSampleModel) {

        this(minX, minY,
             width, height,
             0, 0,           // tileGridXOffset, tileGridYOffset
             tileSampleModel,
             null            // ColorModel
             );
    }


    /**
     * Creates a new image. Sets the {@code ColorModel} to {@code null}
     * 
     * @param minX x coordinate of the upper-left image pixel
     * @param minY y coordinate of the upper-left image pixel
     * @param width image width
     * @param height image height
     * data type etc. for image tiles
     * @param tileGridXOffset x coordinate of the upper-left pixel of the upper-left tile
     * @param tileGridYOffset y coordinate of the upper-left pixel of the upper-left tile
     * @param tileSampleModel the {@code SampleModel}
     */
    public DiskMemImageOrbit(
            int minX, int minY,
            int width, int height,
            int tileGridXOffset, int tileGridYOffset,
            SampleModel tileSampleModel) {

        this(minX, minY,
             width, height,
             tileGridXOffset, tileGridYOffset,
             tileSampleModel,
             null            // ColorModel
             );
    }

    /**
     * Creates a new image.
     *
     * @param minX x coordinate of the upper-left image pixel
     * @param minY y coordinate of the upper-left image pixel
     * @param width image width
     * @param height image height
     * data type etc. for image tiles
     * @param tileGridXOffset x coordinate of the upper-left pixel of the upper-left tile
     * @param tileGridYOffset y coordinate of the upper-left pixel of the upper-left tile
     * @param tileSampleModel the {@code SampleModel}
     * @param colorModel the {@code ColorModel}
     */
    public DiskMemImageOrbit(
            int minX, int minY,
            int width, int height,
            int tileGridXOffset, int tileGridYOffset,
            SampleModel tileSampleModel, ColorModel colorModel) {
        // Manuel: constructor super(ImageLayout...) is only available in PlanarImage, but not in TiledImage.
    	// Instead, we use the super(minX,minY,...) constructor from TiledImage.
    	/*
        super(new ImageLayout(
                minX, minY,
                width, height,
                tileGridXOffset, tileGridYOffset,
                tileSampleModel.getWidth(), tileSampleModel.getHeight(),
                tileSampleModel, colorModel),

                null, null);  // sources, properties
		*/
    	super(minX,minY,width,height,tileGridXOffset,tileGridYOffset,tileSampleModel,colorModel);

        tileGrid = new Rectangle(
                getMinTileX(),
                getMinTileY(),
                getMaxTileX() - getMinTileX() + 1,
                getMaxTileY() - getMinTileY() + 1);

        numWriters = new int[tileGrid.width][tileGrid.height];
        numTilesInUse = 0;

        DataBuffer db = tileSampleModel.createDataBuffer();
        tileMemorySize = DataBuffer.getDataTypeSize(db.getDataType()) / 8L *
                db.getSize() * db.getNumBanks();

        tileObservers = CollectionFactory.set();

        // just to remind us that we are deferring creation of
        // the tile cache
        tileCache = null;
    }
    

    /**
     * Gets a tile for reading. Any changes to the tile's data
     * will not be preserved by the cache.
     *
     * @param tileX the tile's column in the tile grid
     * @param tileY the tile's row in the tile grid
     * @return the tile data for reading
     */
    @Override
    public Raster getTile(int tileX, int tileY) {
        Raster r = null;
        if (tileGrid.contains(tileX, tileY)) {
            r = getTileCache().getTile(this, tileX, tileY);
            if (r == null) {
                r = createTile(tileX, tileY);
                getTileCache().add(this, tileX, tileY, r);
            }
        }

        return r;
    }

    /**
     * {@inheritDoc}
     */
    public void addTileObserver(TileObserver to) {
        tileObservers.add(to);
    }

    /**
     * {@inheritDoc}
     */
    public void removeTileObserver(TileObserver to) {
        tileObservers.remove(to);
    }

    /**
     * Checks out a tile for writing. The tile will be unavailable to other
     * callers through this method until it is released via
     * {@linkplain #releaseWritableTile(int, int)}. If this method is
     * called for the same time prior to the tile being released
     * it returns {@code null} and a warning message is logged.
     *
     * @param tileX tile X ordinate
     * @param tileY tile Y ordinate
     * @return the tile data for writing, or {@code null} if the tile
     *         is already checked-out
     */
    public synchronized WritableRaster getWritableTile(int tileX, int tileY) {
        WritableRaster r = null;
        if (tileGrid.contains(tileX, tileY)) {
            numWriters[tileX - tileGrid.x][tileY - tileGrid.y]++ ;
            if (numWriters[tileX - tileGrid.x][tileY - tileGrid.y] == 1) {
                numTilesInUse++ ;
            }

            r = (WritableRaster) getTileCache().getTile(this, tileX, tileY);
            if (r == null) {
                r = createTile(tileX, tileY);
                getTileCache().add(this, tileX, tileY, r);
            }

            for (TileObserver obs : tileObservers) {
                obs.tileUpdate(this, tileX, tileY, true);
            }
        }
        return r;
    }

    /**
     * Releases a tile that was checked out for writing. The cache's disk copy of
     * the tile's data will be refreshed.
     * <p>
     * If the cache no longer has the tile in its memory storage, e.g.
     * because of memory swapping for other tile accesses, the cache
     * will be unable to refresh the tile's data on disk. In this case
     * a warning message is logged.
     * <p>
     * If the tile was not previously checked-out via
     * {@linkplain #getWritableTile(int, int)} a warning message is
     * logged.
     *
     * @param tileX tile X ordinate
     * @param tileY tile Y ordinate
     */
    public synchronized void releaseWritableTile(int tileX, int tileY) {
        if (tileGrid.contains(tileX, tileY)) {
            numWriters[tileX - tileGrid.x][tileY - tileGrid.y]-- ;
            if (numWriters[tileX - tileGrid.x][tileY - tileGrid.y] < 0) {
                Logger.getLogger(
                        DiskMemImageOrbit.class.getName()).log(Level.SEVERE,
                            String.format("Tile %d,%d released more times than it has been checked out",
                                tileX, tileY));

            } else if (numWriters[tileX - tileGrid.x][tileY - tileGrid.y] == 0) {
                numTilesInUse--;
            }

            /*
             * TODO: Consider skipping this step. It is mostly here as a
             * precaution against the cached tile being garbage collected
             * if the system runs very low on memory.
             */
            try {
                getTileCache().setTileChanged(this, tileX, tileY);

            } catch (Exception ex) {
               // Manuel 5.8.2014: logging disabled -> this exception seems to be ok, just do nothing here
               // Logger.getLogger(DiskMemImage.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (TileObserver obs : tileObservers) {
                obs.tileUpdate(this, tileX, tileY, false);
            }
        }
    }

    /**
     * Tests if a tile is currently checked-out for writing (via
     * a call to {@linkplain #getWritableTile(int, int)}.
     *
     * @param tileX tile X ordinate
     * @param tileY tile Y ordinate
     * @return {@code true} if the tile is currently checked-out for
     *          writing; {@code false} otherwise.
     */
    public boolean isTileWritable(int tileX, int tileY) {
        return numWriters[tileX - tileGrid.x][tileY - tileGrid.y] > 0;
    }

    /**
     * Gets the indices (tile grid col,row) of tiles that are
     * currently checked out for writing.
     *
     * @return tile indices
     */
    public Point[] getWritableTileIndices() {
        Point[] indices = null;

        if (numTilesInUse > 0) {
            indices = new Point[numTilesInUse];
            int k = 0;
            for (int y = tileGrid.y, ny = 0; ny < tileGrid.height; y++, ny++) {
                for (int x = tileGrid.x, nx = 0; nx < tileGrid.width; x++, nx++) {
                    if (numWriters[nx][ny] > 0) {
                        indices[k++] = new Point(x, y);
                    }
                }
            }
        }

        return indices;
    }

    /**
     * Tests if any tiles are currently checked out for writing.
     * @return {@code true} if any tiles are currently checked out; 
     *         {@code false} otherwise
     */
    public boolean hasTileWriters() {
        return numTilesInUse > 0;
    }


    /**
     * Gets the image value for the given image position as an integer.
     *
     * @param x X ordinate
     * @param y Y ordinate
     * @param b band index
     *
     * @return image value
     * @throws PixelOutsideImageException
     */
    public int getSample(int x, int y, int b) throws PixelOutsideImageException {
        int tileX = XToTileX(x);
        int tileY = YToTileY(y);
        Raster t = getTile(tileX, tileY);
        if (t == null) {
            throw new PixelOutsideImageException(x, y, b);
        }
        return t.getSample(x, y, b);
    }

    /**
     * Gets the image value for the given image position as a float.
     *
     * @param x X ordinate
     * @param y Y ordinate
     * @param b band index
     *
     * @return image value
     * @throws PixelOutsideImageException  
     */
    public float getSampleFloat(int x, int y, int b) throws PixelOutsideImageException {
        int tileX = XToTileX(x);
        int tileY = YToTileY(y);
        Raster t = getTile(tileX, tileY);
        if (t == null) {
            throw new PixelOutsideImageException(x, y, b);
        }
        return t.getSampleFloat(x, y, b);
    }

    /**
     * Gets the image value for the given image position as a double.
     *
     * @param x X ordinate
     * @param y Y ordinate
     * @param b band index
     *
     * @return image value
     * @throws PixelOutsideImageException 
     */
    public double getSampleDouble(int x, int y, int b) throws PixelOutsideImageException {
        int tileX = XToTileX(x);
        int tileY = YToTileY(y);
        Raster t = getTile(tileX, tileY);
        if (t == null) {
            throw new PixelOutsideImageException(x, y, b);
        }
        return t.getSampleDouble(x, y, b);
    }

    /**
     * Sets the image value for the given image position as an integer.
     *
     * @param x X ordinate
     * @param y Y ordinate
     * @param b band index
     * @param value the new value
     *
     * @throws PixelOutsideImageException 
     */
    public void setSample(int x, int y, int b, int value) throws PixelOutsideImageException {
        int tileX = XToTileX(x);
        int tileY = YToTileY(y);
        try {
            WritableRaster t = getWritableTile(tileX, tileY);
            if (t == null) {
                throw new PixelOutsideImageException(x, y, b);
            }
            t.setSample(x, y, b, value);

        } finally {
            releaseWritableTile(tileX, tileY);
        }
    }

    /**
     * Sets the image value for the given image position as a float.
     *
     * @param x X ordinate
     * @param y Y ordinate
     * @param b band index
     * @param value the new value
     * @throws PixelOutsideImageException  
     *
     */
    public void setSample(int x, int y, int b, float value) throws PixelOutsideImageException {
        int tileX = XToTileX(x);
        int tileY = YToTileY(y);
        try {
            WritableRaster t = getWritableTile(tileX, tileY);
            if (t == null) {
                throw new PixelOutsideImageException(x, y, b);
            }
            t.setSample(x, y, b, value);

        } finally {
            releaseWritableTile(tileX, tileY);
        }
    }

    /**
     * Sets the image value for the given image position as a double.
     *
     * @param x X ordinate
     * @param y Y ordinate
     * @param b band index
     * @param value the new value
     * @throws PixelOutsideImageException  
     *
     */
    public void setSample(int x, int y, int b, double value) throws PixelOutsideImageException {
        int tileX = XToTileX(x);
        int tileY = YToTileY(y);
        try {
            WritableRaster t = getWritableTile(tileX, tileY);
            if (t == null) {
                throw new PixelOutsideImageException(x, y, b);
            }
            t.setSample(x, y, b, value);

        } finally {
            releaseWritableTile(tileX, tileY);
        }
    }

    /**
     * Copies data from the given {@code Raster} object into this
     * image. The bounds of {@code data} will be used to
     * place the data and only that portion of {@code data}
     * within this image's bounds will be copied.
     *
     * @param data the data to copy
     * @throws IllegalArgumentException if {@code data} is {@code null}
     */
    public void setData(Raster data) {
        if (data == null) {
            throw new IllegalArgumentException("The data argument must not be null");
        }

        Rectangle rBounds = data.getBounds();
        Rectangle common = rBounds.intersection(getBounds());
        if (common.isEmpty()) {
            return;
        }

        int minTileX = XToTileX(common.x);
        int maxTileX = XToTileX(common.x + common.width - 1);
        int minTileY = YToTileY(common.y);
        int maxTileY = YToTileY(common.y + common.height - 1);

        for (int y = minTileY; y <= maxTileY; y++) {
            for (int x = minTileX; x <= maxTileX; x++) {
                WritableRaster tile = getWritableTile(x, y);
                Rectangle tileOverlap = tile.getBounds().intersection(common);

                Raster dataChild = data.createChild(
                        tileOverlap.x, tileOverlap.y,
                        tileOverlap.width, tileOverlap.height,
                        tileOverlap.x, tileOverlap.y,
                        null);

                WritableRaster tChild = tile.createWritableChild(
                        tileOverlap.x, tileOverlap.y,
                        tileOverlap.width, tileOverlap.height,
                        tileOverlap.x, tileOverlap.y,
                        null);

                tChild.setRect(dataChild);
            }
        }
    }

    /**
     * Creates a Graphics2D object for drawing operations with this image.
     * The graphics object will be an instance of {@code DiskMemImageGraphics}.
     * <p>
     * Note that only images of integral data type support graphics operations.
     *
     * @return a new Graphics2D object
     * @throws UnsupportedOperationException if the image is not of integral data type
     * @see DiskMemImageGraphicsOrbit
     */
    public Graphics2D createGraphics() {
        int dataType = getSampleModel().getDataType();
        if (dataType == DataBuffer.TYPE_BYTE ||
            dataType == DataBuffer.TYPE_INT ||
            dataType == DataBuffer.TYPE_SHORT ||
            dataType == DataBuffer.TYPE_USHORT)
        {
            return new DiskMemImageGraphicsOrbit(this);

        } else {
            throw new UnsupportedOperationException("Image must have an integral data type");
        }
    }

    /**
     * Gets the maximum amount of memory, in bytes, that this
     * image will use for in-memory storage of its data. Since
     * this class uses a {@code DiskMemTileCache} this is not
     * the limit of image size.
     * 
     * @return max memory usage
     */
    public long getMemoryCapacity() {
        return getTileCache().getMemoryCapacity();
    }

    /**
     * Gets the amount of memory (bytes) required to store a single
     * tile's data.
     *
     * @return tile memory size in bytes
     */
    public long getTileMemorySize() {
        return tileMemorySize;
    }

    /**
     * Sets whether this image will use the common tile cache. Any tiles
     * belonging to this image that are already cached will be transferred
     * from the image's current tile cache to the common cache (if {@code useCommon}
     * is {@code true}) or to a new exclusive tile cache ((if {@code useCommon}
     * is {@code false}).
     * <p>
     * By default, the image will use an exclusive cache.
     *
     * @param useCommon true to set this image to use the common tile cache; false
     *        for the image to use its own exclusive cache.
     *
     * @see #getCommonTileCache()
     * @see #isUsingCommonCache()
     */
    public void setUseCommonCache(boolean useCommon) {
        if (useCommon && !isUsingCommonCache()) {
            /*
             * transfer any existing tiles to the common cache
             */
            if (tileCache != null) {
                for (int y = getMinTileY(), ny = 0; ny < getNumYTiles(); y++, ny++) {
                    for (int x = getMinTileX(), nx = 0; nx < getNumXTiles(); x++, nx++) {
                        Raster tile = tileCache.getTile(this, x, y);
                        if (tile != null) {
                            getCommonTileCache().add(this, x, y, tile);
                            tileCache.remove(this, x, y);
                        }
                    }
                }
            }
            tileCache = getCommonTileCache();

        } else if (isUsingCommonCache()) {
            /*
             * transfer any existing tiles from the common cache to
             * this images new exclusive cache
             */
            DiskMemTileCache newCache = createNewCache();
            for (int y = getMinTileY(), ny = 0; ny < getNumYTiles(); y++, ny++) {
                for (int x = getMinTileX(), nx = 0; nx < getNumXTiles(); x++, nx++) {
                    Raster tile = getCommonTileCache().getTile(this, x, y);
                    if (tile != null) {
                        newCache.add(this, x, y, tile);
                        getCommonTileCache().remove(this, x, y);
                    }
                }
            }
            tileCache = newCache;
        }
    }

    /**
     * Gets a reference to the {@code DiskMemTileCache} instance
     * used by this image. This method is intended for client
     * code that wishes to query cache state or receive cache diagnostic
     * messages (via the {@code Observer} interface). It is probably <b>not</b>
     * a good idea to manipulate the cache state directly.
     *
     * @return a live reference to the cache being used by this image
     * @see #isUsingCommonCache()
     * @see DiskMemTileCache
     */
    public DiskMemTileCache getTileCache() {
        if (tileCache == null) {
            tileCache = createNewCache();
        }

        return tileCache;
    }

    /**
     * Tests if this image is using the common tile cache.
     *
     * @return {@code true} if using the common tile cache; {@code false} otherwise
     * @see #setUseCommonCache(boolean)
     */
    public boolean isUsingCommonCache() {
        return tileCache != null && tileCache == commonCache;
    }

    /**
     * Creates a new image tile
     * @param tileX tile X ordinate
     * @param tileY tile Y ordinate
     * @return the new tile
     */
    private WritableRaster createTile(int tileX, int tileY) {
        assert(getTileCache().getTile(this, tileX, tileY) == null);

        Point location = new Point(tileXToX(tileX), tileYToY(tileY));
        return createWritableRaster(getSampleModel(), location);
    }

}
