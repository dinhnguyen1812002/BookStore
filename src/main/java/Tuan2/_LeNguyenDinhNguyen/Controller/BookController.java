package Tuan2._LeNguyenDinhNguyen.Controller;

import Tuan2._LeNguyenDinhNguyen.DAOS.Item;
import Tuan2._LeNguyenDinhNguyen.entity.Book;
import Tuan2._LeNguyenDinhNguyen.repository.IBookRepository;
import Tuan2._LeNguyenDinhNguyen.service.BookService;
import Tuan2._LeNguyenDinhNguyen.service.CartService;
import Tuan2._LeNguyenDinhNguyen.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
        @Autowired
        IBookRepository bookRepository;
        @Autowired
        private BookService bookService;
        @Autowired
        private CategoryService categoryService;
        @Autowired
        private CartService cartService;
       @GetMapping
       public String showAllBooks(Model model,@Param("keyword") String keyword){
       List<Book> listBook = bookService.listAll(keyword);
            model.addAttribute("book",listBook);
            model.addAttribute("category",categoryService.getAllCategory());
            model.addAttribute("keyword", keyword);
            return "Book/List";
       }
        @GetMapping("/add")
        public String addBookFrom(Model model){
            model.addAttribute("book", new Book());
            model.addAttribute("category", categoryService.getAllCategory());
            return "Book/add";
        }
        @PostMapping("/add")
        public String addBook(@Valid Book book, BindingResult result, Model model )
        {
            if (result.hasErrors()) {
                model.addAttribute("book", new Book());
                model.addAttribute("category", categoryService.getAllCategory());
                return "Book/add";
            }
            bookService.addBook(book);
            return "redirect:/books";
        }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookService.getAllBookId(id);

        model.addAttribute("book", book);
        model.addAttribute("category", categoryService.getAllCategory());
        return "Book/edit";
    }
    @PostMapping("/update")
    public String updateBook( @Valid @ModelAttribute("book") Book book,BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("book", new Book());
            model.addAttribute("category", categoryService.getAllCategory());
            return "Book/edit";
        }
        bookService.updateBook(book);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    @PostMapping("/add-to-cart")
    public String addToCart(HttpSession session,
                            @RequestParam long id,
                            @RequestParam String name,
                            @RequestParam double price,
                            @RequestParam(defaultValue = "1") int quantity) {
        var cart = cartService.getCart(session);
        cart.addItems(new Item(id, name, price, quantity));
        cartService.updateCart(session, cart);
        return "redirect:/books";
    }

}


