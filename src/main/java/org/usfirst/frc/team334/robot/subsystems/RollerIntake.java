package org.usfirst.frc.team334.robot.subsystems;
import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollerIntake extends Subsystem {
	private VictorSP leftMotor;
	private VictorSP rightMotor;
	private DigitalInput rLimitSwitch1;
	private DigitalInput rLimitSwitch2;
	
	public RollerIntake() {
		leftMotor = new VictorSP(Constants.INTAKE_MOTOR_L);
		rightMotor = new VictorSP(Constants.INTAKE_MOTOR_R);
		rLimitSwitch1 = new DigitalInput(Constants.INTAKE_LIMITSWITCH_1);
		rLimitSwitch2 = new DigitalInput(Constants.INTAKE_LIMITSWITCH_2);
	}
    public void setMotorSpeed(double speed) {
    	leftMotor.set(-speed);
    	rightMotor.set(speed);
    }

    public boolean getLimitSwitch1() {
    	return rLimitSwitch1.get();
    } 
    
    public boolean getLimitSwitch2() {
    	return rLimitSwitch1.get();
    } 
    
    public void initDefaultCommand() {
    }
}