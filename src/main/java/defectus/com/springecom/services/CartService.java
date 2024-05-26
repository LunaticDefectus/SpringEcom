package defectus.com.springecom.services;

import defectus.com.springecom.dao.entities.Cart;
import defectus.com.springecom.dao.entities.Product;
import defectus.com.springecom.dao.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartManager{
    @Autowired
    private CartRepository cartRepository;
    @Override
    public boolean addProductToCart(Cart cart, Product product) {
        // Vérifie si le produit est déjà présent dans le panier
        if (cart.getProducts().contains(product)) {
            return false; // Le produit est déjà dans le panier
        }
        // Ajoute le produit au panier
        cart.getProducts().add(product);
        cartRepository.save(cart);
        return true;
    }

    @Override
    public boolean removeProductFromCart(Cart cart, Product product) {
        // Supprime le produit du panier
        boolean removed = cart.getProducts().remove(product);
        if (removed) {
            cartRepository.save(cart);
        }
        return removed;
    }

    @Override
    public void clearCart(Cart cart) {
        cart.getProducts().clear();
        cartRepository.save(cart);
    }

    @Override
    public double getTotalPrice(Cart cart) {
        double totalPrice = 0.0;
        for (Product product : cart.getProducts()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
