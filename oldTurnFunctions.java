@disabled
    public void SmartTurnRight(float Angle, double Power){//turn right is clockwise
        //code to turn untill an angle ex 0, 90, -90
        float zAngle;
        float targetAngle;
        zAngle = gyro.getAngularOrientation(AxesReference.INTRINSIC,
                AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
        //Set target direction in range -180 - 180;
        targetAngle = (zAngle - Angle + 180);
        while (targetAngle > 360){ targetAngle = targetAngle - 360; }
        while (targetAngle < 0){ targetAngle = targetAngle + 360; }
        targetAngle = targetAngle - 180;
        float as;
        as = AngularSeparation(zAngle, targetAngle);
        while (as > 1.0){//1.0

            if(as < 15) {
                leftDrive.setPower(Math.max(0.2 * Power, 0.1));
                rightDrive.setPower(-Math.max(0.2 * Power, 0.1));

            } else if (as < 45){
                leftDrive.setPower(Math.max(0.5 * Power, 0.1));
                rightDrive.setPower(-Math.max(0.5 * Power, 0.1));
            }else {
                leftDrive.setPower(Math.max(Power, 0.1));
                rightDrive.setPower(-Math.max(Power, 0.1));
            }
            zAngle = gyro.getAngularOrientation(AxesReference.INTRINSIC,
                    AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
            as = AngularSeparation(zAngle, targetAngle);
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);

    }

    public void SmartTurnLeft (float Angle, double Power){
        float zAngle;
        float targetAngle;
        zAngle = gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
        //Set target direction in range -180 - 180;
        targetAngle = (zAngle + Angle + 180);
        while (targetAngle > 360){ targetAngle = targetAngle - 360; }
        while (targetAngle < 0){ targetAngle = targetAngle + 360; }
        targetAngle = targetAngle - 180;
        float as;
        as = AngularSeparation(zAngle, targetAngle);
        while (as > 1.0){

            if(as < 15) {
                leftDrive.setPower(-Math.max(0.2 * Power, 0.1));
                rightDrive.setPower(Math.max(0.2 * Power, 0.1));
            } else if (as < 45){
                leftDrive.setPower(-Math.max(0.5 * Power, 0.1));
                rightDrive.setPower(Math.max(0.5 * Power, 0.1));
            }else {
                leftDrive.setPower(-Math.max(Power, 0.1));
                rightDrive.setPower(Math.max(Power, 0.1));
            }
            zAngle = gyro.getAngularOrientation(AxesReference.INTRINSIC,
                    AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
            as = AngularSeparation(zAngle, targetAngle);
        }
        leftDrive.setPower(0);
        rightDrive.setPower(0);

    }
