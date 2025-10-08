package org.firstinspires.ftc.teamcode.utilities.hardware;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.utilities.config.core.RobotConstants;

import dev.nextftc.ftc.ActiveOpMode;


public class HardwareMap {
    public static DcMotorEx getMotor(String name) {
        return (DcMotorEx) hardwareMap.get(DcMotor.class, name);
    }

    public static DcMotorEx getMotor(RobotConstants.HardwareName item) {
        return getMotor(item.name);
    }
}
