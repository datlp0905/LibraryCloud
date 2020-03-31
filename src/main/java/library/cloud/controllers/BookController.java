package library.cloud.controllers;

import io.swagger.annotations.ApiOperation;
import library.cloud.dtos.BookDTO;
import library.cloud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    @ApiOperation("Get all books")
    public List<BookDTO> getAll() {
        return bookService.getAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Get book by id")
    public BookDTO getById(@PathVariable(name = "id") int id) {
        return bookService.getById(id);
    }

    @GetMapping("test")
    @ApiOperation("Test")
    public String getById() {
        return "Hello World";
    }

    @PostMapping
    @ApiOperation("Create new book")
    public BookDTO create(@RequestBody BookDTO dto) {
        return bookService.create(dto);
    }

    @PutMapping("{id}")
    @ApiOperation("Update a book")
    public BookDTO update(@PathVariable(name = "id") int id, @RequestBody BookDTO dto) {
        return bookService.update(id, dto);
    }

    @PutMapping("deactive/{id}")
    @ApiOperation("Deactive a book")
    public BookDTO deactive(@PathVariable(name = "id") int id) {
        return bookService.deactive(id);
    }
}
