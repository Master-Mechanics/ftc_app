package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp w/ Arm")
public class TeleOpWithArm extends OpMode{

    private Bot bot = new Bot();

    // supposedly the force of gravity according to the best source
    // the robot that we made... meaning... AI HAS TAKEN OVER
    private final double g = .3d;

    private boolean pushed = false;

    // B - gamepad 2
    private boolean armLock = false;

    public void init() {
        bot.init(hardwareMap);
    }

    public void loop() {


        double drive2 = gamepad1.right_stick_y / -2;//, turn = gamepad1.right_stick_x;
        double drive = gamepad1.left_stick_y / -2;
        double straight = gamepad1.right_trigger / 2, back = gamepad1.left_trigger / 2;

        // whole arm motor
        double liftMovement = gamepad2.right_stick_y/3.5*-1;
        if(!armLock) {
            bot.lift.setPower(liftMovement);
            telemetry.addData("lift position: ", bot.lift.getCurrentPosition());
        }

        // using magic numbers
        if(gamepad2.a) {
            bot.claw_right.setPosition(10);
            bot.claw_left.setPosition(0);
        }

        // more magic numbers
        if(gamepad2.b) {
            bot.claw_right.setPosition(90);
            bot.claw_left.setPosition(90);
        }


        // arm pivot server
        double pivot = gamepad2.right_stick_y;
        //bot.pivotPosition = bot.pivot.getPosition();
        //bot.pivot.setPosition(bot.pivotPosition + (pivot / 200));

        // open arm                close arm
        boolean open = gamepad2.a, close = gamepad2.x;
        if(close)
        {
            //bot.clamp.setPosition(0);
        }
        else if(open)
        {
            //bot.clamp.setPosition(.5);
        }

        boolean open2 = gamepad2.y, close2 = gamepad2.b;
        if(close2)
        {
            //bot.pivot2Position = bot.pivot2.getPosition();
            //bot.pivot2.setPosition(bot.pivot2Position-.001);
        }
        else if(open2)
        {
            //bot.pivot2Position = bot.pivot2.getPosition();
            //bot.pivot2.setPosition(bot.pivot2Position+.001);
        }

        // left  trigger = drop
        double leftTrigger = gamepad2.left_trigger;

        // right trigger = bring back
        double rightTrigger = gamepad2.right_trigger;

        if(leftTrigger > rightTrigger)
        {
            //bot.arm2.setPower(leftTrigger / 3 * -1);
        }
        else
            {
                //bot.arm2.setPower(rightTrigger / 3);
        }

        if(straight > 0)
        {
            bot.ld.setPower(straight);
            bot.rd.setPower(straight);
            telemetry.addData("driving straight: ", "true");
        }
        else if(back > 0)
        {
            bot.ld.setPower(back);
            bot.rd.setPower(back);
            telemetry.addData("driving backwards: ", "true");
        }
        else
        {
            //bot.ld.setPower(Range.clip(drive + turn, -1d, 1d));
            //bot.rd.setPower(Range.clip(drive - turn, -1d, 1d));
            //telemetry.addData("left drive power: ", bot.ld.getPowerFloat());
            //telemetry.addData("right drive power: ", bot.rd.getPowerFloat());
            bot.ld.setPower(drive);
            bot.rd.setPower(drive2);
        }



        //if(gamepad1.y){
            //bot.jewel.setPosition(.8);}
       // else if(gamepad1.b){
            //bot.jewel.setPosition(.25);
        //}
    }
}
