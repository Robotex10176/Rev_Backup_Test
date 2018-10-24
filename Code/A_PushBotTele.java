package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "PushBotTele", group = "")
public class A_PushBotTele extends LinearOpMode {

  private DcMotor R;
  private DcMotor L;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    R = hardwareMap.dcMotor.get("R");
    L = hardwareMap.dcMotor.get("L");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        L.setPower(Math.pow(gamepad1.left_stick_y, 3));
        R.setPower(-Math.pow(gamepad1.right_stick_y, 3));
      }
    }
  }
}
