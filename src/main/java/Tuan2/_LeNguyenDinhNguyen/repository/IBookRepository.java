package Tuan2._LeNguyenDinhNguyen.repository;

import Tuan2._LeNguyenDinhNguyen.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book,Long> {
    @Query("select p from Book p where concat(p.title,'',p.author,'',p.price,'',p.category.id) LIKE %?1%")
    public List<Book> search(String keyword);
}
