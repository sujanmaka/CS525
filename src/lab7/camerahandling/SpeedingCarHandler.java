package lab7.camerahandling;

public class SpeedingCarHandler extends Handler {
    public SpeedingCarHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Car car) {
        if (car.getSpeed() > 100) {
            System.out.println("Speeding car detected");
        } else {
            nextHandler.handle(car);
        }
    }
}
