package com.druid.dto.mapstruct;

import com.druid.dto.vm.testVm;
import com.druid.entity.NovelResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapStruct {
    /**
     * 主表字段转换
     *
     * @param novelResource
     * @return
     */
    @Mappings({

    })
    testVm testTransform(NovelResource novelResource);

    List<testVm> testTransformList(List<NovelResource> novelResourceList);
}
