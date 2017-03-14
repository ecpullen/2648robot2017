package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;
import org.usfirst.frc2648.robot2017.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class PidDrive extends PIDCommand {

	private double setpoint;

    public PidDrive(double setpoint) {
		super(1.25, 0.25, 0);
		requires(Robot.driveTrain);
    	setSetpoint(-setpoint);
    	this.setpoint = setpoint;
    	//setTimeout(setpoint/2.5);
    	getPIDController().setAbsoluteTolerance(.2);
    	getPIDController().setOutputRange(-.75, .75);
    	System.out.println(getSetpoint());
    	Robot.driveTrain.resetGyro();
    	Robot.driveTrain.resetEnc();
	}

    protected double returnPIDInput() {
        return Robot.driveTrain.getlEnc().getDistance();
    }

    protected void usePIDOutput(double output) {
    	System.out.println(Robot.driveTrain.getGyro().getAngle());
       Robot.driveTrain.arcadeDrive(output,(Robot.driveTrain.getGyro().getAngle())/7);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*setTimeout(setpoint/3);
    	getPIDController().setAbsoluteTolerance(.2);
    	getPIDController().setOutputRange(-.875, .875);
    	System.out.println(getPIDController().getSetpoint());
		Robot.driveTrain.resetEnc();*/
    	Robot.driveTrain.resetGyro();
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println((Robot.driveTrain.getlEnc().getDistance()-getSetpoint()));
        return (Math.abs(Robot.driveTrain.getlEnc().getDistance() - getSetpoint())) < .2;
    	//return false;
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
