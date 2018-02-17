package org.usfirst.frc.team334.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team334.robot.BNO055;
import org.usfirst.frc.team334.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * DriveTrain for 2018 Robot 6 Victors (3 per side)
 */

public class Drive extends Subsystem {

    public enum DriveControlState {
        TANK_DRIVE_JOYSTICK_CONTROL, TURN_TO_HEADING, DRIVE_TOWARDS_SWITCH, DRIVE_TOWARDS_SCALE
    }

    private DriveControlState mDriveControlState;

    // Sensor declarations
    public static Encoder rEncoderLeft;
    public static Encoder rEncoderRight;
    public static Ultrasonic rUltrasonicR;
    public static Ultrasonic rUltrasonicL;
    public static BNO055 rGyro;

    private TalonSRX miniCimL;
    private TalonSRX miniCimR;
    private TalonSRX cim1L;
    private TalonSRX cim2L;
    private TalonSRX cim1R;
    private TalonSRX cim2R;

    ArrayList<TalonSRX> left;
    ArrayList<TalonSRX> right;

    public Drive() {
        rEncoderLeft = new Encoder(Constants.ENCODER_L_DRIVETRAIN_A, Constants.ENCODER_L_DRIVETRAIN_B);
        rEncoderRight = new Encoder(Constants.ENCODER_R_DRIVETRAIN_A, Constants.ENCODER_R_DRIVETRAIN_B);

        rUltrasonicR = new Ultrasonic(Constants.ULTRASONIC_L_DRIVETRAIN_PING, Constants.ULTRASONIC_L_DRIVETRAIN_ECHO);
        rUltrasonicL = new Ultrasonic(Constants.ULTRASONIC_R_DRIVETRAIN_PING, Constants.ULTRASONIC_R_DRIVETRAIN_ECHO);

        rGyro = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_IMUPLUS, BNO055.vector_type_t.VECTOR_EULER);

        miniCimL = new TalonSRX(Constants.DRIVETRAIN_MC_L);
        cim1L = new TalonSRX(Constants.DRIVETRAIN_C1_L);
        cim2L = new TalonSRX(Constants.DRIVETRAIN_C2_L);
        miniCimR = new TalonSRX(Constants.DRIVETRAIN_MC_R);
        cim1R = new TalonSRX(Constants.DRIVETRAIN_C1_R);
        cim2R = new TalonSRX(Constants.DRIVETRAIN_C2_R);

        left = new ArrayList<TalonSRX>();
        right = new ArrayList<TalonSRX>();

        left.add(miniCimL);
        left.add(cim1L);
        left.add(cim2L);
        right.add(miniCimR);
        right.add(cim1R);
        right.add(cim2R);
    }

    public void stop() {
        setLeft(0);
        setRight(0);
    }

    public void setLeft(double speed) {
        for (TalonSRX talon : left) {
            talon.set(com.ctre.phoenix.motorcontrol.ControlMode.Current, speed);
        }
    }

    public void setRight(double speed) {
        for (TalonSRX talon : right) {
            talon.set(com.ctre.phoenix.motorcontrol.ControlMode.Current, speed);
        }
    }

    public void initDefaultCommand() {

    }

}