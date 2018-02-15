package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	private VictorSP motor1;
	private VictorSP motor2;
	
	private DigitalInput rLimitSwitchBottom;
	private DigitalInput rLimitSwitchTop;
	
	public Climber(){
		motor1 = new VictorSP(Constants.CLIMBER_MOTOR_1);
		motor2 = new VictorSP(Constants.CLIMER_MOTOR_2);
		rLimitSwitchBottom = new DigitalInput(Constants.CLIMBER_LIMITSWITCH_BOTTOM);
		rLimitSwitchTop = new DigitalInput(Constants.CLIMBER_LIMITSWITCH_TOP);
	}
	
	public void setClimberSpeed(double speed){
		motor1.set(speed);
		motor2.set(speed);
	}
	
	public boolean getBottomLimitswitch(){
		return rLimitSwitchBottom.get();
	}
	
	public boolean getTopLimitswitch(){
		return rLimitSwitchTop.get();
	}
	
    public void initDefaultCommand() {
    }
}

