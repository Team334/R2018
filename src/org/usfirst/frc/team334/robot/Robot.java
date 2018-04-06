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
        
        m_oi = new OI();

        vision = new VisionData();

        // Shows current commands that are running
        SmartDashboard.putData(Scheduler.getInstance());

        System.out.println("ROBOT INITIALIZED");
    }

    @Override
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousInit() {
        absoluteHeading = 0;

        Drive.rEncoderLeft.reset();
        Drive.rEncoderRight.reset();
        Drive.rGyro.resetHeading();

        Robot.sDrive.setNormal(); // set motors negative just for auton

        Scheduler.getInstance().removeAll();

        // Gets info from "Game Data" in FRC Driver Station
        String fieldConfig = fms.getGameSpecificMessage();
        SmartDashboard.putString("Field Config", fieldConfig);
        SmartDashboard.putNumber("Start Location", fms.getLocation()); // 1 - left
                                                                       // 2 - middle
                                                                       // 3 - right
        
        boolean doScaleAuton = m_chooser.getSelected().booleanValue(); // 0 = switch only
                                                                       // 1 = scale and switch
        
        // Checks info from FMS to schedule correct auton command.
        if (fms.getLocation() == 1) { // LEFT START
            switch (fieldConfig) {
                // switch same side
                case "LRL":
                    if (doScaleAuton)
                        auton_command = new LeftStartLeftSwitchRightScale();
                    else 
                        auton_command = new LeftStartLeftSwitch();
                    break;
                case "LLL":
                    if (doScaleAuton)
                        auton_command = new LeftStartLeftSwitchLeftScale();
                    else 
                        auton_command = new LeftStartLeftSwitch();
                    break;
                // switch on other side
                case "RLR":
                    if (doScaleAuton)
                        auton_command = new LeftStartRightSwitchLeftScale();
                    else 
                        auton_command = new LeftStartRightSwitch();
                    break;
                case "RRR":
                    if (doScaleAuton)
                        auton_command = new LeftStartLeftSwitchLeftScale();
                    else 
                        auton_command = new LeftStartRightSwitch();
                    break;
                default:
                    auton_command = new CrossLine();
            }
        } else if (fms.getLocation() == 3) { // RIGHT START
            switch (fieldConfig) {
                // switch on other side
                case "LRL":
                    if (doScaleAuton)
                        auton_command = new RightStartLeftSwitchRightScale();
                    else 
                        auton_command = new RightStartLeftSwitch();
                    break;
                case "LLL":
                    if (doScaleAuton)
                        auton_command = new RightStartLeftSwitchLeftScale();
                    else 
                        auton_command = new RightStartLeftSwitch();
                    break;
                // switch same side
                case "RLR":
                    if (doScaleAuton)
                        auton_command = new RightStartRightSwitchLeftScale();
                    else 
                        auton_command = new RightStartLeftSwitch();
                    break;
                case "RRR":
                    if (doScaleAuton)
                        auton_command = new RightStartRightSwitchRightScale();
                    else 
                        auton_command = new RightStartRightSwitch();
                    break;
                default:
                    auton_command = new CrossLine();
                    break;
            }
        } else { // MIDDLE START
            auton_command = new CrossLine();
        }
        
        Scheduler.getInstance().add(auton_command);
    }

    @Override
    public void autonomousPeriodic() {
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
        // Runs any commands that are queued from OI
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {

    }

}
