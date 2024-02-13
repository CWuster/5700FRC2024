// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCMDs;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
//import frc.lib.util.MathUtil;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;



public class IntakeOut extends Command {
  private Intake intake;
	private final double duration;
	private double endTime;
	private boolean killed = false;
  //private RobotContainer robotContainer;

  /** Creates a new IntakeCMD. */
  public IntakeOut(Intake intake) {
    this.duration = 4;
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    killed = false;
    endTime = Timer.getFPGATimestamp() + duration;
    System.out.println("Intake Down, Full Speed");
    intake.intakePistonDown();
    intake.intakeMotorSpeed(1);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

        if(Timer.getFPGATimestamp() > endTime){
      killed = true;
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return killed;
  }
}
