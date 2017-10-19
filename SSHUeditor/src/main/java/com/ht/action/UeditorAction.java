package com.ht.action;

import com.ht.pojo.Ueditor;
import com.ht.service.UeditorService;
import org.hibernate.criterion.DetachedCriteria;
import java.util.Date;
import java.util.List;


public class UeditorAction {
    private UeditorService ueditorService;

    public Ueditor getUeditor() {
        return ueditor;
    }

    public void setUeditor(Ueditor ueditor) {
        this.ueditor = ueditor;
    }

    private Ueditor ueditor;
    private List<Ueditor> ueditorList;

    public List<Ueditor> getUeditorList() {
        return ueditorList;
    }

    public void setUeditorList(List<Ueditor> ueditorList) {
        this.ueditorList = ueditorList;
    }

    public UeditorService getUeditorService() {
        return ueditorService;
    }

    public void setUeditorService(UeditorService ueditorService) {
        this.ueditorService = ueditorService;
    }
    public String delete(){
        ueditorService.delete(ueditor);
        return "ok";
    }
    public String add(){
        ueditor.setCreateTime(new Date());
        ueditorService.add(ueditor);
        return  "add";
    }
    public String find(){
        System.out.println(ueditor.getId()+"======");
        ueditor = ueditorService.queryById(ueditor.getId()+"");
        return "find";

    }
    public String update(){
        System.out.println(ueditor.getContent()+"=====");
        ueditorService.update(ueditor);
        return "update";
    }
    public String list(){
        DetachedCriteria dc = DetachedCriteria.forClass(Ueditor.class);
        ueditorList = ueditorService.pagelist(dc,0,0);
        return "list";

    }
}
