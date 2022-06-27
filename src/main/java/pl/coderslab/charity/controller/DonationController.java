package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRespository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
@SessionAttributes("donate")
public class DonationController {

    @Autowired
    DonationRepository donationRepository;

    @Autowired
    CategoryRespository categoryRespository;

    @Autowired
    InstitutionRepository institutionRepository;
    @GetMapping("/form")
    public String formShow(Model model){
        model.addAttribute("donation",new Donation());
        model.addAttribute("categories",categoryRespository.names());
        model.addAttribute("institutions",institutionRepository.names());
        return "form/form1";
    }

    @PostMapping("/form")
    public String formAdd(Model model, @ModelAttribute("donation") Donation donation){
        model.addAttribute("donate",donation);
        return "redirect:/formSum";
    }


}
