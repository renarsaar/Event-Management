package com.example.EventManagement.web;

import com.example.EventManagement.event.FindEvents;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

/**
 * Configuration for Portal Web.
 */
@Configuration
public class PortalWebConfig {
    /**
     * Web Layout Advice for Portal.
     * <p>
     * Adds a list of Event items into the layout model.
     */

    @ControllerAdvice(basePackageClasses = PortalWebConfig.class)
    @RequiredArgsConstructor
    class WebLayoutAdvice {
        private final @NonNull FindEvents findEvents;

        @ModelAttribute
        public void decorateWithEvents(Model model) {
            model.addAttribute("events", findEvents.all().stream()
                    .map(event -> Map.of(
                        "name", event.name().value(),
                        "eventTime", event.eventTime().value(),
                        "eventLocation", event.eventLocation().value(),
                        "description", event.description().value()))
                    .toArray());
        }
    }
}
