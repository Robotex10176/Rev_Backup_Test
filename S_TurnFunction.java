package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "S_TurnFunction", group = "")
public class template extends LinearOpMode {
  public void spin(double rotations) {
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
  public void spinCentimeters(double cm) {
        spin(toMove);
  }
  public static double convertA(cm) {
    //cm to degrees
    return (cm/80)*360
  }
  public static double convertB(cm) {
    //degrees to cm
    return (cm/360)*80
  }
  public static void Turn(double degrees){
    double toturn = convertB(degrees);
    spinCentimeters(toturn);
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
