package org.usfirst.frc.team334.robot.commands.intake;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GrabPowerCubeAutonCommand extends Command {
    
    private double duration;

    public GrabPowerCubeAutonCommand(double duration) {
	    this.duration = duration;
		requires(Robot.sRollerIntake);
	}

	@Override
	protected void initialize() {
		setTimeout(duration);
	}

	@Override
	protected void execute() {
	    Robot.sRollerIntake.setMotorSpeed(Constants.INTAKE_SPEED);
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