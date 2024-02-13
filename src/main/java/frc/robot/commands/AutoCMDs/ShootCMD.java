// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCMDs;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TalonSRXMotors;
import edu.wpi.first.wpilibj.Timer;


public class ShootCMD extends Command {
	private final double duration;
  private TalonSRXMotors talonSRXMotors;
	private double endTime;
	private boolean killed = false;




  /** Creates a new SetTalonSpeed. */
  public ShootCMD(TalonSRXMotors talonSRXMotors) {
    this.duration = 5;
    this.talonSRXMotors = talonSRXMotors;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(talonSRXMotors);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    killed = false;
    endTime = Timer.getFPGATimestamp() + duration;
    System.out.println("Shooting");
    talonSRXMotors.setSpeed1(1); 
    talonSRXMotors.setSpeed2(1);
    talonSRXMotors.setSpeed3(0.4);
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(Timer.getFPGATimestamp() > endTime){
      killed = true;
    }

  }
  @Override
  public void end(boolean interrupted) {
    System.out.println("Shooting Stop");
    talonSRXMotors.setSpeed1(0); 
    talonSRXMotors.setSpeed2(0);
    talonSRXMotors.setSpeed3(0);
    
  }


  @Override
  public boolean isFinished() {
    return killed;
  }

}