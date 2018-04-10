package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FoldIntakeCommand extends Command {

	public FoldIntakeCommand() {
		requires(Robot.sRollerIntake);
	}

	@Override
	protected void initialize() {
		setTimeout(0.8);
	}

	@Override
	protected void execute() {
        Robot.sRollerIntake.setWindowSpeed(-1);
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