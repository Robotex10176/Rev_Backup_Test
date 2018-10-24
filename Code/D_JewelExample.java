package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "JewelExample", group = "")
public class D_JewelExample extends LinearOpMode {

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
      int blue3;
      int blue;
      //assuming you start at first jewel
      blue1 = blockSensor.blue();
      sleep(100);
      blue2 = blockSensor.blue();
      sleep(100);
      blue3 = blockSensor.blue();
      sleep(100);
      blue = ((blue1 + blue2 + blue3)/3);
      if (blue > 75){
        //Jewel is not gold, move on
        //at this point robot is at second jewel
        blue1 = blockSensor.blue();
        sleep(100);
        blue2 = blockSensor.blue();
        sleep(100);
        blue3 = blockSensor.blue();
        sleep(100);
        blue = ((blue1 + blue2 + blue3)/3);
        if (blue > 75){
          //jewel is not gold, move to third and push it
        }else{
          //jewel is gold, move it
        }
      }else{
        //Jewel is gold, move it.
      }
        
      
      while (opModeIsActive()) {
        
        
      }
    }
  }
}
