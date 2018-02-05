package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	VictorSP cim1 = new VictorSP(Constants.elCim1);
	VictorSP cim2 = new VictorSP(Constants.elCim2);
	
	public void setInvert() {
		cim1.setInverted(true);
		cim2.setInverted(true);
	}
	
	public void setElevator(double speed) {
		cim1.set(speed);
		cim2.set(speed);
	}
	
    public void initDefaultCommand() {
    	
    }
}

