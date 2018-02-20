package org.usfirst.frc.team334.robot.commands.auton;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import org.usfirst.frc.team334.robot.pids.HeadingPIDSource;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnCommand extends Command {

	private double heading;

	private PIDSource gyroInput;
	private PIDOutput out;
	private PIDController turnPID;

	public TurnCommand(double heading) {
		requires(Robot.sDrive);
		out = new PIDOutput() {
			@Override
			public void pidWrite(double output) {
			}
		};
		this.heading = heading;
		gyroInput = new HeadingPIDSource();
		turnPID = new PIDController(Constants.TURN_P, Constants.TURN_I, Constants.TURN_D, gyroInput, out);
		SmartDashboard.putNumber("Heading", Drive.rGyro.getHeading());
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.AbsoluteHeading += heading;
		turnPID.reset();
		turnPID.setSetpoint(Robot.AbsoluteHeading);
		turnPID.setAbsoluteTolerance(0);
		turnPID.setOutputRange(-0.6, 0.6);
		turnPID.enable();

		setTimeout(1.5);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.sDrive.setLeft(turnPID.get());
		Robot.sDrive.setRight(-turnPID.get());
		SmartDashboard.putNumber("Heading", Drive.rGyro.getHeading());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		System.out.println("TURN FINISHED");
		turnPID.disable();
		Robot.sDrive.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("TURN COMMAND INTERRUPTED.");
		turnPID.disable();
		Robot.sDrive.stop();
	}

}
