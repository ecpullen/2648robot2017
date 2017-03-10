package org.usfirst.frc2648.robot2017.subsystems;

import org.usfirst.frc2648.robot2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
    private final CANTalon lClimb = RobotMap.climberlClimb;
    private final CANTalon rClimb = RobotMap.climberrClimb;

    public void initDefaultCommand() {
    }
    
    public void run(double power){
    	lClimb.set(power);
    	rClimb.set(-power);
    }
    public void stop(){
    	run(0);
    }
}

