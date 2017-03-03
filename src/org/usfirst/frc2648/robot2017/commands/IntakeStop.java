package org.usfirst.frc2648.robot2017.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2648.robot2017.Robot;

/**
 *
 */
public class IntakeStop extends Command {
	
    public IntakeStop() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.intake(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
