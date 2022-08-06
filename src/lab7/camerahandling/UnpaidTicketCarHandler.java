package lab7.camerahandling;

public class UnpaidTicketCarHandler extends Handler{
    public UnpaidTicketCarHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Car car) {
        if (car.getLicensePlate().equals("ABCD008")) {
            System.out.println("Unpaid ticket car detected");
        } else {
            nextHandler.handle(car);
        }
    }
}
