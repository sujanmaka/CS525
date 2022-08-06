package lab7.camerahandling;

public class StolenCarHandler extends Handler{
    public StolenCarHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Car car) {
        if (car.getLicensePlate().equals("ABCD007")) {
            System.out.println("Stolen car detected");
        } else {
            nextHandler.handle(car);
        }
    }
}
