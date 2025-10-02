package org.firstinspires.ftc.teamcode.utilities.robot;

import org.firstinspires.ftc.teamcode.utilities.subsystems.WheelController;

public class Robot {
    private static Robot theRobot;

    public WheelController wheelController;

    public static Robot getInstance() {
        if (theRobot == null) theRobot = new Robot();
        return theRobot;
    }

    public Robot() {
        this.wheelController = new WheelController();
    }
}
