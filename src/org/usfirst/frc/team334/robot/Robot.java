package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.commands.TankDriveCommand;
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
	public static Drive sDrive = new Drive();
	public static Elevator sElevator = new Elevator();
	 public static Pneumatics sPneumatics = new Pneumatics();
	public static RollerIntake sRollerIntake = new RollerIntake();
	
	public static OI m_oi = new OI();
	
	Command m_autonomousCommand;

	@Override
	public void robotInit() {
		sDrive.setInverted(Constants.DRIVETRAIN_RIGHT);
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
        
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
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
