package org.usfirst.frc2648.robot2017.subsystems;

import org.usfirst.frc2648.robot2017.Robot;
import org.usfirst.frc2648.robot2017.RobotMap;
import org.usfirst.frc2648.robot2017.commands.ArcadeDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {

	private double pSpeed;
    private final CANTalon lFront = RobotMap.driveTrainlFront;
    private final CANTalon lRear = RobotMap.driveTrainlRear;
    private final CANTalon rFront = RobotMap.driveTrainrFront;
    private final CANTalon rRear = RobotMap.driveTrainrRear;
    private final RobotDrive rd = RobotMap.driveTrainrd;
    private final DigitalInput pixyON = RobotMap.driveTrainpixyON;
    private final AnalogInput pixyX = RobotMap.driveTrainpixyX;
    private final Encoder lEnc = RobotMap.driveTrainlEnc;
    private final Encoder rEnc = RobotMap.driveTrainrEnc;
    private final AnalogInput us = RobotMap.us;
    private final ADXRS450_Gyro gyro = RobotMap.gyro;
    
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
   
    public void arcadeDrive(){
    	double speed = -Robot.oi.getj1().getY(Hand.kLeft);
    	double turn = -.85*Robot.oi.getj1().getX(Hand.kLeft);
    	if(Math.abs(speed)<Math.abs(pSpeed) && Math.signum(pSpeed) == Math.signum(speed)){
    		speed = speed;
    	}
    	else
	    	if(pSpeed < speed){
	    		speed = Math.min(speed, pSpeed + .1);
	    		speed = Math.min(speed, 1);
	    	}
	    	else{
	    		speed = Math.max(speed,  pSpeed - .1);
	    		speed = Math.max(speed,-1);
	    	}
    	pSpeed = speed;
    	rd.arcadeDrive(speed, turn);
    	if(Robot.oi.getj1().getBButton())
    		rd.arcadeDrive(speed/2,turn/2);
    }
    
    public void arcadeDrive(double speed, double turn){
    	rd.arcadeDrive(speed, turn);
    }
    
	public Encoder getlEnc() {
		return lEnc;
	}
	public Encoder getrEnc(){
		return rEnc;
	}
	
	public AnalogInput getUs() {
		return us;
	}
	public void resetEnc(){
		lEnc.reset();
		rEnc.reset();
	}
	
	public void resetGyro(){
		gyro.reset();
	}
	
	public ADXRS450_Gyro getGyro(){
		return gyro;
	}
}

