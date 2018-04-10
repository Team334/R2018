package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ControlSurfaceTest extends CommandGroup {

    public ControlSurfaceTest() {
        addParallel(new UnfoldIntakeCommand());
        addSequential(new SetElevatorToSwitchCommand());
        addSequential(new GrabPowerCubeTestCommand());
        addSequential(new ReleasePowerCubeAutonCommand());
        addParallel(new FoldIntakeCommand());
        addParallel(new CollapseElevatorCommand());
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
    }

}
