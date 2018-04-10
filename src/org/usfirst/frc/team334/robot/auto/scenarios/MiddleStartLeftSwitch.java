package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.DriveForwardCommand;
import org.usfirst.frc.team334.robot.commands.auton.TurnCommand;
import org.usfirst.frc.team334.robot.commands.intake.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleStartLeftSwitch extends CommandGroup {
    
    // -90 is turn left, 90 is turn right
    public MiddleStartLeftSwitch() {
//        addParallel(new AngleIntakeCommand());
        addSequential(new DriveForwardCommand(Constants.DISTANCE_HALFWAY_TO_SWITCH));
        addSequential(new TurnCommand(-90));
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH / 2));
        addSequential(new TurnCommand(90));
        addSequential(new DriveForwardCommand(Constants.DISTANCE_HALFWAY_TO_SWITCH));
        addSequential(new ReleasePowerCubeCommand());
    }
}
