package thinh.acazia.test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import thinh.acazia.test.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Query("Select c.name, c.categoryTag.tag, c.categoryTag.name, c.price from Product c where c.categoryTag.name like %:key% order by c.price desc, c.name asc ")
    Iterable<Product> searchByCategoryTagAndName(@Param("key") String key);
}
