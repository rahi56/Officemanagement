package org.example.officemanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class BankTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDate date;
    private String description;
    private double amount;
    private String type; // INCOMING or OUTGOING
    private String sourceOrRecipient;
    private String category;
    private String referenceNumber;

    public BankTransaction() {
    }

    public BankTransaction(String id, LocalDate date, String description, double amount, String type,
            String sourceOrRecipient, String category, String referenceNumber) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.sourceOrRecipient = sourceOrRecipient;
        this.category = category;
        this.referenceNumber = referenceNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceOrRecipient() {
        return sourceOrRecipient;
    }

    public void setSourceOrRecipient(String sourceOrRecipient) {
        this.sourceOrRecipient = sourceOrRecipient;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}
