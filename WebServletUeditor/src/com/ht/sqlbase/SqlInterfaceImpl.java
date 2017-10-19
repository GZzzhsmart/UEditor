package com.ht.sqlbase;

import com.ht.bean.Ueditor;
import com.ht.sqlcon.MysqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlInterfaceImpl implements SqlInterface{
    Connection connection = MysqlConnection.beginConnection();
    @Override
    public void add(Ueditor ueditor) {
        try{
            Statement statement = connection.createStatement();
            String sql = "insert into ueditor(title,content) VALUES ('"+ueditor.getTitle()+"','"+ueditor.getContent()+"')";
            System.out.println("新增："+sql);
            statement.execute(sql);
            statement.close();
        }catch (Exception e){
            System.out.println("新增数据出错！");
        }

    }

    @Override
    public void delete(String id) {
        try{
            Statement statement = connection.createStatement();
            String sql = "delete from ueditor where id="+id;
            System.out.println("删除："+sql);
            statement.execute(sql);
            statement.close();
        }catch (Exception e){
            System.out.println("删除数据出错！");
        }
    }

    @Override
    public void update(Ueditor ueditor) {
        try{
            Statement statement = connection.createStatement();
            String sql = "update ueditor set ";
            sql+="title='"+ueditor.getTitle()+"',";
            sql+="content='"+ueditor.getContent()+"' where id="+ueditor.getId();
            System.out.println("修改："+sql);
            statement.execute(sql);
            statement.close();
        }catch (Exception e){
            System.out.println("修改数据出错！");
        }
    }

    @Override
    public Ueditor find(String id) {
        Ueditor ueditor = new Ueditor();
        try{
            Statement statement = connection.createStatement();
            String sql = "select * from ueditor where id="+id;
            System.out.println("单个查询："+sql);
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                ueditor.setId(set.getInt("id"));
                ueditor.setTitle(set.getString("title"));
                ueditor.setContent(set.getString("content"));
                ueditor.setCreateTime(set.getDate("createTime"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("单个查询数据出错！");
        }
        return ueditor;
    }

    @Override
    public List<Ueditor> pageList() {
        List<Ueditor> ueditorList = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            String sql = "select * from ueditor";
            System.out.println("单个查询："+sql);
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                Ueditor ueditor = new Ueditor();
                ueditor.setId(set.getInt(1));
                ueditor.setTitle(set.getString(2));
                ueditor.setContent(set.getString(3));
                ueditor.setCreateTime(set.getDate(4));
                ueditorList.add(ueditor);
            }
            statement.close();
        }catch (Exception e){
            System.out.println("查询数据列表出错！");
        }
        return ueditorList;
    }
}
