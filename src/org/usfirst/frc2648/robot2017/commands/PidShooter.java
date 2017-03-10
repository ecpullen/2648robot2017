package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class PidShooter extends PIDCommand {

	double p_speed = .5;
	double m_speed = 70;
	
	public PidShooter(double setpoint){
		super(.0005,0,0);
		PIDController pid = getPIDController();
		pid.setAbsoluteTolerance(0);
		pid.setOutputRange(-.007, .007);
		pid.setSetpoint(setpoint);
		setTimeout(3);
		m_speed= getSetpoint();
	}
	
	protected double returnPIDInput() {
		return Robot.shooter.getShooterEnc().getRate();
	}

	protected void usePIDOutput(double output) {
		if(!isTimedOut()){
			Robot.shooter.spin(.6);
			System.out.println(Robot.shooter.getShooterEnc().getRate());
			return;
		}
		p_speed += output;
		p_speed = Math.min(1, p_speed);
		Robot.shooter.spin(p_speed);
		if(Math.abs(Robot.shooter.getShooterEnc().getRate()-m_speed)<5){
			Robot.oi.getj2().setRumble(RumbleType.kLeftRumble, 1);
		}
		else
			Robot.oi.getj2().setRumble(RumbleType.kLeftRumble, 0);
	}

	protected boolean isFinished() {
		return false;
	}

}
