package lab7.counterHandling;


import lab7.counterHandling.command.DecrementCommand;
import lab7.counterHandling.command.HistoryList;
import lab7.counterHandling.command.IncrementCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameCounter extends JFrame {
//    private Subject subject;
    private Counter counter;
    private HistoryList historyList;

    //    private int count;
    private JButton jButtonIncrement = new JButton();
    private JButton jButtondecrement = new JButton();
    private JButton jButtonundo = new JButton();
    private JButton jButtonredo = new JButton();

//    public void setSubject(Subject subject) {
//        this.subject = subject;
//    }

    public JFrameCounter() {
        try {
            jbInit();
            historyList = new HistoryList();
            counter = new Counter();

//            TextFrame textframe = new TextFrame();
//            textframe.setVisible(true);
//            RectFrame rectframe = new RectFrame();
//            rectframe.setVisible(true);
//            OvalFrame ovalframe = new OvalFrame();
//            ovalframe.setVisible(true);
//            Subject subject = new Subject();
//            subject.addObserver(textframe);
//            subject.addObserver(rectframe);
//            subject.addObserver(ovalframe);
//            setSubject(subject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	JFrameCounter frame = new JFrameCounter();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);

    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(297, 169));
        jButtonIncrement.setText("+");
        jButtonIncrement.setBounds(new Rectangle(30, 25, 73, 22));
        jButtonIncrement.setActionCommand("increment");
        jButtonIncrement.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        IncrementCommand incrementCommand = new IncrementCommand(counter);
                        incrementCommand.execute(e);
                        historyList.addCommand(incrementCommand);
                    }
                });
        jButtondecrement.setText("-");
        jButtondecrement.setBounds(new Rectangle(155, 25, 73, 22));
        jButtondecrement.setActionCommand("decrement");
        jButtondecrement.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        DecrementCommand decrementCommand = new DecrementCommand(counter);
                        decrementCommand.execute(e);
                        historyList.addCommand(decrementCommand);
                    }
                });
        jButtonundo.setText("undo");
        jButtonundo.setBounds(new Rectangle(30, 80, 73, 22));
        jButtonundo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        historyList.undo(e);
//                        jButtonundo_actionPerformed(e);
                    }
                });
        jButtonredo.setText("redo");
        jButtonredo.setBounds(new Rectangle(155, 80, 73, 22));
        jButtonredo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        historyList.redo(e);
//                        jButtonredo_actionPerformed(e);
                    }
                });
        this.getContentPane().add(jButtonredo, null);
        this.getContentPane().add(jButtonundo, null);
        this.getContentPane().add(jButtondecrement, null);
        this.getContentPane().add(jButtonIncrement, null);
    }
//
//    private void jButtonIncrement_actionPerformed(ActionEvent e) {
//        count++;
//        subject.notify(count);
//    }
//
//    private void jButtondecrement_actionPerformed(ActionEvent e) {
//    	count--;
//        subject.notify(count);
//    }

    private void jButtonundo_actionPerformed(ActionEvent e) {
    	System.out.println("undo");
    }

    private void jButtonredo_actionPerformed(ActionEvent e) {
    	System.out.println("redo");
    }
}
