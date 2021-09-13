package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;
import java.security.Principal;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public String show(Principal principal, Model model) {
        model.addAttribute("user", service.getUserByUsername(principal.getName()));
        return "info";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("users", service.showAllUsers());
        return "admin";
    }

    @GetMapping("/admin/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/admin/save")
    public String create(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/edit")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "edit";
    }

    @PatchMapping("/admin/update")
    public String update(@ModelAttribute("user") User user) {
        service.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") long id) {
        service.deleteUser(id);
        return "redirect:/admin";
    }

}


