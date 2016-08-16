
package org.jaitools.tiledimage;

import javax.media.jai.PlanarImage;
import java.awt.*;
import java.awt.RenderingHints.Key;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.image.renderable.RenderableImage;
import java.lang.reflect.Method;
import java.text.AttributedCharacterIterator;
import java.util.Hashtable;
import java.util.Map;

/**
 * A Graphics class for drawing into a <code>DiskMemImage</code>.
 * As with JAI's <code>TiledImageGraphics</code> class, java.awt
 * routines do the work and the purpose of this class is to
 * serve the image data in a form that those routines can handle.
 * <p>
 * Most of the methods in this class are identical in function to
 * those in Graphics2D; these have not been documented here.
 *
 * @author Michael Bedward
 * @version $Id$
 * @see DiskMemImage
 * @since 1.0
 */
public class DiskMemImageGraphicsOrbit extends Graphics2D {

    private DiskMemImageOrbit targetImage;
    private ColorModel colorModel;
    private Hashtable<String, Object> properties;
    private RenderingHints renderingHints;

    /**
     * Constants for paint mode: PAINT or XOR.
     */
    public enum PaintMode {
        /**
         * Simple paint mode.
         */
        PAINT,
        /**
         * XOR paint mode.
         */
        XOR;
    }

    ;

    /*
     * java.awt.Graphics parameters
     */
    private Point origin;
    private Shape compClip;
    private Shape devClip;
    private Shape usrClip;
    private Color color;
    private Font font;
    private PaintMode paintMode;
    private Color XORColor;

    /*
     * java.awt.Graphics2D parameters
     */
    private Color background;
    private Composite composite;
    private Paint paint;
    private Stroke stroke;
    private AffineTransform transform;

    /**
     * Constants and associated data for graphics operations
     */
    public enum OpType {

        /**
         * Describes the clearRect method.
         */
        CLEAR_RECT("clearRect", int.class, int.class, int.class, int.class),

        /**
         * Describes the copyArea method.
         */
        COPY_AREA("copyArea", int.class, int.class, int.class, int.class, int.class, int.class),

        /**
         * Describes the drawArc method.
         */
        DRAW_ARC("drawArc", int.class, int.class, int.class, int.class, int.class, int.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_BUFFERED_IMAGE("drawImage", BufferedImage.class, BufferedImageOp.class, int.class, int.class),

        /**
         * Describes the drawGlyphVector method.
         */
        DRAW_GLYPH_VECTOR("drawGlyphVector", GlyphVector.class, float.class, float.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_IMAGE_DEST_SRC("drawImage", Image.class, int.class, int.class, int.class, int.class,
                int.class, int.class, int.class, int.class, ImageObserver.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_IMAGE_DEST_SRC_COL("drawImage", Image.class, int.class, int.class, int.class, int.class,
                int.class, int.class, int.class, int.class, Color.class, ImageObserver.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_IMAGE_TRANSFORM("drawImage", Image.class, AffineTransform.class, ImageObserver.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_IMAGE_XY("drawImage", Image.class, int.class, int.class, ImageObserver.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_IMAGE_XY_COL("drawImage", Image.class, int.class, int.class, Color.class, ImageObserver.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_IMAGE_XYWH("drawImage", Image.class, int.class, int.class, int.class, int.class, ImageObserver.class),

        /**
         * Describes the drawImage method.
         */
        DRAW_IMAGE_XYWH_COL("drawImage", Image.class, int.class, int.class, int.class, int.class, Color.class, ImageObserver.class),

        /**
         * Describes the drawLine method.
         */
        DRAW_LINE("drawLine", int.class, int.class, int.class, int.class),

        /**
         * Describes the drawOval method.
         */
        DRAW_OVAL("drawOval", int.class, int.class, int.class, int.class),

        /**
         * Describes the drawPolygon method.
         */
        DRAW_POLYGON("drawPolygon", int[].class, int[].class, int.class),

        /**
         * Describes the drawPolyline method.
         */
        DRAW_POLYLINE("drawPolyline", int[].class, int[].class, int.class),

        /**
         * Describes the drawRenderableImage method.
         */
        DRAW_RENDERABLE_IMAGE("drawRenderableImage", RenderableImage.class, AffineTransform.class),

        /**
         * Describes the drawRenderedImage method.
         */
        DRAW_RENDERED_IMAGE("drawRenderedImage", RenderedImage.class, AffineTransform.class),

        /**
         * Describes the drawRoundRect method.
         */
        DRAW_ROUND_RECT("drawRoundRect", int.class, int.class, int.class, int.class, int.class, int.class),

        /**
         * Describes the draw method.
         */
        DRAW_SHAPE("draw", Shape.class),

        /**
         * Describes the drawString method.
         */
        DRAW_STRING_XY("drawString", String.class, float.class, float.class),

        /**
         * Describes the drawString method.
         */
        DRAW_STRING_ITER_XY("drawString", AttributedCharacterIterator.class, float.class, float.class),

        /**
         * Describes the fill method.
         */
        FILL("fill", Shape.class),

        /**
         * Describes the fillArc method.
         */
        FILL_ARC("fillArc", int.class, int.class, int.class, int.class, int.class, int.class),

        /**
         * Describes the fillOval method.
         */
        FILL_OVAL("fillOval", int.class, int.class, int.class, int.class),

        /**
         * Describes the fillPolygon method.
         */
        FILL_POLYGON("fillPolygon", int[].class, int[].class, int.class),

        /**
         * Describes the fillRect method.
         */
        FILL_RECT("fillRect", int.class, int.class, int.class, int.class),

        /**
         * Describes the fillRoundRect method.
         */
        FILL_ROUND_RECT("fillRoundRect", int.class, int.class, int.class, int.class, int.class, int.class);


        private String methodName;
        private Class<?>[] paramTypes;

        OpType(String methodName, Class<?>... types) {
            this.methodName = methodName;
            this.paramTypes = new Class<?>[types.length];
            System.arraycopy(types, 0, this.paramTypes, 0, types.length);
        }

        /**
         * Gets the method name.
         *
         * @return method name
         */
        public String getMethodName() {
            return methodName;
        }

        /**
         * Gets the full method name.
         *
         * @return full name
         */
        public String getFullMethodName() {
            StringBuilder sb = new StringBuilder();
            sb.append(methodName);
            sb.append("(");
            if (paramTypes.length > 0) {
                sb.append(paramTypes[0].getSimpleName());
                for (int i = 1; i < paramTypes.length; i++) {
                    sb.append(", ");
                    sb.append(paramTypes[i].getSimpleName());
                }
            }
            sb.append(")");
            return sb.toString();
        }

        /**
         * Gets the number of method arguments
         *
         * @return number of arguments
         */
        public int getNumArgs() {
            return paramTypes.length;
        }

        /**
         * Gets the types of the arguments.
         *
         * @return argument types
         */
        public Class<?>[] getArgTypes() {
            Class<?>[] copy = new Class<?>[paramTypes.length];
            System.arraycopy(paramTypes, 0, copy, 0, paramTypes.length);
            return copy;
        }
    }

    /**
     * Creates an instance for the given target image
     *
     * @param targetImage the image to be drawn into
     */
    DiskMemImageGraphicsOrbit(DiskMemImageOrbit targetImage) {
        this.targetImage = targetImage;
        this.renderingHints = new RenderingHints(null);
        setColorModel();
        setProperties();
        setGraphicsParams();
    }

    @Override
    public void draw(Shape s) {
        doDraw(OpType.DRAW_SHAPE, correctForStroke(s.getBounds2D()), s);
    }

    @Override
    public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
        Rectangle2D bounds = new Rectangle(0, 0, img.getWidth(obs), img.getHeight(obs));
        Rectangle2D trBounds = xform.createTransformedShape(bounds).getBounds2D();

        return doDraw(OpType.DRAW_IMAGE_TRANSFORM, trBounds, img, xform, obs);
    }

    @Override
    public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
        Rectangle2D bounds = op.getBounds2D(img);
        doDraw(OpType.DRAW_BUFFERED_IMAGE, bounds, img, op, x, y);
    }

    @Override
    public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
        Rectangle2D bounds = new Rectangle(img.getMinX(), img.getMinY(),
                img.getWidth(), img.getHeight());

        Rectangle2D trBounds = xform.createTransformedShape(bounds).getBounds2D();

        doDraw(OpType.DRAW_RENDERED_IMAGE, trBounds, img, xform);
    }

    @Override
    public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
        Rectangle2D bounds = new Rectangle2D.Float(img.getMinX(), img.getMinY(),
                img.getWidth(), img.getHeight());

        Rectangle2D trBounds = xform.createTransformedShape(bounds).getBounds2D();

        doDraw(OpType.DRAW_RENDERABLE_IMAGE, trBounds, img, xform);
    }

    @Override
    public void drawString(String str, int x, int y) {
        drawString(str, (float) x, (float) y);
    }

    @Override
    public void drawString(String str, float x, float y) {
        Rectangle2D bounds = getFontMetrics().getStringBounds(str, this);
        bounds.setRect(x,
                y - bounds.getHeight() + 1,
                bounds.getWidth(),
                bounds.getHeight());

        doDraw(OpType.DRAW_STRING_XY, bounds, str, x, y);
    }

    @Override
    public void drawString(AttributedCharacterIterator iter, int x, int y) {
        drawString(iter, (float) x, (float) y);
    }

    @Override
    public void drawString(AttributedCharacterIterator iter, float x, float y) {
        Rectangle2D bounds = getFontMetrics().getStringBounds(
                iter, iter.getBeginIndex(), iter.getEndIndex(), this);

        bounds.setRect(x,
                y - bounds.getHeight() + 1,
                bounds.getWidth(),
                bounds.getHeight());

        doDraw(OpType.DRAW_STRING_ITER_XY, bounds, iter, x, y);
    }

    @Override
    public void drawGlyphVector(GlyphVector g, float x, float y) {
        Rectangle2D bounds = g.getVisualBounds();

        // expand the rectangle by a single pixel width to allow for
        // rasterizing round-off errors
        // (see apidocs for Graphics2D.drawGlyphVector)
        bounds.setFrame(bounds.getMinX() - 1, bounds.getMinY() - 1,
                bounds.getWidth() + 2, bounds.getHeight() + 2);

        doDraw(OpType.DRAW_GLYPH_VECTOR, bounds, g, x, y);
    }

    @Override
    public void fill(Shape s) {
        doDraw(OpType.FILL, s.getBounds2D(), s);
    }

    @Override
    public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
        Graphics2D gr = getProxy();
        copyGraphicsParams(gr);
        boolean rtnVal = gr.hit(rect, s, onStroke);
        gr.dispose();
        return rtnVal;
    }

    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
        Graphics2D gr = getProxy();
        copyGraphicsParams(gr);
        GraphicsConfiguration gc = gr.getDeviceConfiguration();
        gr.dispose();
        return gc;
    }

    @Override
    public void setComposite(Composite comp) {
        composite = comp;
    }

    @Override
    public void setPaint(Paint p) {
        paint = p;
    }

    @Override
    public void setStroke(Stroke s) {
        stroke = s;
    }

    @Override
    public void setRenderingHint(Key hintKey, Object hintValue) {
        renderingHints.put(hintKey, hintValue);
    }

    @Override
    public Object getRenderingHint(Key hintKey) {
        return renderingHints.get(hintKey);
    }

    @Override
    public void setRenderingHints(Map<?, ?> hints) {
        renderingHints = new RenderingHints(null);
        renderingHints.putAll(hints);
    }

    @Override
    public void addRenderingHints(Map<?, ?> hints) {
        renderingHints.putAll(hints);
    }

    @Override
    public RenderingHints getRenderingHints() {
        return renderingHints;
    }

    @Override
    public void translate(int x, int y) {
        origin.setLocation(x, y);
        transform.translate((double) x, (double) y);
    }

    @Override
    public void translate(double tx, double ty) {
        transform.translate(tx, ty);
    }

    @Override
    public void rotate(double theta) {
        transform.rotate(theta);
    }

    @Override
    public void rotate(double theta, double x, double y) {
        transform.rotate(theta, x, y);
    }

    @Override
    public void scale(double sx, double sy) {
        transform.scale(sx, sy);
    }

    @Override
    public void shear(double shx, double shy) {
        transform.shear(shx, shy);
    }

    @Override
    public void transform(AffineTransform Tx) {
        transform.concatenate(Tx);
    }

    @Override
    public void setTransform(AffineTransform Tx) {
        transform = Tx;
    }

    @Override
    public AffineTransform getTransform() {
        return transform;
    }

    @Override
    public Paint getPaint() {
        return paint;
    }

    @Override
    public Composite getComposite() {
        return composite;
    }

    @Override
    public void setBackground(Color color) {
        background = color;
    }

    @Override
    public Color getBackground() {
        return background;
    }

    @Override
    public Stroke getStroke() {
        return stroke;
    }

    @Override
    public void clip(Shape s) {
        if (s != null) {
            s = transformShape(s);
            if (usrClip != null) {
                Area a1 = (usrClip instanceof Area) ? (Area) usrClip
                        : new Area(usrClip);
                Area a2 = (s instanceof Area) ? (Area) s : new Area(s);
                a2.intersect(a1);
                s = a2;
            }
        }
        usrClip = s;
        validateCompClip();
    }

    @Override
    public FontRenderContext getFontRenderContext() {
        Graphics2D gr = getProxy();
        copyGraphicsParams(gr);
        FontRenderContext frc = gr.getFontRenderContext();
        gr.dispose();
        return frc;
    }

    /**
     * Returns a copy of this object with its current settings
     *
     * @return a new instance of this class
     */
    @Override
    public Graphics create() {
        DiskMemImageGraphicsOrbit gr = new DiskMemImageGraphicsOrbit(targetImage);
        copyGraphicsParams(gr);
        return gr;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color c) {
        color = c;
    }

    @Override
    public void setPaintMode() {
        paintMode = PaintMode.PAINT;
    }

    @Override
    public void setXORMode(Color color) {
        paintMode = PaintMode.XOR;
        XORColor = color;
    }

    @Override
    public Font getFont() {
        return font;
    }

    @Override
    public void setFont(Font font) {
        if (font != null) {
            this.font = font;
        }
    }

    @Override
    public FontMetrics getFontMetrics(Font f) {
        Graphics2D gr = getProxy();
        copyGraphicsParams(gr);
        FontMetrics fm = gr.getFontMetrics(f);
        gr.dispose();
        return fm;
    }

    /**
     * {@inheritDoc}
     * <p>
     * The bounds returned by this method may only be approximately equal to
     * those originally set if a transform is active. See {@linkplain #getClip()}
     * for explanation.
     */
    @Override
    public Rectangle getClipBounds() {
        Shape s = getClip();
        return s == null ? null : s.getBounds();
    }

    @Override
    public void clipRect(int x, int y, int width, int height) {
        clip(new Rectangle(x, y, width, height));
    }

    @Override
    public void setClip(int x, int y, int width, int height) {
        setClip(new Rectangle(x, y, width, height));
    }

    /**
     * {@inheritDoc}
     * <p>
     * Note that if a transform has been
     * applied the result of this method may only be approximately equal to
     * the clip region originally set. This is because the clip region is stored
     * internally in its transformed state, and the result of this method is
     * calculated by applying the inverse of the transform to stored region.
     */
    @Override
    public Shape getClip() {
        return untransformShape(usrClip);
    }

    @Override
    public void setClip(Shape clip) {
        usrClip = clip;
        validateCompClip();
    }

    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        doDraw(OpType.COPY_AREA,
                new Rectangle(x + dx, y + dy, width, height),
                x, y, width, height, dx, dy);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        Rectangle2D bounds = new Rectangle();
        bounds.setFrameFromDiagonal(x1, y1, x2, y2);
        doDraw(OpType.DRAW_LINE, correctForStroke(bounds), x1, y1, x2, y2);
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        doDraw(OpType.FILL_RECT, new Rectangle(x, y, width, height), x, y, width, height);
    }

    @Override
    public void clearRect(int x, int y, int width, int height) {
        doDraw(OpType.CLEAR_RECT, new Rectangle(x, y, width, height), x, y, width, height);
    }

    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        Rectangle2D bounds = new Rectangle(
                x - arcWidth, y - arcHeight,
                width + 2 * arcWidth, height + 2 * arcHeight);

        doDraw(OpType.DRAW_ROUND_RECT, correctForStroke(bounds),
                x, y, width, height, arcWidth, arcHeight);
    }

    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        Rectangle2D bounds = new Rectangle(
                x - arcWidth, y - arcHeight,
                width + 2 * arcWidth, height + 2 * arcHeight);

        doDraw(OpType.FILL_ROUND_RECT, bounds, x, y, width, height, arcWidth, arcHeight);
    }

    @Override
    public void drawOval(int x, int y, int width, int height) {
        Rectangle2D bounds = new Rectangle(x, y, width, height);
        doDraw(OpType.DRAW_OVAL, correctForStroke(bounds), x, y, width, height);
    }

    @Override
    public void fillOval(int x, int y, int width, int height) {
        Rectangle2D bounds = new Rectangle(x, y, width, height);
        doDraw(OpType.FILL_OVAL, bounds, x, y, width, height);
    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        Rectangle2D bounds = new Rectangle(x, y, width, height);
        doDraw(OpType.DRAW_ARC, correctForStroke(bounds), x, y, width, height, startAngle, arcAngle);
    }

    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        Rectangle2D bounds = new Rectangle(x, y, width, height);
        doDraw(OpType.FILL_ARC, bounds, x, y, width, height, startAngle, arcAngle);
    }

    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        doDraw(OpType.DRAW_POLYLINE,
                correctForStroke(getPolyBounds(xPoints, yPoints, nPoints)),
                xPoints, yPoints, nPoints);
    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        doDraw(OpType.DRAW_POLYGON,
                correctForStroke(getPolyBounds(xPoints, yPoints, nPoints)),
                xPoints, yPoints, nPoints);
    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        doDraw(OpType.FILL_POLYGON,
                getPolyBounds(xPoints, yPoints, nPoints),
                xPoints, yPoints, nPoints);
    }

    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver obs) {
        Rectangle2D bounds = new Rectangle(x, y, img.getWidth(obs), img.getHeight(obs));
        return doDraw(OpType.DRAW_IMAGE_XY, bounds, img, x, y, obs);
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver obs) {
        Rectangle2D bounds = new Rectangle(x, y, width, height);
        return doDraw(OpType.DRAW_IMAGE_XYWH, bounds, img, x, y, width, height, obs);
    }

    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver obs) {
        Rectangle2D bounds = new Rectangle(x, y, img.getWidth(obs), img.getHeight(obs));
        return doDraw(OpType.DRAW_IMAGE_XY_COL, bounds, img, x, y, bgcolor, obs);
    }

    @Override
    public boolean drawImage(Image img,
                             int x, int y, int width, int height,
                             Color bgcolor, ImageObserver obs) {

        Rectangle2D bounds = new Rectangle(x, y, width, height);
        return doDraw(OpType.DRAW_IMAGE_XYWH_COL, bounds, img, x, y, width, height, bgcolor, obs);
    }

    @Override
    public boolean drawImage(Image img,
                             int dx1, int dy1, int dx2, int dy2,
                             int sx1, int sy1, int sx2, int sy2,
                             ImageObserver obs) {

        Rectangle2D bounds = new Rectangle(dx1, dy1, dx2 - dx1 + 1, dy2 - dy1 + 1);
        return doDraw(OpType.DRAW_IMAGE_DEST_SRC, bounds, img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, obs);
    }

    @Override
    public boolean drawImage(Image img,
                             int dx1, int dy1, int dx2, int dy2,
                             int sx1, int sy1, int sx2, int sy2,
                             Color bgcolor, ImageObserver obs) {

        Rectangle2D bounds = new Rectangle(dx1, dy1, dx2 - dx1 + 1, dy2 - dy1 + 1);
        return doDraw(OpType.DRAW_IMAGE_DEST_SRC_COL, bounds, img,
                dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2,
                bgcolor, obs);
    }

    @Override
    public void dispose() {
        /*
         * No need to do anything here
         */
    }

    /**
     * Transform a shape with the current transform.
     *
     * @param s the shape to transform
     * @return the transformed shape.
     */
    private Shape transformShape(Shape s) {
        if (s == null) {
            return null;
        }
        if (transform == null) {
            return s;
        }

        return transform.createTransformedShape(s);
    }

    /**
     * Transform a shape with the inverse of the current transform.
     *
     * @param s the shape to transform
     * @return the transformed shape.
     */
    private Shape untransformShape(Shape s) {
        if (s == null) {
            return null;
        }
        if (transform == null) {
            return s;
        }

        try {
            return transform.createInverse().createTransformedShape(s);
        } catch (NoninvertibleTransformException e) {
            return null;
        }
    }

    /**
     * Re-calculate the composite clip, based on both the device clip and
     * the user clip, and the current transform. Call this every time
     * any of these three (devClip, usrClip, transform) change.
     */
    private void validateCompClip() {
        if (usrClip == null) {
            compClip = devClip;

        } else {
            Area a1 = new Area(devClip);
            Area a2 = (usrClip instanceof Area) ? (Area) usrClip
                    : new Area(usrClip);
            a1.intersect(a2);

            compClip = a1;
        }
    }


    /**
     * Performs the graphics operation by partitioning the work across the image's
     * tiles and using Graphics2D routines to draw into each tile.
     *
     * @param opType the type of operation
     * @param bounds bounds of the element to be drawn
     * @param args   a variable length list of arguments for the operation
     */
    private boolean doDraw(OpType opType, Rectangle2D bounds, Object... args) {
        Method method = null;
        boolean rtnVal = false;

        // Transform requested area to obtain actual bounds.
        bounds = getTransform().createTransformedShape(bounds).getBounds();

        try {
            method = Graphics2D.class.getMethod(opType.getMethodName(), opType.getArgTypes());

        } catch (NoSuchMethodException nsmEx) {
            // programmer error :-(
            throw new RuntimeException("No such method: " + opType.getFullMethodName());
        }

        int minTileX = Math.max(targetImage.XToTileX((int) bounds.getMinX()),
                targetImage.getMinTileX());

        int maxTileX = Math.min(targetImage.XToTileX((int) (bounds.getMaxX() + 0.5)),
                targetImage.getMaxTileX());

        int minTileY = Math.max(targetImage.YToTileY((int) bounds.getMinY()),
                targetImage.getMinTileY());

        int maxTileY = Math.min(targetImage.YToTileY((int) (bounds.getMaxY() + 0.5)),
                targetImage.getMaxTileY());

        for (int tileY = minTileY; tileY <= maxTileY; tileY++) {
            int minY = targetImage.tileYToY(tileY);

            for (int tileX = minTileX; tileX <= maxTileX; tileX++) {
                int minX = targetImage.tileXToX(tileX);

                WritableRaster tile = targetImage.getWritableTile(tileX, tileY);

                // create a live-copy of the tile with the upper-left corner
                // translated to 0,0
                WritableRaster copy = tile.createWritableTranslatedChild(0, 0);

                BufferedImage bufImg = new BufferedImage(
                        colorModel,
                        copy,
                        colorModel.isAlphaPremultiplied(),
                        properties);

                Graphics2D gr = bufImg.createGraphics();

                // Note: we use the version of copyGraphicsParams taking a
                // Point arg used to adjust the clip area before copying it
                // into the graphics object
                copyGraphicsParams(gr, new Point(minX, minY));

                try {
                    Point2D p2d = gr.getTransform().transform(new Point2D.Double(0, 0), null);
                    Point p = new Point((int) p2d.getX() - minX, (int) p2d.getY() - minY);
                    p2d = gr.getTransform().inverseTransform(p, null);
                    gr.translate(p2d.getX(), p2d.getY());

                } catch (NoninvertibleTransformException nte) {
                    // TODO replace this with decent error handling
                    throw new RuntimeException(nte);
                }

                try {
                    Object oRtnVal = method.invoke(gr, args);
                    if (oRtnVal != null && oRtnVal.getClass() == boolean.class) {
                        rtnVal = ((Boolean) oRtnVal).booleanValue();
                    }

                } catch (Exception ex) {
                    // TODO replace this with decent error handling
                    throw new RuntimeException(ex);
                }

                gr.dispose();
                targetImage.releaseWritableTile(tileX, tileY);
            }
        }

        return rtnVal;
    }

    /**
     * Takes a bounding rectangle calculated by
     * one of the drawing methods and expands it, if necessary, to
     * account for the current Stroke width.
     * <p>
     * This correction appears to be missing from JAI's TiledImageGraphics
     * class.
     *
     * @param rect input bounds
     * @return expanded bounds as a new Rectangle2D object; or the
     * input Rectangle2D if no stroke is set
     */
    private Rectangle2D correctForStroke(Rectangle2D rect) {
        if (stroke != null) {
            Shape shp = stroke.createStrokedShape(rect);
            return shp.getBounds2D();
        } else {
            return rect;
        }
    }

    /**
     * Gets the bounding rectangle of the given vertices.
     *
     * @param xPoints X ordinates
     * @param yPoints Y ordinates
     * @param nPoints number of vertices
     * @return the bounding rectangle
     */
    private Rectangle2D getPolyBounds(int[] xPoints, int[] yPoints, int nPoints) {
        Rectangle bounds = new Rectangle();

        if (nPoints > 0) {
            int minX = xPoints[0];
            int maxX = minX;
            int minY = yPoints[0];
            int maxY = minY;

            for (int i = 1; i < nPoints; i++) {
                if (xPoints[i] < minX) {
                    minX = xPoints[i];
                } else if (xPoints[i] > maxX) {
                    maxX = xPoints[i];
                }

                if (yPoints[i] < minY) {
                    minY = yPoints[i];
                } else if (yPoints[i] > maxY) {
                    maxY = yPoints[i];
                }
            }

            bounds.setBounds(minX, minY, maxX - minX + 1, maxY - minY + 1);
        }

        return bounds;
    }

    /**
     * Attempts to retrieve or create a <code>ColorModel</code> for the target
     * image.
     *
     * @throws UnsupportedOperationException if a compatible
     *                                       <code>ColorModel</code> is not found
     */
    private void setColorModel() {
        assert (targetImage != null);

        colorModel = targetImage.getColorModel();

        if (colorModel == null) {
            SampleModel sm = targetImage.getSampleModel();
            colorModel = PlanarImage.createColorModel(sm);

            if (colorModel == null) {
                // try simple default
                if (ColorModel.getRGBdefault().isCompatibleSampleModel(sm)) {
                    colorModel = ColorModel.getRGBdefault();

                } else {
                    // admit defeat
                    throw new UnsupportedOperationException(
                            "Failed to get or construct a ColorModel for the image");
                }
            }
        }
    }

    /**
     * Retrieves any properties set for the target image.
     */
    private void setProperties() {
        assert (targetImage != null);

        properties = new Hashtable<String, Object>();
        String[] propertyNames = targetImage.getPropertyNames();
        if (propertyNames != null) {
            for (String name : propertyNames) {
                properties.put(name, targetImage.getProperty(name));
            }
        }

        // TODO: set rendering hints
    }

    /**
     * Creates a Graphics2D instance based on the first tile of the
     * target image and uses its state to set the graphics parameters
     * of this instance.
     */
    private void setGraphicsParams() {
        assert (targetImage != null);
        assert (colorModel != null);
        assert (properties != null);

        Graphics2D gr = getProxy();

        origin = new Point(0, 0);
        devClip = targetImage.getBounds();
        usrClip = null;
        compClip = null;
        validateCompClip();
        color = gr.getColor();
        font = gr.getFont();

        paintMode = PaintMode.PAINT;
        XORColor = null;

        background = gr.getBackground();
        composite = gr.getComposite();
        paint = null;
        stroke = gr.getStroke();
        transform = gr.getTransform();

        gr.dispose();
    }

    /**
     * Copies the current graphics parameters into the given <code>Graphics2D</code>
     * object.
     *
     * @param gr a Graphics2D object
     */
    private void copyGraphicsParams(Graphics2D gr) {
        copyGraphicsParams(gr, null);
    }

    /**
     * Copies the current graphics parameters into the given <code>Graphics2D</code>
     * object. If {@code workingOrigin} is non-null it is used to translate the
     * clip area before copying it across.
     *
     * @param gr a Graphics2D object
     */
    private void copyGraphicsParams(Graphics2D gr, Point workingOrigin) {
        gr.translate(origin.x, origin.y);
        gr.setColor(getColor());

        if (workingOrigin == null) {
            gr.setClip(compClip);
        } else {
            AffineTransform tr = AffineTransform.getTranslateInstance(
                    -workingOrigin.x, -workingOrigin.y);
            Shape trclip = tr.createTransformedShape(compClip);
            gr.setClip(trclip);
        }

        if (paintMode == PaintMode.PAINT) {
            gr.setPaintMode();
        } else if (XORColor != null) {
            gr.setXORMode(XORColor);
        }

        gr.setFont(font);

        // java.awt.Graphics2D state
        gr.setBackground(background);
        gr.setComposite(composite);
        if (paint != null) {
            gr.setPaint(paint);
        }
        if (renderingHints != null) {
            gr.setRenderingHints(renderingHints);
        }
        gr.setStroke(stroke);
        gr.setTransform(new AffineTransform(transform));
    }

    /**
     * Helper method for other methods that need an instantiated
     * Graphics2D object that is 'representative' of the target image.
     *
     * @return a new Graphics2D instance
     */
    private Graphics2D getProxy() {
        Raster tile = targetImage.getTile(targetImage.getMinTileX(), targetImage.getMinTileY());
        WritableRaster tiny = tile.createCompatibleWritableRaster(1, 1);

        BufferedImage img = new BufferedImage(
                colorModel, tiny, colorModel.isAlphaPremultiplied(), properties);

        return img.createGraphics();
    }
}
