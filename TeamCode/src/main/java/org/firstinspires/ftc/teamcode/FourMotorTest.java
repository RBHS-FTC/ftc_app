package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class FourMotorTest extends LinearOpMode{
    private DcMotor Motor0;
    private DcMotor Motor1;
    private DcMotor Motor2;
    private DcMotor Motor3;

    @Override
    public void runOpMode() {
        Motor0 = hardwareMap.get(DcMotor.class, "Motor1");
        Motor1 = hardwareMap.get(DcMotor.class, "Motor2");
        Motor2 = hardwareMap.get(DcMotor.class, "Motor3");
        Motor3 = hardwareMap.get(DcMotor.class, "Motor4");

        telemetry.addData("Status", "Initalized");
        telemetry.update();

        waitForStart();

        double conPwrX = 0;
        double conPwrY = 0;
        while (opModeIsActive()) {
            conPwrX = -this.gamepad1.left_stick_x;
            conPwrY = -this.gamepad1.left_stick_y;
            Motor0.setPower(-conPwrY);
            Motor1.setPower(conPwrY);
            Motor2.setPower(conPwrY);
            Motor3.setPower(-conPwrY);

            /*
            Diagonal Strafe
            M1 = +
            M2 = +
            M3 = -
            M4 = -

            Forward & Back
            M1 = -
            M2 = +
            M3 = +
            M4 = -
             */
            telemetry.addData("Target Power", conPwrY);
            telemetry.addData("Motor1", Motor0.getPower());
            telemetry.addData("Motor2", Motor1.getPower());
            telemetry.addData("Motor3", Motor2.getPower());
            telemetry.addData("Motor4", Motor3.getPower());
            telemetry.update();
        }
    }
}
