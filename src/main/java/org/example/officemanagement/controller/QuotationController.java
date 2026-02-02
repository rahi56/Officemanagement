package org.example.officemanagement.controller;

import org.example.officemanagement.model.InvestmentQuotation;
import org.example.officemanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuotationController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private org.example.officemanagement.repository.InvestmentQuotationRepository investmentQuotationRepository;

    @GetMapping("/quotations")
    public String listQuotations(Model model) {
        model.addAttribute("activePage", "quotations");
        model.addAttribute("investmentQuotations", investmentQuotationRepository.findAll());
        return "quotations/list";
    }

    @GetMapping("/quotations/investment/view")
    public String viewInvestmentQuotation(@RequestParam Long id, Model model) {
        model.addAttribute("activePage", "quotations");
        InvestmentQuotation quote = investmentQuotationRepository.findById(id).orElse(null);
        if (quote == null) {
            return "redirect:/quotations";
        }
        model.addAttribute("quote", quote);
        return "quotations/investment-view";
    }

    @GetMapping("/quotations/new")
    public String newQuotation(@RequestParam(required = false) String clientId, Model model) {
        model.addAttribute("activePage", "quotations");
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("selectedClientId", clientId);
        return "quotations/form";
    }
}
