package Tuan2._LeNguyenDinhNguyen.service;

import Tuan2._LeNguyenDinhNguyen.entity.Book;
import Tuan2._LeNguyenDinhNguyen.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    public Book getAllBookId(Long id){
        return bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tồn tai Sách có Id:"+ id));
    }
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book)
    {
        bookRepository.save(book);
    }
    public void updateBook(Book book)
    {
        bookRepository.save(book);
    }
    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }
    public List<Book> listAll(String keyword) {
        if (keyword  != null) {
            return bookRepository.search(keyword);
        }else

            return getAllBook();
    }


}
