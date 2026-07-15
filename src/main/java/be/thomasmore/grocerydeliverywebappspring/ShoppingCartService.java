package be.thomasmore.grocerydeliverywebappspring;


import be.thomasmore.grocerydeliverywebappspring.controllers.model.CartItem;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.repositories.CartItemRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class ShoppingCartService {

    public enum addProductResult {INVALID_QUANTITY, PRODUCT_NOT_FOUND, SUCCESS}

    ;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    public addProductResult addProduct(Integer productId, Integer quantity, ShoppingCart cart) {

        Optional<Product> product = productRepository.findById(productId);

        if (quantity == null || quantity <= 0) {   /* server side validation of input quantity*/
            return addProductResult.INVALID_QUANTITY;
        }

        if (product.isEmpty()) {
            return addProductResult.PRODUCT_NOT_FOUND;
        }

        if (product.isPresent()) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product.get());
            cartItem.setCart(cart);
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
        return addProductResult.SUCCESS;

    }

    public void removeProduct(Integer cartItemId) {
        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);

        if (cartItem.isPresent()) {
            CartItem itemToRemove = cartItem.get();
            cartItemRepository.deleteById(itemToRemove.getId());
        }

    }

    public void updateCart(String action, Integer itemId) {
        Optional<CartItem> cartItem = cartItemRepository.findById(itemId);

        if (cartItem.isPresent()) {
            CartItem itemToUpdate = cartItem.get();
            if (action.equals("increase")) itemToUpdate.setQuantity(itemToUpdate.getQuantity() + 1);
            if (action.equals("decrease")) itemToUpdate.setQuantity(itemToUpdate.getQuantity() - 1);
            cartItemRepository.save(itemToUpdate);
        }


    }

    public void clearCart() {
        cartItemRepository.deleteAll();
    }


}
