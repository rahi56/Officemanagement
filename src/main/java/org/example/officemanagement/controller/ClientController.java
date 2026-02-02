package org.example.officemanagement.controller;

import org.example.officemanagement.model.Client;

import org.example.officemanagement.service.ClientService;
import org.example.officemanagement.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private org.example.officemanagement.service.TransactionService transactionService;

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("activePage", "clients");
        return "clients/list";
    }

    @GetMapping("/new")
    public String newClientForm(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("activePage", "clients");
        return "clients/form";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}")
    public String viewClient(@PathVariable String id, Model model) {
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        model.addAttribute("activePage", "clients");
        return "clients/view";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable String id, Model model) {
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        model.addAttribute("activePage", "clients");
        return "clients/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }

    @PostMapping("/{id}/upload")
    public String uploadDocument(@PathVariable String id, @RequestParam("file") MultipartFile file) throws IOException {
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        documentService.uploadDocument(client, file);
        return "redirect:/clients/" + id;
    }

    @PostMapping("/{id}/transaction")
    public String addTransaction(@PathVariable String id,
            @ModelAttribute org.example.officemanagement.model.Transaction transaction) {
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        transaction.setClient(client);
        transactionService.saveTransaction(transaction);
        return "redirect:/clients/" + id;
    }

    @PostMapping("/{id}/quick-update")
    public String quickUpdate(@PathVariable String id,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "notes", required = false) String notes) {
        Client client = clientService.getClientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));

        if (status != null) {
            client.setStatus(status);
        }
        if (notes != null) {
            client.setNotes(notes);
        }

        clientService.saveClient(client);
        return "redirect:/clients/" + id;
    }
}
