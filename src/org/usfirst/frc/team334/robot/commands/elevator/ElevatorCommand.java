package org.usfirst.frc.team334.robot.commands.elevator;

import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorCommand extends Command {

    public ElevatorCommand() {
        requires(Robot.sElevator);
    }

    @Override
    protected void initialize() {
        
    }

    @Override
    protected void execute() {
        Robot.sElevator.setMotors(Robot.m_oi.getElevatorJoystick().getY());
        System.out.println(Robot.m_oi.getElevatorJoystick().getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.sElevator.stop();
    }

    @Override
    protected void interrupted() {
        Robot.sElevator.stop();
    }
}
