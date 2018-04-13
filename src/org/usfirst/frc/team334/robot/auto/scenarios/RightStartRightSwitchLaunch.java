package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartRightSwitchLaunch extends CommandGroup {

    public RightStartRightSwitchLaunch() {
        addParallel(new AngleIntakeCommand());
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addSequential(new TurnCommand(-90)); // Turn to switch
        addSequential(new ReleasePowerCubeAutonCommand());
    }

}
