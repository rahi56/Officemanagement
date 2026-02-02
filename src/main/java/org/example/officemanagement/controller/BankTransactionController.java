package org.example.officemanagement.controller;

import org.example.officemanagement.model.BankTransaction;
import org.example.officemanagement.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/finance/bank")
public class BankTransactionController {

    @Autowired
    private BankTransactionService bankTransactionService;

    @GetMapping
    public String listTransactions(Model model) {
        List<BankTransaction> transactions = bankTransactionService.getAllTransactions();

        double totalIncoming = transactions.stream()
                .filter(t -> "INCOMING".equals(t.getType()))
                .mapToDouble(BankTransaction::getAmount)
                .sum();

        double totalOutgoing = transactions.stream()
                .filter(t -> "OUTGOING".equals(t.getType()))
                .mapToDouble(BankTransaction::getAmount)
                .sum();

        model.addAttribute("transactions", transactions);
        model.addAttribute("totalIncoming", totalIncoming);
        model.addAttribute("totalOutgoing", totalOutgoing);
        model.addAttribute("balance", totalIncoming - totalOutgoing);
        model.addAttribute("newTransaction", new BankTransaction());
        model.addAttribute("activePage", "finance");
        return "finance/bank";
    }

    @PostMapping("/add")
    public String addTransaction(@ModelAttribute BankTransaction transaction) {
        if (transaction.getDate() == null) {
            transaction.setDate(LocalDate.now());
        }
        bankTransactionService.saveTransaction(transaction);
        return "redirect:/finance/bank";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable String id) {
        bankTransactionService.deleteTransaction(id);
        return "redirect:/finance/bank";
    }
}
