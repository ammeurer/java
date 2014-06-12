package main.adapters.plate;

import model.tasks.TaskModel;

import java.awt.Graphics;

/**
 * Adapter used by plate model to talk to serial model.
 * @author Christian
 *
 */
public class Plate2TaskAdapter {

    private TaskModel taskModel;

    /* Sets up model references necessary for this adapter. */
    public Plate2TaskAdapter(TaskModel taskModel) {
        this.taskModel = taskModel;
    }

    /**
	 * Tells the serial model to draw/paint all its tasks.
	 * @param g graphics object to draw with
	 * @param sF cm to pixel scale factor to draw objects at
	 */
	public void drawTasks(Graphics g, double sF){
        taskModel.drawTasks(g, sF);
    }
}