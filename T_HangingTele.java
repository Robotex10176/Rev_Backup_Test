package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "HangingTele", group = "")
public class T_HangingTele extends LinearOpMode {

  private DcMotor H;
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    H = hardwareMap.dcMotor.get("H");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        if (gamepad1.left_bumper) {
          H.setPower(1);
        } else {
          H.setPower(0);
        }
      }
    }
  }
}
