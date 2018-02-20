package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStartLeftSwitchLeftScale extends CommandGroup {

	public LeftStartLeftSwitchLeftScale() {
		addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SCALE_DIAGONAL));
		addSequential(new WaitCommand(0.3));
		addSequential(new TurnCommand(Constants.TURN_TO_SCALE_FROM_LEFT));
		addSequential(new WaitCommand(0.5));
		addSequential(new TurnCommand(Constants.TURN_TO_SWITCH_CUBE_FROM_LEFT));
		addSequential(new DriveForwardCommand(Constants.SWITCH_GAP_DISTANCE_AFTER_TURN));
	}

}
