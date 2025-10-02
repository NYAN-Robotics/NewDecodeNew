package org.firstinspires.ftc.teamcode.utilities.hardware;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class StatedMotor {
    public boolean enabled = false;
    public CachedMotor motor;

    public StatedMotor(DcMotorEx motor) {
        this.motor = new CachedMotor(motor);
    }

    public StatedMotor(CachedMotor motor) {
        this.motor = motor;
    }
}
