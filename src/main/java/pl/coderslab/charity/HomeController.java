package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
public class HomeController {


    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    DonationRepository donationRepository;

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institution",institutionRepository.findAll());
        model.addAttribute("sumBag",donationRepository.sumBag());
        model.addAttribute("sumDonation",donationRepository.sumDonation());
        return "index";
    }
}
