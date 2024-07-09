package org.sid.bank_account_service.mappers;


import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponceDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponceDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponceDTO bankAccountResponceDTO= new BankAccountResponceDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponceDTO);
        return bankAccountResponceDTO;

    }
}
