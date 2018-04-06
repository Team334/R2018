package org.usfirst.frc.team334.robot.subsystems;
import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollerIntake extends Subsystem {
	private VictorSP leftMotor;
	private VictorSP rightMotor;
	private VictorSP windowMotor;
	private DigitalInput rBoxLimitSwitch1;
	private DigitalInput rBoxLimitSwitch2;
	private DigitalInput rFoldLimitSwitch;
	
	public RollerIntake() {
		leftMotor = new VictorSP(Constants.INTAKE_MOTOR_L);
		rightMotor = new VictorSP(Constants.INTAKE_MOTOR_R);
		windowMotor = new VictorSP(Constants.INTAKE_WINDOW_MOTOR);
		rBoxLimitSwitch1 = new DigitalInput(Constants.INTAKE_BOX_LIMITSWITCH_1);
		rBoxLimitSwitch2 = new DigitalInput(Constants.INTAKE_BOX_LIMITSWITCH_2);
		rFoldLimitSwitch = new DigitalInput(Constants.INTAKE_FOLD_LIMITSWITCH);
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
    
    public boolean getFoldLimitSwtich() {
        return rFoldLimitSwitch.get();
    }
    
    public void foldIntake() {
        windowMotor.set(0.4);
    }
    
    public void unfoldIntake() {
        windowMotor.set(-0.4);
    }
    
    public void foldStop() {
        windowMotor.stopMotor();
    }
    
    public void initDefaultCommand() {
    }
}