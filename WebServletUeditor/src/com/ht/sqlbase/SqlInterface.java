package com.ht.sqlbase;

import com.ht.bean.Ueditor;

import java.util.List;


public interface SqlInterface {
    void add(Ueditor ueditor);
    void delete(String id);
    void update(Ueditor ueditor);
    Ueditor find(String id);
    List<Ueditor> pageList();
}
