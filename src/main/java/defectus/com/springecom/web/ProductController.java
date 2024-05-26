package defectus.com.springecom.web;

import defectus.com.springecom.dao.entities.Product;
import defectus.com.springecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/shop")
    public String shop(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "shop";
    }
}
