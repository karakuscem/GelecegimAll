package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.util.Date;

public class ProposalService {

    // Proposal yaratmak için
    public Proposal createProposal(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal offerPrice,
                                   Date startDate, Date endDate, Date expireDate, boolean isApproved,
                                   BigDecimal discountPrice) {
        Proposal proposal = new Proposal(); // Instance oluşturma
        // verileri setleme
        proposal.setCompany(insuranceCompany);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(offerPrice);
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
        proposal.setApproved(isApproved);
        proposal.setDiscountPrice(discountPrice);
        // return
        return proposal;
    }
}
