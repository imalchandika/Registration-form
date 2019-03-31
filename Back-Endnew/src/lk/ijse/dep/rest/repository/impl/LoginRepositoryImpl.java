package lk.ijse.dep.rest.repository.impl;


import lk.ijse.dep.rest.entity.DetailEntity;
import lk.ijse.dep.rest.repository.LoginRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public String logout() {
        return "logout";
    }

    @Override
    public String login(DetailEntity detail)throws Exception{
        System.out.println(detail.getEmail());
        System.out.println(detail.getPassWord());
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "mysqlroot");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from detail where email=? and passWord=? ");
        preparedStatement.setObject(1,detail.getEmail());
        preparedStatement.setObject(2,detail.getPassWord());

        ResultSet rst = preparedStatement.executeQuery();

        if(rst.next()){
            return "Login successful";
        }else{
            return "Incorrect credentials";
        }

    }

    @Override
    public DetailEntity getData(String name) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "mysqlroot");
        //connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from detail where email=?");
        preparedStatement.setObject(1,name);

        ResultSet rst = preparedStatement.executeQuery();
        if (rst.next()){
            return new DetailEntity(rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8));
        }else {
            return null;
        }
    }


}
