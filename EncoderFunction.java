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
    public void moveRotations(double rotations) {
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        double pos = R.getCurrentPosition() + L.getCurrentPosition();
        pos = pos/2;
        
        while (pos < rotations*1400) {
            pos = R.getCurrentPosition() + L.getCurrentPosition();
            pos = pos/2;
            R.setPower(1);
            L.setPower(-1);
            
        }
        R.setPower(0);
        L.setPower(0);
        
        
    }
    public void moveCentimeters(double cm) {
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
        
        while (opModeIsActive()) {
            moveRotations(30);
            telemetry.addData("Right Motor Position:", R.getCurrentPosition());
            telemetry.addData("Left Motor Positition:",L.getCurrentPosition());
            telemetry.update();
        }
    }
}
