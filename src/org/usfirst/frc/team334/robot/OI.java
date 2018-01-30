
package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.commands.toggleDogShift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	//Joysticks
	 Joystick thrustMaster = new Joystick(0);
	 
	//Buttons
	 Button toggleShift = new JoystickButton(thrustMaster,1);
	 
	 public OI() {
		 toggleShift.whenPressed(new toggleDogShift());
	 }
}
