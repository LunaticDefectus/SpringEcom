package defectus.com.springecom.web;

import defectus.com.springecom.dao.entities.User;
import defectus.com.springecom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        if ("admin@gmail.com".equals(email) && "admin123".equals(password)) {
            return "redirect:/productsManagement";
        } else {
            Integer userId = userService.IsValidUser(email, password);
            if (userId != null) {
                return "redirect:/home";
            } else {
                redirectAttributes.addFlashAttribute("error", "L'email ou le mot de passe est incorrect");
                return "redirect:/login";
            }
        }
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("User") User new_user) {
        userService.register(new_user);
        return "redirect:/login";


    }
    @GetMapping("/clientmanagement")
    public String listeClients(Model model) {
        List<User> userlist = userService.getAllUsers();
        model.addAttribute("clientmanagement", userlist);
        return "ClientsManagement";
    }



    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/clientmanagement";
    }
}