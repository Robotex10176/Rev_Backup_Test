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
        public static move(cm){
            double cicumference = 9.5 * Math.PI
            
        }
        
        waitForStart();
        
        if (opModeIsActive()) {
            
        }
    }
    // todo: write your code here
}
