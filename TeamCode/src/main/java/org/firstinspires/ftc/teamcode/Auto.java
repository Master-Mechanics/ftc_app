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

    ConceptVuMarkIdentification Vumark = new ConceptVuMarkIdentification();

    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        Vumark.runOpMode();

        waitForStart();

        bot.jewel.setTargetPosition(-1);


        bot.encoderDrive(bot.DRIVE_SPEED, -12, -12, 200);

        bot.encoderDrive(bot.DRIVE_SPEED, 12, 12, 200);
    }

}
