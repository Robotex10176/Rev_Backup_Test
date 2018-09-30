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
      //If there is one sensor and you start at the first jewel:
      telemetry.addline("step 1:");
      telemetry.addline("Sense first jewel");
      telemetry.addline("if it is gold, move it somehow");
      telemetry.addline("if it isn't gold, move to jewel 2.")
      telemetry.update();
      telemetry.addline("step 2:");
      telemetry.addline("if the first jewel isn't gold, sense the second.");
      telemetry.addline("if it is gold, move it somehow");
      telemetry.addline("otherwise, move to the third jewel and move it somehow.");
      telemetry.update();
        }
      }
    }
  }
}
