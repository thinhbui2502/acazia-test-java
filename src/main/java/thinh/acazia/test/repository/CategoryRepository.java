package thinh.acazia.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import thinh.acazia.test.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {
}
