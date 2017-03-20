/*
 *     Orbit, a versatile image analysis software for biological image-based quantification.
 *     Copyright (C) 2009 - 2017 Actelion Pharmaceuticals Ltd., Gewerbestrasse 16, CH-4123 Allschwil, Switzerland.
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

package com.actelion.research.orbit.imageAnalysis.tasks;

import com.actelion.research.mapReduceGeneric.executors.IMapReduceExecutor;

import javax.swing.*;
import java.lang.ref.WeakReference;

public class ProgressUpdateThread extends Thread {

    private WeakReference<IMapReduceExecutor> execRef;
    private WeakReference<OrbitWorker> workerRef;
    private double last = 0;
    private double current;

    /**
     * Updates every 100ms the worker progress based on the executor progress.
     * Runs as MIN_PRIORITY and as daemon.
     * Worker and executor are referenced as WeakReference.
     *
     * @param executor
     * @param orbitWorker
     */
    public ProgressUpdateThread(IMapReduceExecutor executor, OrbitWorker orbitWorker) {
        this.execRef = new WeakReference<IMapReduceExecutor>(executor);
        this.workerRef = new WeakReference<OrbitWorker>(orbitWorker);
        setPriority(Thread.MIN_PRIORITY);
        setDaemon(true);
    }

    @Override
    public void run() {
        IMapReduceExecutor exec;
        while ((exec = execRef.get()) != null) {
            final OrbitWorker worker = workerRef.get();
            if (worker == null) break;
            current = exec.getProgress();
            if (Math.abs(current - last) > 0.1d) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        worker.updateProgress((int) current);
                    }
                });
            }
            if (current == 100d) break;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
