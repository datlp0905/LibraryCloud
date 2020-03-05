package library.cloud.services;

import library.cloud.dtos.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<BookDTO> getAll();
    BookDTO getById(int id);
    BookDTO create(BookDTO dto);
    BookDTO update(int id, BookDTO dto);
    BookDTO deactive(int id);
}
