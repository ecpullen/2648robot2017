package org.usfirst.frc2648.robot2017.commands;

import org.usfirst.frc2648.robot2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */


public class SlowFeeder extends Command {
	
	private int count = 0;
	boolean on = true;

	public SlowFeeder() {

        requires(Robot.shooterFeeder);

    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	count++;
    	if(on)
    	Robot.shooterFeeder.feedOn(.925); //.625
    	else
    		Robot.shooterFeeder.feedOn(0);
    	if(count%100==0){
    		on = !on;
    	}
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooterFeeder.feedOn(0);
    }

    protected void interrupted() {
    	end();
    }
}
