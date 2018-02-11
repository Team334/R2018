package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.commands.Auton.FollowRightWallAutonCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRightEndRightScenario extends CommandGroup {
	
	public StartRightEndRightScenario() {
		addSequential(new FollowRightWallAutonCommand());
	}
	
}
