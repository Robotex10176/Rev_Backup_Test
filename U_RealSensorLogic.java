package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Sensor Read Thing", group = "")
public class U_RealSensorLogic extends LinearOpMode {

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public static void main(String[ ] args) {
        String hex1 = "FFFF00";
        String hex2 = "FFFFFF";
        String hex31 = "FFFFFF";

        int decimal1 = Integer.parseInt(hex1,16);
        int decimal2 = Integer.parseInt(hex2,16);
        int decimal3 = Integer.parseInt(hex31,16);

        int difi1 = decimal1-decimal3;
        int difi2 = decimal2-decimal3;

        String dif1 = Integer.toString(difi1);
        String dif2 = Integer.toString(difi2);

        telemetry.addLine(dif1);
        telemetry.addLine(dif2);
        telemetry.update();

        if (Math.abs(difi1) > Math.abs(difi2)) {
            telemetry.addLine("White, moving on.");
            telemetry.update();
            String hex32 = "FFFFFF";

            int decimal4 = Integer.parseInt(hex1,16);
            int decimal5 = Integer.parseInt(hex2,16);
            int decimal6 = Integer.parseInt(hex32,16);

            int difi3 = decimal4-decimal6;
            int difi4 = decimal5-decimal6;

            String dif3 = Integer.toString(difi3);
            String dif4 = Integer.toString(difi4);

            telemetry.addLine(dif3);
            telemetry.addLine(dif4);
            telemetry.update();

            if (Math.abs(difi3) > Math.abs(difi4)) {
                telemetry.addLine("White, moving on.");
                telemetry.update();
                String hex33 = "FFFF00";

                int decimal7 = Integer.parseInt(hex1,16);
                int decimal8 = Integer.parseInt(hex2,16);
                int decimal9 = Integer.parseInt(hex33,16);

                int difi5 = decimal7-decimal9;
                int difi6 = decimal8-decimal9;

                String dif5 = Integer.toString(difi5);
                String dif6 = Integer.toString(difi6);

                telemetry.addLine(dif5);
                telemetry.addLine(dif6);
                telemetry.update();

                if (Math.abs(difi5) > Math.abs(difi6)) {
                    telemetry.addLine("White, ERROR");
                    telemetry.update();

                }else if (Math.abs(difi5) < Math.abs(difi6)) {
                    telemetry.addLine("Gold, found in position 3");
                    telemetry.update();
                }
            }
            else if (Math.abs(difi3) < Math.abs(difi4)) {
                telemetry.addLine("Gold, found target in position 2");
                telemetry.update();
            }
        }
        else if (Math.abs(difi1) < Math.abs(difi2)) {
            telemetry.addLine("Gold, found target in position 1");
            telemetry.update();
        }
    }
}
