package Tuan2._LeNguyenDinhNguyen.repository;

import Tuan2._LeNguyenDinhNguyen.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {

}
