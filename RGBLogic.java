package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "RGBLogic", group = "")
public class RGBLogic extends LinearOpMode {

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
      int blue4;
      int blue5;
      int blue6;
      int bluea;
      int redt;
      int bluea2;
      telemetry.addLine("ENTER NEXT JEWEL ... 5");
      telemetry.update();
      sleep(1000);
      telemetry.addLine("ENTER NEXT JEWEL ... 4");
      telemetry.update();
      sleep(1000);
      telemetry.addLine("ENTER NEXT JEWEL ... 3");
      telemetry.update();
      sleep(1000);
      telemetry.addLine("ENTER NEXT JEWEL ... 2");
      telemetry.update();
      sleep(1000);
      telemetry.addLine("ENTER NEXT JEWEL ... 1");
      telemetry.update();
      sleep(1000);
      //assuming you start at first jewel
      blue1 = blockSensor.blue();
      sleep(100);
      blue2 = blockSensor.blue();
      sleep(100);
      blue3 = blockSensor.blue();
      redt = blockSensor.red();
      sleep(100);
      bluea = ((blue1 + blue2 + blue3)/3);
      if (bluea > 75){
        //Jewel is not gold, move on
        //at this point robot is at second jewel
        telemetry.addLine("ENTER NEXT JEWEL ... 5");
        telemetry.update();
        sleep(1000);
        telemetry.addLine("ENTER NEXT JEWEL ... 4");
        telemetry.update();
        sleep(1000);
        telemetry.addLine("ENTER NEXT JEWEL ... 3");
        telemetry.update();
        sleep(1000);
        telemetry.addLine("ENTER NEXT JEWEL ... 2");
        telemetry.update();
        sleep(1000);
        telemetry.addLine("ENTER NEXT JEWEL ... 1");
        telemetry.update();
        sleep(1000);                  
        blue4 = blockSensor.blue();
        sleep(100);
        blue5 = blockSensor.blue();
        sleep(100);
        blue6 = blockSensor.blue();
        sleep(100);
        bluea2 = ((blue4 + blue5 + blue6)/3);
        if (bluea2 > 75){
          //jewel is not gold, move to third and push it
          telemetry.addLine("[FUNCTION] Knock off 3RD jewel");
          telemetry.addLine("[FINISH]");
          telemetry.update();
          sleep(2000);
        }else if (bluea2 < 75){
          //jewel is gold, move it
          telemetry.addLine("[FUNCTION] Knock off 2ND jewel");
          telemetry.addLine("[FINISH]");
          telemetry.update();
          sleep(5000);
        }else{
          //jewel error
          telemetry.addLine("[ERROR]")
          telemetry.update();
          sleep(5000);
        }
      }else if (bluea < 75){
        //Jewel is gold, move it.
        telemetry.addLine("[FUNCTION] Knock off 1ST jewel");
        telemetry.addLine("[FINISH]");
        telemetry.update();
        sleep(5000);
      }else{
        telemetry.addLine("[ERROR, STILL GOING]");
        telemetry.update();
        //jewel error, still going on with program
        blue4 = blockSensor.blue();
        sleep(100);
        blue5 = blockSensor.blue();
        sleep(100);
        blue6 = blockSensor.blue();
        sleep(100);
        bluea2 = ((blue4 + blue5 + blue6)/3);
        if (bluea2 > 75){
          //jewel is not gold, move to third and push it
          telemetry.addLine("[FUNCTION] Knock off 3RD jewel");
          telemetry.addLine("[FINISH]");
          telemetry.update();
          sleep(5000);
        }else if (bluea2 < 75){
          //jewel is gold, move it
          telemetry.addLine("[FUNCTION] Knock off 2ND jewel");
          telemetry.addLine("[FINISH]");
          telemetry.update();
          sleep(5000);
        }else{
          //total jewel error
          telemetry.addLine("[TOTAL ERROR]");
          telemetry.update();
          sleep(5000);
        }
      }
        
      
      while (opModeIsActive()) {
        
        
      }
    }
  }
}
