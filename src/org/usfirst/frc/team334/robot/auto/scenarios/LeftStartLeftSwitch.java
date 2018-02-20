package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStartLeftSwitch extends CommandGroup {

	public LeftStartLeftSwitch() {
		addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
		addSequential(new TurnCommand(Constants.TURN_TO_SCALE_FROM_LEFT_PARALLEL));
	}

}
