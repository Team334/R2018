package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartLeftSwitchLeftScale extends CommandGroup {

    public RightStartLeftSwitchLeftScale() {
        addParallel(new UnfoldIntakeCommand());
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL));
        addSequential(new TurnCommand(-90)); // Turn to alleyway
        addParallel(new SetElevatorToSwitchCommand());
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
        addSequential(new TurnCommand(-90)); // Turn to switch
        addSequential(new ReleasePowerCubeAutonCommand());
        addParallel(new TurnCommand(-30)); // Turn to switch cube
        addSequential(new CollapseElevatorCommand());
        addParallel(new GrabPowerCubeAutonCommand(2));
        addSequential(new DriveForwardCommand(Constants.SWITCH_GAP_DISTANCE_AFTER_ALLEYWAY_DROP));
        addParallel(new SetElevatorToScaleCommand());
        addSequential(new TurnCommand(180)); // Turn to scale
        addSequential(new WaitCommand(1));
        addSequential(new ReleasePowerCubeAutonCommand());
    }

}
