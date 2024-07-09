package net.illa.customerservice;

import net.illa.customerservice.entities.Customer;
import net.illa.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication

public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args ->{
            List<Customer> customerList= List.of(
            Customer.builder()
                    .firstName("Hassan")
                    .lastName("Elhoumi")
                    .email("hassan@gmail.com")
                    .build(),
            Customer.builder()
                    .firstName("Mohamed")
                    .lastName("Elhannaoui")
                    .email("hassan@gmail.com")
                    .build()
            );
            customerRepository.saveAll(customerList);

        };
    }
}
