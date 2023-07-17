package service;

import model.BankAccount;
import model.Insurance;
import model.InsuranceCompany;
import model.PaymentMovement;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceCompanyService {

    // Company oluşturmak için gerekli method, verilen bilgiler set edilip InsuranceCompany nesnesi döndürülüyor
    public InsuranceCompany createInsuranceCompany(String name, String taxOffice, String taxNumber,
                                                   String address, BigDecimal commission) {
        InsuranceCompany insuranceCompany = new InsuranceCompany();
        insuranceCompany.setName(name);
        insuranceCompany.setTaxOffice(taxOffice);
        insuranceCompany.setTaxNumber(taxNumber);
        insuranceCompany.setAddress(address);
        insuranceCompany.setCommission(commission);
        return insuranceCompany;
    }

    // Company'e Insurance eklemek için gerekli
    public void addInsuranceToInsuranceCompany(InsuranceCompany insuranceCompany, Insurance insurance) {
        if (insuranceCompany.getInsuranceList() != null) {
            insuranceCompany.getInsuranceList().add(insurance);
        } else {
            ArrayList<Insurance> insuranceList = new ArrayList<>();
            insuranceList.add(insurance);
            insuranceCompany.setInsuranceList(insuranceList);
        }
    }

    // Company'e Banka hesabı eklemek için gerekli method
    public void addBankAccountToInsuranceCompany(InsuranceCompany insuranceCompany, BankAccount bankAccount) {
        if (insuranceCompany.getBankAccountList() != null) {
            insuranceCompany.getBankAccountList().add(bankAccount);
        } else {
            ArrayList<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);
            insuranceCompany.setBankAccountList(bankAccountList);
        }
    }

    // Company'e PaymentMovement eklemek için gerekli
    public void addPaymentMovementToInsuranceCompany(InsuranceCompany insuranceCompany, PaymentMovement paymentMovement) {
        if (insuranceCompany.getPaymentMovementList() != null) {
            insuranceCompany.getPaymentMovementList().add(paymentMovement);
        } else {
            ArrayList<PaymentMovement> paymentMovements = new ArrayList<>();
            paymentMovements.add(paymentMovement);
            insuranceCompany.setPaymentMovementList(paymentMovements);
        }
    }
}
