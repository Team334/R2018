package org.usfirst.frc.team334.robot.commands.Auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.DefaultPIDOutput;
import org.usfirst.frc.team334.robot.pids.GyroPIDSource;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {

    private double heading;

    private PIDController turnPID;

    public TurnCommand(int heading) {
        requires(Robot.sDrive);

        this.heading = heading;
        turnPID = new PIDController(Constants.TURN_P, Constants.TURN_I, Constants.TURN_D, new GyroPIDSource(),
                new DefaultPIDOutput());
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Drive.rGyro.resetHeading();

        turnPID.reset();
        turnPID.setSetpoint(heading);
        turnPID.setAbsoluteTolerance(0);
        turnPID.setOutputRange(-1, 1);
        turnPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.sDrive.setLeft(turnPID.get());
        Robot.sDrive.setRight(-turnPID.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Drive.rGyro.getHeading() > heading - 2 && Drive.rGyro.getHeading() < heading + 2;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        turnPID.disable();
        Robot.sDrive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        System.out.println("TURN COMMAND INTERRUPTED.");
        turnPID.disable();
        Robot.sDrive.stop();
    }

}
