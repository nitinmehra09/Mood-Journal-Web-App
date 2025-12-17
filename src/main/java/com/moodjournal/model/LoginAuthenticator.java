package com.moodjournal.model;

import com.moodjournal.db.DBConnector;
import com.moodjournal.dto.UserDTO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nitin Mehra
 */
public class LoginAuthenticator
{
    public boolean isLogin(UserDTO user)
    {
        String email = user.getEmail();
        String password = user.getPassword();
        String tablePassword="";

        try
        {
            String query = "SELECT id,password FROM user WHERE email='"+email+"'";
            Connection con = DBConnector.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next())
            {
                tablePassword = rs.getString("password");
                user.setId(rs.getInt("id"));
            }
            else
            {
                return false;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return password != null && password.equals(tablePassword);
    }
}