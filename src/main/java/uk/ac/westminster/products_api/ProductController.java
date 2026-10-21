
package uk.ac.westminster.productsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private uk.ac.westminster.productsapi.ProductService productService;

    @GetMapping("/products")
    public List<uk.ac.westminster.productsapi.Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public uk.ac.westminster.productsapi.Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public uk.ac.westminster.productsapi.Product addProduct(@RequestBody uk.ac.westminster.productsapi.Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<uk.ac.westminster.productsapi.Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }
}
