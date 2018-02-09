package org.usfirst.frc.team334.robot.commands;

import org.usfirst.frc.team334.robot.OI;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleTransmissionCommand extends Command {
	public static OI m_oi = new OI();
	
	private boolean isFinished = false, isShifted;
	
	public ToggleTransmissionCommand(boolean shiftState) {
		 requires(Robot.sPneumatics);
		 isShifted = shiftState;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(isShifted){
			ShiftToLowSpeedTransmissionCommand shiftLow = new ShiftToLowSpeedTransmissionCommand();
			shiftLow.start();
			m_oi.setShiftState(false);
		}else {
			ShiftToHighSpeedTransmissionCommand shiftHigh = new ShiftToHighSpeedTransmissionCommand();
			shiftHigh.start();
			m_oi.setShiftState(true);
		}
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
