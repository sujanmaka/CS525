package lab7.counterHandling;

import counter.Observer;

import java.util.ArrayList;
import java.util.Collection;

public class Subject {
  private Collection<Observer> observerlist = new ArrayList<Observer>();

  public void addObserver(Observer observer) {
    observerlist.add(observer);
  }

  public void notify(int count) {
    for (Observer observer : observerlist) {
      observer.setCount(count);
    }
  }
}
