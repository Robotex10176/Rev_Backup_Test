package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "CrazyDriveTele", group = "")
public class A_CrazyDriveTele extends LinearOpMode {

  private DcMotor N;
  private DcMotor S;
  private DcMotor E;
  private DcMotor W;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    N = hardwareMap.dcMotor.get("N");
    S = hardwareMap.dcMotor.get("S");
    E = hardwareMap.dcMotor.get("E");
    W = hardwareMap.dcMotor.get("W");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        N.setPower(Math.pow(gamepad1.left_stick_y, 3));
        S.setPower(-Math.pow(gamepad1.left_stick_y, 3));
        E.setPower(Math.pow(gamepad1.right_stick_x, 3));
        W.setPower(-Math.pow(gamepad1.right_stick_x, 3));
      }
    }
  }
}
