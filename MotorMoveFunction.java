package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import java.lang.math.*;

@Autonomous(name = "MotorMoveFunction", group = "")

public class MotorMoveFunction {
    private DcMotor l;
    private DcMotor r;
    private Blinker expansion_Hub_2;
    private DistanceSensor blockSensor;
    public static void moveRotations(float rotations) {
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
    }
    public static void moveCentimeters(float cm) {
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        float toMove = (Math.pi * 9.5)/cm;
        moveRotations(toMove);
    }
    @Override
    public void runOpMode() {
        R = hardwareMap.dcMotor.get("r");
        L = hardwareMap.dcMotor.get("l");
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //to get current position:
        //(R/L).leftDrive.getCurrentPosition()
        robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        waitForStart();
        
        if (opModeIsActive()) {
            
        }
    }
    // todo: write your code here
}
