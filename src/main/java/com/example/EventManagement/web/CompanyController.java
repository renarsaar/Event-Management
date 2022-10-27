package com.example.EventManagement.web;

import com.example.EventManagement.common.primitives.Description;
import com.example.EventManagement.common.primitives.ParticipantId;
import com.example.EventManagement.common.primitives.PaymentType;
import com.example.EventManagement.company.*;
import com.example.EventManagement.event.EventId;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

/**
 * Web controller for Company use-cases.
 */
@Controller
@RequiredArgsConstructor
class CompanyController {
    private static final int MAX_RESULTS = 20;

    private final @NonNull FindCompanies companies;
    private final @NonNull CreateCompany createCompany;

    @GetMapping("/company/delete")
    public String delete(@RequestParam(name="companyId") String companyId, @RequestParam(name="eventId") String eventId) {
        ParticipantId id = new ParticipantId(companyId);

        companies.byId(id).deleteCompany(id);

        return "redirect:/event/" + eventId;
    }

    @PostMapping("/company")
    public String place(
            @RequestParam(name = "eventId") String eventId,
            @NonNull String legalName, @NonNull String registryCode, @NonNull int numberOfPartakers, @NonNull String companyPaymentType, @NonNull String description
    ) {
        UUID companyId = UUID.randomUUID();

        createCompany.createCompany(
                new ParticipantId(companyId),
                new EventId(eventId),
                new LegalName(legalName),
                new RegistryCode(registryCode),
                new NumberOfPartakers(numberOfPartakers),
                new PaymentType(companyPaymentType),
                new Description(description, 5000)
        );

        return "redirect:/event/" + eventId;
    }

    @GetMapping("/company/edit/{companyId}")
    public String edit(@PathVariable @NonNull String companyId, Model model) {
        Company company = companies.byId(new ParticipantId(companyId));
        Map<String, Object> companyData = toData(company);
        model.addAttribute(
                "company", companyData
        );

        return "company.html";
    }

    @PostMapping("/company/edit")
    public String update(
            @RequestParam(name = "companyId") String companyId,
            String legalName, String registryCode, int numberOfPartakers, String paymentType, String description
    ) {
        Company company = companies.byId(new ParticipantId(companyId));
        company.editCompany(
                new ParticipantId(companyId),
                new LegalName(legalName),
                new RegistryCode(registryCode),
                new NumberOfPartakers(numberOfPartakers),
                new PaymentType(paymentType),
                new Description(description, 5000)
        );

        return "redirect:/";
    }

    @GetMapping("/company/error")
    public String error(String message, Model model) {
        model.addAttribute("messageCode", message);

        return "new_participant_error.html";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    String exception(Exception ex) {
        return "redirect:/company/error?message=" + errorCode(ex);
    }

    private String errorCode(Exception e) {
        if (e instanceof IllegalArgumentException) {

            return e.getMessage();
        }

        return "Something went wrong creating a new participant";
    }

    private Map<String, Object> toData(Company company) {
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
}
