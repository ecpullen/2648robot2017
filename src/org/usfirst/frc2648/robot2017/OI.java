// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2648.robot2017;

import org.usfirst.frc2648.robot2017.commands.ClimbSlow;
import org.usfirst.frc2648.robot2017.commands.ClimberOn;
import org.usfirst.frc2648.robot2017.commands.FeedShooter;
import org.usfirst.frc2648.robot2017.commands.IntakeIn;
import org.usfirst.frc2648.robot2017.commands.PidShooter;
import org.usfirst.frc2648.robot2017.commands.ShooterOnClose;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {

	private XboxController j1;
	private XboxController j2;
	private Button shooterOnClose, intakeIn, climberOn, feedShooter, intakeIn2, intakeOut,pidShooter;
    public OI() {
        j1 = new XboxController(0);
        j2 = new XboxController(1);
        
        //shooterOnClose = new JoystickButton(j2, 1);
        feedShooter = new JoystickButton(j2,6);
        intakeIn = new JoystickButton(j1, 6);
        climberOn = new JoystickButton(j2,3);
        intakeIn2 = new JoystickButton(j2, 5);
        intakeOut = new JoystickButton(j2, 4);
        pidShooter = new JoystickButton(j2,2);
        
        feedShooter.whileHeld(new FeedShooter());
        //shooterOnClose.whileHeld(new ShooterOnClose());
        intakeIn.whileHeld(new IntakeIn());
        climberOn.whileHeld(new ClimberOn());
        intakeIn2.whileHeld(new IntakeIn());
        intakeOut.whileHeld(new ClimbSlow());  
        pidShooter.whileHeld(new PidShooter(67.6));//67.8
        
        //SmartDashboard.putData("pidturn", new PidTurn(90));
        //SmartDashboard.putData("piddrive", new PidDrive(5));
        SmartDashboard.putNumber("Shooter Enc", Robot.shooter.getShooterEnc().getRate());
    }

    public XboxController getj1(){
    	return j1;
    }
    
    public XboxController getj2(){
    	return j2;
    }
}

