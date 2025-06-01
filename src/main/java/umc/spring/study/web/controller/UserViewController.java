package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
<<<<<<< Updated upstream
=======
import org.springframework.ui.Model;
>>>>>>> Stashed changes
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.spring.study.service.UserService.UserCommandService;
import umc.spring.study.web.dto.UserRequestDTO;
<<<<<<< Updated upstream
import org.springframework.ui.Model;
=======
>>>>>>> Stashed changes

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserCommandService userCommandService;

    @PostMapping("/user/signup")
    public String joinUser(@ModelAttribute("userJoinDto") UserRequestDTO.JoinDto request,
<<<<<<< Updated upstream
                           BindingResult bindingResult,
                           Model model) {

        if (bindingResult.hasErrors()) {

=======
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
>>>>>>> Stashed changes
            return "signup";
        }

        try {
            userCommandService.joinUser(request);
            return "redirect:/login";
        } catch (Exception e) {
<<<<<<< Updated upstream
            e.printStackTrace();
            System.out.println("회원가입 실패: " + e.getMessage());
            model.addAttribute("error", "회원가입 중 오류 발생: " + e.getMessage());
=======
            model.addAttribute("error", e.getMessage());
>>>>>>> Stashed changes
            return "signup";
        }
    }

<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userJoinDto", new UserRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}