package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class CompetitionTwo extends LinearOpMode {
    private DcMotor Motor0;
    private DcMotor Motor1;
    private DcMotor Motor2;
    private DcMotor Motor3;
    private DcMotor Motor4;
    private DcMotor Motor5;
    private DcMotor Motor6;
    private DcMotor Motor7;
    private Servo Servo0;
    private Servo Servo1;

    @Override
    public void runOpMode() {
        Motor0 = hardwareMap.get(DcMotor.class, "Motor0");
        Motor1 = hardwareMap.get(DcMotor.class, "Motor1");
        Motor2 = hardwareMap.get(DcMotor.class, "Motor2");
        Motor3 = hardwareMap.get(DcMotor.class, "Motor3");
        Motor4 = hardwareMap.get(DcMotor.class, "Motor4");
        Motor5 = hardwareMap.get(DcMotor.class, "Motor5");
        Motor6 = hardwareMap.get(DcMotor.class, "Motor6");
        Motor7 = hardwareMap.get(DcMotor.class, "Motor7");

        Servo0 = hardwareMap.get(Servo.class, "Servo0");
        Servo1 = hardwareMap.get(Servo.class, "Servo1");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double controllerPowerLeftY = 0;
        double controllerPowerLeftX = 0;
        double controllerPowerRightY = 0;
        double controllerPowerRightX = 0;
        double controllerTwoPowerLeftY = 0;
        double controllerTwoPowerRightY = 0;
        while (opModeIsActive()) {
            controllerPowerLeftY = -this.gamepad1.left_stick_y;
            controllerTwoPowerLeftY = -this.gamepad2.left_stick_y;
            controllerTwoPowerRightY = -this.gamepad2.right_stick_y;

            //Forwards and Backwards
            Motor0.setPower(-controllerPowerLeftY);
            Motor1.setPower(controllerPowerLeftY);
            Motor2.setPower(controllerPowerLeftY);
            Motor3.setPower(-controllerPowerLeftY);

            //Left and Right turning
            controllerPowerLeftX = -this.gamepad1.left_stick_x;
            Motor0.setPower(controllerPowerLeftX);
            Motor1.setPower(controllerPowerLeftX);
            Motor2.setPower(controllerPowerLeftX);
            Motor3.setPower(controllerPowerLeftX);

            // Must Be Checked
            controllerPowerRightY = -this.gamepad1.right_stick_y;
            Motor0.setPower(-controllerPowerRightY);
            Motor1.setPower(-controllerPowerRightY);
            Motor2.setPower(controllerPowerRightY);
            Motor3.setPower(controllerPowerRightY);
            //  Must Be Checked
            controllerPowerRightX = -this.gamepad1.right_stick_x;
            Motor0.setPower(controllerPowerRightX);
            Motor1.setPower(controllerPowerRightX);
            Motor2.setPower(-controllerPowerRightX);
            Motor3.setPower(-controllerPowerRightX);

            // START BALL COLLECTION
            if (gamepad2.b) Servo0.setPosition(0.5);
            if (gamepad2.a) Motor6.setPower(1); //Motor to collect balls
            if (gamepad2.y) Motor7.setPower(-1); // Drop collection Arm
            if (gamepad2.x && Servo1.getPosition() == 90 ) Servo1.setPosition(0);
            if (gamepad2.x && Servo1.getPosition() == 0 ) Servo1.setPosition(90);
            // END

            //Motor to move arm forward and back
            Motor4.setPower(controllerTwoPowerLeftY);

            //Motor to move arm up and down
            Motor5.setPower(controllerTwoPowerRightY);

            telemetry.addData("Motor0", Motor0.getPower());
            telemetry.addData("Motor1", Motor1.getPower());
            telemetry.addData("Motor2", Motor2.getPower());
            telemetry.addData("Motor3", Motor3.getPower());
            telemetry.addData("Motor4", Motor4.getPower());
            telemetry.addData("Motor5", Motor5.getPower());
            telemetry.addData("Servo0", Servo0.getPosition());
            telemetry.addData("Servo1", Servo1.getPosition());
            telemetry.update();
        }
    }
}
