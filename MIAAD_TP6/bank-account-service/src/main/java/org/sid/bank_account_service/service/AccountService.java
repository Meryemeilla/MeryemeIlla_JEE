package org.sid.bank_account_service.service;


import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponceDTO;

public interface AccountService {
    BankAccountResponceDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponceDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);
}
