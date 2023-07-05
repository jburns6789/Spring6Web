package student.practice.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import student.practice.spring6webapp.domain.Publisher;

//cmd click on CrudRepository give instructions and details and how to use methods and basic operations

// setup Generics

//JPA will write the implementations at runtime

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
