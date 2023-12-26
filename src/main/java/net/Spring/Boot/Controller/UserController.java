package net.Spring.Boot.Controller;

import net.Spring.Boot.Model.User;
import net.Spring.Boot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user", produces = "text/html; charset=UTF-8")
    public String carList(Model model) {
        List<User> users = userService.displayAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/addNewUser", produces = "text/html; charset=UTF-8")
    public String newCar(Model model) {
        model.addAttribute("user", new User());
        return "addNewUser";
    }

    @PostMapping(value = "/addNewUser", produces = "text/html; charset=UTF-8")
    public String create(User user) {
        userService.addNewUser(user);
        return "redirect:/user";
    }
//    @GetMapping(value = "show",produces = "text/html; charset=UTF-8")
//    public String show (@RequestParam int id, Model model){
//        model.addAttribute("user", userService.getUserById(id));
//        return "show";
//    }
//
    @GetMapping(value = "/Update-User" ,produces = "text/html; charset=UTF-8")
    public String userUpdateForm(@RequestParam Long id , Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "/Update-User";
    }
    @PostMapping(value = "/Update-User",produces = "text/html; charset=UTF-8")
    public String  userUpdate(User user){
        userService.addNewUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id , Model model) {
        userService.deleteUser(id);
        return "redirect:user";

    }
}
