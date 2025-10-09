package org.firstinspires.ftc.teamcode.utilities.config.core;

public class RobotConstants {
    public static double WHEEL_SPEED = 0.8;

    public enum HardwareName {
        WHEEL_FR("frontRightWheel"),
        WHEEL_FL("frontLeftWheel"),
        WHEEL_BR("backRightWheel"),
        WHEEL_BL("backLeftWheel");

        public final String name;

        HardwareName(String name) {
            this.name = name;
        }
    }
}