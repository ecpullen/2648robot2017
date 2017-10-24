package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;
import org.usfirst.frc2648.robot2017.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TalonPidShooter extends Command {

	public double setpoint;
    public TalonPidShooter(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.lShooter.changeControlMode(TalonControlMode.Speed);
    	Robot.shooter.rShooter.changeControlMode(TalonControlMode.Follower);
    	Robot.shooter.rShooter.reverseOutput(true);
    	Robot.shooter.lShooter.setPID(0,0,0,1,0,0,0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.lShooter.setPosition(Robot.shooter.getShooterEnc().getRate());
    	Robot.shooter.lShooter.setSetpoint(setpoint);
    	Robot.shooter.rShooter.set(12);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
