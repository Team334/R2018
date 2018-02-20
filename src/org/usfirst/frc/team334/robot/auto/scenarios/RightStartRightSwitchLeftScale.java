package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.commands.auton.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartRightSwitchLeftScale extends CommandGroup {

	public RightStartRightSwitchLeftScale() {
		addSequential(new TurnCommand(-90));
	}

}
