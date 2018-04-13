package org.usfirst.frc.team334.robot.commands.auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.*;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {

    private double heading;

    private PIDController turnPID;

    public TurnCommand(double heading) {
        requires(Robot.sDrive);
        this.heading = heading;
        
        turnPID = new PIDController(
            Constants.TURN_P,
            Constants.TURN_I,
            Constants.TURN_D,
            new HeadingPIDSource(),
            new StandardPIDOutput()
        );
    }

    @Override
    protected void initialize() {
        Robot.absoluteHeading += heading;
        turnPID.reset();
        turnPID.setSetpoint(Robot.absoluteHeading);
        turnPID.setAbsoluteTolerance(0);
        turnPID.setOutputRange(-0.6, 0.6);
        turnPID.enable();

        setTimeout(1.5);
    }

    @Override
    protected void execute() {
        Robot.sDrive.setLeft(turnPID.get());
        Robot.sDrive.setRight(-turnPID.get());
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        turnPID.disable();
        Robot.sDrive.stop();
    }

    @Override
    protected void interrupted() {
        turnPID.disable();
        Robot.sDrive.stop();
    }

}
