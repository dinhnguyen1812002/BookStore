package Tuan2._LeNguyenDinhNguyen.DAOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private Long bookId;
    private String bookName;
    private Double price;
    private int quantity;
}
