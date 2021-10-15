package example.hobbydemo.controller;

import example.hobbydemo.model.Hobby;
import example.hobbydemo.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Random;

@Controller
public class HobbyController {

    @Autowired
    HobbyRepository hobbyRepository;

    @GetMapping("/hobies")
    public String getHobby(Model model) {
        model.addAttribute("hobbies", hobbyRepository.findAll());

        return "hobby";
    }


    @GetMapping("/randomhobby")
    public String getRandomHobby(Model model) {

        Random rand = new Random();

        long randomID = rand.nextLong();

        Optional<Hobby> found = hobbyRepository.findById(randomID);

        if (found.isPresent()) {
            model.addAttribute("hobby", found.get());
        } else {
            model.addAttribute("hobby", new Hobby(0, "not found", "Hobby not found!"));
        }


        return "single_hobby";
    }

    @GetMapping("/hobby")
    public String createHobby(Model model) {

        model.addAttribute("add_model", new Hobby());

        return "add_model";
    }

    @PostMapping("/addhobby")
    public ModelAndView addHobby(@ModelAttribute Hobby hobby) {
        hobbyRepository.save(hobby);

        return new ModelAndView("hobby", "hobbies", hobbyRepository.findAll());
    }



}
