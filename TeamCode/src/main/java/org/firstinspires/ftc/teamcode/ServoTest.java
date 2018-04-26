package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

import junit.framework.Test;

@TeleOp
public class MotorTest extends LinearOpMode {
    private DcMotor motorTest;
    private Servo servoTest;

    @Override
    public void runOpMode() {
        motorTest = hardwareMap.get(DcMotor.class, "Motor01");
        servoTest = hardwareMap.get(Servo.class, "Servo01");

        telemetry.addData("Status", "Initalized");
        telemetry.update();

        waitForStart();

        // run until the end of the match (driver presses STOP)
        double tgtPower = 0;
        while (opModeIsActive()) {
            tgtPower = -this.gamepad1.left_stick_y;
            motorTest.setPower(tgtPower);
            // check to see if we need to move the servo.
            if(gamepad1.y) {
                // move to 0 degrees.
                servoTest.setPosition(0);
            } else if (gamepad1.x || gamepad1.b) {
                // move to 90 degrees.
                servoTest.setPosition(0.5);
            } else if (gamepad1.a) {
                // move to 180 degrees.
                // Servo stuck at 180 degrees
                servoTest.setPosition(0.95);
            }
            telemetry.addData("Servo Position", servoTest.getPosition());
            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("Motor Power", motorTest.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
        /*
        double tgtPower = 0;
        while (opModeIsActive()) {
            tgtPower = -this.gamepad1.left_stick_y;
            motorTest.setPower(tgtPower);
            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("servoTest", motorTest.getPower());
            telemetry.addData("Status", "Initialized");
            telemetry.update();
        }
        */

    }
}
