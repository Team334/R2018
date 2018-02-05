package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	public Compressor compressor = new Compressor(Constants.compressor);
	public AnalogInput compressorValue = new AnalogInput(Constants.pressureSensor);

	DoubleSolenoid pancakeL = new DoubleSolenoid(Constants.pancakeLI, Constants.pancakeLO);
	DoubleSolenoid pancakeR = new DoubleSolenoid(Constants.pancakeRI, Constants.pancakeRO);

	public int getPressure() {
		return compressorValue.getAverageValue();
	}

	public boolean lowPressure() {
		return ((getPressure() < 500) ? true : false);
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

