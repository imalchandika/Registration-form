package lk.ijse.dep.rest.service;

import lk.ijse.dep.rest.dto.DetailDTO;
import lk.ijse.dep.rest.entity.DetailEntity;

public interface LoginService {

    public String logout();

    public String login(DetailDTO detail)throws Exception;

    public DetailDTO getData(String name) throws Exception;
}
