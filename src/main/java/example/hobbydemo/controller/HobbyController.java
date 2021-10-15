package example.hobbydemo.controller;

import example.hobbydemo.model.Hobby;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class HobbyController {
    @GetMapping("/hobies")
    public String getHobby(Model model) {
        return "hobby";
    }
    @GetMapping("/hobies/{id}")
    public String getHobby(@PathVariable int id, Model model) {
        return "hobby";
    }
}
