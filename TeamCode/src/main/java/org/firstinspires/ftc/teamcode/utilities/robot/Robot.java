package org.firstinspires.ftc.teamcode.utilities.robot;

import org.firstinspires.ftc.teamcode.utilities.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.utilities.subsystems.WheelController;

public class Robot {
    public WheelController wheelController;

    public Robot(HardwareMap hardwareMap) {
        this.wheelController = new WheelController(hardwareMap);
    }
}
