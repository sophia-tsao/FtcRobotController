package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DistanceSensorControl {

    private DistanceSensor distanceSensor;

    public DistanceSensorControl(HardwareMap hardwareMap){
        distanceSensor = hardwareMap.get(
                DistanceSensor.class,
                "sensorColorRange"
        );
    }

    public double getDistanceInches(){
        return distanceSensor.getDistance(DistanceUnit.INCH);
    }

    public boolean isTooClose(double minimumDistance){
        return getDistanceInches() < minimumDistance;
    }
}
