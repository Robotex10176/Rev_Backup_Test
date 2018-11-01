package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous(name = "A_Auto", group = "")
public class A_Auto extends LinearOpMode {
  private DcMotor R;
  private DcMotor L;
  private BNO055IMU imu;
  private DcMotor climb;
  private Servo dropservo;
  
  
    public void DriveRotations(double rotations) {
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
    public void driveCentimeters(double cm) {
        double toMove = cm/(3.14159265359 * 9.5);
        DriveRotations(toMove);
    }
    public void climbRotations(double rotations) {
        int torotate = (int) Math.ceil(rotations * 3600.0);
        climb.setTargetPosition(torotate);
        climb.setPower(1);
        
        while (climb.isBusy()) {
            sleep(1);
        }
        climb.setPower(0);
        
    }
    public void climbCentimeters(double cm) {
        double toMove = cm/(3.14159265359 * 1.5*2);
        DriveRotations(toMove);
    }
    public void turnRight(double degrees) {
    R.setPower(-0.5);
    L.setPower(0.5);
    while (-1*(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle) < degrees) {
      //empty for speed (intentional)
    }
    R.setPower(0);
    L.setPower(0);
    
  }
  public void turnLeft(double degrees) {
    R.setPower(0.5);
    L.setPower(-0.5);
    while (-1*(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle) > degrees) {
      //empty for speed (intentional)
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
    R.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    L.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    climb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    BNO055IMU.Parameters parem = new BNO055IMU.Parameters();
    parem.mode = BNO055IMU.SensorMode.IMU;
    parem.angleUnit = BNO055IMU.AngleUnit.DEGREES;
    parem.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    parem.loggingEnabled = false;
    imu = hardwareMap.get(BNO055IMU.class, "imu");
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        //red (or blue) claiming side
        climbCentimeters(30);  //Come down
        turnLeft(90);  //turn left 90 degrees
        driveCentimeters(208);//move straight until we are in the claiming zone need to know tihs value
        dropservo.setPosition(0.8);//drop claimer
        driveCentimeters(150);//back up to get out of the way need to know this value
        dropservo.setPosition(0.2);
        //red (or blue) crater side
        ClimCentimeters(30);//land
        turnLeft(90);//turn left 90 degrees
        driveCentimeters(10);//drive straight to crater    //need to know this value
        driveCentimeters(-10);//back up a little           //need to know this value
        turnLeft(90);//turn left 90 degrees
        driveCentimeters(10);//drive straight              //need to know this value
        turnLeft(45);//left 45 degrees
        driveCentimeters(10);//drive straight              //need to know this value
        dropservo.setPosition(0.8);//drop claimer          //need to know this value
        driveCentimeters(-10);//back up                    //need to know this value
        dropservo.setPosition(0.2);
      }
    }
  }
}
