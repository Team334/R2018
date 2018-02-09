package org.usfirst.frc.team334.robot.subsystems;

import java.util.*;

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
	
	private VictorSP leftVic1;
	private VictorSP leftVic2;
	private VictorSP leftVic3;
	private VictorSP rightVic1;
	private VictorSP rightVic2;
	private VictorSP rightVic3;
	
	private ArrayList<VictorSP> leftVics;
	private ArrayList<VictorSP> rightVics;
	
	public Drive() {
		leftVic1 = new VictorSP(Constants.DRIVETRAIN_L_BACK);
		leftVic2 = new VictorSP(Constants.DRIVETRAIN_L_MIDDLE);
		leftVic3 = new VictorSP(Constants.DRIVETRAIN_L_FRONT);
		leftVics = new ArrayList<>(
				Arrays.asList(leftVic1, leftVic2, leftVic3));
		
		rightVic1 = new VictorSP(Constants.DRIVETRAIN_R_BACK);
		rightVic2 = new VictorSP(Constants.DRIVETRAIN_R_MIDDLE);
		rightVic3 = new VictorSP(Constants.DRIVETRAIN_R_FRONT);
		rightVics = new ArrayList<>(
				Arrays.asList(rightVic1, rightVic2, rightVic3));
	}
	
	public void stop() {
		setLeft(0);
		setRight(0);
	}
	
	public void setLeft(double speed) {
		for(VictorSP v : leftVics) {
			v.set(speed);
		}
	}
	
	public void setRight(double speed) {
		for(VictorSP v : rightVics) { 
			v.set(speed);
		}
	}

    public void initDefaultCommand() {
    	
    }
}

