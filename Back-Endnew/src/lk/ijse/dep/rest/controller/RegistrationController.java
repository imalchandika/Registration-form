package lk.ijse.dep.rest.controller;

import lk.ijse.dep.rest.dto.DetailDTO;
import lk.ijse.dep.rest.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
@CrossOrigin
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping
    public String getRegistration(){
        return "OKK";
    }

    @PostMapping
    public String PublicRouts(@RequestBody DetailDTO detail) throws Exception {
        return registrationService.register(detail);
    }
}
