package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class TwoControllerTest extends LinearOpMode {
    private DcMotor Motor0;
    private DcMotor Motor1;
    private DcMotor Motor2;
    private DcMotor Motor3;
    private DcMotor Motor4;
    private DcMotor Motor5;
    private Servo Servo0;

    @Override
    public void runOpMode() {
        Motor0 = hardwareMap.get(DcMotor.class, "Motor0");
        Motor1 = hardwareMap.get(DcMotor.class, "Motor1");
        Motor2 = hardwareMap.get(DcMotor.class, "Motor2");
        Motor3 = hardwareMap.get(DcMotor.class, "Motor3");
        Motor4 = hardwareMap.get(DcMotor.class, "Motor4");
        Motor5 = hardwareMap.get(DcMotor.class, "Motor6");

        Servo0 = hardwareMap.get(Servo.class, "Servo0");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double controllerOnePowerLeftY = 0;
        double controllerTwoPowerRightY = 0;
        while (opModeIsActive()) {
            controllerOnePowerLeftY = -this.gamepad1.left_stick_y;
            controllerTwoPowerRightY = -this.gamepad2.right_stick_y;
            /*
            //Forwards and Backwards
            Motor0.setPower(-controllerOnePowerLeftY);
            Motor1.setPower(controllerOnePowerLeftY);
            Motor2.setPower(controllerTwoPowerLeftY);
            Motor3.setPower(-controllerTwoPowerLeftY);
            */

            //Motor to move arm forward and back
            Motor4.setPower(controllerOnePowerLeftY);

            //Motor to move arm up and down
            Motor5.setPower(controllerTwoPowerRightY);
            if (gamepad2.b) Servo0.setPosition(0.5);
            if (gamepad2.a) Motor4.setPower(1);
            if (gamepad2.y) Motor5.setPower(-1);

            telemetry.addData("Motor0", Motor0.getPower());
            telemetry.addData("Motor1", Motor1.getPower());
            telemetry.addData("Motor2", Motor2.getPower());
            telemetry.addData("Motor3", Motor3.getPower());
            telemetry.addData("Motor4", Motor4.getPower());
            telemetry.addData("Motor5", Motor5.getPower());
            telemetry.addData("Servo0", Servo0.getPosition());
            telemetry.update();
        }
    }
}
