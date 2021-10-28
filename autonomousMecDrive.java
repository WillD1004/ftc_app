package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;




@Autonomous(name = "autonomousMecDrive")
public class autonomousMecDrive extends LinearOpMode {
  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;
  private CRServo spinner;


    //private void Drive (int fL,int fR, int bL, int bR, int s){ frontLeft.setPower(fL);
       // frontRight.setPower(bR); backRight.setPower(bL); backLeft.setPower(fR); sleep(s);}

    @Override
    public void runOpMode() {



        frontLeft = hardwareMap.get(DcMotor.class, "left_front");
        frontRight = hardwareMap.get(DcMotor.class, "right_front");
        backLeft = hardwareMap.get(DcMotor.class, "left_rear");
        backRight = hardwareMap.get(DcMotor.class, "right_rear");
        spinner = hardwareMap.get(CRServo.class, "spinner");
        telemetry.addData("Status", "Initialized");
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        //private void DriveForward (int a,int b, int c, int d int e){ frontLeft.setPower(a);
            //frontRight.setPower(b); backRight.setPower(c); backLeft.setPower(d); sleep(e);}


        waitForStart();


        // run until the end of the match (driver presses STOP)


            //Drive(1,1,1,1,3500);
            //Drive(1,1,1,1,875);
            //Drive(1,-1,-1, 1,875);
            //Drive(-1,-1,-1,-1, 875);
           // Drive(1,-1,-1,1,583);
            //Drive(1,-1,-1,1, 5250);

            spinner.setPower(1);
            sleep(5000);
            spinner.setPower(0);

            frontLeft.setPower(1);
            frontRight.setPower(1);
            backRight.setPower(1);


        /* spinner.setPower(1);
            sleep(2000);
            spinner.setPower(0); */






             //Mecanum Drive Code
            //backRight.setPower(+gamepad1.left_stick_y - gamepad1.left_stick_x  + gamepad1.right_stick_x);
           //backLeft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x  - gamepad1.right_stick_x);
           //frontRight.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x  + gamepad1.right_stick_x);
           //frontLeft.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x  - gamepad1.right_stick_x);

            /* double speed = .5;
            boolean changed = false; //Outside of loop()
            if (gamepad1.a && !changed) {
                speed = 2;
                changed = true;

            } else if (!gamepad1.right_bumper) changed = false;
             //mecanum tank
            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;
            final double v1 = r * Math.cos(robotAngle) + rightX;
            final double v2 = r * Math.sin(robotAngle) - rightX;
            final double v3 = r * Math.sin(robotAngle) + rightX;
            final double v4 = r * Math.cos(robotAngle) - rightX;

             //Send calculated power to wheels
            frontLeft.setPower(speed * v1);
            frontRight.setPower(speed * v2);
           backLeft.setPower(speed * v3);
            backRight.setPower(speed * v4); */

            backRight.setPower(0);
            backLeft.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
        }
    }
