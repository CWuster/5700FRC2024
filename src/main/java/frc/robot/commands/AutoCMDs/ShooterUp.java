// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCMDs;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;


public class ShooterUp extends Command {

  private Shooter shooter;




  /** Creates a new SetTalonSpeed. */
  public ShooterUp(Shooter shooter) {

    this.shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }
 
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.shooterPistonUp();


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }
  @Override
  public void end(boolean interrupted) {

  }
  
  @Override
  public boolean isFinished() {
    return true;
  }
}