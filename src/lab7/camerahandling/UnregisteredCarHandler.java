package lab7.camerahandling;

public class UnregisteredCarHandler extends Handler {
    public UnregisteredCarHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Car car) {
        if (car.getLicensePlate().equals("ABCD009")) {
            System.out.println("Unregistered car detected");
        } else {
            nextHandler.handle(car);
        }
    }
}
