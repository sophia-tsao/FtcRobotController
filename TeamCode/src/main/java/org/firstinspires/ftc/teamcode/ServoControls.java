package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ServoControls {

    private Servo servoTest;

    // Constructor
    public ServoControls(HardwareMap hardwareMap) {
        servoTest = hardwareMap.get(Servo.class, "servoTest");
    }

    public void open(){
        servoTest.setPosition(1.0);
    }

    public void close(){
        servoTest.setPosition(0.0);
    }
}