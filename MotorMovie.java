package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MotorMovie (Blocks to Java)", group = "")
public class MotorMovie extends LinearOpMode {

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
        if (gamepad1.right_bumper) {
          R.setPower(1);
        } else {
          R.setPower(0);
        }
        if (gamepad1.left_bumper) {
          L.setPower(-1);
        } else {
          L.setPower(0);
        }
      }
    }
  }
}
