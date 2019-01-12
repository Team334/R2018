package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartRightSwitchRightScale extends CommandGroup {

    public RightStartRightSwitchRightScale() {
        addParallel(new SetElevatorToScaleCommand());
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SCALE_DIAGONAL));
        addSequential(new WaitCommand(0.3));
        addSequential(new TurnCommand(-45)); // Turn to scale diagonally
        addSequential(new ReleasePowerCubeCommand());
        addSequential(new TurnCommand(-90)); // Turn to box
        addParallel(new SetElevatorToExchangeCommand());
        addSequential(new DriveForwardCommand(Constants.SWITCH_GAP_DISTANCE_AFTER_TURN));
        addSequential(new GrabPowerCubeCommand());
        addSequential(new SetElevatorToSwitchCommand());
        addSequential(new ReleasePowerCubeCommand()); // du yu knoe de wey
    }

}
