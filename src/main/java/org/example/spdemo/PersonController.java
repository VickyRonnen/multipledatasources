package org.example.spdemo;

import org.example.spdemo.primary.PersonRepository1;
import org.example.spdemo.secondary.PersonRepository2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository1 primaryRepository;

    private final PersonRepository2 secondaryRepository;

    public PersonController(PersonRepository1 primaryRepository, PersonRepository2 secondaryRepository) {
        this.primaryRepository = primaryRepository;
        this.secondaryRepository = secondaryRepository;
    }

    @GetMapping
    public String listPersons(Model model) {
        List<org.example.spdemo.primary.Person> primaryPersons = primaryRepository.findAll();
        List<org.example.spdemo.secondary.Person> secondaryPersons = secondaryRepository.findAll();

        model.addAttribute("primaryPersons", primaryPersons);
        model.addAttribute("secondaryPersons", secondaryPersons);
        return "persons/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("primaryPerson", new org.example.spdemo.primary.Person());
        model.addAttribute("secondaryPerson", new org.example.spdemo.secondary.Person());
        return "persons/add";
    }

    @PostMapping("/add/primary")
    public String addToPrimary(@ModelAttribute org.example.spdemo.primary.Person person) {
        primaryRepository.save(person);
        return "redirect:/persons";
    }

    @PostMapping("/add/secondary")
    public String addToSecondary(@ModelAttribute org.example.spdemo.secondary.Person person) {
        secondaryRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/primary/{id}")
    public String showEditPrimaryForm(@PathVariable String id, Model model) {
        Optional<org.example.spdemo.primary.Person> person = primaryRepository.findById(id);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
            model.addAttribute("database", "primary");
            return "persons/edit";
        }
        return "redirect:/persons";
    }

    @GetMapping("/edit/secondary/{id}")
    public String showEditSecondaryForm(@PathVariable String id, Model model) {
        Optional<org.example.spdemo.secondary.Person> person = secondaryRepository.findById(id);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
            model.addAttribute("database", "secondary");
            return "persons/edit";
        }
        return "redirect:/persons";
    }

    @PostMapping("/edit/primary")
    public String updatePrimary(@ModelAttribute org.example.spdemo.primary.Person person) {
        primaryRepository.save(person);
        return "redirect:/persons";
    }

    @PostMapping("/edit/secondary")
    public String updateSecondary(@ModelAttribute org.example.spdemo.secondary.Person person) {
        secondaryRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/primary/{id}")
    public String deletePrimary(@PathVariable String id) {
        primaryRepository.deleteById(id);
        return "redirect:/persons";
    }

    @GetMapping("/delete/secondary/{id}")
    public String deleteSecondary(@PathVariable String id) {
        secondaryRepository.deleteById(id);
        return "redirect:/persons";
    }

    @GetMapping("/procedures")
    public String showProcedures(Model model) {
        try {
            Integer primaryCount = primaryRepository.getPersonCount();
            Integer primaryCount2 = primaryRepository.getPersonCount2();
            Integer secondaryCount = secondaryRepository.getPersonCount();
            Integer secondaryCount2 = secondaryRepository.getPersonCount2();

            model.addAttribute("primaryCount", primaryCount);
            model.addAttribute("primaryCount2", primaryCount2);
            model.addAttribute("secondaryCount", secondaryCount);
            model.addAttribute("secondaryCount2", secondaryCount2);
        } catch (Exception e) {
            model.addAttribute("error", "Error executing procedures: " + e.getMessage());
        }
        return "persons/procedures";
    }
}
