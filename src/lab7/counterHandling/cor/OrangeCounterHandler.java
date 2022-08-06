package lab7.counterHandling.cor;

public class OrangeCounterHandler extends CounterHandler{

    public OrangeCounterHandler(CounterHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleCounter(int value) {
        if (value % 2 != 0 && value >= 15 && value != 17 && value != 19) {
            System.out.println("Orange");
        }else {
            nextHandler.handleCounter(value);
        }
    }
}
