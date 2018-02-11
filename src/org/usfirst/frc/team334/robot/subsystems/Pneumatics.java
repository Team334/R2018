package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	
	public enum TransmissionState {
		LOW_SPEED,
		HIGH_SPEED
	}
	
	private TransmissionState mTransmissionState;
	
	private Compressor compressor;
	private AnalogInput compressorPressure;
	
	private DoubleSolenoid pancakeL;
	private DoubleSolenoid pancakeR;

	public Pneumatics() {
		compressor = new Compressor(Constants.COMPRESSOR);
		compressorPressure = new AnalogInput(Constants.PRESSURE_SENSOR);
		
		pancakeL = new DoubleSolenoid(Constants.PANCAKE_L_INPUT, Constants.PANCAKE_L_OUTPUT);
		pancakeR = new DoubleSolenoid(Constants.PANCAKE_R_INPUT, Constants.PANCAKE_R_OUTPUT);
		
		// default = one transmission
		mTransmissionState = TransmissionState.LOW_SPEED;
		setLowSpeedTransmission();
	}
	
	public void setLowSpeedTransmission() {
		if (mTransmissionState != TransmissionState.LOW_SPEED) {
			mTransmissionState = TransmissionState.LOW_SPEED;
			pancakeL.set(DoubleSolenoid.Value.kReverse);
			pancakeR.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	public void setHighSpeedTransmission() {
		if (mTransmissionState != TransmissionState.HIGH_SPEED) {
			mTransmissionState = TransmissionState.HIGH_SPEED;
			pancakeL.set(DoubleSolenoid.Value.kForward);
			pancakeR.set(DoubleSolenoid.Value.kForward);
		}
	}

	public TransmissionState getTransmissionState() {
		return mTransmissionState;
	}
	
	public int getPressure() {
		return compressorPressure.getAverageValue();
	}

	public boolean isCompressorLowPressure() {
		return (getPressure() < 500) ? true : false;
	}

	// Running these commands will turn off compressor automatic mode 
	// (Compressor runs when pressure <110psi)
	public void runCompressor() {
		compressor.start();
	}

	public void stopCompressor() {
		compressor.stop();
	}

    public void initDefaultCommand() {
    	
    }
    
}
