package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PidShooter extends PIDCommand {

	double p_speed = .2;
	double m_speed = 60;
	
	public PidShooter(double setpoint){
		super(.008,0.00000025,0.003);
		//super(.008,0,0.006);
		PIDController pid = getPIDController();
		pid.setAbsoluteTolerance(0);
		//pid.setOutputRange(-.007, .007);
		pid.setSetpoint(setpoint);
		setTimeout(.1);
		m_speed= getSetpoint();
	}
	
	protected double returnPIDInput() {
		return Robot.shooter.getShooterEnc().getRate();
	}

	protected void usePIDOutput(double output) {
		if(!isTimedOut()){
			Robot.shooter.spin(1);
			//System.out.println(Robot.shooter.getShooterEnc().getRate());
			return;
		}
		SmartDashboard.putNumber("Shooter Enc", Robot.shooter.getShooterEnc().getRate());
		System.out.println(Robot.shooter.getShooterEnc().getRate());
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
