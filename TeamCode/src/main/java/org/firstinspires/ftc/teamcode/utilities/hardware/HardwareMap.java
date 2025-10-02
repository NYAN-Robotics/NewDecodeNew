package org.firstinspires.ftc.teamcode.utilities.hardware;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.utilities.config.core.RobotConstants;

public class HardwareMap {
    public static DcMotorEx getMotor(String name) {
        return hardwareMap.get(DcMotorEx.class, name);
    }

    public static DcMotorEx getMotor(RobotConstants.HardwareName item) {
        return getMotor(item.name);
    }
}
