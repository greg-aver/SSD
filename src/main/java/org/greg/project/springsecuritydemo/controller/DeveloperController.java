package org.greg.project.springsecuritydemo.controller;


import org.greg.project.springsecuritydemo.model.Developer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
//@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {
    List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Hui", "Huimov"),
            new Developer(2L, "Abram", "Rezerferd"),
            new Developer(3L, "Shlomo", "Rerdec")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
