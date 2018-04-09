package org.usfirst.frc.team334.robot;

import org.usfirst.frc.team334.robot.auto.scenarios.*;
import org.usfirst.frc.team334.robot.commands.drivetrain.TankDriveCommand;
import org.usfirst.frc.team334.robot.subsystems.*;
import org.usfirst.frc.team334.robot.vision.VisionData;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    
    // FMS -> retrieves auton information
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

    private static VisionData vision;

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

        vision = new VisionData();

        // Shows starting position selector
        SmartDashboard.putData(position_chooser);
        // Shows scale auton option
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
                        SmartDashboard.putString("Scenario", "L:LRL+S");
                    } else {
                        auton_command = new LeftStartLeftSwitch2(); // PLACEHOLDER
                        SmartDashboard.putString("Scenario", "L:LRL");
                    }
                    break;
                case "LLL":
                    if (doScaleAuton) {
                        auton_command = new LeftStartLeftSwitchLeftScale();
                        SmartDashboard.putString("Scenario", "L:LLL+S");
                    } else { 
                        auton_command = new LeftStartLeftSwitch2(); // PLACEHOLDER
                        SmartDashboard.putString("Scenario", "L:LLL");
                    }
                    break;
                // Switch opposite side
                case "RLR":
                    if (doScaleAuton) {
                        auton_command = new LeftStartRightSwitchLeftScale();
                        SmartDashboard.putString("Scenario", "L:RLR+S");
                    } else { 
                        auton_command = new LeftStartRightSwitch2(); // PLACEHOLDER
                        SmartDashboard.putString("Scenario", "L:RLR");
                    }
                    break;
                case "RRR":
                    if (doScaleAuton) {
                        auton_command = new LeftStartLeftSwitchLeftScale();
                        SmartDashboard.putString("Scenario", "L:RRR+S");
                    } else {
                        auton_command = new LeftStartRightSwitch2(); // PLACEHOLDER
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
                        SmartDashboard.putString("Scenario", "R:LRL+S");
                    } else {
                        auton_command = new RightStartLeftSwitch2(); // PLACEHOLDER
                        SmartDashboard.putString("Scenario", "R:LRL");
                    }
                    break;
                case "LLL":
                    if (doScaleAuton) {
                        auton_command = new RightStartLeftSwitchLeftScale();
                        SmartDashboard.putString("Scenario", "R:LLL+S");
                    } else { 
                        auton_command = new RightStartLeftSwitch2(); // PLACEHOLDER
                        SmartDashboard.putString("Scenario", "R:LLL");
                    }
                    break;
                // Switch same side
                case "RLR":
                    if (doScaleAuton) {
                        auton_command = new RightStartRightSwitchLeftScale();
                        SmartDashboard.putString("Scenario", "R:RLR+S");
                    } else {
                        auton_command = new RightStartRightSwitch2(); // PLACEHOLDER
                        SmartDashboard.putString("Scenario", "R:RLR");
                    }
                    break;
                case "RRR":
                    if (doScaleAuton) {
                        auton_command = new RightStartRightSwitchRightScale();
                        SmartDashboard.putString("Scenario", "R:RRR+S");
                    } else {
                        auton_command = new RightStartRightSwitch2(); // PLACEHOLDER
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
        System.out.println(Drive.rGyro.getHeading());
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
        TankDriveCommand tankDrive = new TankDriveCommand();
        Robot.sDrive.setInvert();
        tankDrive.start();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Robot.sElevator.setMotors(m_oi.getElevatorJoystick().getY());
        System.out.println(Drive.rGyro.getHeading());
    }
    
}
