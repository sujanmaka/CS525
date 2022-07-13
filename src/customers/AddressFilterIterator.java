package customers;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class AddressFilterIterator<T> implements Iterator<T> {
  private final List<T> list;
  private int position;
  private Predicate<T> predicate;

  public AddressFilterIterator(List<T> list, Predicate<T> predicate) {
    this.list = list;
    this.predicate = predicate;
    this.position = 0;
  }

  @Override
  public boolean hasNext() {
    int tempPosition = position;
    while (tempPosition < list.size()) {
      T nextElement = list.get(tempPosition);
      if (predicate.test(nextElement)) {
        return true;
      } else {
        tempPosition++;
      }
    }
    return false;
  }

  @Override
  public T next() {
    int tempPosition = position;
    while (tempPosition < list.size()) {
      T nextElement = list.get(tempPosition);
      if (predicate.test(nextElement)) {
        position = tempPosition + 1;
        return nextElement;
      } else {
        tempPosition++;
      }
    }
    return null;
  }
}
