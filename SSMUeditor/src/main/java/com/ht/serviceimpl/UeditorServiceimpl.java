package com.ht.serviceimpl;

import com.ht.dao.UeditorDAO;
import com.ht.pojo.Ueditor;
import com.ht.service.UeditorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chenfeilong on 2017/10/18.
 */
@Service
public class UeditorServiceimpl implements UeditorService {
    @Resource
    private UeditorDAO ueditorDAO;
    @Override
    public Ueditor queryById(String id) {
        return ueditorDAO.queryById(id);
    }

    @Override
    public void update(Ueditor ueditor) {
        ueditorDAO.update(ueditor);
    }

    @Override
    public void add(Ueditor ueditor) {
        ueditorDAO.add(ueditor);
    }

    @Override
    public void delete(String id) {
        ueditorDAO.delete(id);
    }

    @Override
    public List<Ueditor> pagelist() {
        return ueditorDAO.pagelist();
    }

    @Override
    public int count() {
        return ueditorDAO.count();
    }
}
