package org.usfirst.frc.team334.robot.commands.Auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

public class FollowRightWallAutonCommand extends Command {
	
	private int kP, kI, kD;
	
	private PIDSource rightUltrasonic;
	private PIDOutput out;
		
	public FollowRightWallAutonCommand() {
		requires(Robot.sDrive);
		rightUltrasonic = Drive.rEncoderRight;
		out = new PIDOutput() {
			@Override
			public void pidWrite(double output) { }
		};
	}

	private PIDController wallFollowPID = new PIDController(kP, kI, kD, rightUltrasonic, out);

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Drive.rUltrasonicR.setAutomaticMode(true);
		Drive.rUltrasonicR.setEnabled(true);
		Drive.rEncoderRight.reset();
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
		return (Drive.rEncoderRight.get() > Constants.DISTANCE_TO_BASELINE) ? true : false;
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
		System.out.println("FOLLOW RIGHT WALL INTERRUPTED");
		end();
	}
	
}
