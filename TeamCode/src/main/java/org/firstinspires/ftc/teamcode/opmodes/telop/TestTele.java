package org.firstinspires.ftc.teamcode.opmodes.telop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.utilities.config.core.RobotConstants;
import org.firstinspires.ftc.teamcode.utilities.hardware.StickControlPosition;
import org.firstinspires.ftc.teamcode.utilities.robot.Robot;

import dev.nextftc.ftc.NextFTCOpMode;

@SuppressWarnings("unused")
@TeleOp(name = "Test Tele")
public class TestTele extends NextFTCOpMode {
    public Robot robot;

    {
        addComponents(/* vararg components */);
    }

    @Override public void onInit() {
        robot = Robot.getInstance();
    }

    @Override public void onStartButtonPressed() { }

    @Override public void onUpdate() {
        StickControlPosition leftStick = new StickControlPosition(gamepad1.left_stick_x, gamepad1.left_stick_y);
        StickControlPosition rightStick = new StickControlPosition(gamepad1.right_stick_x, gamepad1.right_stick_y);
        double x = leftStick.x;
        double y = leftStick.y;
        double rx = rightStick.x;

        telemetry.addData("Left Stick X: ", leftStick.x);
        telemetry.addData("Left Stick Y: ", leftStick.y);
        telemetry.update();

        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1);
        robot.wheelController.setWheelPower((y + x + rx) / denominator, RobotConstants.HardwareName.WHEEL_FL);
        robot.wheelController.setWheelPower((y - x - rx) / denominator, RobotConstants.HardwareName.WHEEL_FR);
        robot.wheelController.setWheelPower((y - x + rx) / denominator, RobotConstants.HardwareName.WHEEL_BL);
        robot.wheelController.setWheelPower((y + x - rx) / denominator, RobotConstants.HardwareName.WHEEL_BR);
    }

    @Override public void onStop() { }
}