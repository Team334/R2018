package org.usfirst.frc.team334.robot.commands.Auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

public class FollowLeftWallAutonCommand extends Command {
	
	private PIDSource leftUltrasonic;
	private PIDOutput out;
	private PIDController wallFollowPID;
		
	public FollowLeftWallAutonCommand() {
		requires(Robot.sDrive);
		out = new PIDOutput() {
			@Override
			public void pidWrite(double output) { }
		};
		leftUltrasonic = Drive.rUltrasonicL;
		wallFollowPID = new PIDController(Constants.WALL_FOLLOW_kP, Constants.WALL_FOLLOW_kI, Constants.WALL_FOLLOW_kD, leftUltrasonic, out);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Set automatic mode required for multiple sensors
		Drive.rUltrasonicL.setAutomaticMode(true);
		Drive.rUltrasonicL.setEnabled(true);
		Drive.rEncoderLeft.reset();
		wallFollowPID.reset();
		wallFollowPID.setSetpoint(Constants.DISTANCE_FROM_WALL);
		wallFollowPID.setAbsoluteTolerance(0);
		wallFollowPID.setOutputRange(-1, 1);
		wallFollowPID.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sDrive.setLeft(Constants.WALL_FOLLOW_PID_SPEED + wallFollowPID.get() * 0.5);
		Robot.sDrive.setRight(Constants.WALL_FOLLOW_PID_SPEED - wallFollowPID.get() * 0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Drive.rEncoderLeft.get() > Constants.DISTANCE_TO_BASELINE;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		wallFollowPID.disable();
		Robot.sDrive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("FOLLOW LEFT WALL COMMAND INTERRUPTED");
		wallFollowPID.disable();
		Robot.sDrive.stop();
	}
	
}
