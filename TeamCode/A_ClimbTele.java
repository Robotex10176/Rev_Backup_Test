package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "ClimbTele", group = "")
public class ClimbTele extends LinearOpMode {

  private DcMotor R;
  private DcMotor L;
  private DcMotor C;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    R = hardwareMap.dcMotor.get("R");
    L = hardwareMap.dcMotor.get("L");
    C = hardwareMap.dcMotor.get("climb");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        L.setPower(Math.pow(gamepad1.left_stick_y, 3));
        R.setPower(-Math.pow(gamepad1.right_stick_y, 3));
        if (gamepad1.dpad_up) {
            C.setPower(-1);
        }else {
            C.setPower(0);
        }
        if (gamepad1.dpad_down) {
            C.setPower(1);
        } else {
            C.setPower(0);
        }
      }
    }
  }
}
