package com.ht.controller;

import com.ht.pojo.Ueditor;
import com.ht.service.UeditorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


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
    @RequestMapping("update")
    @ResponseBody
    public String ueditorDelete(Ueditor ueditor){
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


}
