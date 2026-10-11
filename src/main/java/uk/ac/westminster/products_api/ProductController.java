package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public List<Product> getAllProducts() {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product(1L, "Laptop", 999.99));
        list.add(new Product(2L, "Keyboard", 8.78));
        list.add(new Product(3L, "Mouse", 3.45));
        return list;
    }

    @GetMapping("/goodbye")
    public String goodbye(){
        return "Goodbye from Spring Boot";
    }

    @PostMapping()
    public Product saveProduct(@RequestBody Product product) {
        System.out.println(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
        return "Delete endpoint executed: ID: " + id + " product has been deleted successfully";
    }

}
