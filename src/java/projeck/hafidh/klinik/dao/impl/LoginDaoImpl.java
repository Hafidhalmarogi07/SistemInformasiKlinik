/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import java.util.List;
import org.hibernate.Query;
import projeck.hafidh.klinik.dao.LoginDao;
import projeck.hafidh.klinik.dto.LoginDto;
import projeck.hafidh.klinik.model.LoginModel;

/**
 *
 * @author Acer
 */
public class LoginDaoImpl extends HibernateUtil implements LoginDao{

   
    @Override
    public List<LoginModel> getlistlogin(LoginDto loginDto) throws Exception {
        String sql = null;
	List<LoginModel> listLogin = null;
	try {
            sql = "select model from LoginModel model where username=:user and password=:pass";
		Query query = createQuery(sql).setParameter("user", loginDto.getUsername());
		query.setParameter("pass", loginDto.getPassword());
		listLogin = query.list();
	} catch (Exception e) {
            // TODO: handle exception
	}
	return listLogin;
    }
    
}
