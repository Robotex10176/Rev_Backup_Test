package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name = "S_TurnFunction", group = "")
public class S_TurnFunction extends LinearOpMode {
  private DcMotor R;
  private DcMotor L;
  private BNO055IMU imu;
  
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
  
  
  
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    R = hardwareMap.dcMotor.get("R");
    L = hardwareMap.dcMotor.get("L");
    L.setDirection(DcMotorSimple.Direction.REVERSE);
    
    BNO055IMU.Parameters parem = new BNO055IMU.Parameters();
    parem.mode = BNO055IMU.SensorMode.IMU;
    parem.angleUnit = BNO055IMU.AngleUnit.DEGREES;
    parem.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    parem.loggingEnabled = false;
    imu = hardwareMap.get(BNO055IMU.class, "imu");
    imu.initialize(parem);
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      imu.initialize(parem);
      turnRight(90);
    }
  }
}
