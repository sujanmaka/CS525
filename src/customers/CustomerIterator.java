package customers;

import java.util.Iterator;
import java.util.List;

public class CustomerIterator implements Iterator<Customer> {

  private final List<Customer> list;
  private int position;

  public CustomerIterator(List<Customer> list) {
    this.list = list;
    this.position = 0;
  }

  @Override
  public boolean hasNext() {
    return position < list.size();
  }

  @Override
  public Customer next() {
    int tempPosition = position;
    position = position + 2;
    return list.get(tempPosition);
  }
}
