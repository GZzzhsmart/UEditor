package com.ht.servlet;

import com.ht.bean.Ueditor;
import com.ht.sqlbase.SqlInterfaceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
//1、jsp+servlet+ueditor+mysql
//        2、采用最原始的方式实现ueditor的编辑文章实先增删改查

public class UeditorServlet extends HttpServlet {

    SqlInterfaceImpl sql = new SqlInterfaceImpl();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order = request.getParameter("order");
        if(order.equals("list")){
            List<Ueditor> ueditorList = sql.pageList();
            request.setAttribute("ueditorList",ueditorList);
            request.getRequestDispatcher("/uediorList.jsp").forward(request,response);
        }else if(order.equals("add")){
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Ueditor ueditor = new Ueditor();
            ueditor.setContent(content);
            ueditor.setTitle(title);
            sql.add(ueditor);
            request.getRequestDispatcher("/uediorList.jsp").forward(request,response);
        }else if(order.equals("find")){
            Ueditor ueditor = sql.find(request.getParameter("id"));
            request.setAttribute("ueditor",ueditor);
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        }else if(order.equals("update")){
            Ueditor ueditor = new Ueditor();
            ueditor.setId(Integer.parseInt(request.getParameter("id").toString()));
            ueditor.setTitle(request.getParameter("title"));
            ueditor.setContent(request.getParameter("content"));
            sql.update(ueditor);
            request.getRequestDispatcher("/uediorList.jsp").forward(request,response);
        }else if(order.equals("delete")){
            PrintWriter out = response.getWriter();
            sql.delete(request.getParameter("id"));
            out.print("ok");
            request.getRequestDispatcher("/uediorList.jsp").forward(request,response);
        }
    }
}
