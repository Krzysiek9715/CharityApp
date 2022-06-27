package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.charity.model.Donation;
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
        model.addAttribute("sumDonation",donationRepository.count());
        return "index";
    }

    @GetMapping("/formSum")
    public String donationPage(Model model, @SessionAttribute("donate") Donation donation){
        model.addAttribute("donat",donation);
        return "form/formSum";
    }
}
