package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@Autonomous

public class EncoderOut extends LinearOpMode {
    private DcMotor L;
    private DcMotor R;
    private DcMotor climb;
    private Blinker expansion_Hub_2;
    private DistanceSensor blockSensor;
    

    // todo: write your code here
    public void runOpMode() {
        R = hardwareMap.dcMotor.get("R");
        L = hardwareMap.dcMotor.get("L");
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Right Position", R.getCurrentPosition());
            telemetry.addData("Left Position", L.getCurrentPosition());
            telemetry.update();
        }
    }
}
