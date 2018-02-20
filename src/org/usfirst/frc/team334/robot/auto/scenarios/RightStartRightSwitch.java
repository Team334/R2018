package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.DriveForwardCommand;
import org.usfirst.frc.team334.robot.commands.auton.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartRightSwitch extends CommandGroup {

	public RightStartRightSwitch() {
		addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
		addSequential(new TurnCommand(-90)); // Turn to switch
		// Drop cube command
	}

}
