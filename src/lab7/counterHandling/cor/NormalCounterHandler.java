package lab7.counterHandling.cor;

public class NormalCounterHandler extends CounterHandler {
    public NormalCounterHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCounter(int value) {
        System.out.println("Normal counter handler");
    }
}
