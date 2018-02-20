package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStartRightSwitch extends CommandGroup {

    public LeftStartRightSwitch() {
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL));
        addSequential(new TurnCommand(90)); // Turn to alleyway
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
        addSequential(new TurnCommand(90)); // Turn to switch
        // Drop cube command
    }

}
