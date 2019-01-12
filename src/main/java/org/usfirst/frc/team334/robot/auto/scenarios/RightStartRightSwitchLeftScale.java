package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartRightSwitchLeftScale extends CommandGroup {

    public RightStartRightSwitchLeftScale() {
        addParallel(new SetElevatorToSwitchCommand());
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addSequential(new TurnCommand(-90)); // Turn left 90 to face switch
        addSequential(new ReleasePowerCubeCommand());
        addSequential(new TurnCommand(90)); // Turn away from switch
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_REAR - Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addParallel(new SetElevatorToExchangeCommand());
        addSequential(new TurnCommand(-90)); // Turn to box behind switch
        addSequential(new DriveForwardCommand(10)); // Go up to box
        addSequential(new GrabPowerCubeCommand());
        addSequential(new TurnCommand(90)); // Turn to alleyway
        addSequential(new DriveForwardCommand(15)); // Move to middle of alleyway
        addSequential(new TurnCommand(-90)); // Turn to far side of alleyway
        addParallel(new SetElevatorToScaleCommand());
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
        addSequential(new TurnCommand(90)); // Turn to scale
        addSequential(new ReleasePowerCubeCommand());
    }

}
