package lab7.camerahandling;

public class CarHandler {
    private Handler chainOfHandlers;

    public void setChainOfHandlers(Handler chainOfHandlers) {
        this.chainOfHandlers = chainOfHandlers;
    }

    public void handleCar(Car car) {
        chainOfHandlers.handle(car);
    }
}
