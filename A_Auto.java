package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous(name = "Autonomous", group = "")
public class template extends LinearOpMode {
  private DcMotor R;
  private DcMotor L;
  private BNO055IMU imu;
  private DcMotor climb;
  public void turnRight(double degrees) {
    while (-1*(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle) < degrees) {
      R.setPower(-1);
      L.setPower(1);
      
    }
    R.setPower(0);
    L.setPower(0);
    
  }
  public void turnLeft(double degrees) {
    while (-1*(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle) > degrees) {
      R.setPower(1);
      L.setPower(-1);
      
    }
    R.setPower(0);
    L.setPower(0);
    
  }
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
    public void moveRotations(double rotations) {
        int torotate = (int) Math.ceil(rotations * 1440.0);
        R.setTargetPosition(torotate);
        L.setTargetPosition(torotate);
        R.setPower(1);
        L.setPower(1);
        
        while (L.isBusy() && R.isBusy()) {
            sleep(1);
        }
        R.setPower(0);
        L.setPower(0);
        
    }
    public void moveCentimeters(double cm) {
        double toMove = cm/(3.14159265359 * 9.5);
        moveRotations(toMove);
    }

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        
      }
    }
  }
}
