/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeck.hafidh.klinik.dao.LoginDao;
import projeck.hafidh.klinik.dto.LoginDto;
import projeck.hafidh.klinik.model.LoginModel;
import projeck.hafidh.klinik.service.LoginService;

/**
 *
 * @author Acer
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;
    
    @Override
    public LoginDto getListDataUserLogin(LoginDto fromDto) throws Exception {
        List<LoginModel> datalist=loginDao.getlistlogin(fromDto);
        LoginDto usrDto = new LoginDto();
        
        try {
            usrDto.setListDataUser(loginDao.getlistlogin(fromDto));
            if(datalist != null){
            for (LoginModel ddm : datalist) {       
                if(ddm.getUsername()!= null){
                    usrDto.setUsername(ddm.getUsername());
                }
                if(ddm.getPassword()!= null){
                    usrDto.setPassword(ddm.getPassword());
                }
                if(ddm.getStatus() != null){
                    usrDto.setStatus(ddm.getStatus()
                    );
                }
                
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usrDto;
    }
    
}
