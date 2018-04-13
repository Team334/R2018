package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartLeftSwitchLaunch extends CommandGroup {

    public RightStartLeftSwitchLaunch() {
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL));
        addSequential(new TurnCommand(-90)); // Turn to alleyway
        addParallel(new AngleIntakeCommand());
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
        addSequential(new TurnCommand(-90)); // Turn to switch
        addSequential(new ReleasePowerCubeAutonCommand());
    }

}
