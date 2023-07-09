package Tuan2._LeNguyenDinhNguyen.Controller;

import Tuan2._LeNguyenDinhNguyen.DTO.BookDTO;
import Tuan2._LeNguyenDinhNguyen.Viewmodels.BookGetVm;
import Tuan2._LeNguyenDinhNguyen.entity.Book;
import Tuan2._LeNguyenDinhNguyen.repository.IBookRepository;
import Tuan2._LeNguyenDinhNguyen.service.BookService;
import Tuan2._LeNguyenDinhNguyen.service.CartService;
import Tuan2._LeNguyenDinhNguyen.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ApiController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final CartService cartService;
    private final IBookRepository  bookRepository;
    @GetMapping("/books")
    public ResponseEntity<List<BookGetVm>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBook()
                .stream()
                .map(BookGetVm::from)
                .toList());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookGetVm> getBookById(@PathVariable Long id)
    {
        return ResponseEntity.ok(bookService.getBookById(id)
                .map(BookGetVm::from)
                .orElse(null));
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/books/search")
    public ResponseEntity<List<BookGetVm>> searchBooks(String keyword)
    {
        return ResponseEntity.ok(bookService.listAll(keyword)
                .stream()
                .map(BookGetVm::from)
                .toList());
    }
}
