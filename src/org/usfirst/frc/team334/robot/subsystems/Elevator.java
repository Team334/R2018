package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	
	private VictorSP left;
	private VictorSP right;

	private DigitalInput rTopLimit;
	private DigitalInput rBottomLimit;

	private Encoder rElevatorEncoder;

	public Elevator() {
		super(Constants.ELEVATOR_P, Constants.ELEVATOR_I, Constants.ELEVATOR_D);
		
		left = new VictorSP(Constants.ELEVATOR_MOTOR_LEFT);
		right = new VictorSP(Constants.ELEVATOR_MOTOR_RIGHT);
		
		rTopLimit = new DigitalInput(Constants.ELEVATOR_LIMIT_TOP);
		rBottomLimit = new DigitalInput(Constants.ELEVATOR_LIMIT_BOTTOM);
		
		rElevatorEncoder = new Encoder(Constants.ELEVATOR_ENCODER_A, Constants.ELEVATOR_ENCODER_B);
		
		this.disable();
		this.setAbsoluteTolerance(0);
		this.setOutputRange(-1, 0);
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
		return rElevatorEncoder.get();
	}
	
	@Override
	protected void usePIDOutput(double output) {
//		System.out.println("Error: " + output + "Encoder Value: " + rElevatorEncoder.get());
		setMotors(output);
	}
	
	public boolean getTopLimitSwitch() {
		return rTopLimit.get();
	}
	
	public boolean getBottomLimitSwitch() {
		return rBottomLimit.get();
	}
	
	public Encoder getEncoder() {
		return rElevatorEncoder;
	}
	
    public void initDefaultCommand() {
    	
    }
}
