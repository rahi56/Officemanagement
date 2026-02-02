package org.example.officemanagement.controller;

import org.example.officemanagement.model.InvestmentQuotation;
import org.example.officemanagement.repository.InvestmentQuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @Autowired
    private InvestmentQuotationRepository quotationRepository;

    @GetMapping("/calculator")
    public String calculator(Model model) {
        model.addAttribute("activePage", "calculator");
        return "calculator";
    }

    @PostMapping("/api/quotations/investment")
    @ResponseBody
    public InvestmentQuotation saveQuotation(@RequestBody InvestmentQuotation quotation) {
        return quotationRepository.save(quotation);
    }

    @GetMapping("/api/quotations/investment/{id}")
    @ResponseBody
    public InvestmentQuotation getQuotation(@PathVariable Long id) {
        return quotationRepository.findById(id).orElse(null);
    }
}
