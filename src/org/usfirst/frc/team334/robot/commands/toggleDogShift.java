package org.usfirst.frc.team334.robot.commands;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Changes the shift state of the gearboxes
 */
public class toggleDogShift extends Command {
	private boolean isDone = false;
	
    public toggleDogShift() {
    	 requires(Robot.chassis);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.chassis.toggleDog();
    	isDone = true;
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
    }

    protected void interrupted() {
    	isDone = true;
    }
}
