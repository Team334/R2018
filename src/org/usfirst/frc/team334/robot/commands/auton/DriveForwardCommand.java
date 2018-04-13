package org.usfirst.frc.team334.robot.commands.auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.*;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardCommand extends Command {

    private double distance;

    private PIDController driveForwardHeadingPID;
    private PIDController driveForwardDistancePID;

    // Distance argument is in INCHES
    public DriveForwardCommand(double distance) {
        requires(Robot.sDrive);
        this.distance = Constants.ENCODER_TICKS_PER_INCH * distance;
        
        driveForwardHeadingPID = new PIDController(
            Constants.DRIVE_HEADING_PID_P,
            Constants.DRIVE_HEADING_PID_I,
            Constants.DRIVE_HEADING_PID_D,
            new HeadingPIDSource(),
            new StandardPIDOutput()
        );
        driveForwardDistancePID = new PIDController(
            Constants.DRIVE_DISTANCE_PID_P,
            Constants.DRIVE_DISTANCE_PID_I,
            Constants.DRIVE_DISTANCE_PID_D,
            Drive.rEncoderLeft,
            new StandardPIDOutput()
        );
    }

    @Override
    protected void initialize() {
        Drive.rEncoderLeft.reset();

        driveForwardHeadingPID.reset();
        driveForwardHeadingPID.setSetpoint(Robot.absoluteHeading);
        driveForwardHeadingPID.setAbsoluteTolerance(0);
        driveForwardHeadingPID.setOutputRange(-1, 1);
        driveForwardHeadingPID.enable();

        driveForwardDistancePID.reset();
        driveForwardDistancePID.setSetpoint(distance);
        driveForwardDistancePID.setAbsoluteTolerance(0);
        driveForwardDistancePID.setOutputRange(-1, 1);
        driveForwardDistancePID.enable();
    }

    @Override
    protected void execute() {
        if (Drive.rGyro.isInitialized()) {
            Robot.sDrive.setLeft(driveForwardDistancePID.get() + driveForwardHeadingPID.get());
            Robot.sDrive.setRight(driveForwardDistancePID.get() - driveForwardHeadingPID.get());
        }
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Drive.rEncoderLeft.get()) > Math.abs(distance);
    }

    @Override
    protected void end() {
        driveForwardHeadingPID.disable();
        driveForwardDistancePID.disable();
        Robot.sDrive.stop();
    }

    @Override
    protected void interrupted() {
        driveForwardHeadingPID.disable();
        driveForwardDistancePID.disable();
        Robot.sDrive.stop();
    }

}
