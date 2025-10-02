package org.firstinspires.ftc.teamcode.utilities.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class CachedMotor {
    private final DcMotorEx motor;
    private double lastPower = 0;
    private double lastVelocity = 0;
    private int lastTargetPosition = 0;
    private DcMotor.RunMode lastRunMode;
    private boolean velocityControlEnabled = false;

    public CachedMotor(DcMotorEx motor) {
        this.motor = motor;
        this.lastRunMode = motor.getMode();
    }

    public void setPower(double power) {
        if (Math.abs(power - lastPower) < 0.001) return;
        motor.setPower(power);
        lastPower = power;
        velocityControlEnabled = false;
    }

    public void setVelocity(double velocity) {
        if (Math.abs(velocity - lastVelocity) < 0.1) return;
        motor.setVelocity(velocity);
        lastVelocity = velocity;
        velocityControlEnabled = true;
    }

    public void setTargetPosition(int targetPosition) {
        if (targetPosition == lastTargetPosition) return;
        motor.setTargetPosition(targetPosition);
        lastTargetPosition = targetPosition;
    }

    public void setMode(DcMotor.RunMode runMode) {
        if (runMode == lastRunMode) return;
        motor.setMode(runMode);
        lastRunMode = runMode;
    }

    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior zeroPowerBehavior) {
        motor.setZeroPowerBehavior(zeroPowerBehavior);
    }

    public void setPIDFCoefficients(double kP, double kI, double kD, double kF) {
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(kP, kI, kD, kF);
        motor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
    }

    public void setDirection(DcMotorSimple.Direction direction) {
        motor.setDirection(direction);
    }

    public int getCurrentPosition() {
        return motor.getCurrentPosition();
    }

    public double getVelocity() {
        return motor.getVelocity();
    }

    public double getPower() {
        return motor.getPower();
    }

    public boolean isAtTargetPosition() {
        return !motor.isBusy();
    }

    public boolean isVelocityControlEnabled() {
        return velocityControlEnabled;
    }

    public DcMotorEx getMotor() {
        return motor;
    }

    public void resetEncoder() {
        DcMotor.RunMode currentMode = motor.getMode();
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(currentMode);
        lastRunMode = currentMode;
    }
}