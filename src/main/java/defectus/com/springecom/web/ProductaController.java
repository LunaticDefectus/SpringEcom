package defectus.com.springecom.web;

import defectus.com.springecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import defectus.com.springecom.dao.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductaController {
    @Autowired
    private  ProductService productService;



    @GetMapping("/productsManagement")
    public String listProducts(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Product> productPage = productService.getAllProduits(page, size);
        model.addAttribute("productsManagement", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        return "ProductsManagement";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Integer id) {
        productService.deleteProductById(id);
        return "redirect:/productsManagement";
    }

    @GetMapping("/edit")
    public String editProduct(Model model, @RequestParam(name = "id") Integer id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "EditProduct";
        } else {
            return "error";
        }
    }

    @PostMapping("/save")
    public String update(Product p) {
        productService.addProduct(p);
        return "redirect:/productsManagement";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("newProduct", new Product());
        return "Form";
    }

    @PostMapping("/ajouter-produit")
    public String addProduct(@ModelAttribute("newProduct") Product newProduct) {
        productService.addProduct(newProduct);
        return "redirect:/productsManagement";
    }
}


