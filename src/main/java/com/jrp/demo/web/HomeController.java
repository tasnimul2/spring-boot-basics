package com.jrp.demo.web;

import com.jrp.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("formData",new User());
        return "index";
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public String processFormData(User user, RedirectAttributes redirectAttributes){
        // Do whatever you need to need to do with the user data, for example :
        System.out.println("Name: " + user.getFullName() + " Gender: " + user.getGender() );
        //now, pass the user object to the redirect:
        redirectAttributes.addFlashAttribute("user",user);
        return "redirect:/display";
    }

    @RequestMapping(value="/display",method=RequestMethod.GET)
    public String displayFormData(User user){
        return "result";
    }
}
