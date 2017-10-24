package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveTurn extends CommandGroup {

	public static boolean blue=false;
    public DriveTurn() {
    	int i = 1;
    	//blue = RobotMap.auto.get();
    	
    	if(blue){
    		addSequential(new PidDrive(10));
        	addSequential(new PidTurn(90*i));
        	addSequential(new TimeDrive(1,.75));
        	addSequential(new TimeDrive(1.5,0));
        	addSequential(new PidDrive(3));
        	addSequential(new PidTurn(-90*i));
        	addSequential(new PidDrive(-7.75));//-7.25));
        	addSequential(new PidTurn(45*i));
        	addSequential(new TimeDrive(.5,.75));
        	addParallel(new FeedShooter());
        	addParallel(new IntakeIn());
        	//addParallel(new TimeDrive(.25));
    	}
    	else{
    		addSequential(new PidDrive(10));
        	addSequential(new PidTurn(-90));
        	addSequential(new TimeDrive(1,.75));
        	addSequential(new TimeDrive(1.5,0));
        	addSequential(new PidDrive(3));
        	addSequential(new PidTurn(90));
        	addSequential(new PidDrive(-8.375));//-8.125));
        	addSequential(new PidTurn(-45));
        	addSequential(new TimeDrive(.5,.75));
        	addParallel(new FeedShooter());
        	addParallel(new IntakeIn());
    	}
    }
}
