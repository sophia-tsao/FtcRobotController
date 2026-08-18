package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
public class ArmControl {

    private DcMotor armMotor;

    public ArmControl(HardwareMap hardwareMap){
        armMotor = hardwareMap.get(DcMotor.class,"armMotor");

        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void move(double power){
        armMotor.setPower(power);
    }

    public void stop(){
        armMotor.setPower(0);
    }
}
