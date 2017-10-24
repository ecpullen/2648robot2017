package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;
import org.usfirst.frc2648.robot2017.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;


public class PidDrive extends PIDCommand {
	///if you want to use PID on your robot use this format.
	private double setpoint;

    public PidDrive(double setpoint) {
    		//set your PID values
    		super(.3,.001,0.001);
		requires(Robot.driveTrain);
	    	setSetpoint(-setpoint);
	    	this.setpoint = setpoint;
	    	//This is how close is "close enough"
	    	getPIDController().setAbsoluteTolerance(1);
	    	//This is the max and min power the pid is allowed to output
	    	getPIDController().setOutputRange(-1, 1);
	    	System.out.println(getSetpoint());
	    	//you should reset all of your sensors before you run a pid command.
	    	Robot.driveTrain.resetGyro();
	    	Robot.driveTrain.resetEnc();
	}

    protected double returnPIDInput() {
    	//return your data for pid here
        return Robot.driveTrain.getlEnc().getDistance();
    }

    protected void usePIDOutput(double output) {
    	//this is where you drive the robot based on the pid
    	System.out.println(Robot.driveTrain.getGyro().getAngle());
       Robot.driveTrain.arcadeDrive(output,(Robot.driveTrain.getGyro().getAngle())/7);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetGyro();
    	Robot.driveTrain.resetEnc();
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Command stops when it has reached its target.
    	return this.getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("End PidDrive");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
