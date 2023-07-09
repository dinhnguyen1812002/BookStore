package Tuan2._LeNguyenDinhNguyen.service;

import Tuan2._LeNguyenDinhNguyen.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceService {
    @Autowired
    private IInvoiceRepository invoiceRepository;
    public Long getTotalOrders()
    {
        return invoiceRepository.count();
    }
}



