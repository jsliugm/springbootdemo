package com.universe.demo.springboot.mapper;

import com.universe.demo.springboot.entity.Person;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;
import tk.mybatis.mapper.common.Mapper;

public interface PersonMapper extends Mapper<Person> {
    @Select("select * from t_person")
    Cursor<Person> scan();
}
