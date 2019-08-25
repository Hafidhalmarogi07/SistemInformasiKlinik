/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao;

import java.util.List;
import projeck.hafidh.klinik.dto.LoginDto;
import projeck.hafidh.klinik.model.LoginModel;

/**
 *
 * @author Acer
 */
public interface LoginDao {
    public List<LoginModel> getlistlogin(LoginDto loginDto) throws Exception;
}
