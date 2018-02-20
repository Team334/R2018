package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.DriveForwardCommand;
import org.usfirst.frc.team334.robot.commands.auton.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStartRightSwitchRightScale extends CommandGroup {

	public LeftStartRightSwitchRightScale() {
		addSequential(new DriveForwardCommand(Constants.ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL));
		addSequential(new TurnCommand(90)); // Turn to alleyway
		addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
		addSequential(new TurnCommand(90)); // Turn to switch
		// Drop cube command
		// Pickup cube command
		addSequential(new TurnCommand(180)); // Turn to scale
		// Drop cube command
	}

}
