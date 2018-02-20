package org.usfirst.frc.team334.robot.subsystems;
import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RollerIntake extends Subsystem {
	private VictorSP leftMotor;
	private VictorSP rightMotor;
	private Ultrasonic rUltrasonic;
	
	public RollerIntake() {
		leftMotor = new VictorSP(Constants.INTAKE_MOTOR_L);
		rightMotor = new VictorSP(Constants.INTAKE_MOTOR_R);
		rUltrasonic = new Ultrasonic(Constants.INTAKE_ULTRASONIC_PING,Constants.INTAKE_ULTRASONIC_OUTPUT);
		rUltrasonic.setAutomaticMode(true);
	}
    public void setMotorSpeed(double speed) {
    	leftMotor.set(-speed);
    	rightMotor.set(speed);
    }

    public double getRangeInches() {
    	return rUltrasonic.getRangeInches();
    } 
    
    public void initDefaultCommand() {
    }
}