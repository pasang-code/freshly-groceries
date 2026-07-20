package be.thomasmore.grocerydeliverywebappspring.config;

import be.thomasmore.grocerydeliverywebappspring.controllers.ShoppingCartController;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.User;
import be.thomasmore.grocerydeliverywebappspring.repositories.ShoppingCartRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.net.http.HttpRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@ControllerAdvice
public class GlobalControllerAdvice {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("currentUrl")
    public String getCurrentUrl(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @ModelAttribute("cart")
    public ShoppingCart cart(Principal principal) {

        if (principal == null) return null;

        User user = userRepository.getUserByUsername(principal.getName());

        Optional<ShoppingCart> cart = shoppingCartRepository.findShoppingCartByUser(user);
        if (cart.isPresent()) return cart.get();
        else {
            ShoppingCart cartNew = new ShoppingCart();
            cartNew.setCreatedAt(LocalDateTime.now());
            cartNew.setStatus("Active");
            cartNew.setUser(user);
            ShoppingCart cartReturnedWithId = shoppingCartRepository.save(cartNew);
            return cartReturnedWithId;
        }



    }





}
