package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "dualMotor2 (Blocks to Java)", group = "")
public class dualMotor2 extends LinearOpMode {

  private DcMotor L;
  private DcMotor R;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    L = hardwareMap.dcMotor.get("L");
    R = hardwareMap.dcMotor.get("R");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      L.setPower(1);
      R.setPower(1);
    }
  }
}
