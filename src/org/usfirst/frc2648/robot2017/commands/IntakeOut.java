package org.usfirst.frc2648.robot2017.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2648.robot2017.Robot;

/**
 *
 */
public class IntakeOut extends Command {

    public IntakeOut() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.intake(-1);
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.intake.stop();
    }

    protected void interrupted() {
    }
}
