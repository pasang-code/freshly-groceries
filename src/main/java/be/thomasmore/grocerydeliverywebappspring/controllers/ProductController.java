package be.thomasmore.grocerydeliverywebappspring.controllers;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping({"/product-details/{id}","/product-details"})
    public String productDetails(Model model, @PathVariable(required = false) Integer id) {

        Product product = productService.productSearchBehaviour(id);
        model.addAttribute("product", product);

        return "product-details";
    }
}