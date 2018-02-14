package org.usfirst.frc.team334.robot.subsystems;
import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollerIntake extends Subsystem {
	private VictorSP leftMotor;
	private VictorSP rightMotor;
	private Ultrasonic sUltrasonic;
	
	public RollerIntake(){
		leftMotor = new VictorSP(Constants.INTAKE_MOTOR_L);
		rightMotor = new VictorSP(Constants.INTAKE_MOTOR_R);
		sUltrasonic = new Ultrasonic(Constants.INTAKE_ULTRASONIC_PING,Constants.INTAKE_ULTRASONIC_OUTPUT);
		sUltrasonic.setAutomaticMode(true);
	}
    public void setMotorSpeed(double speed){
    	leftMotor.set(speed * -1);
    	rightMotor.set(speed);
    }
    
    public void stopMotors(){
    	leftMotor.set(0);
    	rightMotor.set(0);
    }

    public double getRangeInches(){
    	return sUltrasonic.getRangeInches();
    } 
    
    public void initDefaultCommand() {
    }
}