package org.ainy.db.dao.mapper;

import org.ainy.db.dao.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author AINY
 * @description 推送类型映射
 * @date 2019-08-02 13:40
 */
@Mapper
@Repository
public interface StudentMapper {

    @Select("select id, name, sex from public.student ")
    List<Student> selectAll();
}
