package be.thomasmore.grocerydeliverywebappspring.controllers;

import be.thomasmore.grocerydeliverywebappspring.ShoppingCartService;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.CartItem;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.repositories.CartItemRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ShoppingCartController {

    @Autowired
    private  ShoppingCartService shoppingCartService;
    @Autowired
    private  ProductRepository productRepository;

    @PostMapping("/shopping-cart-add")
    public String shoppingCartAddPost(@RequestParam Integer productId,
                                      @RequestParam(required = false) Integer quantity,
                                      @ModelAttribute("cart") ShoppingCart cart,
                                      Model model) {

        ShoppingCartService.addProductResult result = shoppingCartService.addProduct(productId, quantity, cart);


        if (!result.equals(ShoppingCartService.addProductResult.SUCCESS)) {
            Optional<Product> product = productRepository.findById(productId);


            model.addAttribute("invalidInput", true);

            productRepository.findById(productId)
                    .ifPresent(p -> model.addAttribute("product", p));
            return "product-details";

        }

        return "redirect:/product-details/" + productId;


    }

    @PostMapping("/shopping-cart-clear")
    public String shoppingCartClearPost() {
        shoppingCartService.clearCart();
        return "redirect:/shopping-cart";
    }

    @PostMapping("/shopping-cart-remove")
    public String shoppingCartRemovePost(@RequestParam Integer cartItemId) {
        shoppingCartService.removeProduct(cartItemId);
        return "redirect:/shopping-cart";
    }

    @PostMapping("/shopping-cart-update")
    public String shoppingCartUpdatePost(@RequestParam String action,
                                         @RequestParam Integer itemId) {

        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart")
    public String shoppingCart(@ModelAttribute("cart") ShoppingCart cart) {
        return "shopping-cart";
    }
}