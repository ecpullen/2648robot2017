package org.usfirst.frc2648.robot2017.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2648.robot2017.Robot;

public class ClimberOn extends Command {

    public ClimberOn() {
        requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.run(-.8);
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
