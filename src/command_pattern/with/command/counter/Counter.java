package command_pattern.with.command.counter;

import counter.OvalFrame;
import counter.RectFrame;
import counter.Subject;
import counter.TextFrame;

import java.awt.event.ActionEvent;

public class Counter extends Subject {
    private int count;

    public Counter() {
        counter.TextFrame textframe = new TextFrame();
        textframe.setVisible(true);
        counter.RectFrame rectframe = new RectFrame();
        rectframe.setVisible(true);
        counter.OvalFrame ovalframe = new OvalFrame();
        ovalframe.setVisible(true);

        addObserver(textframe);
        addObserver(rectframe);
        addObserver(ovalframe);
    }


    public void jButtonIncrement_actionPerformed(ActionEvent e) {
        count++;
        notify(count);
    }

    public void jButtondecrement_actionPerformed(ActionEvent e) {
        count--;
        notify(count);
    }
}
