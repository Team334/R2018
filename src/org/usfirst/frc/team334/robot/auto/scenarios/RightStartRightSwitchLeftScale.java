package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.DriveForwardCommand;
import org.usfirst.frc.team334.robot.commands.auton.TurnCommand;
import org.usfirst.frc.team334.robot.commands.auton.WaitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartRightSwitchLeftScale extends CommandGroup {

    public RightStartRightSwitchLeftScale() {
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addSequential(new TurnCommand(-90)); // Turn left 90 to face scale
        addSequential(new WaitCommand(0.5)); // Placeholder for drop cube command
        addSequential(new TurnCommand(90)); // Turn away from scale
        addSequential(
                new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_REAR - Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addSequential(new TurnCommand(-90)); // Turn to box behind switch
        addSequential(new DriveForwardCommand(10)); // Go up to box
        addSequential(new WaitCommand(0.5)); // Placeholder for intake command
        addSequential(new TurnCommand(90)); // Turn to alleyway
        addSequential(new DriveForwardCommand(15)); // Move to middle of alleyway
        addSequential(new TurnCommand(-90)); // Turn to far side of alleyway
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_DISTANCE_FROM_ALLIANCE_WALL));
        addSequential(new TurnCommand(90)); // Turn to scale
        // Drop cube command
    }

}
