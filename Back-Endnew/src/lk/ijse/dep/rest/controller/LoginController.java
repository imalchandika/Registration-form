package lk.ijse.dep.rest.controller;

import lk.ijse.dep.rest.dto.DetailDTO;
import lk.ijse.dep.rest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String authLogin(@ModelAttribute DetailDTO detail) throws Exception {
        return loginService.login(detail);
        //return "imal"+detail.getEmail();
    }

    @PostMapping("/logout")
    public String authLogout() throws Exception {
        return loginService.logout();
    }

    @GetMapping ("/getdata/{name}")
    public DetailDTO getData(@PathVariable String name) throws Exception {
        return loginService.getData(name);
    }
}
