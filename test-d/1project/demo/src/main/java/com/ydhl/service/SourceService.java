package com.ydhl.service;

import java.util.List;

import com.ydhl.dao.SourceDao;
import com.ydhl.entity.Source;

public class SourceService {

    // 查询-模糊查询
    public List<Source> Query(String name) {
        // 调用数据访问层
        SourceDao dao = new SourceDao();
        return dao.Query(name);
    }

    // 删除方法
    public boolean del(int id) {
        SourceDao dao = new SourceDao();
        return dao.del(id);
    }

    // 新增方法
    public boolean add(Source source) {
        SourceDao dao = new SourceDao();
        return dao.add(source);
    }

    //根据id查询对应数据 方面后续修改
    public Source Modifysel(int id) {
        SourceDao dao = new SourceDao();
        return dao.Modifysel(id);
    }

    //修改方法
    public boolean Modify(Source source) {
        SourceDao dao = new SourceDao();
        return dao.modify(source);
    }

}