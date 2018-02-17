package org.usfirst.frc.team334.robot.commands.Auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.DefaultPIDOutput;
import org.usfirst.frc.team334.robot.pids.GyroPIDSource;
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

        driveForwardHeadingPID = new PIDController(Constants.DRIVE_HEADING_PID_P, Constants.DRIVE_HEADING_PID_I,
                Constants.DRIVE_HEADING_PID_D, new GyroPIDSource(), new DefaultPIDOutput());
        driveForwardDistancePID = new PIDController(Constants.DRIVE_DISTANCE_PID_P, Constants.DRIVE_DISTANCE_PID_I,
                Constants.DRIVE_DISTANCE_PID_D, Drive.rEncoderLeft, new DefaultPIDOutput());
    }

    @Override
    protected void initialize() {
        Drive.rGyro.resetHeading();
        Drive.rEncoderLeft.reset();
        Drive.rEncoderRight.reset();

        driveForwardHeadingPID.reset();
        driveForwardHeadingPID.setSetpoint(Constants.DRIVE_HEADING_PID_TARGET);
        driveForwardHeadingPID.setAbsoluteTolerance(0);
        driveForwardHeadingPID.setOutputRange(-1, 1);
        driveForwardHeadingPID.enable();

        driveForwardDistancePID.reset();
        driveForwardDistancePID.setSetpoint(distance);
        driveForwardDistancePID.setAbsoluteTolerance(5);
        driveForwardDistancePID.setOutputRange(-1, 1);
        driveForwardDistancePID.enable();
    }

    @Override
    protected void execute() {
        Robot.sDrive.setLeft(Constants.DRIVE_PID_SPEED + driveForwardHeadingPID.get() * 0.5);
        Robot.sDrive.setRight(Constants.DRIVE_PID_SPEED - driveForwardHeadingPID.get() * 0.5);
    }

    @Override
    protected boolean isFinished() {
        return driveForwardHeadingPID.onTarget();

        // double encLeft = Drive.rEncoderLeft.get();
        // double encRight = Drive.rEncoderRight.get();
        //
        // return Math.abs(encLeft - distance) > 5 && Math.abs(encRight -
        // distance) > 5;

        // return (encLeft > distance - 5 && encLeft < distance + 5) &&
        // (encRight > distance - 5 && encRight < distance + 5);
    }

    @Override
    protected void end() {
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
