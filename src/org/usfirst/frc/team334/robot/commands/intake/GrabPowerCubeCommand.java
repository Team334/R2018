package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GrabPowerCubeCommand extends Command {

	public GrabPowerCubeCommand() {
		requires(Robot.sRollerIntake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		if (Robot.m_oi.getLeftJoystick().getRawButton(Constants.INTAKE_SPEED_HIGH_BUTTON))
			Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_SPEED_HIGH);
		else
			Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_SPEED);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//Motor speed set in initialize
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// if cube touches either of the 2 limit switches, end command
		return Robot.sRollerIntake.getLimitSwitch1() || Robot.sRollerIntake.getLimitSwitch2();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.sRollerIntake.foldStop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.sRollerIntake.foldStop();
	}
}