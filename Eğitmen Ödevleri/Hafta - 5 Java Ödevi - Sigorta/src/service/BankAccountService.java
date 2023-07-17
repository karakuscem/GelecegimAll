package service;

import model.BankAccount;

import java.math.BigDecimal;

public class BankAccountService {

    // Gerekli bilgilerle banka hesabı oluşturup döndüren method
    public BankAccount createBankAccount(String name, String iban, BigDecimal amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setName(name);
        bankAccount.setIban(iban);
        bankAccount.setAmount(amount);
        return bankAccount;
    }
}
