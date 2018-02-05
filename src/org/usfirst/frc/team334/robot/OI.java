package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.commands.FillAirTanksCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	//Joysticks
	 Joystick thrustMaster = new Joystick(0);
	 
	//Buttons
	 Button button = new JoystickButton(thrustMaster,1);
	 
	 public OI() {
		 button.whenPressed(new FillAirTanksCommand());
	 }
}
