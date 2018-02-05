package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * DriveTrain for 2018 Robot
 * 6 Cims (3 Each)
 */
public class Drive extends Subsystem {

	VictorSP LC1 = new VictorSP(Constants.cimL1);
	VictorSP LC2 = new VictorSP(Constants.cimL2);
	VictorSP LC3 = new VictorSP(Constants.miniCimL);
	VictorSP RC1 = new VictorSP(Constants.cimR1);
	VictorSP RC2 = new VictorSP(Constants.cimR2);
	VictorSP RC3 = new VictorSP(Constants.miniCimR);

	public void setInvert(){
		LC1.setInverted(true);
		LC2.setInverted(true);
		LC3.setInverted(true);
		RC1.setInverted(true);
		RC2.setInverted(true);
		RC3.setInverted(true);
	}
	
	
	public void setAll(double speed) {
		LC1.set(speed);
		LC2.set(speed);
		LC3.set(speed);
		RC1.set(speed);
		RC2.set(speed);
		RC3.set(speed);
	}
	
	public void setLeft(double speed) {
		LC1.set(speed);
		LC2.set(speed);
		LC3.set(speed);
	}
	
	public void setRight(double speed) {
		RC1.set(speed);
		RC2.set(speed);
		RC3.set(speed);
	}

    public void initDefaultCommand() {
    }
}

