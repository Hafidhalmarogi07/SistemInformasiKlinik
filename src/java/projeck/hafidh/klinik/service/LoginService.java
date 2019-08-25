/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service;

import projeck.hafidh.klinik.dto.LoginDto;

/**
 *
 * @author Acer
 */
public interface LoginService {
    public LoginDto getListDataUserLogin(LoginDto usrDto)throws Exception;  
}
