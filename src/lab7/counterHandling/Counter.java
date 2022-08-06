package lab7.counterHandling;

import counter.OvalFrame;
import counter.RectFrame;
import counter.Subject;
import counter.TextFrame;
import lab7.camerahandling.NormalCarHandler;
import lab7.counterHandling.cor.CounterReceiver;
import lab7.counterHandling.cor.GreenCounterHandler;
import lab7.counterHandling.cor.NormalCounterHandler;
import lab7.counterHandling.cor.RedCounterHandler;
import lab7.orderhandling.with.cor.CompanyAOrderHandler;
import lab7.orderhandling.with.cor.CompanyBNewYorkOrderHandler;
import lab7.orderhandling.with.cor.CompanyBTexasOrderHandler;
import lab7.orderhandling.with.cor.OrderReceiver;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Counter extends Subject {
    private int count;
    private CounterReceiver counterReceiver;

    public Counter() {
        TextFrame textframe = new TextFrame();
        textframe.setVisible(true);
        RectFrame rectframe = new RectFrame();
        rectframe.setVisible(true);
        OvalFrame ovalframe = new OvalFrame();
        ovalframe.setVisible(true);

        addObserver(textframe);
        addObserver(rectframe);
        addObserver(ovalframe);

        counterReceiver = new CounterReceiver();
        NormalCounterHandler normalCounterHandler = new NormalCounterHandler(null);
        RedCounterHandler redCounterHandler = new RedCounterHandler(normalCounterHandler);
        GreenCounterHandler greenCounterHandler = new GreenCounterHandler(redCounterHandler);
        counterReceiver.setCounterHandler(greenCounterHandler);
    }


    public void jButtonIncrement_actionPerformed(ActionEvent e) {
        System.out.println(counterReceiver.getCounterHandler());
        count++;
        notify(count);
        counterReceiver.receiveCounter(count);
    }

    public void jButtondecrement_actionPerformed(ActionEvent e) {
        count--;
        notify(count);
        counterReceiver.receiveCounter(count);
    }
}
