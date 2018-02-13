package org.usfirst.frc.team334.robot.commands.Auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.ForwardPIDSource;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardCommand extends Command {
	
	private double distance;
	
	private PIDSource gyroInput;
	private PIDSource encoderInput;
	private PIDOutput outputHeadingPID;
	private PIDOutput outputDistancePID;
	private PIDController driveForwardHeadingPID;
	private PIDController driveForwardDistancePID;
	
	// Distance argument is in INCHES
	public DriveForwardCommand(double distance) {
		requires(Robot.sDrive);
		outputHeadingPID = new PIDOutput() {
			@Override
			public void pidWrite(double output) { }
		};
		outputDistancePID = new PIDOutput() {
			@Override
			public void pidWrite(double output) { }
		};
		this.distance = Constants.ENCODER_REVOLUTIONS_PER_INCH * distance;
		gyroInput = new ForwardPIDSource();
		encoderInput = Drive.rEncoderLeft;
		driveForwardHeadingPID = new PIDController(Constants.DRIVE_HEADING_PID_kP, Constants.DRIVE_HEADING_PID_kI, Constants.DRIVE_HEADING_PID_kD, gyroInput, outputHeadingPID);
		driveForwardDistancePID = new PIDController(Constants.DRIVE_DISTANCE_PID_kP, Constants.DRIVE_DISTANCE_PID_kI, Constants.DRIVE_DISTANCE_PID_kD, encoderInput, outputDistancePID);
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
		driveForwardDistancePID.setAbsoluteTolerance(0);
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
		return (Drive.rEncoderLeft.get() > distance - 5 && Drive.rEncoderLeft.get() < distance + 5) && (Drive.rEncoderRight.get() > distance - 5 && Drive.rEncoderRight.get() < distance + 5);
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
