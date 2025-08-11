package com.votingsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class VotingController {

    private List<Candidato> candidates;
    private Set<String> voters;
    private LocalDateTime votingEndDate;

    public VotingController() {
        this.candidates = new ArrayList<>();
        this.candidates.add(new Candidato("bob marley"));
        this.candidates.add(new Candidato(" bob dylan"));
        this.candidates.add(new Candidato("john lennon"));
        this.voters = new HashSet<>();
        // Define a data final da votação para 100 anos no futuro, conforme solicitado.
        this.votingEndDate = LocalDateTime.now().plusYears(100);
    }

    @GetMapping("/")
    
    public String showVotingPage(Model model, Authentication authentication) {
        model.addAttribute("candidates", candidates);
        model.addAttribute("hasVoted", voters.contains(authentication.getName()));

        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(votingEndDate)) {
            long days = ChronoUnit.DAYS.between(now, votingEndDate);
            long hours = ChronoUnit.HOURS.between(now, votingEndDate) % 24;
            long minutes = ChronoUnit.MINUTES.between(now, votingEndDate) % 60;

            model.addAttribute("countdown", String.format("%d dias, %d horas e %d minutos", days, hours, minutes));
            model.addAttribute("votingActive", true);
        } else {
            model.addAttribute("votingActive", false);
        }

        return "index";
    }

    @PostMapping("/vote")
    public String handleVote(@RequestParam String candidateName, Authentication authentication) {
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(votingEndDate)) {
            return "redirect:/";
        }

        String username = authentication.getName();
        if (voters.contains(username)) {
            return "redirect:/";
        }

        for (Candidato candidato : candidates) {
            if (candidato.getName().equals(candidateName)) {
                candidato.addVote();
                voters.add(username);
                break;
            }
        }
        return "redirect:/";
    }
}