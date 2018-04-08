package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Bot {

    public DcMotor ld  = null;
    public DcMotor rd  = null;
    public DcMotor arm = null;
    public DcMotor arm2 = null;

    public Servo pivot2 = null;
    public Servo pivot = null;
    public Servo clamp = null;
    public Servo armTop = null;
    public Servo jewel  = null;

    //public ColorSensor colorSensor = null;

    public double pivotPosition = 0d;
    public double jewelPosition = 0d;
    public  double pivot2Position = 0d;

    public String vuLicense = "AZdKRPL/////AAAAGdWHky5ZjET7mNUJ+qxkIDtvddP9PIXKwsMwBNDXV0SrsOuioPqAv1q7EB2k1QqsJd3eIb8WIXmHt4fxm153DMq6AEpg0L8nuqQuMmzxL9nFfM2ubV6PVSoZcdQqPOwtLpJqk4KUjKc8v0Es0M0aZl7R8a+jyzDiobaKVE9+4EY1dKuRPTB1OYCqCKfn1OkULrWxH6zSzwyf6ztPp6cKFn+oaglcxzX9iOhejsX4CsoAg4X/6HLnWWrux1Z4hfVP2EKanjrXqeSm5iursV0Lu+HRKMvo9VbIzGnit7JDusQsI7JVEpVsRnR39GaTJT1W1jijOVaw7VVkCt/7D9U+z5JcjgzOoug+Mye9H6n020MW";

    private HardwareMap hardwareMap = null;

    static final double COUNTS_PER_MOTOR_REV    = 1440;
    static final double DRIVE_GEAR_REDUCTION    = 1;
    static final double WHEEL_DIAMETER_INCHES   = 5.0;
    static final double COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION)
            / (WHEEL_DIAMETER_INCHES * Math.PI) / 2;

    static final double DRIVE_SPEED             = 0.6;
    static final double TURN_SPEED              = 0.5;

    private ElapsedTime runtime = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        hardwareMap = ahwMap;

        ld = hardwareMap.get(DcMotor.class, "left_drive");
        rd = hardwareMap.get(DcMotor.class, "right_drive");
        //arm = hardwareMap.get(DcMotor.class, "front_arm");
        //arm2 = hardwareMap.get(DcMotor.class, "back_arm");

        //pivot = hardwareMap.get(Servo.class, "pivot");
        //pivot2 = hardwareMap.get(Servo.class, "back_pivot");
        //clamp = hardwareMap.get(Servo.class,  "clamp");
        //armTop = hardwareMap.get(Servo.class, "arm_top");
        //jewel = hardwareMap.get(Servo.class, "jewel_servo");

        //colorSensor = hardwareMap.get(ColorSensor.class, "color");

        //pivotPosition = pivot.getPosition();
        //pivot2Position = pivot2.getPosition();
        //jewelPosition = jewel.getPosition();

        ld.setDirection(DcMotorSimple.Direction.FORWARD);
        rd.setDirection(DcMotorSimple.Direction.REVERSE);

        //ld.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutSeconds) {
        int newLeftTarget, newRightTarget;

        if(true) {
            // finding target   position
            newLeftTarget = ld.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = rd.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);

            // setting target encoder position
            ld.setTargetPosition(newLeftTarget);
            rd.setTargetPosition(newRightTarget);

            // move to position

            ld.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // resetting timer and setting speed
            runtime.reset();
            ld.setPower(Math.abs(speed));
            rd.setPower(Math.abs(speed));


            while((runtime.seconds() < timeoutSeconds) &&
                    ld.isBusy() && rd.isBusy()) {
            }

            // stopping motion
            ld.setPower(0);
            rd.setPower(0);

            // turn off RUN_TO_POSITION mode
            ld.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rd.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }
}
