// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Climber extends SubsystemBase {
  WPI_TalonSRX Climber;
  DigitalInput BottomLimit;

  /** Creates a new Climber. */
  public Climber() {
    Climber = new WPI_TalonSRX(Constants.ClimberConstants.climberID);
    BottomLimit = new DigitalInput(Constants.ClimberConstants.switchPort);

    //Set the climber motor to brake mode when idle.
    Climber.setNeutralMode(NeutralMode.Brake);



  }

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */
  public Command Climb() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.runEnd(
        // When the command is initialized, begin continuously climb UNLESS the limit switch is activated.
        () -> {
          if (getLimitSwitch()) {
            setPower(1);
          } else {
            setPower(0);
          }
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }

  public Command Extend() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, extend the climber
        () -> {
          setPower(-0.5);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }

  // An accessor method to set the speed (technically the output percentage) 
  public void setPower(double speed) {
    Climber.set(speed);
  }

  // A helper method to stop the climber.. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    Climber.set(0);
  }

  public boolean getLimitSwitch() {
    return BottomLimit.get();
  }


@Override public void periodic() {
  SmartDashboard.putBoolean("Climber limit hit", getLimitSwitch());
}
}
