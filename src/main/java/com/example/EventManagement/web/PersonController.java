package com.example.EventManagement.web;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.person.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

/**
 * Web controller for Person use-cases.
 */
@Controller
@RequiredArgsConstructor
class PersonController {
    private static final int MAX_RESULTS = 20;

    private final @NonNull FindPersons persons;
    private final @NonNull CreatePerson createPerson;

    @GetMapping("/person/delete")
    public String delete(@RequestParam(name = "personId") String personId, @RequestParam(name = "eventId") String eventId) {
        ParticipantId id = new ParticipantId(personId);

        persons.byId(id).deletePerson(id);

        return "redirect:/event/" + eventId;
    }

    @PostMapping("/person")
    public String place(
        @RequestParam(name = "eventId") String eventId,
        @NonNull String firstName, @NonNull String lastName, @NonNull String personalCode, @NonNull String paymentType, @NonNull String description
    ) {
        UUID personId = UUID.randomUUID();

        createPerson.createPerson(
                new ParticipantId(personId),
                new EventId(eventId),
                new FirstName(firstName),
                new LastName(lastName),
                new PersonalCode(personalCode),
                new PaymentType(paymentType),
                new Description(description, 1500)
        );

        return "redirect:/event/" + eventId;
    }

    @GetMapping("/person/error")
    public String error(String message, Model model) {
        model.addAttribute("messageCode", message);

        return "new_participant_error.html";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    String exception(Exception ex) {
        return "redirect:/person/error?message=" + errorCode(ex);
    }

    private String errorCode(Exception e) {
        if (e instanceof IllegalArgumentException) {

            return e.getMessage();
        }

        return "Something went wrong creating a new participant";
    }
}
