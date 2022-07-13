package lab4;

import java.util.ArrayList;
import java.util.List;

public class Product extends ProductCatalog {


  public Product(String name) {
    super(name);
  }

  @Override
  void print() {
    System.out.println("Product " + name);
  }
}
