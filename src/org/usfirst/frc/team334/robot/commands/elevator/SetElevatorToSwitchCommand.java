package org.usfirst.frc.team334.robot.commands.elevator;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetElevatorToSwitchCommand extends Command {

    public SetElevatorToSwitchCommand() {
        requires(Robot.sElevator);
    }

    @Override
    protected void initialize() {
        setTimeout(3);
        Robot.sElevator.setSetpoint(Constants.ELEVATOR_SWITCH_HEIGHT);
        Robot.sElevator.enable();
    }

    @Override
    protected void execute() {
        
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.sElevator.stop();
        Robot.sElevator.disable();
    }

    @Override
    protected void interrupted() {
        Robot.sElevator.stop();
        Robot.sElevator.disable();
    }
}
