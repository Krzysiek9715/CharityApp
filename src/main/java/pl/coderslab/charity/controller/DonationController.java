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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        model.addAttribute("allCategories",categoryRespository.findAll());
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
    public String postForm2(@RequestParam("institution") Institution institution){
        sessionDonation.setInstitution(institution);
        return "form/form4";
    }

    @PostMapping("/form4")
    public String postForm3(Model model,
                            @RequestParam("street") String street,
                            @RequestParam("city") String city,
                            @RequestParam("zipCode") String zipCode,
                            @RequestParam("pickUpDate") String pickUpDate,
                            @RequestParam("pickUpTime") String pickUpTime,
                            @RequestParam("pickUpComment")String pickUpComment){
        sessionDonation.setStreet(street);
        sessionDonation.setCity(city);
        sessionDonation.setZipCode(zipCode);
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        sessionDonation.setPickUpDate(LocalDate.parse(pickUpDate,formatterDate));
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H:mm");
        sessionDonation.setPickUpTime(LocalTime.parse(pickUpTime, formatterTime));
        sessionDonation.setPickUpComment(pickUpComment);
        model.addAttribute("sessionData",sessionDonation);
        return "form/formSum";
    }


    @PostMapping("/formSum")
    public String postForm2(Model model){
        model.addAttribute("sessionData",sessionDonation);
        Donation newDonation = new Donation();
        newDonation.setCategories(sessionDonation.getCategories());
        newDonation.setInstitution(sessionDonation.getInstitution());
        newDonation.setQuantity(sessionDonation.getQuantity());
        newDonation.setCity(sessionDonation.getCity());
        newDonation.setStreet(sessionDonation.getStreet());
        newDonation.setZipCode(sessionDonation.getZipCode());
        newDonation.setPickUpTime(sessionDonation.getPickUpTime());
        newDonation.setPickUpDate(sessionDonation.getPickUpDate());
        newDonation.setPickUpComment(sessionDonation.getPickUpComment());
        donationRepository.save(newDonation);
        return "redirect:/";
    }



}
