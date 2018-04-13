package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReleasePowerCubeAutonCommand extends Command {
	
	public ReleasePowerCubeAutonCommand() {
		requires(Robot.sRollerIntake);
	}

	@Override
	protected void initialize() {
	    setTimeout(1);
		Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_OUT_SPEED);
	}

	@Override
	protected void execute() {
	    
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.sRollerIntake.setMotorSpeed(0);
	}

	@Override
	protected void interrupted() {
		Robot.sRollerIntake.setMotorSpeed(0);
	}
}