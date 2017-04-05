package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;
import org.usfirst.frc2648.robot2017.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class PidTurn extends PIDCommand {

    public PidTurn(double setpoint) {
		super(.1, 0, 0);
		// TODO Auto-generated constructor stub
		requires(Robot.driveTrain);
    	setSetpoint(setpoint);
	}

    protected double returnPIDInput() {
        return Robot.driveTrain.getGyro().getAngle();
    }

    protected void usePIDOutput(double output) {
    	System.out.println(output);
       Robot.driveTrain.arcadeDrive(0,-output);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1.5);
    	System.out.println("PIDTURN");
    	getPIDController().setAbsoluteTolerance(5);
    	getPIDController().setOutputRange(-.75, .75);
    	System.out.println(getPIDController().getSetpoint());
		Robot.driveTrain.resetEnc();
    	Robot.driveTrain.resetGyro();
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println(Math.abs(Robot.driveTrain.getGyro().getAngle()-getSetpoint()));
        return isTimedOut() && Math.abs(Robot.driveTrain.getGyro().getAngle()-getSetpoint())<5;
    	//return isTimedOut() && getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
/*package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;
import org.usfirst.frc2648.robot2017.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;


public class PidTurn extends PIDCommand {

    public PidTurn(double setpoint) {
		super(.03, 0.02, 0.1);
		// TODO Auto-generated constructor stub
		requires(Robot.driveTrain);
    	setSetpoint(setpoint);
    	
	}

    protected double returnPIDInput() {
        return Robot.driveTrain.getGyro().getAngle();
    }

    protected void usePIDOutput(double output) {
    	System.out.println(output);
       Robot.driveTrain.arcadeDrive(0,-output);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1.2);
    	System.out.println("PIDTURN");
    	getPIDController().setAbsoluteTolerance(1);
    	getPIDController().setOutputRange(-.8, .8);
    	System.out.println(getPIDController().getSetpoint());
		Robot.driveTrain.resetEnc();
    	Robot.driveTrain.resetGyro();
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.getPIDController().onTarget();//isTimedOut() && Math.abs(Robot.driveTrain.getGyro().getAngle()-getSetpoint())<5;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}*/
