package org.example.officemanagement.controller;

import org.example.officemanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activePage", "dashboard");
        model.addAttribute("totalClients", clientService.getAllClients().size());
        // Add more stats here later
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
