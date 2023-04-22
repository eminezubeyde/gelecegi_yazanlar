package kodlama.io.ecommerce.business.concretes;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("Product Not Found");
    }
}
