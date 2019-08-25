
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeck.hafidh.klinik.dao.impl;

import javax.transaction.Transactional;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Acer
 */
@Transactional
class HibernateUtil {
    @Autowired
    public SessionFactory sessionFactory;
    
    public org.hibernate.Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    protected org.hibernate.Query createQuery(String query){
        return getSession().createQuery(query);
    }

    protected SQLQuery createNativeQuery(String query){
        return getSession().createSQLQuery(query);
    }
    
}
