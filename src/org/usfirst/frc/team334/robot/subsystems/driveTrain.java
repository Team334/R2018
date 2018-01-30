package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * DriveTrain for 2018 Robot
 * 6 Cims (3 Each), 2 Pancake Solenoids (1 Each)
 */
public class driveTrain extends Subsystem {
	boolean torque = false;

	VictorSP LC1 = new VictorSP(RobotMap.cimL1);
	VictorSP LC2 = new VictorSP(RobotMap.cimL2);
	VictorSP LC3 = new VictorSP(RobotMap.miniCimL);
	VictorSP RC1 = new VictorSP(RobotMap.cimR1);
	VictorSP RC2 = new VictorSP(RobotMap.cimR2);
	VictorSP RC3 = new VictorSP(RobotMap.miniCimR);
	
	DoubleSolenoid pancakeL = new DoubleSolenoid(RobotMap.pancakeLI,RobotMap.pancakeLO);
	DoubleSolenoid pancakeR = new DoubleSolenoid(RobotMap.pancakeRI,RobotMap.pancakeRO);

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
	
	public void toggleDog() {
		System.out.println(torque);
		if (torque) {
			pancakeL.set(DoubleSolenoid.Value.kReverse);
			pancakeR.set(DoubleSolenoid.Value.kReverse);
			torque = false;
		}else {
			torque = true;
			pancakeL.set(DoubleSolenoid.Value.kForward);
			pancakeR.set(DoubleSolenoid.Value.kForward);
		}
	}
	public boolean getTorqueLevel() {
		return torque;
	}

    public void initDefaultCommand() {
    }
}

