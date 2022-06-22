package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.coderslab.charity.repository.DonationRepository;

@Controller
public class DonationController {

    @Autowired
    DonationRepository donationRepository;

}
