package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

    User getUserByUsername(String username);
}
