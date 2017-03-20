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

import com.actelion.research.orbit.imageAnalysis.models.TaskResult;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.List;

/**
 * SwingWorker wrapper with progress update und time estimation.
 */
public abstract class OrbitWorker extends SwingWorker<Void, Void> {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrbitWorker.class);
    public static final String TASK_DONE = "worker_done";
    public static final String PROGRESS_CHANGE = "worker_progressChange";

    protected abstract void doWork() throws Exception;

    protected long timeEst = 0L;
    protected double progressD = 0d;
    protected long startTime = System.currentTimeMillis();
    protected TaskResult taskResult = null;
    protected List<SwingWorker<Void, Void>> dependencyList = null;
    protected boolean withGUI = true;


    @Override
    protected Void doInBackground() throws Exception {
        try {
            if (dependencyList != null) {
                boolean notFinished = true;
                while (notFinished) {
                    notFinished = false;
                    for (SwingWorker<Void, Void> sw : dependencyList) {
                        if (!sw.isDone()) {
                            notFinished = true;
                        }
                        if (sw.isCancelled()) cancel(true);
                    }
                    //System.out.println("waiting of dependency...");
                    Thread.sleep(100);
                }
            }

            startTime = System.currentTimeMillis();
            doWork();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Orbit worker error: " + e.getMessage());
            throw e;
        }

        return null;
    }


    @Override
    public void done() {
        firePropertyChange(TASK_DONE, null, taskResult);
    }


    /**
     * does nothing, should be overwritten
     */
    public void pause() {
    }

    /**
     * does nothing, should be overwritten
     */
    public void resume() {
    }


    /**
     * returns 0, should be overwritten
     *
     * @return
     */
    public long getTimeEst() {
        long elapsed = (System.currentTimeMillis() - startTime);
        double et = (elapsed / (getProgressD() / 100d)) * (1d - (getProgressD() / 100d));
        timeEst = (long) et;
        return timeEst;
    }

    /**
     * returns the progress in %. In contrast to the swingWorker getProgress this method returns the more precise double progress.
     * Here it returns getProgress() but should be overwritten.
     *
     * @return
     */
    public double getProgressD() {
        return getProgress();
    }


    /**
     * simply calls setProgress() (which is protected)
     *
     * @param progress
     */
    public void updateProgress(int progress) {
        setProgress(progress);
    }

    /**
     * can be null
     */
    public TaskResult getTaskResult() {
        return taskResult;
    }


    public boolean isWithGUI() {
        return withGUI;
    }


    public void setWithGUI(boolean withGUI) {
        this.withGUI = withGUI;
    }


}
