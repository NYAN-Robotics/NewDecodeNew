package org.firstinspires.ftc.teamcode.utilities.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.utilities.config.core.RobotConstants;


public class HardwareMap {
    private final com.qualcomm.robotcore.hardware.HardwareMap sdkHardwareMap;
    public HardwareMap(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        if (hardwareMap == null) {
            throw new IllegalArgumentException("HardwareMap cannot be null!");
        }
        this.sdkHardwareMap = hardwareMap;
    }
    public DcMotorEx getMotor(String name) {
        if (sdkHardwareMap == null) {
            throw new NullPointerException("HardwareMap was not initialized!");
        }
        return (DcMotorEx) sdkHardwareMap.get(DcMotor.class, name);
    }

    public DcMotorEx getMotor(RobotConstants.HardwareName item) {
        return getMotor(item.name);
    }
}
