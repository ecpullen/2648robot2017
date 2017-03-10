package org.usfirst.frc2648.robot2017.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2648.robot2017.Robot;

/**
 *
 */
public class FeedShooter extends Command {

    public FeedShooter() {

        requires(Robot.shooterFeeder);

    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	Robot.shooterFeeder.feedOn(1);
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooterFeeder.feedOn(0);
    }

    protected void interrupted() {
    	end();
    }
}
