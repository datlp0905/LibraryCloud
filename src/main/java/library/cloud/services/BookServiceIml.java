package library.cloud.services;

import library.cloud.common.ErrorMessage;
import library.cloud.common.LibraryException;
import library.cloud.dtos.BookDTO;
import library.cloud.entities.Book;
import library.cloud.mappers.BookMapper;
import library.cloud.repositories.BookRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceIml implements BookService{
    @Autowired
    private BookRepository bookRepository;

    private BookMapper mapper = Mappers.getMapper(BookMapper.class);

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(book -> mapper.entityToDto(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            return mapper.entityToDto(book.get());
        }
        throw new LibraryException(HttpStatus.NOT_FOUND, ErrorMessage.BOOK_NOT_FOUND + id);
    }

    @Override
    public BookDTO create(BookDTO dto) {
        Book book = mapper.dtoToEntity(dto);
        return mapper.entityToDto(bookRepository.save(book));
    }

    @Override
    public BookDTO update(int id, BookDTO dto) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            Book updatedBook = mapper.dtoToEntity(dto);
            bookRepository.save(updatedBook);
            return mapper.entityToDto(updatedBook);
        }
        throw new LibraryException(HttpStatus.NOT_FOUND, ErrorMessage.BOOK_NOT_FOUND + id);
    }

    @Override
    public BookDTO deactive(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            Book deactiveBook = book.get();
            deactiveBook.setActive(false);
            bookRepository.save(deactiveBook);
            return mapper.entityToDto(deactiveBook);
        }
        throw new LibraryException(HttpStatus.NOT_FOUND, ErrorMessage.BOOK_NOT_FOUND + id);
    }
}
