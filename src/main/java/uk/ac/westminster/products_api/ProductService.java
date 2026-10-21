
package uk.ac.westminster.productsapi;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<uk.ac.westminster.productsapi.Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<uk.ac.westminster.productsapi.Product> getAllProducts() {
        return products;
    }

    public uk.ac.westminster.productsapi.Product addProduct(uk.ac.westminster.productsapi.Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<uk.ac.westminster.productsapi.Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<uk.ac.westminster.productsapi.Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}
