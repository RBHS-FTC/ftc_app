package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TwoControllerTest extends LinearOpMode {
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

        double controllerOnePowerLeftY = 0;
        double controllerTwoPowerLeftY = 0;
        while (opModeIsActive()) {
            controllerOnePowerLeftY = -this.gamepad1.left_stick_y;
            controllerTwoPowerLeftY = -this.gamepad2.left_stick_y;
            //Forwards and Backwards
            Motor0.setPower(-controllerOnePowerLeftY);
            Motor1.setPower(controllerOnePowerLeftY);
            Motor2.setPower(controllerTwoPowerLeftY);
            Motor3.setPower(-controllerTwoPowerLeftY);

            /*
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
            */

            telemetry.addData("Motor0", Motor0.getPower());
            telemetry.addData("Motor1", Motor1.getPower());
            telemetry.addData("Motor2", Motor2.getPower());
            telemetry.addData("Motor3", Motor3.getPower());
            telemetry.update();
        }
    }
}
