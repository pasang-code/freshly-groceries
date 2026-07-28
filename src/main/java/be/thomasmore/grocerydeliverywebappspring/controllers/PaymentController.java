package be.thomasmore.grocerydeliverywebappspring.controllers;


import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.User;
import be.thomasmore.grocerydeliverywebappspring.repositories.ShoppingCartRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.Option;
import java.security.Principal;
import java.util.Optional;

@Controller
public class PaymentController {

 @Autowired
    ShoppingCartRepository shoppingCartRepository;
 @Autowired
    UserRepository userRepository;

    @GetMapping("/payment")
    public String payment(Model model, Principal principal){

        if (principal == null) return "redirect:/home";

        User user = userRepository.getUserByUsername(principal.getName());
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findShoppingCartByUser(user);

        if (shoppingCartOptional.isPresent())
        {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            model.addAttribute("shoppingCart",shoppingCart);
        }

        return "payment";
    }

}
