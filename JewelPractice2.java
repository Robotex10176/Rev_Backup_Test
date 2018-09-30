package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MotorMovie (Blocks to Java)", group = "")
public class JewelPractice extends LinearOpMode {
	
  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
	  
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      telemetry.addline("Starting Jewel Sensing...");
      telemetry.update();
      //If there are 2 sensors sensor and you start at the first jewel:
      telemetry.addline("step 1:");
      telemetry.addline("sense jewel 1 and 2");
      telemetry.addline("if jewel 1 is gold, turn towards it and move it in some way");
      telemetry.addline("else if jewel 2 is gold, turn towards it and move it in some way");
      telemetry.addline("else turn to jewel 3 and move it in some way.");
      telemetry.update();
        }
      }
    }
  }
}
