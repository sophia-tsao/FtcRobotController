//lists of tasks for robot controller to perform

@TeleOp
//teleop means driver-controlled. replace with @autonomous to autonomous op mode. 
    
public class MyFIRSTJavaOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motorTest;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;
    //5 private member variables that hold references to the five configured devices that the onbot java editor that is detected in the config file of your robot controller.

    @Override
    public void runOpMode() {
        //overriden method called runOpMode, this must be implemented by every OpMode of type LinearOpMode. gets called whenever a user selects and runs the mode.
        imu = hardwareMap.get(Gyroscope.class, "imu");
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");
        //hardwareMap object is available to use in the runOpMode method. object of the hardwareMap class. 
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}

https://ftc-docs.firstinspires.org/en/latest/programming_resources/tutorial_specific/android_studio/creating_op_modes/Creating-and-Running-an-Op-Mode-%28Android-Studio%29.html#teamcode-module
