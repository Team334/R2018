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
	public DriverStation fms = DriverStation.getInstance();
	
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

	@Override
	public void robotInit() {
		sDrive = new Drive();
		sElevator = new Elevator();
		sPneumatics = new Pneumatics();
		sRollerIntake = new RollerIntake();
		
		leftLeft = new StartLeftEndLeftScenario();
		leftRight = new StartLeftEndRightScenario();
		rightRight = new StartRightEndRightScenario();
		rightLeft = new StartRightEndLeftScenario();
		
		m_oi = new OI();
		
		System.out.println("ROBOT INITIALIZED");
		
		// Shows current commands that are running
		SmartDashboard.putData(Scheduler.getInstance());
		
		// Start receiving vision data from TK1
		VisionData.initTable();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void autonomousInit() {
		Scheduler.getInstance().removeAll();
		
		// Gets info from "Game Data" in FRC Driver Station
		String fieldConfig = fms.getGameSpecificMessage(); 
		SmartDashboard.putString("Field Config", fieldConfig);
		SmartDashboard.putNumber("Start Location", fms.getLocation());
		
		// Checks info from FMS to schedule correct auton command.
		switch (fieldConfig) {
			case "LLR":
				Scheduler.getInstance().add(leftLeft);
				break;
			case "LRR":
				Scheduler.getInstance().add(leftRight);
				break;
			case "LRL":
				Scheduler.getInstance().add(leftRight);
				break;
			case "RRL":
				Scheduler.getInstance().add(rightRight);
				break;
			case "RLL":
				Scheduler.getInstance().add(rightLeft);
				break;
			case "RLR":
				Scheduler.getInstance().add(rightLeft);
				break;
			default:
				System.out.println("FAILURE IN AUTON");
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		TankDriveCommand tankDrive = new TankDriveCommand();
		tankDrive.start();
	}

	@Override
	public void teleopPeriodic() {
		// Runs any commands that are queued from OI
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		
	}
	
}
