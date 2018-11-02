package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotor.*;
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
        R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
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
        climb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        climb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        int torotate = (int) Math.ceil(rotations * 4320.0);
        climb.setTargetPosition(torotate);
        climb.setPower(1);
        
        while (climb.isBusy()) {
            sleep(1);
        }
        climb.setPower(0);
        
    }
    public void climbCentimeters(double cm) {
        climb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        climb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        
        double toMove = cm/(3.14159265359 * 1.5*2);
        climbRotations(toMove);
    }
    public void turnRight(double degrees) {
    R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    R.setPower(-0.5);
    L.setPower(0.5);
    while (-1*(imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle) < degrees) {
      //empty for speed (intentional)
    }
    R.setPower(0);
    L.setPower(0);
    
  }
  public void turnLeft(double degrees) {
    R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    
    R.setPower(0.5);
    L.setPower(-0.5);
    while ((imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle) < degrees) {
      //empty for speed (intentional)
    }
    R.setPower(0);
    L.setPower(0);
    sleep(5000);
    
    
  }
  public void waitForstop() {
    while (R.isBusy() || L.isBusy() || climb.isBusy()) {
      //nada
    }
    return;
  }
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    telemetry.addLine("Init: Running");
    telemetry.update();
    R = hardwareMap.dcMotor.get("R");
    L = hardwareMap.dcMotor.get("L");
    climb = hardwareMap.dcMotor.get("climb");
    dropservo = hardwareMap.servo.get("dropservo");
    L.setDirection(DcMotor.Direction.REVERSE);
    climb.setDirection(DcMotor.Direction.REVERSE);
    R.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    L.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    climb.setZeroPowerBehavior(ZeroPowerBehavior.BRAKE);
    BNO055IMU.Parameters parem = new BNO055IMU.Parameters();
    parem.mode = BNO055IMU.SensorMode.IMU;
    parem.angleUnit = BNO055IMU.AngleUnit.DEGREES;
    parem.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    parem.loggingEnabled = false;
    imu = hardwareMap.get(BNO055IMU.class, "imu");
    imu.initialize(parem);  
    dropservo.setPosition(0.2);
    telemetry.addLine("Init: Complete");
    telemetry.update();
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      //red (or blue) claiming side
      climbCentimeters(33);  //Come down
      turnLeft(60);  //turn left 90 degrees
      driveCentimeters(100);//move straight until we are in the claiming zone need to know tihs value
      dropservo.setPosition(0.8);//drop claimer
      sleep(1000);
      driveCentimeters(-75);//back up to get out of the way need to know this value
      dropservo.setPosition(0.2);
      sleep(1000);
      
      //red (or blue) crater side
      //calClimCentimeters(30);//land
      //turnLeft(90);//turn left 90 degrees
      //driveCentimeters(10);//drive straight to crater    //need to know this value
      //driveCentimeters(-10);//back up a little           //need to know this value
      ///turnLeft(90);//turn left 90 degrees
      //driveCentimeters(10);//drive straight              //need to know this value
      //turnLeft(45);//left 45 degrees
      //driveCentimeters(10);//drive straight              //need to know this value
      //dropservo.setPosition(0.8);//drop claimer          //need to know this value
      //driveCentimeters(-10);//back up                    //need to know this value
      //dropservo.setPosition(0.2);
    }
  }
}
