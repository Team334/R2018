package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.commands.auton.FollowLeftWallAutonCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartLeftEndLeftScenario extends CommandGroup {
	
	public StartLeftEndLeftScenario() {
		addSequential(new FollowLeftWallAutonCommand());
	}
	
}
