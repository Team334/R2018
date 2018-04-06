package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReleasePowerCubeCommand extends Command {
	
	double timer = 0;
	
	public ReleasePowerCubeCommand() {
		requires(Robot.sRollerIntake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	    setTimeout(2);
		if (Robot.m_oi.getLeftJoystick().getRawButton(Constants.INTAKE_SPEED_HIGH_BUTTON)) {
			Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_OUT_SPEED_HIGH);
		}
		else {
			Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_OUT_SPEED);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	    
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
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