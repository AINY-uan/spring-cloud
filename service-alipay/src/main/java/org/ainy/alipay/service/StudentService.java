package org.ainy.alipay.service;

import org.ainy.db.config.DataSourceContextHolder;
import org.ainy.db.config.DatabaseType;
import org.ainy.db.dao.entity.Student;
import org.ainy.db.dao.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: YUANDONG
 * @Description: 推送类型服务
 * @Date: 2019-08-02 13:46
 */
@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getAll() {

        DataSourceContextHolder.setDatabaseType(DatabaseType.pushEngine);

        return studentMapper.selectAll();
    }
}
