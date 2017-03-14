package org.usfirst.frc2648.robot2017.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveTurn extends CommandGroup {

	public static final boolean blue = true;
    public DriveTurn() {
    	int i = 1;
    	if(!blue){
    		i*=-1;
    	}
    	
    		addSequential(new PidDrive(7.75));
        	addSequential(new PidTurn(90*i));
        	addSequential(new TimeDrive(.6,.75));
        	addSequential(new TimeDrive(2.25,0));
        	addSequential(new PidDrive(.7));
        	addSequential(new PidTurn(-90*i));
        	addSequential(new PidDrive(-6.5));
        	addSequential(new PidTurn(45*i));
        	addSequential(new TimeDrive(.75,.75));
        	addParallel(new FeedShooter());
        	addParallel(new IntakeIn());
    }
}
