/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dto;

import java.util.List;
import projeck.hafidh.klinik.model.LoginModel;

/**
 *
 * @author Acer
 */
public class LoginDto {
     String username,password,status;
     List<LoginModel> listDataUser;

    public List<LoginModel> getListDataUser() {
        return listDataUser;
    }

    public void setListDataUser(List<LoginModel> listDataUser) {
        this.listDataUser = listDataUser;
    }
   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
    
}
