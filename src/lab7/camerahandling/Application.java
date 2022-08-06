package lab7.camerahandling;

public class Application {
    public static void main(String[] args) {
        CarHandler carHandler = new CarHandler();
        NormalCarHandler normalCarHandler = new NormalCarHandler(null);
        SpeedingCarHandler speedingCarHandler = new SpeedingCarHandler(normalCarHandler);
        StolenCarHandler stolenCarHandler = new StolenCarHandler(speedingCarHandler);
        UnpaidTicketCarHandler unpaidTicketCarHandler = new UnpaidTicketCarHandler(stolenCarHandler);
        UnregisteredCarHandler unregisteredCarHandler = new UnregisteredCarHandler(unpaidTicketCarHandler);
        carHandler.setChainOfHandlers(unregisteredCarHandler);
        carHandler.handleCar(new Car("ABCD007", 100, "324"));
//        carHandler.handleCar(new Car("ABCD001", 60, "123"));
//        carHandler.handleCar(new Car("ABCD009", 70, "222"));
    }
}
