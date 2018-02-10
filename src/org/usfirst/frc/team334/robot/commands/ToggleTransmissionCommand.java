package org.usfirst.frc.team334.robot.commands;

import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleTransmissionCommand extends Command {
		
	public ToggleTransmissionCommand() {
		 requires(Robot.sPneumatics);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// If ENUM TransMissionState is set to HIGH_SPEED shift to low speed otherwise shift to high speed
		// Transmission state is set internally within the Pneumatics Subsystem when the Command is called
		if (Robot.sPneumatics.getTransmissionState() == Pneumatics.TransmissionState.HIGH_SPEED){
			ShiftToLowSpeedTransmissionCommand shiftLow = new ShiftToLowSpeedTransmissionCommand();
			shiftLow.start();
		} else {
			ShiftToHighSpeedTransmissionCommand shiftHigh = new ShiftToHighSpeedTransmissionCommand();
			shiftHigh.start();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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
