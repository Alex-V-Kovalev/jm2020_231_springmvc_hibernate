package application.springmvc_hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping(value = "/")
    public String getUsersPage() {
        return "users-view";
    }

    @RequestMapping(value = "/edit")
    public String getEditUserPage() {
        return "user-edit-page";
    }
}
