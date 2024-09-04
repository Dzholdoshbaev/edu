package dzholdoshbaev.laboratory.controller;



import dzholdoshbaev.laboratory.dto.UsersDto;
import dzholdoshbaev.laboratory.model.Users;
import dzholdoshbaev.laboratory.service.AuthoritiesService;
import dzholdoshbaev.laboratory.service.UsersService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;



@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UsersService usersService;
    private final AuthoritiesService authoritiesService;


    @GetMapping
    public String profile(Model model, Principal principal) {
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        model.addAttribute("userDto", user);
        return "auth/profile";
    }


    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute @Valid UsersDto usersDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "auth/register";
        }

        usersService.createUser(usersDto);
        return "redirect:/auth/login";
    }


    @GetMapping("/register")
    public String create(Model model) {
        model.addAttribute("usersDto", new UsersDto());
        return "auth/register";
    }


}
