package lab4;

public abstract class ProductCatalog {
    protected String name;
    abstract void print();

    public ProductCatalog(String name) {
        this.name = name;
    }
}
