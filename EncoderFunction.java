package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@Autonomous(name = "EncoderFunction", group = "")

public class EncoderFunction extends LinearOpMode {
    private DcMotor L;
    private DcMotor R;
    L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    public void moveRotations(double rotations) {
	rotations = rotations * 1440
	R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
	R.setTargetPosition(rotations);
	L.setTargetPosition(rotations);
	
        
        
    }
    public void moveCentimeters(double cm) {
        double toMove = (3.14159265359 * 9.5)/cm;
        moveRotations(toMove);
    }
    @Override
    public void runOpMode() {
        
        //to reset
        //L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //to set to run with encoder
        //L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //to get current position:
        //(R/L).leftDrive.getCurrentPosition()
        //to set to run
        //L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R = hardwareMap.dcMotor.get("R");
        L = hardwareMap.dcMotor.get("L");
        waitForStart();
        
        if (opModeIsActive()) {
            moveRotations(3);
        }
    }
}
