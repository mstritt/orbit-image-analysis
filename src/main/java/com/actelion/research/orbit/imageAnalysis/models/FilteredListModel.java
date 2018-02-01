/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2018 Idorsia Pharmaceuticals Ltd., Hegenheimermattweg 91, CH-4123 Allschwil, Switzerland.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.actelion.research.orbit.imageAnalysis.models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class FilteredListModel<T> extends AbstractListModel {

    private static final long serialVersionUID = 1L;
    protected final ArrayList<T> items = new ArrayList<T>();
    ;
    protected final ArrayList<T> filteredItems = new ArrayList<T>();
    protected final ReentrantReadWriteLock itemLock = new ReentrantReadWriteLock();
    protected final ReentrantReadWriteLock filteredItemLock = new ReentrantReadWriteLock();

    protected abstract boolean accept(T element);

    public FilteredListModel() {
        super();
    }

    public int getSize() {
        filteredItemLock.readLock().lock();
        try {
            return filteredItems.size();
        } finally {
            filteredItemLock.readLock().unlock();
        }
    }

    public Object getElementAt(int index) {
        filteredItemLock.readLock().lock();
        try {
            if (index < filteredItems.size())
                return filteredItems.get(index);
            else
                return null;
        } finally {
            filteredItemLock.readLock().unlock();
        }
    }

    public void addElement(T o) {
        itemLock.writeLock().lock();
        try {
            items.add(o);
        } finally {
            itemLock.writeLock().unlock();
        }
    }

    public void addAll(Collection<? extends T> o) {
        itemLock.writeLock().lock();
        try {
            items.addAll(o);
        } finally {
            itemLock.writeLock().unlock();
        }
    }

    public boolean removeElement(T o) {
        itemLock.writeLock().lock();
        try {
            return items.remove(o);
        } finally {
            itemLock.writeLock().unlock();
        }
    }

    public void removeElementAt(int index) {
        itemLock.writeLock().lock();
        try {
            items.remove(index);
        } finally {
            itemLock.writeLock().unlock();
        }
    }

    public boolean contains(T o) {
        itemLock.readLock().lock();
        try {
            return items.contains(o);
        } finally {
            itemLock.readLock().unlock();
        }
    }

    public boolean containsFiltered(T o) {
        filteredItemLock.readLock().lock();
        try {
            return filteredItems.contains(o);
        } finally {
            filteredItemLock.readLock().unlock();
        }
    }

    public int indexOf(T o) {
        itemLock.readLock().lock();
        try {
            return items.indexOf(o);
        } finally {
            itemLock.readLock().unlock();
        }
    }

    public int indexOfFiltered(T o) {
        filteredItemLock.readLock().lock();
        try {
            return filteredItems.indexOf(o);
        } finally {
            filteredItemLock.readLock().unlock();
        }
    }

    public void clear() {
        itemLock.writeLock().lock();
        filteredItemLock.writeLock().lock();
        try {
            items.clear();
            filteredItems.clear();
        } finally {
            itemLock.writeLock().unlock();
            filteredItemLock.writeLock().unlock();
        }
    }

    public void filter() {
        itemLock.readLock().lock();
        filteredItemLock.writeLock().lock();
        try {
            int oldSize = filteredItems.size();
            filteredItems.clear();
            if (oldSize > 0)
                fireIntervalRemoved(this, 0, oldSize - 1); // needed?
            for (T o : items) {
                if (accept(o)) {
                    filteredItems.add(o);
                }
            }
            if (getSize() > 0)
                fireIntervalAdded(this, 0, getSize() - 1);
        } finally {
            itemLock.readLock().unlock();
            filteredItemLock.writeLock().unlock();
        }
    }

    public List<T> getAllElements() {
        return items;
    }


}
