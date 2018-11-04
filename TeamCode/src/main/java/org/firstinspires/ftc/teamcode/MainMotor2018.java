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

        double controllerPowerY = 0;
        double controllerPowerX = 0;
        while (opModeIsActive()) {
            controllerPowerY = -this.gamepad1.left_stick_y;
            //Forwards and Backwards
            Motor0.setPower(-controllerPowerY);
            Motor1.setPower(controllerPowerY);
            Motor2.setPower(controllerPowerY);
            Motor3.setPower(-controllerPowerY);

            //Left and Right turning
            controllerPowerX = -this.gamepad1.right_stick_x;
            Motor0.setPower(controllerPowerX);
            Motor1.setPower(controllerPowerX);
            Motor2.setPower(controllerPowerX);
            Motor3.setPower(controllerPowerX);
            /*
            Diagonal Strafe
            M0 = +
            M1 = +
            M2 = -
            M3 = -

            Forward & Back
            M0 = -
            M1 = +
            M2 = +
            M3 = -
             */
            telemetry.addData("Motor Power", controllerPowerY);
            telemetry.addData("Motor0", Motor0.getPower());
            telemetry.addData("Motor1", Motor1.getPower());
            telemetry.addData("Motor2", Motor2.getPower());
            telemetry.addData("Motor3", Motor3.getPower());
            telemetry.update();
        }
    }
}
