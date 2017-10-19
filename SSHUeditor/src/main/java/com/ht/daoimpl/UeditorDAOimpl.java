package com.ht.daoimpl;

import com.ht.dao.UeditorDAO;
import com.ht.pojo.Ueditor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class UeditorDAOimpl implements UeditorDAO {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ueditor queryById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Ueditor ueditor = (Ueditor) session.get(Ueditor.class,Integer.parseInt(id));
        return ueditor;
    }

    public void update(Ueditor ueditor) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(ueditor);
    }

    public void add(Ueditor ueditor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(ueditor);
    }

    public int count(String column, String ifvalue) {
        return 0;
    }

    public void delete(Ueditor ueditor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(ueditor);
    }

    public List<Ueditor> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
        Session session = sessionFactory.getCurrentSession();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Ueditor.class);
        Criteria criteria = detachedCriteria.getExecutableCriteria(session);
        return criteria.list();
    }
}
