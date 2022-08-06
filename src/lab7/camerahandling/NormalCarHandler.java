package lab7.camerahandling;

public class NormalCarHandler extends Handler {
    public NormalCarHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Car car) {
        System.out.println("Normal car detected");
    }
}
