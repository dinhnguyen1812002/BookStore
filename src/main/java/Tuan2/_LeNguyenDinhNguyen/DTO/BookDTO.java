package Tuan2._LeNguyenDinhNguyen.DTO;

import Tuan2._LeNguyenDinhNguyen.Validator.annotation.ValidCategoryId;
import Tuan2._LeNguyenDinhNguyen.entity.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookDTO {

    private Long Id;

    private String title;


    private String author;


    private Double price;

    private String category;

}
