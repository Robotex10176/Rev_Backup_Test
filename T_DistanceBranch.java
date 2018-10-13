package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "distancetest (Blocks to Java)", group = "")
public class distancetest extends LinearOpMode {

  private ColorSensor blockSensor;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    blockSensor = hardwareMap.colorSensor.get("blockSensor");
    int distance1;
    int distance2;
    int distance3;

    telemetry.addData("key", ((DistanceSensor) blockSensor).getDistance(DistanceUnit.CM));
    distance1 = blockSensor.getDistance(DistanceUnit.MM);
    sleep(100);
    distance2 = blockSensor.getDistance(DistanceUnit.MM);
    sleep(100);
    distance3 = blockSensor.getDistance(DistanceUnit.MM);
    sleep(100);
    telemetry.addData(distance1)
    telemetry.addData(distance2)
    telemetry.addData(distance3)
    telemetry.update();
    sleep(5000);

  }
}
