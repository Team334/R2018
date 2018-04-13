package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AngleIntakeCommand extends Command {
    
	public AngleIntakeCommand() {
		requires(Robot.sRollerIntake);
	}

	@Override
	protected void initialize() {
		setTimeout(0.2);
	}

	@Override
	protected void execute() {
        Robot.sRollerIntake.setWindowSpeed(0.8);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.sRollerIntake.foldStop();
	}

	@Override
	protected void interrupted() {
		Robot.sRollerIntake.foldStop();
	}
}