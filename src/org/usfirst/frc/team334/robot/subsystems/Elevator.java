package org.usfirst.frc.team334.robot.subsystems;

import org.usfirst.frc.team334.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {

    // 775 pros
    private VictorSP pro1;
    private VictorSP pro2;

    private DigitalInput rTopLimit;
    private DigitalInput rBottomLimit;

    public static Encoder rEncoder;

    public Elevator() {
        super(Constants.ELEVATOR_POT_P, Constants.ELEVATOR_POT_I, Constants.ELEVATOR_POT_D);

        pro1 = new VictorSP(Constants.ELEVATOR_MOTOR_L);
        pro2 = new VictorSP(Constants.ELEVATOR_MOTOR_R);

        rTopLimit = new DigitalInput(Constants.ELEVATOR_LIMIT_TOP);
        rBottomLimit = new DigitalInput(Constants.ELEVATOR_LIMIT_BOTTOM);

        rEncoder = new Encoder(Constants.ELEVATOR_ENCODER_A, Constants.ELEVATOR_ENCODER_B);

        this.disable();
        this.setAbsoluteTolerance(1);
        this.setOutputRange(-1, 1);
    }

    public void setMotors(double speed) {
        pro1.set(speed);
        pro2.set(speed);
    }

    public void stop() {
        pro1.set(0);
        pro2.set(0);
    }

    @Override
    protected double returnPIDInput() {
        return rEncoder.get(); // sets pidsource
    }

    @Override
    protected void usePIDOutput(double output) {
        System.out.println("Error: " + output + "Encoder Value: " + rEncoder.get());
        setMotors(output * Constants.ELEVATOR_SPEED_MULTIPLIER); // move elevator
    }

    public boolean isTooHigh() {
        return rTopLimit.get();
    }

    public boolean isTooLow() {
        return rBottomLimit.get();
    }

    public Encoder getEncoder() {
        return rEncoder;
    }

    public void initDefaultCommand() {

    }
}
