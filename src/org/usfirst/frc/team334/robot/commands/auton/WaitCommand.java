package org.usfirst.frc.team334.robot.commands.auton;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WaitCommand extends Command {

    private double time;

    public WaitCommand(double time) {
        requires(Robot.sDrive);
        this.time = time;
    }

    @Override
    protected void initialize() {
        setTimeout(time);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }

}
