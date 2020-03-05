package library.cloud.mappers;

import library.cloud.dtos.BookDTO;
import library.cloud.entities.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDTO entityToDto(Book entity);

    Book dtoToEntity(BookDTO dto);
}
