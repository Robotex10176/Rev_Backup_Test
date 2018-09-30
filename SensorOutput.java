package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@Autonomous

public class SensorOutput {
    private DcMotor l;
    private DcMotor r;
    private Blinker expansion_Hub_2;
    private DistanceSensor blockSensor;

	// todo: write your code here
	public void runOpMode() {
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        telemetry.addData("SensorValue:", blockSensor.
      }
    }
  }
}
