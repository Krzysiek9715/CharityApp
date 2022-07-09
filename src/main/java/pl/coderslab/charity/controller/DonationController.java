package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.charity.model.*;
import pl.coderslab.charity.repository.CategoryRespository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.UserRepository;

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

    @Autowired
    UserRepository userRepository;

    @GetMapping("/form")
    public String formShow(Model model){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        model.addAttribute("categories",sessionDonation.getCategories());
        model.addAttribute("allCategories",categoryRespository.findAll());
        return "form/form1";
    }

    @GetMapping("/form1")
    public String formShow1(Model model){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        model.addAttribute("categories",sessionDonation.getCategories());
        model.addAttribute("quantity",sessionDonation.getQuantity());
        model.addAttribute("institution",sessionDonation.getInstitution());

        return "form/form2";
    }

    @PostMapping("/form1")
    public String postForm1(Model model, @RequestParam("categories")List<Category> categories) {
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        sessionDonation.setCategories(categories);
        model.addAttribute("quantity",sessionDonation.getQuantity());
        return "form/form2";
    }

    @GetMapping("/form2")
    public String formShow2(Model model){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        model.addAttribute("categories",sessionDonation.getCategories());
        model.addAttribute("quantity",sessionDonation.getQuantity());
        model.addAttribute("institution",sessionDonation.getInstitution());
        model.addAttribute("allInstitutions",institutionRepository.findAll());
        return "form/form3";
    }

    @PostMapping("/form2")
    public String postForm2(Model model,@RequestParam("quantity") Integer quantity){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        sessionDonation.setQuantity(quantity);
        model.addAttribute("allInstitutions",institutionRepository.findAll());
        return "form/form3";
    }

    @GetMapping("/form3")
    public String formShow3(Model model){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));

        model.addAttribute("categories",sessionDonation.getCategories());
        model.addAttribute("quantity",sessionDonation.getQuantity());
        model.addAttribute("institution",sessionDonation.getInstitution());
        model.addAttribute("street",sessionDonation.getStreet());
        model.addAttribute("city",sessionDonation.getCity());
        model.addAttribute("zipCode",sessionDonation.getZipCode());
        model.addAttribute("pickUpDate",sessionDonation.getPickUpDate());
        model.addAttribute("pickUpTime",sessionDonation.getPickUpTime());
        model.addAttribute("pickUpComment",sessionDonation.getPickUpComment());
        return "form/form4";
    }

    @PostMapping("/form3")
    public String postForm2(Model model,@RequestParam("institution") Institution institution){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        sessionDonation.setInstitution(institution);
        return "form/form4";
    }

    @GetMapping("/form4")
    public String formShow4(Model model){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
        model.addAttribute("categories",sessionDonation.getCategories());
        model.addAttribute("quantity",sessionDonation.getQuantity());
        model.addAttribute("institution",sessionDonation.getInstitution());
        model.addAttribute("street",sessionDonation.getStreet());
        model.addAttribute("city",sessionDonation.getCity());
        model.addAttribute("zipCode",sessionDonation.getZipCode());
        model.addAttribute("pickUpDate",sessionDonation.getPickUpDate());
        model.addAttribute("pickUpTime",sessionDonation.getPickUpTime());
        model.addAttribute("pickUpComment",sessionDonation.getPickUpComment());
        return "form/formSum";
    }


    @PostMapping("/form4")
    public String postForm3(Model model,
                            @RequestParam("street") String street,
                            @RequestParam("city") String city,
                            @RequestParam("zipCode") String zipCode,
                            @RequestParam("pickUpDate") String pickUpDate,
                            @RequestParam("pickUpTime") String pickUpTime,
                            @RequestParam("pickUpComment")String pickUpComment){
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
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
        model.addAttribute("user",userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
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
        return "form/form6";
    }

}
