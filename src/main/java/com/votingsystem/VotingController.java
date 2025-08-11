package com.votingsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VotingController {

    private List<Candidato> candidates;

    public VotingController() {
        this.candidates = new ArrayList<>();
        this.candidates.add(new Candidato("raul seixas"));
        this.candidates.add(new Candidato(" gabriel o pensador"));
        this.candidates.add(new Candidato(" cazuza"));
    }

    @GetMapping("/")
    public String showVotingPage(Model model) {
        model.addAttribute("candidates", candidates);
        return "index";
    }
    @PostMapping("/vote")
    public String handleVote(@RequestParam String candidateName) {
        for (Candidato candidate : candidates) {
            if (candidate.getName().equals(candidateName)) {
                candidate.addVote();
                break;
            }
        }
        return "redirect:/";
    }

}