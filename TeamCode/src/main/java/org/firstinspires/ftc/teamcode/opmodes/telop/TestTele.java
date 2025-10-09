package org.firstinspires.ftc.teamcode.opmodes.telop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.utilities.config.core.RobotConstants;
import org.firstinspires.ftc.teamcode.utilities.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.utilities.hardware.StickControlPosition;
import org.firstinspires.ftc.teamcode.utilities.robot.Robot;

@SuppressWarnings("unused")
@TeleOp(name = "Test Tele")
public class TestTele extends OpMode {
    public HardwareMap hardwareMapEx;
    public Robot robot;

    @Override public void init() {
        hardwareMapEx = new HardwareMap(hardwareMap);
        robot = new Robot(hardwareMapEx);

        robot.wheelController.setWheelDirection(DcMotorSimple.Direction.REVERSE, RobotConstants.HardwareName.WHEEL_FL, RobotConstants.HardwareName.WHEEL_BL);
    }

    @Override public void loop() {
        StickControlPosition leftStick = new StickControlPosition(gamepad1.left_stick_x, gamepad1.left_stick_y);
        StickControlPosition rightStick = new StickControlPosition(gamepad1.right_stick_x, gamepad1.right_stick_y);
        double x = leftStick.x;
        double y = leftStick.y;
        double rx = rightStick.x;

        telemetry.addData("Left Stick X: ", leftStick.x);
        telemetry.addData("Left Stick Y: ", leftStick.y);
        telemetry.update();

        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1);
        robot.wheelController.moveInDirection(x, y, rx, denominator);
    }

    @Override public void stop() { }
}