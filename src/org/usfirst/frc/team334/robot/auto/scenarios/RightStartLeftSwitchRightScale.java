package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightStartLeftSwitchRightScale extends CommandGroup {

    public RightStartLeftSwitchRightScale() {
        addSequential(new DriveForwardCommand(Constants.DISTANCE_TO_SCALE_DIAGONAL));
        addSequential(new WaitCommand(0.3));
        addSequential(new TurnCommand(-45)); // Turn to scale diagonally
        addSequential(new WaitCommand(0.5)); // Placeholder for drop cube command
        addSequential(new TurnCommand(-90)); // Turn to box
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_GAP_DISTANCE_AFTER_TURN));
        addSequential(new TurnCommand(45)); // Turn to alleyway
        addSequential(new DriveForwardCommand(Constants.ALLEYWAY_TOTAL_LENGTH));
        addSequential(new TurnCommand(-90)); // Turn to switch box
        // Intake cube
        // Drop cube command
    }

}