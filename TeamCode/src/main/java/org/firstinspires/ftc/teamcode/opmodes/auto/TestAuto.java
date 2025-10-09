package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utilities.config.core.RobotConstants;
import org.firstinspires.ftc.teamcode.utilities.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.utilities.robot.Robot;

@Autonomous(name = "Test Auto")
public class TestAuto extends OpMode {
    ElapsedTime runtime = new ElapsedTime();
    public HardwareMap hardwareMapEx;
    public Robot robot;

    @Override public void init() {
        hardwareMapEx = new HardwareMap(hardwareMap);
        robot = new Robot(hardwareMapEx);

        robot.wheelController.setWheelDirection(DcMotorSimple.Direction.REVERSE, RobotConstants.HardwareName.WHEEL_FL, RobotConstants.HardwareName.WHEEL_BL);
    }
    @Override public void loop() {
        if (runtime.milliseconds() >= 2000) {
            robot.wheelController.moveInDirection(0, 0);
            return;
        }
        robot.wheelController.moveInDirection(0, 1);
    }
    @Override public void stop() {
        robot.wheelController.moveInDirection(0, 0);
    }
}