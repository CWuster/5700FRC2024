// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TalonSRXMotors;
import frc.robot.subsystems.Shooter;


public class ShooterLowCMD extends Command {

  private double feederdelay;
  private TalonSRXMotors talonSRXMotors;
  private Shooter shooter;




  /** Creates a new SetTalonSpeed. */
  public ShooterLowCMD(TalonSRXMotors talonSRXMotors,Shooter shooter) {
    
    this.talonSRXMotors = talonSRXMotors;
    this.shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(talonSRXMotors);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Shooting Speaker");
    shooter.shooterPistonUp();
    feederdelay = Timer.getFPGATimestamp() + 0.5;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    talonSRXMotors.setShooterSpeed(1);
    if(Timer.getFPGATimestamp() > feederdelay){
    talonSRXMotors.setSpeedFeeder(1);
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Shooting Release");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }


}
