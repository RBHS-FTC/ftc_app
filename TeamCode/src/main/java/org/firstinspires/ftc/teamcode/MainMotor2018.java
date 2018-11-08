package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MainMotor2018 extends LinearOpMode{
    private DcMotor Motor0;
    private DcMotor Motor1;
    private DcMotor Motor2;
    private DcMotor Motor3;

    @Override
    public void runOpMode() {
        Motor0 = hardwareMap.get(DcMotor.class, "Motor0");
        Motor1 = hardwareMap.get(DcMotor.class, "Motor1");
        Motor2 = hardwareMap.get(DcMotor.class, "Motor2");
        Motor3 = hardwareMap.get(DcMotor.class, "Motor3");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double controllerPowerLeftY = 0;
        double controllerPowerLeftX = 0;
        double controllerPowerRightY = 0;
        double controllerPowerRightX = 0;
        while (opModeIsActive()) {
            controllerPowerLeftY = -this.gamepad1.left_stick_y;
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
            controllerPowerRightX = -this.gamepad1.right_stick_y;
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


            /*
            Forward & Back
            M0 = -
            M1 = +
            M2 = +
            M3 = -
             */
            telemetry.addData("Motor0", Motor0.getPower());
            telemetry.addData("Motor1", Motor1.getPower());
            telemetry.addData("Motor2", Motor2.getPower());
            telemetry.addData("Motor3", Motor3.getPower());
            telemetry.update();
        }
    }
}
