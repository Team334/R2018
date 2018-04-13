package org.usfirst.frc.team334.robot.subsystems;
import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollerIntake extends Subsystem {
	private VictorSP leftMotor;
	private VictorSP rightMotor;
	public static VictorSP windowMotor;
	private DigitalInput rBoxLimitSwitch1;
	private DigitalInput rBoxLimitSwitch2;
	
	public RollerIntake() {
		leftMotor = new VictorSP(Constants.INTAKE_MOTOR_L);
		rightMotor = new VictorSP(Constants.INTAKE_MOTOR_R);
		windowMotor = new VictorSP(Constants.INTAKE_WINDOW_MOTOR);
		rBoxLimitSwitch1 = new DigitalInput(Constants.INTAKE_BOX_LIMITSWITCH_1);
		rBoxLimitSwitch2 = new DigitalInput(Constants.INTAKE_BOX_LIMITSWITCH_2);
	}
	
    public void setMotorSpeed(double speed) {
    	leftMotor.set(-speed);
    	rightMotor.set(speed);
    }

    public boolean getLimitSwitch1() {
    	return rBoxLimitSwitch1.get();
    } 
    
    public boolean getLimitSwitch2() {
    	return rBoxLimitSwitch2.get();
    }
    
    public void setWindowSpeed(double speed) {
        windowMotor.set(speed);
    }
    
    public void foldStop() {
        windowMotor.stopMotor();
    }
    
    public void initDefaultCommand() {
    }
}