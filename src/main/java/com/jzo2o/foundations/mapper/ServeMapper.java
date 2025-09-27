package com.jzo2o.foundations.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jzo2o.foundations.model.domain.Serve;
import com.jzo2o.foundations.model.dto.response.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author itcast
 * @since 2023-07-03
 */
public interface ServeMapper extends BaseMapper<Serve> {
    /**
     * 根据区域查询服务列表
     * @param regionId
     * @return
     */
    List<ServeResDTO> queryServeListByRegionId(@Param("regionId") Long regionId);

    /**
     * 根据区域id查询服务图标分类列表
     *
     * @param regionId 区域id
     * @return 服务图标分类列表
     */
    List<ServeCategoryResDTO> findServeIconCategoryByRegionId(Long regionId);

    /**
     * 根据区域id查询服务聚合类型列表
     *
     * @param regionId 区域id
     * @return 服务聚合类型列表
     */
    List<ServeAggregationTypeSimpleResDTO> findServeAggregationTypeByRegionId(Long regionId);

    /**
     * 根据区域id查询热门服务列表
     *
     * @param regionId 区域id
     * @return 热门服务列表
     */
    List<ServeAggregationSimpleResDTO> queryHotServeListByRegionId(Long regionId);

    /**
     * 根据服务id查询服务详情
     *
     * @param id 服务id
     * @return 服务详情
     */
    ServeAggregationSimpleResDTO queryServeDetailById(Long id);
}
