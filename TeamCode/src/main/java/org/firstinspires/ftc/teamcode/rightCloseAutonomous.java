package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//basic autonomous program
@Autonomous(name="Right Close Autonomous")
public class rightCloseAutonomous extends LinearOpMode
{

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motorRight = null;
    private DcMotor motorLeft = null;
    private DcMotor spinLeft = null;
    private DcMotor spinRight = null;
    private Servo servo = null;
  //  DigitalChannel digitalTouch;
    private void DriveForward (int a,int b, int c){ motorLeft.setPower(a);
        motorRight.setPower(b);
        sleep(c);}


    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        spinLeft = hardwareMap.get(DcMotor.class, "spinLeft");
        spinRight = hardwareMap.get(DcMotor.class,"spinRight");
        servo = hardwareMap.get(Servo.class,"servo");
    //     digitalTouch = hardwareMap.digitalChannel.get("digitalTouch");
                // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
       // servo.setPosition(.49);

     /*   if (digitalTouch.getState() == true){
            servo.setPosition(1);
        }

        sleep(1000); */

        //code for right positions
       DriveForward(1,1, 200 );
       DriveForward(1,-1,1200);
       DriveForward(1,1,1700);


       //Push Block Out
       /* spinLeft.setPower(-.75);
        spinRight.setPower(.75);
        sleep(2000);

        //Pull Block In
        spinRight.setPower(-.75);
        spinLeft.setPower(.75);
        sleep(2000);*/

        motorLeft.setPower(0);
        motorRight.setPower(0);
    }
}
