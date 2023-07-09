package Tuan2._LeNguyenDinhNguyen.entity;

import Tuan2._LeNguyenDinhNguyen.Validator.annotation.ValidCategoryId;
import Tuan2._LeNguyenDinhNguyen.Validator.annotation.ValidUserId;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.websocket.OnMessage;
import lombok.Data;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column( name = "Title")
    @NotEmpty(message = "không để trống")
    @Size(min = 1, max = 50,message = "không quá 50 kí tự")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Price")
    @NotNull(message = "không để trống")
    private Double price;
    @ManyToOne
    @ValidCategoryId
    @JoinColumn(name = "Category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ItemInvoice> itemInvoices = new ArrayList<>();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) !=
                Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return getId() != null && Objects.equals(getId(),
                book.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
