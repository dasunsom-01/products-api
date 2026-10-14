package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/{id}")
    public uk.ac.westminster.productsapi.Customer getById(@PathVariable Long id) {

        uk.ac.westminster.productsapi.Address address = new uk.ac.westminster.productsapi.Address(
                "115 New Cavendish Street",
                "London",
                "W1W 6UW"
        );

        return new uk.ac.westminster.productsapi.Customer(
                id,
                "Ada Lovelace",
                "ada@example.com",
                address
        );
    }
}