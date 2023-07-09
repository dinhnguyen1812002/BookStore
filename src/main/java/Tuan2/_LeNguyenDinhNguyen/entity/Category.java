package Tuan2._LeNguyenDinhNguyen.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Name")
    private String Name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List <Book> listBook;
}
