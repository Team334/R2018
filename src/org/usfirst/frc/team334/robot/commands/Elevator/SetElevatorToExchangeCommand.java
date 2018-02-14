package org.usfirst.frc.team334.robot.commands.Elevator;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetElevatorToExchangeCommand extends Command {
	
	public SetElevatorToExchangeCommand() {
		requires(Robot.sElevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("MOVING ELEVATOR TO EXCHANGE POSITION");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sElevator.setSetpoint(Constants.ELEVATOR_EXCHANGE);
		Robot.sElevator.enable();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.sElevator.onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.sElevator.stop();
		Robot.sElevator.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.sElevator.stop();
		Robot.sElevator.disable();
	}
}
