package library.cloud.mappers;

import library.cloud.dtos.CategoryDTO;
import library.cloud.entities.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDTO entityToDto(Category entity);
    Category dtoToEntity(CategoryDTO dto);
}
