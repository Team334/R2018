package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class UnfoldIntakeCommand extends Command {

	public UnfoldIntakeCommand() {
		requires(Robot.sRollerIntake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(1);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	    Robot.sRollerIntake.unfoldIntake();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut(); // intake hits 90 degrees to elevator
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.sRollerIntake.setMotorSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.sRollerIntake.setMotorSpeed(0);
	}
}