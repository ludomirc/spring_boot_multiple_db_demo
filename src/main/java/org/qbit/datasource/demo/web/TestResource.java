package org.qbit.datasource.demo.web;

import org.qbit.datasource.demo.db1.Table1;
import org.qbit.datasource.demo.db2.Table2;
import org.qbit.datasource.demo.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestResource {

    @Autowired
    TService t1;

    @GetMapping("/data")
    public List getData(){

        LinkedList list = new LinkedList();
        List<Table1> table1List =  t1.getAllFromT1();
        List<Table2> table2List =  t1.getAllFromT2();

        list.add(table1List);
        list.add(table2List);

        return list;
    }
}
