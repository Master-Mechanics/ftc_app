package org.firstinspires.ftc.teamcode;

import android.util.SparseIntArray;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.ColorSensor;

//👉😎👉
@Autonomous(name="test")
public class Auto extends LinearOpMode {

    private Bot bot = new Bot();

    @Override
    public void runOpMode() {
        bot.init(hardwareMap);

        waitForStart();

        encoderDrive(DRIVE_SPEED, -12, -12, 200);

        encoderDrive(DRIVE_SPEED, 12, 12, 200);
    }

}
