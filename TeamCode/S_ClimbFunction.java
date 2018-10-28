package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;

//Autonomous code part for going down from hanger

@Autonomous(name = "EncoderFunction_Copy", group = "")

public class ClimbFunction extends LinearOpMode {
    private DcMotor climb;
    public void climbRotations(double rotations) {
        int torotate = (int) Math.ceil(rotations * 4320.0);
        climb.setTargetPosition(torotate);
        climb.setPower(1);
        
        while (climb.isBusy()) {
            sleep(1);
        }
        climb.setPower(0);
        
    }
    public void climbCentimeters(double cm) {
        double toMove = cm/(3.14159265359 * 1.5*2);
        moveRotations(toMove);
    }
    @Override
    public void runOpMode() {
        climb = hardwareMap.dcMotor.get("climb");
        climb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        climb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        climb.setDirection(DcMotorSimple.Direction.REVERSE);
        
        
        
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
            moveCentimeters(29);
        }
    }
}
