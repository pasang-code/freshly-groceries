package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {

    public Product findTopByOrderByIdDesc();

    public Product findTopByOrderByIdAsc();

    public Product findTopByIdGreaterThanOrderByIdAsc(Integer id);
    public Product findTopByIdLessThanOrderByIdDesc(Integer id);


    @Query("SELECT DISTINCT(p) FROM Product p LEFT JOIN p.categories c WHERE (:name IS NULL OR p.productName ILIKE CONCAT('%',:name,'%')) AND (:weight IS NULL OR p.weight >= :weight) AND (:minPrice IS NULL OR (p.price >= :minPrice)) AND (:maxPrice IS NULL OR p.price <= :maxPrice) AND (:category IS NULL or :category = '' or :category = c.name) AND (:organic IS NULL OR p.organic = :organic) AND (:searchQuery IS NULL or p.productName ILIKE concat('%',:searchQuery,'%'))")
    public List<Product> findByFilter(@Param("name") String name, @Param("weight") Double weight, @Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice, @Param("category") String category, @Param("organic") Boolean organic, @Param("searchQuery") String searchQuery);
}
