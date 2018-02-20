package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.auto.scenarios.*;
import org.usfirst.frc.team334.robot.commands.drivetrain.TankDriveCommand;
import org.usfirst.frc.team334.robot.subsystems.Drive;
import org.usfirst.frc.team334.robot.subsystems.Elevator;
import org.usfirst.frc.team334.robot.subsystems.Pneumatics;
import org.usfirst.frc.team334.robot.subsystems.RollerIntake;
import org.usfirst.frc.team334.robot.vision.VisionData;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	// FMS -> retrieves auton information
	private DriverStation fms = DriverStation.getInstance();

	// Initialize subsystems
	public static Drive sDrive;
	public static Elevator sElevator;
	public static Pneumatics sPneumatics;
	public static RollerIntake sRollerIntake;

	// Initialize commands
	private Command leftLeft;
	private Command leftRight;
	private Command rightRight;
	private Command rightLeft;

	public static OI m_oi;

	public static double AbsoluteHeading;

	private static VisionData vision;

	@Override
	public void robotInit() {
		sDrive = new Drive();
		sElevator = new Elevator();
		sPneumatics = new Pneumatics();
		sRollerIntake = new RollerIntake();

		leftLeft = new LeftStartLeftSwitchLeftScale();
		leftRight = new LeftStartLeftSwitchRightScale();
		rightRight = new RightStartRightSwitchRightScale();
		rightLeft = new RightStartRightSwitchLeftScale();

		m_oi = new OI();

		vision = new VisionData();

		// Shows current commands that are running
		SmartDashboard.putData(Scheduler.getInstance());

		System.out.println("ROBOT INITIALIZED");
	}

	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() {
	}

	@Override
	public void autonomousInit() {
		AbsoluteHeading = 0;

		Drive.rEncoderLeft.reset();
		Drive.rEncoderRight.reset();
		Drive.rGyro.resetHeading();

		Robot.sDrive.setNormal();

		Scheduler.getInstance().removeAll();

		// Gets info from "Game Data" in FRC Driver Station
		String fieldConfig = fms.getGameSpecificMessage();
		SmartDashboard.putString("Field Config", fieldConfig);
		SmartDashboard.putNumber("Start Location", fms.getLocation());

		// Checks info from FMS to schedule correct auton command.
		// switch (fieldConfig) {
		// case "LLR":
		// Scheduler.getInstance().add(leftLeft);
		// break;
		// case "LRR":
		// Scheduler.getInstance().add(leftRight);
		// break;
		// case "LRL":
		// Scheduler.getInstance().add(leftRight);
		// break;
		// case "RRL":
		// Scheduler.getInstance().add(rightRight);
		// break;
		// case "RLL":
		// Scheduler.getInstance().add(rightLeft);
		// break;
		// case "RLR":
		// Scheduler.getInstance().add(rightLeft);
		// break;
		// default:
		// System.out.println("FAILURE IN AUTON");
		// }
		Scheduler.getInstance().add(leftLeft);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		System.out.println(Drive.rGyro.getHeading());
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		TankDriveCommand tankDrive = new TankDriveCommand();
		Robot.sDrive.setInvert();
		tankDrive.start();
	}

	@Override
	public void teleopPeriodic() {
		// Runs any commands that are queued from OI
		Scheduler.getInstance().run();
		System.out.println(Drive.rEncoderLeft.get());
	}

	@Override
	public void testPeriodic() {

	}

}
