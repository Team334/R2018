package org.usfirst.frc.team334.robot.commands;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftToHighSpeedTransmissionCommand extends Command {
	private boolean isFinished = false;
	
	public ShiftToHighSpeedTransmissionCommand() {
		 requires(Robot.sPneumatics);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sPneumatics.setHighSpeedTransmission();
		isFinished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
	}
}
