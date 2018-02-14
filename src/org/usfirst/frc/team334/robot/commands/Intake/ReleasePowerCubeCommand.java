package org.usfirst.frc.team334.robot.commands.Intake;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReleasePowerCubeCommand extends Command {
	
	public ReleasePowerCubeCommand() {
		requires(Robot.sRollerIntake);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		System.out.println("ReleasePowerCubeCommand has initialized");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(Robot.m_oi.getLeftJoystick().getRawButton(Constants.INTAKE_HIGH_BUTTON)){
			Robot.sRollerIntake.SetMotorSpeed(Constants.INTAKE_SPEED_HIGH * -1);
		}
		else{
			Robot.sRollerIntake.SetMotorSpeed(Constants.INTAKE_SPEED * -1);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		// if cube goes outside of a certain range(INTAKE_GRAB_DISTANCE) of the ultrasonic, the command stops running
		if(Robot.sRollerIntake.GetInchesUltrasonic() >= Constants.INTAKE_RELEASE_DISTANCE){
			return true;
		}
		else{
			return false;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.sRollerIntake.SetMotorSpeed(0);
		
		System.out.println("ReleasePowerCubeCommand has ended");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.sRollerIntake.SetMotorSpeed(0);
		
		System.out.println("ReleasePowerCubeCommand has been interrupted");
	}
	
}
