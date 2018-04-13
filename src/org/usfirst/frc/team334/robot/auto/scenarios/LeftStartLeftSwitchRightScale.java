package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStartLeftSwitchRightScale extends CommandGroup {

    public LeftStartLeftSwitchRightScale() {
        addParallel(new SetElevatorToSwitchCommand());
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addSequential(new TurnCommand(90)); // Turn right 90 to face switch
        addSequential(new ReleasePowerCubeAutonCommand());
        addSequential(new TurnCommand(-90)); // Turn away from switch
        addParallel(new CollapseElevatorCommand());
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL - Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addSequential(new TurnCommand(45)); // Turn to box behind switch
        addSequential(new GrabPowerCubeAutonCommand(1));
        addSequential(new DriveForwardCommand(Constants.SWITCH_GAP_DISTANCE_AFTER_ALLEYWAY_TURN));
        addSequential(new DriveForwardCommand(-Constants.SWITCH_GAP_DISTANCE_AFTER_ALLEYWAY_TURN));
        addSequential(new TurnCommand(-45)); // Turn to alleyway
        addParallel(new SetElevatorToSwitchCommand());
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
        addSequential(new TurnCommand(-90)); // Turn to scale
        addSequential(new ReleasePowerCubeAutonCommand());
    }

}
