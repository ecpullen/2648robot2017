package org.usfirst.frc2648.robot2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearToLeftShoot extends CommandGroup {

    public GearToLeftShoot() {
    	addSequential (new PidDrive (-4));
        addSequential (new PidTurn (-52));
        addSequential (new PidDrive (-4.115));
        addSequential (new TimeDrive (1.5,0));
        addSequential (new PidDrive (1.5));
        addSequential (new PidTurn (10));
        addSequential (new PidDrive (10));  
    }
}
