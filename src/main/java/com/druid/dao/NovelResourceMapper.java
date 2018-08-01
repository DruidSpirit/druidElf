package com.druid.dao;

import com.druid.entity.NovelResource;
import com.druid.entity.NovelResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NovelResourceMapper {
	List<NovelResource> selectByNovelResource(NovelResource novelResource);
	
    long countByExample(NovelResourceExample example);

    int deleteByExample(NovelResourceExample example);

    int insert(NovelResource record);

    int insertSelective(NovelResource record);

    List<NovelResource> selectByExample(NovelResourceExample example);

    int updateByExampleSelective(@Param("record") NovelResource record, @Param("example") NovelResourceExample example);

    int updateByExample(@Param("record") NovelResource record, @Param("example") NovelResourceExample example);
}