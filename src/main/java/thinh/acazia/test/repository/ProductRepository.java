package thinh.acazia.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import thinh.acazia.test.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
