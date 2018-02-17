package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.commands.auton.FollowLeftWallAutonCommand;
import org.usfirst.frc.team334.robot.commands.auton.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeftEndRightScenario extends CommandGroup {
	
	public StartLeftEndRightScenario() {
		addSequential(new FollowLeftWallAutonCommand());
		addSequential(new TurnCommand(90));
	}
	
}
