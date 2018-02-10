package org.usfirst.frc.team334.robot.subsystems;


import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * DriveTrain for 2018 Robot
 * 6 Victors (3 per side)
 */

public class Drive extends Subsystem {

	public enum DriveControlState {
		TANK_DRIVE_JOYSTICK_CONTROL,
		TURN_TO_HEADING,
		DRIVE_TOWARDS_SWITCH, // for auton
		DRIVE_TOWARDS_SCALE // for auton
	}
	
	private DriveControlState mDriveControlState;
	
	private VictorSP left;
	private VictorSP right;
	
	public Drive() {
		left = new VictorSP(Constants.DRIVETRAIN_LEFT);
		right = new VictorSP(Constants.DRIVETRAIN_RIGHT);
		right.setInverted(true);
	}
	
	public void stop() {
		setLeft(0);
		setRight(0);
	}
	
	public void setLeft(double speed) {
		left.set(speed);
	}
	
	public void setRight(double speed) {
		right.set(speed);
	}

    public void initDefaultCommand() {
    	
    }
    
}
