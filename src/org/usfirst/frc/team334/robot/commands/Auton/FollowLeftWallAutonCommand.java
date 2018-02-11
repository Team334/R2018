package org.usfirst.frc.team334.robot.commands.Auton;

import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.DriveAlongLeftPIDOutput;
import org.usfirst.frc.team334.robot.pids.DriveAlongLeftPIDSource;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

public class FollowLeftWallAutonCommand extends Command {
		
	public FollowLeftWallAutonCommand() {
		 requires(Robot.sDrive);
	}
	
	private PIDSource src = new DriveAlongLeftPIDSource();
	private PIDOutput out = new DriveAlongLeftPIDOutput();

	private PIDController drive = new PIDController(0.075, 0, 0, src, out);

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Drive.rUltrasonicL.setAutomaticMode(true);
		Drive.rUltrasonicL.setEnabled(true);
		Drive.rEncoderLeft.reset();
		drive.reset();
		drive.setSetpoint(20);
		drive.setAbsoluteTolerance(0);
		drive.setOutputRange(-1, 1);
		drive.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sDrive.setLeft(0.5 + drive.get() * 0.5);
		Robot.sDrive.setRight(0.5 - drive.get() * 0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// 4000 is estimated distance to cross auton line (in encoder ticks)
		return (Drive.rEncoderLeft.get() > 4000) ? true : false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		drive.disable();
		Robot.sDrive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("FOLLOW LEFT WALL INTERRUPTED");
		end();
	}
	
}
