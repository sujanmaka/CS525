package customers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AgeIterator implements Iterator<Customer> {
  private final List<Customer> list;
  private int position;

  public AgeIterator(List<Customer> list) {
    list.sort(Comparator.comparing(Customer::getAge));
    this.list = list;
    this.position = 0;
  }

  @Override
  public boolean hasNext() {
    return position < list.size();
  }

  @Override
  public Customer next() {
    return list.get(position++);
  }
}
