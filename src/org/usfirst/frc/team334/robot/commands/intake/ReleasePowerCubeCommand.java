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
		System.out.println("RELEASEPOWERCUBECOMMAND INITIALIZED");
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
		// increments timer if the box isnt touching any of the limit switches to keep the command running for some additional time
		if (Robot.sRollerIntake.getLimitSwitch1() == false && Robot.sRollerIntake.getLimitSwitch2()== false) {
			timer++;
		}
		else {
			timer = 0;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// if the timer is greater than the Constant, then the command ends.
		return timer >= Constants.RELEASE_TIME;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.sRollerIntake.setMotorSpeed(0);
		
		System.out.println("RELEASEPOWERCUBECOMMAND ENDED");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.sRollerIntake.setMotorSpeed(0);
		
		System.out.println("RELEASEPOWERCUBECOMMAND INTERRUPTED");
	}
}