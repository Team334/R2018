package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	
	private VictorSP left;
	private VictorSP right;

	private DigitalInput rTopLimit;
	private DigitalInput rBottomLimit;

	private AnalogPotentiometer rPotentiometer;

	public Elevator() {
		super(Constants.ELEVATOR_P, Constants.ELEVATOR_I, Constants.ELEVATOR_D);
		
		left = new VictorSP(Constants.ELEVATOR_MOTOR_LEFT);
		right = new VictorSP(Constants.ELEVATOR_MOTOR_RIGHT);
		
		rTopLimit = new DigitalInput(Constants.ELEVATOR_LIMIT_TOP);
		rBottomLimit = new DigitalInput(Constants.ELEVATOR_LIMIT_BOTTOM);
		
		rPotentiometer = new AnalogPotentiometer(Constants.ELEVATOR_POTENTIOMETER);
		
		this.disable();
		this.setAbsoluteTolerance(1);
		this.setOutputRange(-1, 1);
	}
	
	public void setMotors(double speed) {
		left.set(speed);
		right.set(speed);
	}
	
	public void stop() {
		left.set(0);
		right.set(0);
	}
	
	@Override
	protected double returnPIDInput() {
		return rPotentiometer.get();
	}
	
	@Override
	protected void usePIDOutput(double output) {
		// System.out.println("Error: " + output + "Potentiometer Value: " + rPotentiometer.get());
		setMotors(output * .1);
	}
	
	public boolean getTopLimitSwitch() {
		return rTopLimit.get();
	}
	
	public boolean getBottomLimitSwitch() {
		return rBottomLimit.get();
	}
	
	public AnalogPotentiometer getPotentiometer() {
		return rPotentiometer;
	}
	
    public void initDefaultCommand() {
    	
    }
}
