package com.votingsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VotingController {

    @GetMapping("/")
    public String showVotingPage() {
        return "index";
    }

}