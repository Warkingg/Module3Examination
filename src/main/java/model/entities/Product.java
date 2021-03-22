package model.entities;

public class Product {
        private int id;
        private String product_name;
        private double price;
        private int quantity;
        private String color;
        private String descriptions;
        private String category_name;

        public Product() {
        }

    public Product(int id, String product_name, double price, int quantity, String color, String descriptions, String category_name) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descriptions = descriptions;
        this.category_name = category_name;
    }

    public Product(String product_name, double price, int quantity, String color, String descriptions, String category_name) {
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.descriptions = descriptions;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
