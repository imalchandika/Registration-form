package lk.ijse.dep.rest.service.custom;


import lk.ijse.dep.rest.dto.DetailDTO;
import lk.ijse.dep.rest.entity.DetailEntity;
import lk.ijse.dep.rest.repository.RegistrationRepository;
import lk.ijse.dep.rest.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public String register(DetailDTO detail)throws Exception{


        return registrationRepository.register(new DetailEntity(detail.getEmail(),
                detail.getFirstName(),
                detail.getLastName(),
                detail.getMobileNo(),
                detail.getGender(),
                detail.getDob(),
                detail.getPassWord()));

    }

}
