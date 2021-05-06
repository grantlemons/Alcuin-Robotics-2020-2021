package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import java.util.Locale;
import java.lang.*;

@TeleOp(name="Spin Motor", group="Linear Opmode")

public class SpinMotor extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();

    private DcMotor motor = null;
    public Servo pusher = null;

    private String THROWER_MOTOR = System.getenv("THROWER_MOTOR");
    private String PUSHER_SERVO = System.getenv("PUSHER_SERVO");

    @Override
    public void runOpMode() {
        motor  = hardwareMap.get(DcMotor.class, THROWER_MOTOR);
        pusher = hardwareMap.get(Servo.class, PUSHER_SERVO);
        motor.setDirection(DcMotor.Direction.FORWARD);

        double targetAngle = 145;

        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {

            if ( runtime.time() < 5 ) {
                motor.setPower(1.0);
            }
            else if ( runtime.time() > 5 ) {
                pusher.setPosition(targetAngle/180);
            }

        }
    }
}