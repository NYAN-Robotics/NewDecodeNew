package org.firstinspires.ftc.teamcode.utilities.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Consumer;
import org.firstinspires.ftc.teamcode.utilities.config.core.RobotConstants;
import org.firstinspires.ftc.teamcode.utilities.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.utilities.hardware.StatedMotor;

public class WheelController {
    private final StatedMotor frontLeftWheel;
    private final StatedMotor frontRightWheel;
    private final StatedMotor backLeftWheel;
    private final StatedMotor backRightWheel;

    public WheelController(HardwareMap hardwareMap) {
        this.frontLeftWheel = new StatedMotor(hardwareMap.getMotor(RobotConstants.HardwareName.WHEEL_FL));
        this.frontRightWheel = new StatedMotor(hardwareMap.getMotor(RobotConstants.HardwareName.WHEEL_FR));
        this.backLeftWheel = new StatedMotor(hardwareMap.getMotor(RobotConstants.HardwareName.WHEEL_BL));
        this.backRightWheel = new StatedMotor(hardwareMap.getMotor(RobotConstants.HardwareName.WHEEL_BR));
    }

    private StatedMotor getWheelFromName(RobotConstants.HardwareName name) {
        switch(name) {
            case WHEEL_FL: return this.frontLeftWheel;
            case WHEEL_FR: return this.frontRightWheel;
            case WHEEL_BL: return this.backLeftWheel;
            case WHEEL_BR: return this.backRightWheel;
        }
        return null;
    }

    private void runForMotors(Consumer<StatedMotor> runnable, RobotConstants.HardwareName... names) {
        for (RobotConstants.HardwareName name : names) {
            runnable.accept(getWheelFromName(name));
        }
    }

    private void runForMotors(Consumer<StatedMotor> runnable, StatedMotor... motors) {
        for (StatedMotor motor : motors) {
            runnable.accept(motor);
        }
    }

    private void runForEachMotor(Consumer<StatedMotor> runnable) {
        runForMotors(runnable, frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
    }

    public void setWheelDirection(DcMotorSimple.Direction direction, RobotConstants.HardwareName... names) {
        runForMotors((motor) -> motor.motor.setDirection(DcMotorSimple.Direction.REVERSE), names);
    }

    public void setWheelPower(double power, RobotConstants.HardwareName... names) {
        runForMotors((motor) -> motor.motor.setPower(power), names);
    }


    public void moveInDirection(double x, double y) {
        setWheelPower((y + x) * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_FL);
        setWheelPower((y - x) * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_FR);
        setWheelPower((y - x) * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_BL);
        setWheelPower((y + x) * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_BR);
    }

    public void moveInDirection(double x, double y, double rx, double denominator) {
        setWheelPower((y + x + rx) / denominator * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_FL);
        setWheelPower((y - x - rx) / denominator * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_FR);
        setWheelPower((y - x + rx) / denominator * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_BL);
        setWheelPower((y + x - rx) / denominator * RobotConstants.WHEEL_SPEED, RobotConstants.HardwareName.WHEEL_BR);
    }
}
