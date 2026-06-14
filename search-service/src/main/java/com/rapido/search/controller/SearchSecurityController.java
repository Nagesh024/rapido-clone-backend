package com.rapido.search.controller;

import com.rapido.search.service.RateLimiterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchSecurityController {

    private final RateLimiterService service;

    public SearchSecurityController(
            RateLimiterService service) {
        this.service = service;
    }

    @GetMapping("/search/protected")
    public String protectedSearch(
            HttpServletRequest request) {

        String ip =
                request.getRemoteAddr();

        if (!service.allowRequest(ip)) {

            return "Rate Limit Exceeded";
        }

        return "Search Request Allowed";
    }
}