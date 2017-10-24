package org.usfirst.frc2648.robot2017;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2648.robot2017.commands.*;
import org.usfirst.frc2648.robot2017.subsystems.*;

public class Robot extends IterativeRobot {
	//Create a command for auto
    Command autonomousCommand;
    //Create an object for OI (Operator Interface)
    public static OI oi;
    //Create an object for all of your subsystems
    public static DriveTrain driveTrain;
    public static Shooter shooter;
    public static Climber climber;
    public static Gear gear;
    public static Intake intake;
    public static ShooterFeeder shooterFeeder;
    //Create any other variables you need
    public static double time;
    
    public void robotInit() {
    	//Always start by calling RobotMap.init();
    	RobotMap.init();
    	//Now assign respective objects for OI and all of your subsystems
        driveTrain = new DriveTrain();
        shooter = new Shooter();
        climber = new Climber();
        gear = new Gear();
        intake = new Intake();
        shooterFeeder = new ShooterFeeder();
        oi = new OI();
        autonomousCommand = new AutonomousCommand();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }
//leave this
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    //leave this
    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        SmartDashboard.putBoolean("blue?", RobotMap.auto.get());
    }

    /**
     * This function is called periodically during autonomous
     */
    //leave this
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    //leave this
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        System.out.println(DriverStation.getInstance().getAlliance()==Alliance.Invalid);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
