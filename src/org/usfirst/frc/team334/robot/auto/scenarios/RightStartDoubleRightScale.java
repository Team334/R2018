package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartDoubleRightScale extends CommandGroup {

    public RightStartDoubleRightScale() {
        addParallel(new UnfoldIntakeCommand());
        addParallel(new SetElevatorToScaleCommand());
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SCALE_DIAGONAL));
        addSequential(new TurnCommand(-45)); // Turn to scale diagonally
        addSequential(new ReleasePowerCubeAutonCommand());
        addSequential(new TurnCommand(-90)); // Turn to box
        addSequential(new CollapseElevatorCommand());
        addParallel(new GrabPowerCubeAutonCommand(2));
        addSequential(new DriveForwardCommand(Constants.SWITCH_GAP_DISTANCE_AFTER_TURN));
        addParallel(new SetElevatorToScaleCommand());
        addSequential(new TurnCommand(135));
        addSequential(new DriveForwardCommand(Constants.DOUBLE_SCALE_GAP_DISTANCE));
        addSequential(new ReleasePowerCubeAutonCommand());
    }

}
