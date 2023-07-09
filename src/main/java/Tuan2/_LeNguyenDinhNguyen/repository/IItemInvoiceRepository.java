package Tuan2._LeNguyenDinhNguyen.repository;

import Tuan2._LeNguyenDinhNguyen.entity.ItemInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemInvoiceRepository extends JpaRepository<ItemInvoice, Long>{
}
