package service;

import model.Agency;
import model.BankAccount;
import model.Customer;
import model.InsuranceCompany;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AgencyService {

    // İsim ile bir agency oluşuturup döndürüyoruz
    public Agency createAgency(String name) {
        Agency agency = new Agency();
        agency.setName(name);
        return agency;
    }

    // Oluşturulan agency'lere bank account eklemek için gerekli method
    public void addBankAccountToAgency(BankAccount bankAccount, Agency agency){
        if (agency.getBankAccountList() != null)
        {
            agency.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountArrayList = new ArrayList<BankAccount>();
            bankAccountArrayList.add(bankAccount);
            agency.setBankAccountList(bankAccountArrayList);
        }
    }

    // InsuranceCompany eklemek için gerekli method
    public void addInsuranceCompanyToAgency(Agency agency, InsuranceCompany insuranceCompany) {
        if (agency.getInsuranceCompanyList() != null) {
            agency.getInsuranceCompanyList().add(insuranceCompany);
        } else {
            ArrayList<InsuranceCompany> insuranceCompanies = new ArrayList<InsuranceCompany>();
            insuranceCompanies.add(insuranceCompany);
            agency.setInsuranceCompanyList(insuranceCompanies);
        }
    }

    // Agency'e customer eklemek için gerekli method
    public void addCustomerToAgency(Agency agency, Customer customer) {
        if (agency.getCustomerList() != null) {
            agency.getCustomerList().add(customer);
        } else {
            ArrayList<Customer> customerList = new ArrayList<>();
            customerList.add(customer);
            agency.setCustomerList(customerList);
        }
    }
}
