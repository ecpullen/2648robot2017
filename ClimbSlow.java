package org.usfirst.frc2648.robot2017.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2648.robot2017.Robot;

public class ClimbSlow extends Command {

    public ClimbSlow() {
        requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.run(-.1);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.stop();
    }
    
    protected void interrupted() {
    	end();
    }
}