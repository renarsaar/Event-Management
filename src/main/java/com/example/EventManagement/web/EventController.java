package com.example.EventManagement.web;

import com.example.EventManagement.company.Companies;
import com.example.EventManagement.company.FindCompaniesFromEvent;
import com.example.EventManagement.event.Event;
import com.example.EventManagement.event.EventId;
import com.example.EventManagement.event.FindEvents;
import com.example.EventManagement.person.FindPersonsFromEvent;
import com.example.EventManagement.person.Persons;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.Map;

/**
 * Web controller for Event use-cases.
 */
@Controller
@RequiredArgsConstructor
class EventController {
    private static final int MAX_RESULTS = 10;

    private final @NonNull FindEvents events;
    private final @NonNull FindCompaniesFromEvent companiesFromEvent;
    private final @NonNull FindPersonsFromEvent personsFromEvent;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", events.all()
                .range(MAX_RESULTS).stream()
                .map(this::toData)
                .toArray());

        System.out.println(
                Arrays.toString(events.all().range(10).stream().map(this::toData).toArray())
        );

        return "events";
    }

    @GetMapping("/event/{eventId}")
    public String event(@PathVariable @NonNull EventId eventId, Model model) {
        Companies companies = companiesFromEvent.byEventId(eventId);
        Persons persons = personsFromEvent.byEventId(eventId);

        System.out.println(companies);
        System.out.println(persons);

        // model.addAttribute("events", events.byId(eventId));

        return "event/{eventId}";
    }

    private Map<String, Object> toData(Event event) {
        return Map.of(
                "id", event.id(),
                "name", event.name().value(),
                "eventTime", event.eventTime().value(),
                "eventLocation", event.eventLocation().value(),
                "description", event.description().value()
        );
    }
}
