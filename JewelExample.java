package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "JewelExample", group = "")
public class SensorOutput_Copy extends LinearOpMode {

  private ColorSensor blockSensor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    blockSensor = hardwareMap.colorSensor.get("blockSensor");
    waitForStart();
    if (opModeIsActive()) {
      int blue1;
      int blue2;
      int blue3
      int blue
      //assuming you start at first jewel
      blue1 = blockSensor.blue();
      sleep(100)
      blue2 = blockSensor.blue();
      sleep(100)
      blue3 = blockSensor.blue();
      sleep(100)
      blue = (blue1 + blue2 + blue3)/3
      telemetry.addLine(integer.tostring(blue));
      
      while (opModeIsActive()) {
        
        
      }
    }
  }
}
