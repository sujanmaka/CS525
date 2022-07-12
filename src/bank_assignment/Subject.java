package bank_assignment;

import java.util.ArrayList;
import java.util.List;

public class Subject {
  private List<Observer> observerlist = new ArrayList<Observer>();

  public void addObserver(Observer observer) {
    this.observerlist.add(observer);
  }

  public void doNotify(String message) {
    for (Observer observer : observerlist) {
      observer.notify(message);
    }
  }
}
