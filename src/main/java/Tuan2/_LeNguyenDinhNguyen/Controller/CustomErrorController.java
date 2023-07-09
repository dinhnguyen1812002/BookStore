package Tuan2._LeNguyenDinhNguyen.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {
    @GetMapping
    public String error(HttpServletRequest reques){
        Object status = reques.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status!=null){
            int statusCode = Integer.parseInt(status.toString());
            if(statusCode == 404 ) return  "error/error";

        }
        return null;
    }
}
