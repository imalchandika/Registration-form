package lk.ijse.dep.rest.service.custom;

import lk.ijse.dep.rest.dto.DetailDTO;
import lk.ijse.dep.rest.entity.DetailEntity;
import lk.ijse.dep.rest.repository.LoginRepository;
import lk.ijse.dep.rest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public String logout() {
      return loginRepository.logout();
    }

    @Override
    public String login(DetailDTO detail)throws Exception{
        return loginRepository.login(new DetailEntity(detail.getEmail(),
                detail.getFirstName(),
                detail.getLastName(),
                detail.getMobileNo(),
                detail.getGender(),
                detail.getDob(),
                detail.getPassWord()));
    }

    @Override
    public DetailDTO getData(String name) throws Exception {

        DetailEntity detail = loginRepository.getData(name);

        return new DetailDTO(detail.getEmail(),
                detail.getFirstName(),
                detail.getLastName(),
                detail.getMobileNo(),
                detail.getGender(),
                detail.getDob(),
                detail.getPassWord());
    }


}
