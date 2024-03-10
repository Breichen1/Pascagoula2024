// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation TODO check these ports 
    public static final int kDriverControllerPort = 1;
    public static final int kOperatorControllerPort = 0;
  }

  public static class DrivetrainConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kLeftRearID = 4;
    public static final int kLeftFrontID = 3;
    public static final int kRightRearID = 2;
    public static final int kRightFrontID = 1;

  }

  public static class LauncherConstants {
    // PWM ports/CAN IDs for motor controllers
    // Set CAN IDs for these 2 sparkMax objects in Rev Hardware Client
    //TODO check these are correct for front and back
    public static final int kFeederID = 5;
    public static final int kLauncherID = 6;

    // Current limit for launcher and feed wheels
    public static final int kLauncherCurrentLimit = 80;
    public static final int kFeedCurrentLimit = 80;

    // Speeds for wheels when intaking and launching. Intake speeds are negative to run the wheels
    // in reverse
    public static final double kLauncherSpeed = 1;
    public static final double kLaunchFeederSpeed = 1;
    public static final double kIntakeLauncherSpeed = -1;
    public static final double kIntakeFeederSpeed = -.2;

    public static final double kLauncherDelay = 1;
  }

  public static class ClimberConstants {

   //DIO port for the limit switch
   public static final int switchPort = 0;

   //CAN ID for the Climber VictorSPX Motor controller
   public static final int climberID = 10;

  }
}
