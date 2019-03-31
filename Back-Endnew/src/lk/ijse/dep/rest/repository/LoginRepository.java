package lk.ijse.dep.rest.repository;

import lk.ijse.dep.rest.entity.DetailEntity;

public interface LoginRepository {

    public String logout();

    public String login(DetailEntity detail)throws Exception;

    public DetailEntity getData(String name) throws Exception;
}
