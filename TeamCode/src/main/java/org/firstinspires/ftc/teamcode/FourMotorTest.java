package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class FourMotorTest extends LinearOpMode{
    private DcMotor Motor1;
    private DcMotor Motor2;
    private DcMotor Motor3;
    private DcMotor Motor4;

    @Override
    public void runOpMode() {
        Motor1 = hardwareMap.get(DcMotor.class, "Motor1");
        Motor2 = hardwareMap.get(DcMotor.class, "Motor2");
        Motor3 = hardwareMap.get(DcMotor.class, "Motor3");
        Motor4 = hardwareMap.get(DcMotor.class, "Motor4");

        telemetry.addData("Status", "Initalized");
        telemetry.update();

        waitForStart();

        double controllerPower = 0;
        while (opModeIsActive()) {
            controllerPower = -this.gamepad1.left_stick_y;
            Motor1.setPower(controllerPower);
            Motor2.setPower(controllerPower);
            Motor3.setPower(controllerPower);
            Motor4.setPower(controllerPower);
            telemetry.addData("Target Power", controllerPower);
            telemetry.addData("Motor1", Motor1.getPower());
            telemetry.addData("Motor2", Motor2.getPower());
            telemetry.addData("Motor3", Motor3.getPower());
            telemetry.addData("Motor4", Motor4.getPower());
            telemetry.update();
        }
    }
}
