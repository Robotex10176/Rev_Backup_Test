package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Distance Branch", group = "")
public class T_DistanceBranch extends LinearOpMode {

  private ColorSensor blockSensor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    blockSensor = hardwareMap.colorSensor.get("blockSensor");
    double distance1;
    double distance2;
    double distance3;
    distance1 = ((DistanceSensor) blockSensor).getDistance(DistanceUnit.MM);
    sleep(100);
    distance2 = ((DistanceSensor) blockSensor).getDistance(DistanceUnit.MM);
    sleep(100);
    distance3 = ((DistanceSensor) blockSensor).getDistance(DistanceUnit.MM);
    sleep(100);
    String distances1 = Double.toString(distance1);
    String distances2 = Double.toString(distance2);
    String distances3 = Double.toString(distance3);
    telemetry.addLine(distances1);
    telemetry.addLine(distances2);
    telemetry.addLine(distances3);
    telemetry.update();
    sleep(5000);

  }
}
