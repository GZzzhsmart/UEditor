package com.ht.serviceimpl;

import com.ht.dao.UeditorDAO;
import com.ht.pojo.Ueditor;
import com.ht.service.UeditorService;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;


public class UeditorServiceimpl implements UeditorService {
    private UeditorDAO ueditorDAO;

    public UeditorDAO getUeditorDAO() {
        return ueditorDAO;
    }

    public void setUeditorDAO(UeditorDAO ueditorDAO) {
        this.ueditorDAO = ueditorDAO;
    }

    public Ueditor queryById(String id) {
        return ueditorDAO.queryById(id);
    }

    public void update(Ueditor ueditor) {
        ueditorDAO.update(ueditor);
    }

    public void add(Ueditor ueditor) {
        ueditorDAO.add(ueditor);
    }

    public int count(String column, String ifvalue) {
        return 0;
    }

    public void delete(Ueditor ueditor) {
        ueditorDAO.delete(ueditor);
    }

    public List<Ueditor> pagelist(DetachedCriteria dc, int startpage, int pagesize) {
        return ueditorDAO.pagelist(dc,startpage,pagesize);
    }
}
