package org.usfirst.frc.team334.robot.commands.elevator;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetElevatorToExchangeCommand extends Command {

    public SetElevatorToExchangeCommand() {
        requires(Robot.sElevator);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.println("MOVING ELEVATOR TO EXCHANGE POSITION");

        Robot.sElevator.setSetpoint(Constants.ELEVATOR_EXCHANGE_HEIGHT);
        Robot.sElevator.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.sElevator.onTarget() || Robot.sElevator.isTooHigh()
                || Robot.sElevator.isTooLow();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.sElevator.stop();
        Robot.sElevator.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.sElevator.stop();
        Robot.sElevator.disable();
    }
}
