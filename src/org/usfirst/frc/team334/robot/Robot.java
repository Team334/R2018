package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.auto.scenarios.*;
import org.usfirst.frc.team334.robot.commands.drivetrain.TankDriveCommand;
import org.usfirst.frc.team334.robot.commands.elevator.ElevatorCommand;
import org.usfirst.frc.team334.robot.commands.intake.IntakePitchCommand;
import org.usfirst.frc.team334.robot.subsystems.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
   
    private DriverStation fms = DriverStation.getInstance();

    // Initialize subsystems
    public static Drive sDrive;
    public static Elevator sElevator;
    public static Pneumatics sPneumatics;
    public static RollerIntake sRollerIntake;
    
    private CommandGroup auton_command;
    
    private SendableChooser<Boolean> m_chooser;
    private SendableChooser<String> position_chooser;
    
    public static OI m_oi;

    public static double absoluteHeading;

    @Override
    public void robotInit() {
        
        sDrive = new Drive();
        sElevator = new Elevator();
        sPneumatics = new Pneumatics();
        sRollerIntake = new RollerIntake();

        m_chooser = new SendableChooser<>();
        m_chooser.addDefault("Default (no scale)", false);
        m_chooser.addObject("Do Scale", true);
        
        position_chooser = new SendableChooser<>();
        position_chooser.addDefault("M", "M");
        position_chooser.addObject("R", "R");
        position_chooser.addObject("L", "L");
        
        m_oi = new OI();

        // Shows starting position selector
        SmartDashboard.putData("Starting Position Selector", position_chooser);
        // Shows scale auton option
        SmartDashboard.putData("Auton Scale Selector", m_chooser);
    }

    @Override
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void disabledPeriodic() {
        SmartDashboard.putString("Starting Position", position_chooser.getSelected().toString());
        SmartDashboard.putBoolean("Gyro Initialization", Drive.rGyro.isInitialized());
    }

    @Override
    public void autonomousInit() {
        absoluteHeading = 0;

        Drive.rEncoderLeft.reset();
        Drive.rEncoderRight.reset();
        Drive.rGyro.resetHeading();
        Robot.sElevator.rEncoder.reset();

        Robot.sDrive.setNormal(); // Reverse motors just for auton

        Scheduler.getInstance().removeAll();

        // Gets info from "Game Data" in FRC Driver Station
        String fieldConfig = fms.getGameSpecificMessage();
        SmartDashboard.putString("Field Config", fieldConfig);
        SmartDashboard.putString("Starting Pos", position_chooser.getSelected().toString());
        
        String startPos = position_chooser.getSelected().toString();
                
        boolean doScaleAuton = m_chooser.getSelected().booleanValue(); // 0 = switch only
                                                                       // 1 = scale and switch
        
        doScaleAuton = false;
        
        // Checks info from FMS to schedule correct auton command.
        if (startPos.equals("L")) { // LEFT START
            switch (fieldConfig) {
                // Switch same side
                case "LRL":
                    if (doScaleAuton) {
                        auton_command = new LeftStartLeftSwitchRightScale();
                        // auton_command = new LeftStartDoubleRightScale(); DOUBLE SCALE
                        SmartDashboard.putString("Scenario", "L:LRL+S");
                    } else {
                        auton_command = new LeftStartLeftSwitch();
                        SmartDashboard.putString("Scenario", "L:LRL");
                    }
                    break;
                case "LLL":
                    if (doScaleAuton) {
                        auton_command = new LeftStartLeftSwitchLeftScale();
                        // auton_command = new LeftStartDoubleLeftScale(); DOUBLE SCALE
                        SmartDashboard.putString("Scenario", "L:LLL+S");
                    } else { 
                        auton_command = new LeftStartLeftSwitch();
                        SmartDashboard.putString("Scenario", "L:LLL");
                    }
                    break;
                // Switch opposite side
                case "RLR":
                    if (doScaleAuton) {
                        auton_command = new LeftStartRightSwitchLeftScale();
                        // auton_command = new LeftStartDoubleLeftScale(); DOUBLE SCALE
                        SmartDashboard.putString("Scenario", "L:RLR+S");
                    } else { 
                        auton_command = new LeftStartRightSwitch();
                        SmartDashboard.putString("Scenario", "L:RLR");
                    }
                    break;
                case "RRR":
                    if (doScaleAuton) {
                        auton_command = new LeftStartRightSwitchRightScale();
                        // auton_command = new LeftStartDoubleRightScale(); DOUBLE SCALE
                        SmartDashboard.putString("Scenario", "L:RRR+S");
                    } else {
                        auton_command = new LeftStartRightSwitch();
                        SmartDashboard.putString("Scenario", "L:RRR");
                    }
                    break;
                default:
                    auton_command = new CrossLine();
            }
        } else if (startPos.equals("R")) { // RIGHT START
            switch (fieldConfig) {
                // Switch opposite side
                case "LRL":
                    if (doScaleAuton) {
                        auton_command = new RightStartLeftSwitchRightScale();
                        // auton_command = new RightStartDoubleRightScale();
                        SmartDashboard.putString("Scenario", "R:LRL+S");
                    } else {
                        auton_command = new RightStartLeftSwitch();
                        SmartDashboard.putString("Scenario", "R:LRL");
                    }
                    break;
                case "LLL":
                    if (doScaleAuton) {
                        auton_command = new RightStartLeftSwitchLeftScale();
                        // auton_command = new RightStartDoubleLeftScale(); DOUBLE SCALE
                        SmartDashboard.putString("Scenario", "R:LLL+S");
                    } else { 
                        auton_command = new RightStartLeftSwitch();
                        SmartDashboard.putString("Scenario", "R:LLL");
                    }
                    break;
                // Switch same side
                case "RLR":
                    if (doScaleAuton) {
                        auton_command = new RightStartRightSwitchLeftScale();
                        // auton_command = new RightStartDoubleLeftScale(); DOUBLE SCALE
                        SmartDashboard.putString("Scenario", "R:RLR+S");
                    } else {
                        auton_command = new RightStartRightSwitch();
                        SmartDashboard.putString("Scenario", "R:RLR");
                    }
                    break;
                case "RRR":
                    if (doScaleAuton) {
                        auton_command = new RightStartRightSwitchRightScale();
                        // auton_command = new RightStartDoubleRightScale(); DOUBLE SCALE 
                        SmartDashboard.putString("Scenario", "R:RRR+S");
                    } else {
                        auton_command = new RightStartRightSwitch();
                        SmartDashboard.putString("Scenario", "R:RRR");
                    }
                    break;
                default:
                    auton_command = new CrossLine();
                    SmartDashboard.putString("Scenario", "Cross");
            }
        } else { // MIDDLE START
            auton_command = new CrossLine();
            SmartDashboard.putString("Scenario", "Cross");
        }
        Scheduler.getInstance().add(auton_command);
    }

    @Override
    public void autonomousPeriodic() {
        SmartDashboard.putData(Scheduler.getInstance());
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
        // Initialize Tank-Drive control via Joysticks
        TankDriveCommand tankDrive = new TankDriveCommand();
        Robot.sDrive.setInvert();
        tankDrive.start();
        // Initialize Elevator control via Joysticks
        ElevatorCommand elevator = new ElevatorCommand();
        elevator.start();
        // Initialize Intake control via Joysticks
        IntakePitchCommand intake = new IntakePitchCommand();
        intake.start();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
}
