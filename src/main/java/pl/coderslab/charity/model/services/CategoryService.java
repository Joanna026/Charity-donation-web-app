package pl.coderslab.charity.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.entities.Category;
import pl.coderslab.charity.model.repositories.CategoryRepository;
import pl.coderslab.charity.model.DTO.CategoryDTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;


    public CategoryService(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    public void save(CategoryDTO categoryDTO) {
        Category category = toEntity(categoryDTO);
        categoryRepository.save(category);
    }


    public List<CategoryDTO> getAll() {
        List<CategoryDTO> categoryDtoList = new ArrayList<>();

        for(Category category : categoryRepository.findAll()) {
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    public void update(CategoryDTO categoryDTO) {
        categoryRepository.save(toEntity(categoryDTO));
    }


    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }


    private CategoryDTO toDto(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    private Category toEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }
}
