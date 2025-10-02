package org.firstinspires.ftc.teamcode.utilities.config.core;

public class RobotConstants {
    public enum HardwareName {
        WHEEL_FR("frontRightMotor"),
        WHEEL_FL("frontLeftMotor"),
        WHEEL_BR("backRightMotor"),
        WHEEL_BL("backLeftMotor");

        public final String name;

        HardwareName(String name) {
            this.name = name;
        }
    }
}