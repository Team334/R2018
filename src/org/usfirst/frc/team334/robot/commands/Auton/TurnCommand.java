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
	private double kP,kI,kD;
	private double heading;
	
	private PIDSource gyroInput;
	private PIDOutput out;
	private PIDController turn;
	
	public TurnCommand(int heading) {
		 requires(Robot.sDrive);
		 this.heading = heading;
		 gyroInput = new TurnPIDSource();
		 out = new TurnPIDOutput();
		 turn = new PIDController(kP, kI, kD, gyroInput, out);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Drive.rGyro.resetHeading();
		turn.reset();
		turn.setSetpoint(heading);
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
		return (Drive.rGyro.getHeading() > heading - 2 && Drive.rGyro.getHeading() > heading + 2) ? true : false;
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
