package thinh.acazia.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import thinh.acazia.test.model.Category;

import java.util.Optional;

public interface CategoryService {
    Page<Category> findALL(Pageable pageable);

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);

}
