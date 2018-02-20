package org.usfirst.frc.team334.robot;

import java.util.ArrayList;

import org.usfirst.frc.team334.robot.commands.climber.ExtendClimberCommand;
import org.usfirst.frc.team334.robot.commands.climber.RetractClimberCommand;
import org.usfirst.frc.team334.robot.commands.drivetrain.ToggleTransmissionCommand;
import org.usfirst.frc.team334.robot.commands.elevator.CollapseElevatorCommand;
import org.usfirst.frc.team334.robot.commands.elevator.SetElevatorToExchangeCommand;
import org.usfirst.frc.team334.robot.commands.elevator.SetElevatorToScaleCommand;
import org.usfirst.frc.team334.robot.commands.elevator.SetElevatorToSwitchCommand;
import org.usfirst.frc.team334.robot.commands.intake.GrabPowerCubeCommand;
import org.usfirst.frc.team334.robot.commands.intake.ReleasePowerCubeCommand;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    // Joysticks and Xbox controls
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    private XboxController xbox;
    private ArrayList<GenericHID> controls;

    // Button controls
    private Button shiftGears;

    private Button raiseElevatorToSwitch;
    private Button raiseElevatorToScale;
    private Button raiseElevatorToExchange;
    private Button collapseElevator;
    private Button grabBox;
    private Button releaseBox;
    private Button extendClimber; 
    private Button retractClimber;

    public OI() {
        leftJoystick = new Joystick(Constants.JOYSTICK_LEFT);
        rightJoystick = new Joystick(Constants.JOYSTICK_RIGHT);
        xbox = new XboxController(Constants.XBOX);
        controls = new ArrayList<>();
        controls.add(leftJoystick);
        controls.add(rightJoystick);
        controls.add(xbox);

        // Init Buttons
        shiftGears = new JoystickButton(controls.get(Constants.SWITCH_GEAR_CONTROL), Constants.SWITCH_GEAR_BUTTON);

        raiseElevatorToSwitch = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL),
                Constants.ELEVATOR_TO_SWITCH_BUTTON);
        raiseElevatorToScale = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL),
                Constants.ELEVATOR_TO_SCALE_BUTTON);
        raiseElevatorToExchange = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL),
                Constants.ELEVATOR_TO_EXCHANGE_BUTTON);
        collapseElevator = new JoystickButton(controls.get(Constants.ELEVATOR_CONTROL),
                Constants.COLLAPSE_ELEVATOR_BUTTON);
        grabBox = new JoystickButton(controls.get(Constants.GRAB_CONTROL), 
        		Constants.GRAB_BUTTON);
        releaseBox = new JoystickButton(controls.get(Constants.RELEASE_CONTROL), 
        		Constants.RELEASE_BUTTON);
        extendClimber = new JoystickButton(controls.get(Constants.EXTEND_CONTROL), 
        		Constants.EXTEND_BUTTON);
        retractClimber = new JoystickButton(controls.get(Constants.RETRACT_CONTROL), 
        		Constants.RETRACT_BUTTON);
        

        // Button Actions
        shiftGears.whenPressed(new ToggleTransmissionCommand());
        
        raiseElevatorToSwitch.whenPressed(new SetElevatorToSwitchCommand());
        raiseElevatorToScale.whenPressed(new SetElevatorToScaleCommand());
        raiseElevatorToExchange.whenPressed(new SetElevatorToExchangeCommand());
        collapseElevator.whenPressed(new CollapseElevatorCommand());
        grabBox.whileHeld(new GrabPowerCubeCommand());
        releaseBox.whileHeld(new ReleasePowerCubeCommand());
        extendClimber.whenPressed(new ExtendClimberCommand());
        retractClimber.whenPressed(new RetractClimberCommand());
    }

    public Joystick getLeftJoystick() {
        return this.leftJoystick;
    }

    public Joystick getRightJoystick() {
        return this.rightJoystick;
    }

    public XboxController getXBoxController() {
        return this.xbox;
    }

}
