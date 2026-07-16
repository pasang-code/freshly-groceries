package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.CartItem;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Integer> {

   public Optional<ShoppingCart> findShoppingCartByUser(User user);
}
