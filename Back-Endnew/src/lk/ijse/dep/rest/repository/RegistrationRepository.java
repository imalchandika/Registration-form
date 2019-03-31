package lk.ijse.dep.rest.repository;

import lk.ijse.dep.rest.entity.DetailEntity;

public interface RegistrationRepository {

    public String register(DetailEntity detail)throws Exception;
}
