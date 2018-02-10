package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.commands.Drivetrain.FollowRightWallAutonCommand;
import org.usfirst.frc.team334.robot.commands.Drivetrain.TurnCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StartRightEndLeftScenario extends CommandGroup {
	
	public StartRightEndLeftScenario() {
		addSequential(new FollowRightWallAutonCommand());
		addSequential(new TurnCommand(-90));
	}
	
}
