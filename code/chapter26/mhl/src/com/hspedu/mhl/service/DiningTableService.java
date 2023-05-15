package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.DiningTableDAO;
import com.hspedu.mhl.domain.DiningTable;

import java.util.List;

public class DiningTableService { //业务层
    //定义一个DiningTableDAO对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回所有餐桌的信息
    public List<DiningTable> list() {

        return diningTableDAO.queryMulti("select id, state from diningTable", DiningTable.class);
    }

    //根据id , 查询对应的餐桌DiningTable 对象
    //,如果返回null , 表示id编号对应的餐桌不存在
    public DiningTable getDiningTableById(int id) {

        //小技巧：把sql语句放在查询分析器去测试一下.
        return diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class, id);
    }

    //如果餐桌可以预定，调用方法，对其状态进行更新(包括预定人的名字和电话)
    public boolean orderDiningTable(int id, String orderName, String orderTel) {

        int update =
                diningTableDAO.update("update diningTable set state='已经预定', orderName=?, orderTel=? where id=?", orderName, orderTel, id);

        return  update > 0;
    }

    //需要提供一个更新 餐桌状态的方法
    public boolean updateDiningTableState(int id, String state) {

        int update = diningTableDAO.update("update diningTable set state=? where id=?", state, id);
        return update > 0;
    }

    //提供方法，将指定的餐桌设置为空闲状态
    public boolean updateDiningTableToFree(int id, String state) {

        int update = diningTableDAO.update("update diningTable set state=?,orderName='',orderTel='' where id=?", state, id);
        return update > 0;
    }

}
