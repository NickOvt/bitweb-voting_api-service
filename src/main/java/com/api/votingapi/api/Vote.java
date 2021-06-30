package com.api.votingapi.api;

import com.api.votingapi.models.Choice;
import com.api.votingapi.models.VoteResponse;
import com.api.votingapi.services.ChoiceServiceMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/vote")
@RestController
public class Vote {
    private final ChoiceServiceMQ choiceServiceMQ;

    @Autowired
    public Vote(ChoiceServiceMQ choiceServiceMQ) {
        this.choiceServiceMQ = choiceServiceMQ;
    }

    @GetMapping
    public String hello() {
        return "Welcome to the API!";
    }

    @PostMapping
    public ResponseEntity<?> doVote(@RequestBody Choice choice) {
        System.out.println("Voted for: " + "'" +  choice.getChoice() + "'");
        choiceServiceMQ.send(choice);
        return ResponseEntity.ok(new VoteResponse("Vote successful"));
    }

}
