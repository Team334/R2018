package org.usfirst.frc.team334.robot.commands;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCommand extends Command {
	public TankDriveCommand() {
		requires(Robot.sDrive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("TANK DRIVE INITIALIZED");	
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sDrive.setLeft(Robot.m_oi.getLeftJoystick().getY());
		Robot.sDrive.setRight(Robot.m_oi.getRightJoystick().getY());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println("STOPPED TANK DRIVE");
		Robot.sDrive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("TANK DRIVE INTERRUPTED");
		Robot.sDrive.stop();
	}
}
