package org.usfirst.frc.team334.robot.auto.scenarios;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.commands.auton.*;
import org.usfirst.frc.team334.robot.commands.elevator.*;
import org.usfirst.frc.team334.robot.commands.intake.*;
import org.usfirst.frc.team334.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ControlSurfaceTest extends CommandGroup {

    public ControlSurfaceTest() {
        System.out.println("Running Control Surfaces Test...");
        addParallel(new UnfoldIntakeCommand());
        addParallel(new DriveForwardCommand(Constants.DISTANCE_TO_SWITCH_PARALLEL));
        addSequential(new SetElevatorToSwitchCommand());
        addSequential(new GrabPowerCubeAutonCommand(1));
        addSequential(new ReleasePowerCubeAutonCommand());
        addParallel(new FoldIntakeCommand());
        addParallel(new CollapseElevatorCommand());
        System.out.println("Gyro Initialization Check:");
        System.out.println(Drive.rGyro.isInitialized());
        System.out.println("Gyro Calibration Check:");
        System.out.println(Drive.rGyro.isCalibrated());
        System.out.println("Gyro Calibration Level:");
        System.out.println(Drive.rGyro.getCalibration());
    }

}
