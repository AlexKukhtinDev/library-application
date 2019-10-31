package mate.academy.spring.controller;

import mate.academy.spring.dto.UserDto;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RoleService;
import mate.academy.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private static final String ROLE_USER = "USER";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public String addUserPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute @Valid UserDto userDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "User creating error");
            return "registration";
        }
        userService.add(dtoToEntity(userDto));
        return "login";
    }

    private User dtoToEntity(UserDto userDto) {
        User newUser = new User();
        newUser.setName(userDto.getFirstName());
        newUser.setSurname(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setUsername(userDto.getUserName());
        newUser.setPassword(userDto.getPassword());

        Role role = roleService.getRoleByName(ROLE_USER).get();
        newUser.getRoles().add(role);
        return newUser;
    }
}
