package org.usfirst.frc2648.robot2017.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveTurn extends CommandGroup {

    public DriveTurn() {
    	if(DriverStation.getInstance().getAlliance()==Alliance.Red){
    		addSequential(new PidDrive(7.5));
        	addSequential(new PidTurn(-90));
        	addSequential(new TimeDrive(.3,.75));
        	addSequential(new TimeDrive(2.25,0));
        	addSequential(new PidDrive(2));
        	addSequential(new PidTurn(90));
        	addSequential(new PidDrive(-6));
        	addSequential(new PidTurn(-45));
        	addSequential(new PidDrive(-2));
        	addParallel(new FeedShooter());
    	}
    	
    	if(DriverStation.getInstance().getAlliance()==Alliance.Blue){
    		addSequential(new PidDrive(7.5));
        	addSequential(new PidTurn(90));
        	addSequential(new TimeDrive(.3,-.75));
        	addSequential(new TimeDrive(2.25,0));
        	addSequential(new PidDrive(2));
        	addSequential(new PidTurn(-90));
        	addSequential(new PidDrive(-6));
        	addSequential(new PidTurn(45));
        	addSequential(new PidDrive(-2));
        	addParallel(new FeedShooter());
    	}
    }
}
