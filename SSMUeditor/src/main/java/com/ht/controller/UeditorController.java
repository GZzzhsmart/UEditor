package com.ht.controller;

import com.ht.bean.Ueditor;
import com.ht.service.UeditorService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("ueditor")
public class UeditorController {
    @Resource
    private UeditorService ueditorService;
    @RequestMapping("list")
    public ModelAndView ueditorList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ueditorList");
        modelAndView.addObject("ueditorList",ueditorService.pagelist());
        return modelAndView;
    }
    @RequestMapping("delete/{id}")
    @ResponseBody
    public String ueditorDelete(@PathVariable("id") String id){
        ueditorService.delete(id);
        return "ok";
    }
    @PostMapping("update")
    @ResponseBody
    public String ueditorDelete(Ueditor ueditor){
        System.out.println(ueditor.getId()+"===========");
        ueditorService.update(ueditor);
        return "ok";
    }
    @RequestMapping("find/{id}")
    public ModelAndView ueditorFind(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("ueditor",ueditorService.queryById(id));
        return modelAndView;
    }
    @RequestMapping("add")
    @ResponseBody
    public String ueditorAdd(Ueditor ueditor){
        ueditorService.add(ueditor);
        return "ok";
    }
    @RequestMapping("initAdd")
    public String initAdd(){
        return "addUeditor";
    }
    @RequestMapping("core")
    public String core(){
        return "ueditor/jsp/controller";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


}
