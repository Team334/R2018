package org.usfirst.frc.team334.robot.commands.auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.*;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardCommand extends Command {

    private double distance;
    private double multiplier;

    private PIDSource encoderInput;
    private PIDController driveForwardHeadingPID;
    private PIDController driveForwardDistancePID;

    // Distance argument is in INCHES
    public DriveForwardCommand(double distance) {
        requires(Robot.sDrive);
        this.distance = Constants.ENCODER_TICKS_PER_INCH * distance;
        encoderInput = Drive.rEncoderLeft;
        driveForwardHeadingPID = new PIDController(Constants.DRIVE_HEADING_PID_P, Constants.DRIVE_HEADING_PID_I,
                Constants.DRIVE_HEADING_PID_D, new HeadingPIDSource(), new StandardPIDOutput());
        driveForwardDistancePID = new PIDController(Constants.DRIVE_DISTANCE_PID_P, Constants.DRIVE_DISTANCE_PID_I,
                Constants.DRIVE_DISTANCE_PID_D, encoderInput, new StandardPIDOutput());
    }

    @Override
    protected void initialize() {
        Drive.rEncoderLeft.reset();

        driveForwardHeadingPID.reset();
        driveForwardHeadingPID.setSetpoint(Robot.AbsoluteHeading);
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
            // Go faster if your distance is less than 40 inches.
            multiplier = (Math.abs(distance) < 40 * Constants.ENCODER_TICKS_PER_INCH) ? 1 : 0.4;

            Robot.sDrive.setLeft(driveForwardDistancePID.get() * multiplier + driveForwardHeadingPID.get());
            Robot.sDrive.setRight(driveForwardDistancePID.get() * multiplier - driveForwardHeadingPID.get());
        }
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Drive.rEncoderLeft.get()) > Math.abs(distance);
    }

    @Override
    protected void end() {
        System.out.println("DRIVE STOP");
        driveForwardHeadingPID.disable();
        driveForwardDistancePID.disable();
        Robot.sDrive.stop();
    }

    @Override
    protected void interrupted() {
        System.out.println("DRIVE COMMAND INTERRUPTED");
        driveForwardHeadingPID.disable();
        driveForwardDistancePID.disable();
        Robot.sDrive.stop();
    }

}
