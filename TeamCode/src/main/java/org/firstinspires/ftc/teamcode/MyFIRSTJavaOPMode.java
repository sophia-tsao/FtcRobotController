package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "My FIRST Java OpMode")
public class MyFIRSTJavaOpMode extends LinearOpMode{

    private Gyroscope imu;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;

    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private TouchSensorControl touchSensor;


    @Override
    public void runOpMode() {

        // get devices from robot configuration
        imu = hardwareMap.get(Gyroscope.class, "imu");
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");
        //initializing front left right back left right motors
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        touchSensor = new TouchSensorControl(hardwareMap);

        //because motors mounted on opposite sides physically face opposite
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        // make motors resist movement when power is 0
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait until PLAY is pressed
        waitForStart();

        //run until stop is pressed
        while (opModeIsActive()){

            //left stick controls backwards/forwards
            double drive = -gamepad1.left_stick_y;

            //right stick controls turning
            double turn = gamepad1.right_stick_x;

            double leftPower = drive + turn;
            double rightPower = drive - turn;

            //slow mode by holding left bumper
            double speedMultiplier = 1.0;
            if (gamepad1.left_bumper){
                speedMultiplier = 0.4;
            }
            leftPower *= speedMultiplier;
            rightPower *= speedMultiplier;

            //prevent calculated motor powers from going above 1 or below -1
            double max = Math.max(
                    Math.abs(leftPower),
                    Math.abs(rightPower)
            );

            if (max>1.0){
                leftPower /= max;
                rightPower /= max;
            }

            //send calculated power to drivetrain motors
            frontLeft.setPower(leftPower);
            backLeft.setPower(leftPower);

            frontRight.setPower(rightPower);
            backRight.setPower(rightPower);

            //sensor telemetry
            if (touchSensor.isPressed()) {
                telemetry.addData("Touch Sensor", "Pressed");
            } else {
                telemetry.addData("Touch Sensor", "Not pressed");
            }

            telemetry.update();

            //telemetry
            telemetry.addData("Drive", drive);
            telemetry.addData("Turn", turn);
            telemetry.addData("Left Power", leftPower);
            telemetry.addData("Right Power", rightPower);
            telemetry.addData("Slow Mode", gamepad1.left_bumper);
            telemetry.addData("Status", "Running");
            telemetry.update();

        }

    }

}
