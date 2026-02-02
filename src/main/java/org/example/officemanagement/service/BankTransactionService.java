package org.example.officemanagement.service;

import org.example.officemanagement.model.BankTransaction;
import org.example.officemanagement.repository.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankTransactionService {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    public List<BankTransaction> getAllTransactions() {
        return bankTransactionRepository.findAll();
    }

    public Optional<BankTransaction> getTransactionById(String id) {
        return bankTransactionRepository.findById(id);
    }

    public BankTransaction saveTransaction(BankTransaction transaction) {
        return bankTransactionRepository.save(transaction);
    }

    public void deleteTransaction(String id) {
        bankTransactionRepository.deleteById(id);
    }
}
