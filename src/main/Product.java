package main;

class Product extends AbstractPurchase{
    private String name;
    private Euro price;

    public static void main(String[] args) {
        Euro euro = new Euro(50, 50);
        Product product = new Product("mfka", euro);
        System.out.println(product.getPrice());
    }
    public Product() {}

    public Product(String name, Euro price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Euro getPrice() {
        return price;
    }

    public void setPrice(Euro price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name='" + getName() + '\'' +
                "; price=" + getPrice().getEuro();
    }
}
