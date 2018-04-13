package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakePitchCommand extends Command {
    
	public IntakePitchCommand() {
		requires(Robot.sRollerIntake);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
        Robot.sRollerIntake.setWindowSpeed(-Robot.m_oi.getIntakeJoystick().getY() * Constants.INTAKE_FOLD_SPEED_MULTIPLIER);
	}

	@Override
	protected boolean isFinished() {
		return false;
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