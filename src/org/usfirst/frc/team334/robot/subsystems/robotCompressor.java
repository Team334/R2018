package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class robotCompressor extends Subsystem {
	public Compressor compressor = new Compressor(RobotMap.compressor);
	public AnalogInput compressorValue = new AnalogInput(RobotMap.pressureSensor);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public int getPressure() {
		return compressorValue.getAverageValue();
	}
	public boolean lowPressure() {
		return ((getPressure()<500) ? true : false);
	}
	
	
	// If you run these commands the compressor is taken out of automatic mode (Compressor runs when pressure <110psi)
	public void runCompressor() {
		compressor.start();
	}
	public void stopCompressor() {
		compressor.stop();
	}
    public void initDefaultCommand() {
    }
}

