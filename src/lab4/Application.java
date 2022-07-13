package lab4;

public class Application {
  public static void main(String[] args) {
    Category category1 = new Category("Clothing");
    Category category2 = new Category("Cosmetics");
    Product product1 = new Product("T-Shirt");
    Product product2 = new Product("Pant");
    Product product3 = new Product("Eyeliner");
    category1.addComponent(product1);
    category1.addComponent(product2);
    category2.addComponent(product3);
    category1.print();
    System.out.println();
    category2.print();

    //
  }
}
