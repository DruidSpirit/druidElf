package com.druid.service;


import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 通用接口，偏向于单表操作
 * @Description: CRUD 常见操作封装
 * @author <a href="smniuhe@gmail.com">smniuhe</a>
 */
@Service
public interface IService<T> {

    /**
     * 根据主键查询
     * @param key
     * @return
     */
    T selectByKey(Object key);

    /**
     * 保存实体
     * @param entity
     * @return
     */
    int save(T entity);

    /**
     * 根据主键删除
     * @param key
     * @return
     */
    int delete(Object key);

    /**
     * 更新实体
     * @param entity
     * @return
     */
    int updateAll(T entity);

    /**
     * 更新实体-过滤null属性
     * @param entity
     * @return
     */
    int updateNotNull(T entity);

    /**
     * 条件查询
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    //TODO 其他...
}
