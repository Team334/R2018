package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class elevator extends Subsystem {
	private double multiplier = 1;
	VictorSP cim1 = new VictorSP(RobotMap.elCim1);
	VictorSP cim2 = new VictorSP(RobotMap.elCim2);
	
	public void setInvert() {
		cim1.setInverted(true);
		cim2.setInverted(true);
	}
	
	public void setElevatorSpeed(double newmlt) {
		if(newmlt<1 && newmlt>-1) {
			multiplier = newmlt;
		}
	}
	public void runElevator(double speed) {
		cim1.set(speed*multiplier);
		cim2.set(speed*multiplier);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

