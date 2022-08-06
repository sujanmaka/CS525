package lab7.counterHandling.cor;

import java.io.IOException;


public class CounterReceiver {
    private CounterHandler counterHandler;

    public void setCounterHandler(CounterHandler counterHandler) {
        this.counterHandler = counterHandler;
    }

    public CounterHandler getCounterHandler() {
        return counterHandler;
    }

    public void receiveCounter(int value) {
        System.out.println("Stored in database");
        System.out.println("Logged into file");
        handleCounter(value);
    }

    public void handleCounter(int value) {
        counterHandler.handleCounter(value);
    }
}
