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
	
	private Compressor sCompressor;
	private AnalogInput compressorPressure;
	
	private DoubleSolenoid sPancakeL;
	private DoubleSolenoid sPancakeR;

	public Pneumatics() {
		sCompressor = new Compressor(Constants.COMPRESSOR);
		compressorPressure = new AnalogInput(Constants.PRESSURE_SENSOR);
		
		sPancakeL = new DoubleSolenoid(Constants.PANCAKE_L_INPUT, Constants.PANCAKE_L_OUTPUT);
		sPancakeR = new DoubleSolenoid(Constants.PANCAKE_R_INPUT, Constants.PANCAKE_R_OUTPUT);
		
		// default = one transmission
		mTransmissionState = TransmissionState.LOW_SPEED;
		setLowSpeedTransmission();
	}
	
	public void setLowSpeedTransmission() {
		if (mTransmissionState != TransmissionState.LOW_SPEED) {
			mTransmissionState = TransmissionState.LOW_SPEED;
			sPancakeL.set(DoubleSolenoid.Value.kReverse);
			sPancakeR.set(DoubleSolenoid.Value.kReverse);
		}
	}
	
	public void setHighSpeedTransmission() {
		if (mTransmissionState != TransmissionState.HIGH_SPEED) {
			mTransmissionState = TransmissionState.HIGH_SPEED;
			sPancakeL.set(DoubleSolenoid.Value.kForward);
			sPancakeR.set(DoubleSolenoid.Value.kForward);
		}
	}
	
	public int getPressure() {
		return compressorPressure.getAverageValue();
	}

	public boolean isCompressorLowPressure() {
		return ((getPressure() < 500) ? true : false);
	}

	// Running these commands will turn off compressor automatic mode 
	// (Compressor runs when pressure <110psi)
	public void runCompressor() {
		sCompressor.start();
	}

	public void stopCompressor() {
		sCompressor.stop();
	}

    public void initDefaultCommand() {
    	
    }
}

