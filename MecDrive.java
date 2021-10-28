package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "MecDrive", group = "Concept")
public class MecDrive extends LinearOpMode {
  public DcMotor frontLeft;
  public DcMotor frontRight;
  public DcMotor backLeft;
  public DcMotor backRight;
  public CRServo spinner;

    @Override
    public void runOpMode() {



        frontLeft = hardwareMap.get(DcMotor.class, "left_front");
        frontRight = hardwareMap.get(DcMotor.class, "right_front");
        backLeft = hardwareMap.get(DcMotor.class, "left_rear");
        backRight = hardwareMap.get(DcMotor.class, "right_rear");
        spinner = hardwareMap.get(CRServo.class, "spinner");
        telemetry.addData("Status", "Initialized");
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Hola", "Why Hello There");



        waitForStart();


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {


             //Mecanum Drive Code
            backRight.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x  + gamepad1.right_stick_x);
           backLeft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x  - gamepad1.right_stick_x);
           frontRight.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x  + gamepad1.right_stick_x);
           frontLeft.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x  - gamepad1.right_stick_x);




            if (gamepad2.left_trigger == 1){
                spinner.setPower(1);
            }
            else if (gamepad2.right_trigger == 1){
                spinner.setPower(-1);
            }
            else {
                //too much
                spinner.setPower(-.1);
            }

            double speed = .5; //Outside of loop()
            if (gamepad1.a = true) {
                speed = 2;


            } else if (!gamepad1.right_bumper){
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
            backRight.setPower(speed * v4); }

        }
    }
}