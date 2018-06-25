package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MotorTest extends LinearOpMode {
	private DcMotor MotorTest;

	@Override
	public void runOpMode() {
		MotorTest = hardwareMap.get(DcMotor.class, "Motor01");

		telemetry.addData("Status", "Initialized");
		telemetry.update();

		waitForStart();

		double tgtPower = 0;
		while (opModeIsActive()) {
			tgtPower = -this.gamepad1.left_stick_y;
			MotorTest.setPower(tgtPower);
			telemetry.addData("Target Power", tgtPower);
			telemetry.addData("motorTest", MotorTest.getPower());
			telemetry.addData("Status", "Initialized");
			telemetry.update();
		}
	}
}
