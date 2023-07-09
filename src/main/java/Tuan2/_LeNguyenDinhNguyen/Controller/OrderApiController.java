package Tuan2._LeNguyenDinhNguyen.Controller;

import Tuan2._LeNguyenDinhNguyen.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderApiController {
    @Autowired
    private  InvoiceService invoiceService;
    @GetMapping("/total")
    public ResponseEntity<Long> getTotalOrders() {
        long totalOrders = invoiceService.getTotalOrders();
        return ResponseEntity.ok(totalOrders);
    }

//    @GetMapping("/total-by-date")
//    public ResponseEntity<Map<String, Long>> getTotalOrdersByDate() {
//        Map<String, Long> totalOrdersByDate = invoiceService.getTotalOrdersByDate();
//        return ResponseEntity.ok(totalOrdersByDate);
//    }



}
