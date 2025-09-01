package com.sky.mapper;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    List<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类和状态的禁用和启用
     */
    void update(Category category);

    /**
     * 新增分类
     */
    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) VALUES (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Category category);

    /**
     * 根据id删除分类
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    /**
     * 根据类型查询分类
     */
    @Select("select * from category where type = #{type} order by sort")
    List<Category> list(Integer type);
}
