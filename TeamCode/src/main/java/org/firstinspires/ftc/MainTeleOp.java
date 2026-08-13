package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOp")
public class MainTeleOp extends LinearOpMode{

    @Override
    public void runOpMode(){
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        telemetry.addLine("Ready to start. ");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            leftMotor.setPower(drive + turn);
            rightMotor.setPower(drive - turn);

            telemetry.addData("drive", drive);
            telemetry.update();
        }
    }

}
