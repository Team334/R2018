package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.subsystems.Drive;
import org.usfirst.frc.team334.robot.subsystems.Elevator;
import org.usfirst.frc.team334.robot.subsystems.Pneumatics;
import org.usfirst.frc.team334.robot.subsystems.RollerIntake;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	public static OI m_oi;
	
	//Initialize subsystems
	public static Drive sDrive = new Drive();
	public static Elevator sElevator = new Elevator();
	public static Pneumatics sPneumatics = new Pneumatics();
	public static RollerIntake sRollerIntake = new RollerIntake();
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		m_oi = new OI();
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

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
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
