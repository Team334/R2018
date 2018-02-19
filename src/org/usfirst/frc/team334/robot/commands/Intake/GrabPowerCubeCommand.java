package org.usfirst.frc.team334.robot.commands.Intake;

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
		System.out.println("GRABPOWERCUBECOMMAND HAS BEEN INITIALIZED");
		if (Robot.m_oi.getLeftJoystick().getRawButton(Constants.INTAKE_SPEED_HIGH_BUTTON)) {
			Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_SPEED_HIGH);
		}
		else {
			Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_SPEED);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//Motor speed set in initialize
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// if cube gets within a certain range(INTAKE_GRAB_DISTANCE) of the ultrasonic, the command stops running
		return Robot.sRollerIntake.getRangeInches() <= Constants.INTAKE_GRAB_DISTANCE;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.sRollerIntake.setMotorSpeed(0);
		
		System.out.println("GRABPOWERCUBECOMMAND HAS ENDED");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.sRollerIntake.setMotorSpeed(0);
		
		System.out.println("GRABPOWERCUBECOMMAND HAS BEEN INTERRUPTED");
	}
}