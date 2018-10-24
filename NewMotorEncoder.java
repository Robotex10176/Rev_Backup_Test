package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "NewMotorEncoder", group = "")

public class NewMotorEncoder extends LinearOpMode{
    private DcMotor l;
    private DcMotor r;
    private DcMotor climb;
    private Blinker expansion_Hub_2;
    private DistanceSensor blockSensor;
    public void runOpMode() {
        climb = hardwareMap.dcMotor.get("climb");
        while (opModeIsActive()) {
            telemetry.addData("EncoderValue: ", climb.getCurrentPosition());
        }
    }
    

    // todo: write your code here
    
}