package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@Autonomous(name = "EncoderFunction", group = "")

public class EncoderFunction extends LinearOpMode {
    private DcMotor L;
    private DcMotor R;
    public void moveRotations(double rotations) {
        int torotate = (int) Math.ceil(rotations * 1440.0);
        R.setTargetPosition(torotate);
        L.setTargetPosition(torotate);
        R.setPower(1);
        L.setPower(1);
        
        while (L.isBusy() && R.isBusy()) {
            sleep(1);
        }
        R.setPower(0);
        L.setPower(0);
        
    }
    public void moveCentimeters(double cm) {
        double toMove = cm/(3.14159265359 * 9.5);
        moveRotations(toMove);
    }
    @Override
    public void runOpMode() {
        R = hardwareMap.dcMotor.get("R");
        L = hardwareMap.dcMotor.get("L");
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        L.setDirection(DcMotorSimple.Direction.REVERSE);
        
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
        waitForStart();
        
        if (opModeIsActive()) {
            moveCentimeters(150);
        }
    }
}
