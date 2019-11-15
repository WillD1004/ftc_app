package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;


@TeleOp(name = "TeleOp Main")
public class TeleOpMain extends LinearOpMode
{
    private DcMotor spinLeft;
    private DcMotor spinRight;
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo servo;
    DigitalChannel digitalTouch;



    @Override
    public void runOpMode() throws InterruptedException
    {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        spinLeft = hardwareMap.dcMotor.get("spinLeft");
        spinRight = hardwareMap.dcMotor.get("spinRight");
        servo = hardwareMap.servo.get("servo");


        // get a reference to our digitalTouch object.
        digitalTouch = hardwareMap.digitalChannel.get("digitalTouch");
        // set the digital channel to input.
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);


        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        spinLeft.setDirection(DcMotor.Direction.REVERSE);



        waitForStart();
        servo.setPosition(.49);

        while (opModeIsActive())
        {

                if (gamepad2.y && digitalTouch.getState() == true )  {
                    //move lift up
                    servo.setPosition(1);
                }
                else if (gamepad2.a) {
                    //move lift down
                    servo.setPosition(0);
                }
                //else if (digitalTouch.getState() == true) {
               // servo.setPosition(.49);
         //  }
                else  servo.setPosition(.49);


            //driving motors
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            //block grabbing wheels

            //In
            spinLeft.setPower(-gamepad2.right_trigger* 1);
            spinRight.setPower(-gamepad2.right_trigger* 1);

            //Out
            spinLeft.setPower(gamepad2.left_trigger* 1);
            spinRight.setPower(gamepad2.left_trigger* 1);



        }
    }
}

