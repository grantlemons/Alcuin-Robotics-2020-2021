package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import java.util.Locale;
import java.lang.*;

@TeleOp(name="DriverBoth", group="Linear Opmode")

public class DriverBoth extends LinearOpMode {
    private static final String colorString = System.getenv("SIDE");

    @Override
    public void runOpMode() {
        Drivetrain drivetrain = new Drivetrain(hardwareMap, telemetry);
        BrainNew brain = new BrainNew(hardwareMap, drivetrain, telemetry);
        waitForStart();

        while (opModeIsActive()) {
            //*******************
            // Drivetrain
            //*******************
            if(!gamepad1.right_bumper) {
                drivetrain.driveWithLimit(
                    -gamepad1.left_stick_y,
                    gamepad1.right_stick_x,
                    //0,
                    gamepad1.left_stick_x
                );
            }
            if (gamepad1.right_bumper) {
                drivetrain.driveWithLimit(
                    -gamepad1.left_stick_y*0.15,
                    gamepad1.right_stick_x*0.15,
                    //0,
                    gamepad1.left_stick_x*0.15
                );
            }

            switch (colorString) {
                case "blue":
                    while(gamepad1.x) {drivetrain.setHeading(0);}
                    while(gamepad1.a) {drivetrain.setHeading(90);} // +angle is left
                    while(gamepad1.y) {drivetrain.setHeading(-90);} // -angle is right
                    while(gamepad1.b) {drivetrain.setHeading(180);}
                    break;
                case "red":
                    while(gamepad1.x) {drivetrain.setHeading(180);}
                    while(gamepad1.a) {drivetrain.setHeading(-90);} // +angle is left
                    while(gamepad1.y) {drivetrain.setHeading(90);} // -angle is right
                    while(gamepad1.b) {drivetrain.setHeading(0);}
                    break;
            }
            
        }
    }
}
