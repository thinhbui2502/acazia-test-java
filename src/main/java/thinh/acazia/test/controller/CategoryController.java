package thinh.acazia.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thinh.acazia.test.model.Category;
import thinh.acazia.test.service.CategoryService;

import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<Category>> showList(Pageable pageable) {
        Page<Category> categories = categoryService.findALL(pageable);
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{tag}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable String tag) {
        Optional<Category> category = categoryService.findById(tag);
        if (category.isPresent()) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/update/{tag}")
    public ResponseEntity<Category> updateById(@PathVariable String tag, @RequestBody Category category) {
        Optional<Category> currentCategory = categoryService.findById(tag);
        if (!currentCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentCategory.get().setName(category.getName());
        currentCategory.get().setTag(category.getTag());

        Category updatedCategory = currentCategory.get();
        categoryService.save(updatedCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{tag}")
    public ResponseEntity<Category> deleteById(@PathVariable String tag) {
        Optional<Category> category = categoryService.findById(tag);
        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(tag);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
