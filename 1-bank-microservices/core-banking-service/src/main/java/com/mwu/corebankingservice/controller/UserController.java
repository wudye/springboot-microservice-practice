package com.mwu.corebankingservice.controller;


import com.mwu.corebankingservice.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MessageSource messageSource;

    @GetMapping("/greet")
    public ResponseEntity<String> greetUser(@RequestParam("name") String name) {
        String message = messageSource.getMessage("greeting.message", new Object[]{name}, LocaleContextHolder.getLocale());
        return ResponseEntity.ok(message);
    }

    @GetMapping(value = "/{identification}")
    public ResponseEntity readUser(@PathVariable("identification") String identification) {
        return ResponseEntity.ok(userService.readUser(identification));
    }
   // Pageable pageable = PageRequest.of(0, 10, Sort.by("lastName").ascending());

    @GetMapping
    public ResponseEntity readUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.readUsers(pageable));
    }

}
