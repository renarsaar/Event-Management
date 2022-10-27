package com.example.EventManagement.web;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.company.Companies;
import com.example.EventManagement.company.Company;
import com.example.EventManagement.company.FindCompaniesFromEvent;
import com.example.EventManagement.event.*;
import com.example.EventManagement.person.FindPersonsFromEvent;
import com.example.EventManagement.person.Person;
import com.example.EventManagement.person.Persons;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Web controller for Event use-cases.
 */
@Controller
@RequiredArgsConstructor
class EventController {
    private static final int MAX_RESULTS = 20;

    private final @NonNull FindEvents events;
    private final @NonNull FindCompaniesFromEvent companiesFromEvent;
    private final @NonNull FindPersonsFromEvent personsFromEvent;
    private final @NonNull CreateEvent createEvent;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", events.all()
                .range(MAX_RESULTS).stream()
                .map(this::toData)
                .toArray());

        return "events";
    }

    @GetMapping("/event/{eventId}")
    public String event(@PathVariable @NonNull String eventId, Model model) {
        EventId id = new EventId(eventId);
        Event event = events.byId(id);
        Map<String, Object> eventData = toData(event);

        Companies companies = companiesFromEvent.byEventId(id);
        Persons persons = personsFromEvent.byEventId(id);

        model.addAttribute("event", eventData);
        model.addAttribute("companies", companies
                .range(MAX_RESULTS).stream()
                .map(this::companyToData)
                .toArray());
        model.addAttribute("persons", persons
                .range(MAX_RESULTS).stream()
                .map(this::personToData)
                .toArray());

        return "event.html";
    }

    @PostMapping("/event")
    public String place(
            @NonNull String name, String time, String location, String description,
            HttpServletRequest request, HttpServletResponse response
    ) {
        UUID eventId = UUID.randomUUID();

        createEvent.createEvent(new EventId(eventId), new Name(name), new EventTime(time), new EventLocation(location), new Description(description, 5000));

        return "redirect:/";
    }

    @GetMapping("/event/delete")
    public String delete(@RequestParam(name="eventId")String eventId) {
        EventId id = new EventId(eventId);

        events.byId(id).deleteEvent(id);

        return "redirect:/";
    }

    @GetMapping("/event/create")
    public String newEvent() {
        return "new_event.html";
    }

    @GetMapping("/event/error")
    public String error(String message, Model model) {
        model.addAttribute("messageCode", message);

        return "new_event_error.html";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    String exception(Exception ex) {
        return "redirect:/event/error?message=" + errorCode(ex);
    }

    private Map<String, Object> toData(Event event) {
        return Map.of(
                "id", event.id().value(),
                "name", event.name().value(),
                "event_time", event.eventTime().value(),
                "event_location", event.eventLocation().value(),
                "description", event.description().value()
        );
    }

    private Map<String, Object> companyToData(Company company) {
        return Map.of(
                "id", company.participantId().value(),
                "event_id", company.eventId().value(),
                "legal_name", company.legalName().value(),
                "registry_code", company.registryCode().value(),
                "number_of_partakers", company.numberOfPartakers().value(),
                "payment_type", company.paymentType().value(),
                "description", company.description().value()
        );
    }

    private Map<String, Object> personToData(Person person) {
        return Map.of(
                "id", person.participantId().value(),
                "event_id", person.eventId().value(),
                "first_name", person.firstName().value(),
                "last_name", person.lastName().value(),
                "personal_code", person.personalCode().value(),
                "payment_type", person.paymentType().value(),
                "description", person.description().value()
        );
    }

    private String errorCode(Exception e) {
        if (e instanceof IllegalArgumentException) {

            return e.getMessage();
        }

        return "default";
    }
}
