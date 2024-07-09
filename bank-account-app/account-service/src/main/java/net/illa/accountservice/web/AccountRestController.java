package net.illa.accountservice.web;


import net.illa.accountservice.clients.CustomerRestClient;
import net.illa.accountservice.entities.BankAccount;
import net.illa.accountservice.model.Customer;
import net.illa.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AccountRestController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository=accountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount>  accountList() {
        return accountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
       BankAccount bankAccount= accountRepository.findById(id).get();
       Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
       bankAccount.setCustomer(customer);
       return bankAccount;

    }
}