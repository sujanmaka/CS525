package lab4;

import java.util.ArrayList;
import java.util.List;

public class Category extends ProductCatalog {


  protected List<ProductCatalog> productCatalogs = new ArrayList<>();

  public void addComponent(ProductCatalog productCatalog) {
    productCatalogs.add(productCatalog);
  }

  public Category(String name) {
    super(name);
  }

  @Override
  void print() {
    System.out.println("Category " + name + " : ");
    for (ProductCatalog productCatalog : productCatalogs) {
      productCatalog.print();
    }
  }
}
