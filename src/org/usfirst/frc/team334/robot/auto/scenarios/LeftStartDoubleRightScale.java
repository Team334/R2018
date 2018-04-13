package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftStartDoubleRightScale extends CommandGroup {

    public LeftStartDoubleRightScale() {
        addParallel(new UnfoldIntakeCommand());
        addParallel(new SetElevatorToScaleCommand());
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL));
        addSequential(new TurnCommand(90)); // Turn to alleyway
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
        addSequential(new TurnCommand(-90)); // Turn to scale
        addSequential(new ReleasePowerCubeAutonCommand());
        addSequential(new TurnCommand(180)); // Turn to cube pickup location
        addParallel(new CollapseElevatorCommand());
        addParallel(new GrabPowerCubeAutonCommand(2));
        addSequential(new DriveForwardCommand(Constants.DOUBLE_SCALE_GAP_DISTANCE));
        addSequential(new TurnCommand(180));
        addParallel(new SetElevatorToScaleCommand());
        addSequential(new DriveForwardCommand(Constants.DOUBLE_SCALE_GAP_DISTANCE));
        addSequential(new ReleasePowerCubeAutonCommand());
    }

}
