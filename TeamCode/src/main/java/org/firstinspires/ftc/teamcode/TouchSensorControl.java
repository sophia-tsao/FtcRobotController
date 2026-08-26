package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TouchSensorControl {
    private DigitalChannel digitalTouch;


    public TouchSensorControl(HardwareMap hardwareMap) {

        digitalTouch = hardwareMap.get(
                DigitalChannel.class,
                "digitalTouch"
        );

        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
    }


    public boolean isPressed() {
        return !digitalTouch.getState();
    }
}

