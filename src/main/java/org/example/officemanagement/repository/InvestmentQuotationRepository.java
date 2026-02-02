package org.example.officemanagement.repository;

import org.example.officemanagement.model.InvestmentQuotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentQuotationRepository extends JpaRepository<InvestmentQuotation, Long> {
}
