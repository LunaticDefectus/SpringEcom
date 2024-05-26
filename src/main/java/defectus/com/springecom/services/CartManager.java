package defectus.com.springecom.services;
import defectus.com.springecom.dao.entities.Cart;
import defectus.com.springecom.dao.entities.Product;
public interface CartManager {
    boolean addProductToCart(Cart cart, Product product);

    boolean removeProductFromCart(Cart cart, Product product);

    //pour vider le panier
    void clearCart(Cart cart);

    double getTotalPrice(Cart cart);
}
