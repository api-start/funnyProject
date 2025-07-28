package com.project.api.configuration.StartupListeners;

import com.project.api.model.Category;
import com.project.api.repository.interfaces.CategoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryEnumVerifierDb implements
        ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;

    public CategoryEnumVerifierDb(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<String> categoriesNames = categoryRepository.findAllCategoriesNames();
        Category [] categories = Category.values();
        int index = 0;

        /*ASSUMING Category.values() returns the enum in order as it says
          what this method do is find the last index of the value that exists
          and then we insert in db starting from the index because that was the last value
         */
        for (String categoryName: categoriesNames){
            if (Category.fromName(categoryName) != null){
                index++;
            }
        }
        for (int i = index; i<categories.length; i++){
            categoryRepository.create(categories[i]);
        }
    }
}
