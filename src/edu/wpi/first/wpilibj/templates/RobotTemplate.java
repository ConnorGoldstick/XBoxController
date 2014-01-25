/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /* .getRawAxis(1); = Left Joystick X-axis.
     * .getRawAxis(2); = Left Joystick Y-axis.
     * .getRawAxis(3); = Triggers: 
     *      Left Trigger = 0 to -1, Right Trigger = 0 to 1 
     *      returns Left Trigger + Right Trigger.
     * .getRawAxis(4); = Right Joystick X-axis.
     * .getRawAxis(5); = Right Joystick Y-axis.
     * .getRawAxis(6); = D-Pad: 1 for right, -1 for left
     * .getRawButton(1); A Button.
     * .getRawButton(2); B Button.
     * .getRawButton(3); X Button.
     * .getRawButton(4); Y Button.
     * .getRawButton(5); Left Bumper.
     * .getRawButton(6); Right Bumper.
     */

    Joystick XBox;
    Jaguar jagLeft, jagRight;
    double speed, turn;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        XBox = new Joystick(1);
        jagLeft = new Jaguar(2, 1);
        jagRight = new Jaguar(2, 2);
        speed = 0;
        turn = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit() {
        speed = 0;
        turn = 0;
    }

    public void teleopPeriodic() {
        speed = XBox.getRawAxis(2);
        turn = 0.5 * XBox.getRawAxis(4);
        if (turn < 0.1 && turn > -0.1) {
            turn = 0;
        }
        jagLeft.set(speed - turn);
        jagRight.set(speed + turn);
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
}
