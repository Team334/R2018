package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReleasePowerCubeCommand extends Command {
	
	public ReleasePowerCubeCommand() {
		requires(Robot.sRollerIntake);
	}

	@Override
	protected void initialize() {
	    setTimeout(1);
		Robot.sRollerIntake.setMotorSpeed((Robot.m_oi.getElevatorJoystick().getRawAxis(3) - 1) / 2);
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