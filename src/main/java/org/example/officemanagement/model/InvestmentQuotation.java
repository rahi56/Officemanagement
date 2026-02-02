package org.example.officemanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class InvestmentQuotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String familyStructure;
    private LocalDateTime createdAt = LocalDateTime.now();

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Column(name = "main_applicant_count")
    private int mainApplicantCount = 1;
    @Column(name = "spouse_apply_count")
    private int spouseApplyCount;
    @Column(name = "non_app_spouse_count")
    private int nonAppSpouseCount;
    @Column(name = "child0_to16_count")
    private int child0To16Count;
    @Column(name = "child17_plus_count")
    private int child17PlusCount;
    @Column(name = "sibling_count")
    private int siblingCount;
    @Column(name = "parent56_plus_count")
    private int parent56PlusCount;
    @Column(name = "parent56_plus_non_app_count")
    private int parent56PlusNonAppCount;
    @Column(name = "parent_under55_count")
    private int parentUnder55Count;
    @Column(name = "parent_under55_non_app_count")
    private int parentUnder55NonAppCount;
    @Column(name = "non_app_sponsor_count")
    private int nonAppSponsorCount;

    // Rates & Quantities
    private double appFeeRate = 1500.0;
    private int appFeeQty;

    private double procFee17Rate = 1500.0;
    private int procFee17Qty;

    private double procFee0Rate = 500.0;
    private int procFee0Qty;

    private double ddFee17Rate = 5000.0;
    private int ddFee17Qty;

    private double ddFeeNonAppRate = 8000.0;
    private int ddFeeNonAppQty;

    private double interviewFeeRate = 1000.0;
    private int interviewFeeQty;

    private double legalFee = 6000.0;

    private double miscFeeRate = 450.0;
    private int miscFeeQty;

    private double courierFee = 200.0;

    private double notaryFeeRate = 100.0;
    private int notaryFeeQty;

    private double totalInvestment = 270000.0;
    private double advancePaymentRate = 0.10; // 10%

    // Government Fee Fields
    private String govtFeeDescription;
    private double govtFeeBase = 50000.0;
    private double govtFeeAdditionalRate = 25000.0;
    private int govtFeeAdditionalQty;

    @Column(name = "govt_fee_under55_rate")
    private double govtFeeUnder55Rate = 50000.0;
    @Column(name = "govt_fee_under55_qty")
    private int govtFeeUnder55Qty;

    @Column(name = "govt_fee_sibling_rate")
    private double govtFeeSiblingRate = 75000.0;
    @Column(name = "govt_fee_sibling_qty")
    private int govtFeeSiblingQty;

    // VAT and Bank Charges
    private double bankChargesAndVat1;
    private double bankChargesAndVat2;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getFamilyStructure() {
        return familyStructure;
    }

    public void setFamilyStructure(String familyStructure) {
        this.familyStructure = familyStructure;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getAppFeeRate() {
        return appFeeRate;
    }

    public void setAppFeeRate(double appFeeRate) {
        this.appFeeRate = appFeeRate;
    }

    public int getAppFeeQty() {
        return appFeeQty;
    }

    public void setAppFeeQty(int appFeeQty) {
        this.appFeeQty = appFeeQty;
    }

    public double getProcFee17Rate() {
        return procFee17Rate;
    }

    public void setProcFee17Rate(double procFee17Rate) {
        this.procFee17Rate = procFee17Rate;
    }

    public int getProcFee17Qty() {
        return procFee17Qty;
    }

    public void setProcFee17Qty(int procFee17Qty) {
        this.procFee17Qty = procFee17Qty;
    }

    public double getProcFee0Rate() {
        return procFee0Rate;
    }

    public void setProcFee0Rate(double procFee0Rate) {
        this.procFee0Rate = procFee0Rate;
    }

    public int getProcFee0Qty() {
        return procFee0Qty;
    }

    public void setProcFee0Qty(int procFee0Qty) {
        this.procFee0Qty = procFee0Qty;
    }

    public double getDdFee17Rate() {
        return ddFee17Rate;
    }

    public void setDdFee17Rate(double ddFee17Rate) {
        this.ddFee17Rate = ddFee17Rate;
    }

    public int getDdFee17Qty() {
        return ddFee17Qty;
    }

    public void setDdFee17Qty(int ddFee17Qty) {
        this.ddFee17Qty = ddFee17Qty;
    }

    public double getDdFeeNonAppRate() {
        return ddFeeNonAppRate;
    }

    public void setDdFeeNonAppRate(double ddFeeNonAppRate) {
        this.ddFeeNonAppRate = ddFeeNonAppRate;
    }

    public int getDdFeeNonAppQty() {
        return ddFeeNonAppQty;
    }

    public void setDdFeeNonAppQty(int ddFeeNonAppQty) {
        this.ddFeeNonAppQty = ddFeeNonAppQty;
    }

    public double getInterviewFeeRate() {
        return interviewFeeRate;
    }

    public void setInterviewFeeRate(double interviewFeeRate) {
        this.interviewFeeRate = interviewFeeRate;
    }

    public int getInterviewFeeQty() {
        return interviewFeeQty;
    }

    public void setInterviewFeeQty(int interviewFeeQty) {
        this.interviewFeeQty = interviewFeeQty;
    }

    public double getLegalFee() {
        return legalFee;
    }

    public void setLegalFee(double legalFee) {
        this.legalFee = legalFee;
    }

    public double getMiscFeeRate() {
        return miscFeeRate;
    }

    public void setMiscFeeRate(double miscFeeRate) {
        this.miscFeeRate = miscFeeRate;
    }

    public int getMiscFeeQty() {
        return miscFeeQty;
    }

    public void setMiscFeeQty(int miscFeeQty) {
        this.miscFeeQty = miscFeeQty;
    }

    public double getCourierFee() {
        return courierFee;
    }

    public void setCourierFee(double courierFee) {
        this.courierFee = courierFee;
    }

    public double getNotaryFeeRate() {
        return notaryFeeRate;
    }

    public void setNotaryFeeRate(double notaryFeeRate) {
        this.notaryFeeRate = notaryFeeRate;
    }

    public int getNotaryFeeQty() {
        return notaryFeeQty;
    }

    public void setNotaryFeeQty(int notaryFeeQty) {
        this.notaryFeeQty = notaryFeeQty;
    }

    public double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public double getAdvancePaymentRate() {
        return advancePaymentRate;
    }

    public void setAdvancePaymentRate(double advancePaymentRate) {
        this.advancePaymentRate = advancePaymentRate;
    }

    public String getGovtFeeDescription() {
        return govtFeeDescription;
    }

    public void setGovtFeeDescription(String govtFeeDescription) {
        this.govtFeeDescription = govtFeeDescription;
    }

    public double getGovtFeeBase() {
        return govtFeeBase;
    }

    public void setGovtFeeBase(double govtFeeBase) {
        this.govtFeeBase = govtFeeBase;
    }

    public double getGovtFeeAdditionalRate() {
        return govtFeeAdditionalRate;
    }

    public void setGovtFeeAdditionalRate(double govtFeeAdditionalRate) {
        this.govtFeeAdditionalRate = govtFeeAdditionalRate;
    }

    public int getGovtFeeAdditionalQty() {
        return govtFeeAdditionalQty;
    }

    public void setGovtFeeAdditionalQty(int govtFeeAdditionalQty) {
        this.govtFeeAdditionalQty = govtFeeAdditionalQty;
    }

    public double getBankChargesAndVat1() {
        return bankChargesAndVat1;
    }

    public void setBankChargesAndVat1(double bankChargesAndVat1) {
        this.bankChargesAndVat1 = bankChargesAndVat1;
    }

    public double getBankChargesAndVat2() {
        return bankChargesAndVat2;
    }

    public void setBankChargesAndVat2(double bankChargesAndVat2) {
        this.bankChargesAndVat2 = bankChargesAndVat2;
    }

    public int getMainApplicantCount() {
        return mainApplicantCount;
    }

    public void setMainApplicantCount(int mainApplicantCount) {
        this.mainApplicantCount = mainApplicantCount;
    }

    public int getSpouseApplyCount() {
        return spouseApplyCount;
    }

    public void setSpouseApplyCount(int spouseApplyCount) {
        this.spouseApplyCount = spouseApplyCount;
    }

    public int getNonAppSpouseCount() {
        return nonAppSpouseCount;
    }

    public void setNonAppSpouseCount(int nonAppSpouseCount) {
        this.nonAppSpouseCount = nonAppSpouseCount;
    }

    public int getChild0To16Count() {
        return child0To16Count;
    }

    public void setChild0To16Count(int child0To16Count) {
        this.child0To16Count = child0To16Count;
    }

    public int getChild17PlusCount() {
        return child17PlusCount;
    }

    public void setChild17PlusCount(int child17PlusCount) {
        this.child17PlusCount = child17PlusCount;
    }

    public int getSiblingCount() {
        return siblingCount;
    }

    public void setSiblingCount(int siblingCount) {
        this.siblingCount = siblingCount;
    }

    public int getParent56PlusCount() {
        return parent56PlusCount;
    }

    public void setParent56PlusCount(int parent56PlusCount) {
        this.parent56PlusCount = parent56PlusCount;
    }

    public int getParent56PlusNonAppCount() {
        return parent56PlusNonAppCount;
    }

    public void setParent56PlusNonAppCount(int parent56PlusNonAppCount) {
        this.parent56PlusNonAppCount = parent56PlusNonAppCount;
    }

    public int getParentUnder55Count() {
        return parentUnder55Count;
    }

    public void setParentUnder55Count(int parentUnder55Count) {
        this.parentUnder55Count = parentUnder55Count;
    }

    public int getParentUnder55NonAppCount() {
        return parentUnder55NonAppCount;
    }

    public void setParentUnder55NonAppCount(int parentUnder55NonAppCount) {
        this.parentUnder55NonAppCount = parentUnder55NonAppCount;
    }

    public int getNonAppSponsorCount() {
        return nonAppSponsorCount;
    }

    public void setNonAppSponsorCount(int nonAppSponsorCount) {
        this.nonAppSponsorCount = nonAppSponsorCount;
    }

    public double getGovtFeeUnder55Rate() {
        return govtFeeUnder55Rate;
    }

    public void setGovtFeeUnder55Rate(double govtFeeUnder55Rate) {
        this.govtFeeUnder55Rate = govtFeeUnder55Rate;
    }

    public int getGovtFeeUnder55Qty() {
        return govtFeeUnder55Qty;
    }

    public void setGovtFeeUnder55Qty(int govtFeeUnder55Qty) {
        this.govtFeeUnder55Qty = govtFeeUnder55Qty;
    }

    public double getGovtFeeSiblingRate() {
        return govtFeeSiblingRate;
    }

    public void setGovtFeeSiblingRate(double govtFeeSiblingRate) {
        this.govtFeeSiblingRate = govtFeeSiblingRate;
    }

    public int getGovtFeeSiblingQty() {
        return govtFeeSiblingQty;
    }

    public void setGovtFeeSiblingQty(int govtFeeSiblingQty) {
        this.govtFeeSiblingQty = govtFeeSiblingQty;
    }

    // Calculated Totals
    public double getFirstPaymentTotal() {
        double subtotal = (appFeeRate * appFeeQty) +
                (procFee17Rate * procFee17Qty) +
                (procFee0Rate * procFee0Qty) +
                (ddFee17Rate * ddFee17Qty) +
                (ddFeeNonAppRate * ddFeeNonAppQty) +
                (interviewFeeRate * interviewFeeQty) +
                legalFee +
                (miscFeeRate * miscFeeQty) +
                courierFee +
                (notaryFeeRate * notaryFeeQty) +
                (totalInvestment * advancePaymentRate);
        return subtotal + bankChargesAndVat1;
    }

    public double getSecondPaymentTotal() {
        double subtotal = (totalInvestment * (1 - advancePaymentRate)) +
                govtFeeBase +
                (govtFeeAdditionalRate * govtFeeAdditionalQty) +
                (govtFeeUnder55Rate * govtFeeUnder55Qty) +
                (govtFeeSiblingRate * govtFeeSiblingQty);
        return subtotal + bankChargesAndVat2;
    }

    public double getTotalAmount() {
        return getFirstPaymentTotal() + getSecondPaymentTotal();
    }
}
