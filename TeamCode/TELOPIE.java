package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TELEOPIE", group = "")
public class TELOPIE extends LinearOpMode {

  private DcMotor R;
  private DcMotor L;
  private DcMotor climb;
  private Servo dropservo;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    R = hardwareMap.dcMotor.get("R");
    L = hardwareMap.dcMotor.get("L");
    climb = hardwareMap.dcMotor.get("climb");
    dropservo = hardwareMap.servo.get("dropservo");
    R.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    L.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    climb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    dropservo.setPosition(0.2);
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        L.setPower(Math.pow(gamepad1.left_stick_y, 3));
        R.setPower(-Math.pow(gamepad1.right_stick_y, 3));
        if (gamepad1.dpad_up) {
          climb.setPower(-1);
        }else {
          climb.setPower(0);
          
        }
        if (gamepad1.dpad_down) {
          climb.setPower(1);
        }else {
          climb.setPower(0);
          
        }
        if (gamepad1.right_bumper) {
          dropservo.setPosition(0.9);
        }
        if (gamepad1.left_bumper) {
          dropservo.setPosition(0.2);
          
        }
      }
    }
  }
}
