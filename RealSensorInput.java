package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Sensor Read Thing", group = "")
public class template extends LinearOpMode {

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void main(String[ ] args) {
        String hex1 = "FFFF00";
        String hex2 = "FFFFFF";
        String hex31 = "FFFFFF";

        int decimal1 = Integer.parseInt(hex1,16);
        int decimal2 = Integer.parseInt(hex2,16);
        int decimal3 = Integer.parseInt(hex31,16);

        int dif1 = decimal1-decimal3;
        int dif2 = decimal2-decimal3;
        
        
        
        telemetry.addLine(dif1);
        telemetry.addLine(dif2);
        telemetry.update();

        if (Math.abs(dif1) > Math.abs(dif2)) {
            telemetry.addLine("White, moving on.");
            telemetry.update();
            String hex32 = "FFFFFF";

            int decimal4 = Integer.parseInt(hex1,16);
            int decimal5 = Integer.parseInt(hex2,16);
            int decimal6 = Integer.parseInt(hex32,16);

            int dif3 = decimal4-decimal6;
            int dif4 = decimal5-decimal6;

            telemetry.addLine(dif3);
            telemetry.addLine(dif4);
            telemetry.update();

            if (Math.abs(dif3) > Math.abs(dif4)) {
                telemetry.addLine("White, moving on.");
                telemetry.update();
                String hex33 = "FFFF00";

                int decimal7 = Integer.parseInt(hex1,16);
                int decimal8 = Integer.parseInt(hex2,16);
                int decimal9 = Integer.parseInt(hex33,16);

                int dif5 = decimal7-decimal9;
                int dif6 = decimal8-decimal9;

                telemetry.addLine(dif5);
                telemetry.addLine(dif6);
                telemetry.update();

                if (Math.abs(dif5) > Math.abs(dif6)) {
                    telemetry.addLine("White, ERROR");
                    telemetry.update();

                }else if (Math.abs(dif5) < Math.abs(dif6)) {
                    telemetry.addLine("Gold, found in position 3");
                    telemetry.update();
                }
            }
            else if (Math.abs(dif3) < Math.abs(dif4)) {
                telemetry.addLine("Gold, found target in position 2");
                telemetry.update();
            }
        }
        else if (Math.abs(dif1) < Math.abs(dif2)) {
            telemetry.addLine("Gold, found target in position 1");
            telemetry.update();
        }
    }
}
