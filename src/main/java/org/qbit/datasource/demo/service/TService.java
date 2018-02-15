package org.qbit.datasource.demo.service;

import org.qbit.datasource.demo.db1.Table1;
import org.qbit.datasource.demo.db1.reposiotry.T1Dao;
import org.qbit.datasource.demo.db2.Table2;
import org.qbit.datasource.demo.db2.repository.T2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TService {

    @Autowired
    T1Dao db1T1Dao;

    @Autowired
    T2Dao db2TDao;

    @Transactional(value = "ta1")
    public List<Table1> getAllFromT1() {
        return (List<Table1>) db1T1Dao.findAll();
    }

    @Transactional(value = "ta2")
    public List<Table2> getAllFromT2() {
        return (List<Table2>) db2TDao.findAll();
    }
}
