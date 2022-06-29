package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.SessionDonation;
import pl.coderslab.charity.repository.CategoryRespository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    @Autowired
    DonationRepository donationRepository;
    @Autowired
    CategoryRespository categoryRespository;
    @Autowired
    InstitutionRepository institutionRepository;
    @Autowired
    SessionDonation sessionDonation;
    @GetMapping("/form")
    public String formShow(Model model){
        model.addAttribute("categories",sessionDonation.getCategories());
        model.addAttribute("allCategories",categoryRespository.names());
        return "form/form1";
    }
    @PostMapping("/form1")
    public String postForm1(@RequestParam("categories")List<Category> categories) {
        sessionDonation.setCategories(categories);
        return "form/form2";
    }

    @PostMapping("/form2")
    public String postForm2(Model model,@RequestParam("quantity") Integer quantity){
        sessionDonation.setQuantity(quantity);
        model.addAttribute("allInstitutions",institutionRepository.findAll());
        return "form/form3";
    }
    @PostMapping("/form3")
    public String postForm2(Model model, @RequestParam("institution") Institution institution){
        sessionDonation.setInstitution(institution);
        model.addAttribute("session",sessionDonation);
        return "form/formSum";
    }



}
