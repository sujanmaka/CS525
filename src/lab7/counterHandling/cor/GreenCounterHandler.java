package lab7.counterHandling.cor;

public class GreenCounterHandler extends CounterHandler {

    public GreenCounterHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCounter(int value) {
        if (value % 2 == 0 && value >= 10 && value != 12 && value != 13) {
            System.out.println("Green");
        } else {
            nextHandler.handleCounter(value);
        }
    }
}
