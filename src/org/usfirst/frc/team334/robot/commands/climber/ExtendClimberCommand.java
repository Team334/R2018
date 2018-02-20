package org.usfirst.frc.team334.robot.commands.climber;

import org.usfirst.frc.team334.robot.Constants;
import org.usfirst.frc.team334.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ExtendClimberCommand extends Command {

    public ExtendClimberCommand() {
        requires(Robot.sClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("EXTENDCLIMBERCOMMAND INITIALIZED");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sClimber.setClimberSpeed(Constants.CLIMBER_EXTEND_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.sClimber.getTopLimitSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.sClimber.setClimberSpeed(0);
    	System.out.println("EXTENDCLIMBERCOMMAND ENDED");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.sClimber.setClimberSpeed(0);
    	System.out.println("EXTENDCLIMBERCOMMAND INTERRUPTED");
    }
}
