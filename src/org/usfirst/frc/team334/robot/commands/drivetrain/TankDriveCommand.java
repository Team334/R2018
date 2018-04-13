package org.usfirst.frc.team334.robot.commands.drivetrain;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCommand extends Command {

    public TankDriveCommand() {
        requires(Robot.sDrive);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.sDrive.setLeft(Robot.m_oi.getLeftJoystick().getY() * Constants.DRIVETRAIN_SPEED_MULTIPLIER);
        Robot.sDrive.setRight(Robot.m_oi.getRightJoystick().getY() * Constants.DRIVETRAIN_SPEED_MULTIPLIER);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.sDrive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.sDrive.stop();
    }

}
