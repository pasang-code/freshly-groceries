package be.thomasmore.grocerydeliverywebappspring;


import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;


    public Product productSearchBehaviour(Integer id){
        if (id == null) return null;

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) return product.get();

        Product highest = productRepository.findTopByOrderByIdDesc();
        Product lowest = productRepository.findTopByOrderByIdAsc();
        if (highest == null || lowest == null) return null; // empty table

        // wrap around when out of range
        if (id > highest.getId()) return lowest;
        if (id < lowest.getId()) return highest;

       // JPA die de volgende grootste id-product returned
        Product next = productRepository.findTopByIdGreaterThanOrderByIdAsc(id);
        if (next != null) return next;

        return productRepository.findTopByIdLessThanOrderByIdDesc(id);
    }
}
