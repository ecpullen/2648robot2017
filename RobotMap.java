package org.usfirst.frc2648.robot2017;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
    //create objects for every motor controller and sensor
    public static CANTalon driveTrainlFront;
    public static CANTalon driveTrainlRear;
    public static CANTalon driveTrainrFront;
    public static CANTalon driveTrainrRear;
    public static RobotDrive driveTrainrd;
    public static DigitalInput driveTrainpixyON;
    public static AnalogInput driveTrainpixyX;
    public static Encoder driveTrainlEnc;
    public static Encoder driveTrainrEnc;
    public static CANTalon shooterlShooter;
    public static Encoder shooterencShooter;
    public static CANTalon shooterrShooter;
    public static CANTalon climberlClimb;
    public static CANTalon climberrClimb;
    public static CANTalon intakeintake;
    public static CANTalon shooterFeedershooterFeeder;
    public static AnalogInput us;
    public static ADXRS450_Gyro gyro;
    public static DigitalInput auto;
    
    public static void init() {
    	//Assign all of your fields.
    	us = new AnalogInput(0);
    	LiveWindow.addSensor("DriveTrain", "Ultrasonic", us);
    	
        driveTrainlFront = new CANTalon(16);
        //This puts the motor controller on the smart dashboard so that it can be tested. I would recommend doing this
        LiveWindow.addActuator("DriveTrain", "lFront", driveTrainlFront);
        
        driveTrainlRear = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "lRear", driveTrainlRear);
        
        driveTrainrFront = new CANTalon(14);
        LiveWindow.addActuator("DriveTrain", "rFront", driveTrainrFront);
        
        driveTrainrRear = new CANTalon(15);
        LiveWindow.addActuator("DriveTrain", "rRear", driveTrainrRear);
        
        driveTrainrd = new RobotDrive(driveTrainlFront, driveTrainlRear,
              driveTrainrFront, driveTrainrRear);
        
        driveTrainrd.setSafetyEnabled(true);
        driveTrainrd.setExpiration(0.1);
        driveTrainrd.setSensitivity(0.5);
        driveTrainrd.setMaxOutput(1.0);

        driveTrainpixyON = new DigitalInput(2);
        LiveWindow.addSensor("DriveTrain", "pixyON", driveTrainpixyON);
        
        driveTrainpixyX = new AnalogInput(3);
        LiveWindow.addSensor("DriveTrain", "pixyX", driveTrainpixyX);
        
        driveTrainlEnc = new Encoder(3, 4, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "lEnc", driveTrainlEnc);
        driveTrainlEnc.setDistancePerPulse(1.0/1277 );
        driveTrainlEnc.setPIDSourceType(PIDSourceType.kDisplacement);
        driveTrainrEnc = new Encoder(5, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "rEnc", driveTrainrEnc);
        driveTrainrEnc.setDistancePerPulse(1.0/1955);
        driveTrainrEnc.setPIDSourceType(PIDSourceType.kDisplacement);
        shooterlShooter = new CANTalon(12);
        LiveWindow.addActuator("Shooter", "lShooter", shooterlShooter);
        
        shooterencShooter = new Encoder(8, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "encShooter", shooterencShooter);
        shooterencShooter.setDistancePerPulse(0.125);
        shooterencShooter.setPIDSourceType(PIDSourceType.kRate);
        shooterencShooter.setDistancePerPulse(.5/3);
        shooterrShooter = new CANTalon(13);
        LiveWindow.addActuator("Shooter", "rShooter", shooterrShooter);
        
        climberlClimb = new CANTalon(2);
        LiveWindow.addActuator("Climber", "lClimb", climberlClimb);
        
        climberrClimb = new CANTalon(3);
        LiveWindow.addActuator("Climber", "rClimb", climberrClimb);
        
        intakeintake = new CANTalon(4);
        LiveWindow.addActuator("Intake", "intake", intakeintake);
        
        shooterFeedershooterFeeder = new CANTalon(5);
        LiveWindow.addActuator("ShooterFeeder", "shooterFeeder", shooterFeedershooterFeeder);
        
        gyro = new ADXRS450_Gyro();
        LiveWindow.addActuator("DriveTrain", "Gyro", gyro);
        
        auto = new DigitalInput(9);
    }
}
