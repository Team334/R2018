package org.usfirst.frc.team334.robot.commands.Auton;

import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.TurnPIDOutput;
import org.usfirst.frc.team334.robot.pids.TurnPIDSource;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {
		
	private double angle;
	
	private PIDSource src = new TurnPIDSource();
	private PIDOutput out = new TurnPIDOutput();

	private PIDController turn = new PIDController(0.075, 0, 0, src, out);
	
	public TurnCommand(int angle) {
		 requires(Robot.sDrive);
		 this.angle = angle;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Drive.rGyro.resetHeading();
		turn.reset();
		turn.setSetpoint(angle);
		turn.setAbsoluteTolerance(0);
		turn.setOutputRange(-1, 1);
		turn.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sDrive.setLeft(turn.get());
		Robot.sDrive.setRight(-turn.get());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (Drive.rGyro.getHeading() > angle - 2 && Drive.rGyro.getHeading() > angle + 2) ? true : false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		turn.disable();
		Robot.sDrive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("Turn Command interrupted.");
		end();
	}
	
}
