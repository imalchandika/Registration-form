package lk.ijse.dep.rest.repository.impl;

import lk.ijse.dep.rest.connection.DBConnection;
import lk.ijse.dep.rest.entity.DetailEntity;
import lk.ijse.dep.rest.repository.RegistrationRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {



    public String register(DetailEntity detail)throws Exception{

        System.out.println(detail.getDob());
        System.out.println(detail.getGender());
//       Class.forName("com.mysql.jdbc.Driver");
//       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "mysqlroot");
        //connection.setAutoCommit(false);
        Connection connection = DBConnection.getConnection();

        PreparedStatement pst1 = connection.prepareStatement("select  * from detail where email=?");
        pst1.setObject(1,detail.getEmail());

        ResultSet resultSet = pst1.executeQuery();
        if(resultSet.next()){
            return "User exists";
        }else {


            PreparedStatement pst = connection.prepareStatement("insert into detail VALUES (?,?,?,?,?,?,?,?)");
            pst.setObject(1, null);
            pst.setObject(2, detail.getEmail());
            pst.setObject(3, detail.getFirstName());
            pst.setObject(4, detail.getLastName());
            pst.setObject(5, detail.getMobileNo());
            pst.setObject(6, detail.getGender());
            pst.setObject(7, detail.getDob());
            pst.setObject(8, detail.getPassWord());

            int i = pst.executeUpdate();
            if (i > 0) {
                // connection.commit();
                return "All IS well";
            } else {
                //connection.rollback();
                return "NOT WELL";
            }


        }




    }


}
