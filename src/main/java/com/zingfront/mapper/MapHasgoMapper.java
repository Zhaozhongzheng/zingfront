package com.zingfront.mapper;

import com.zingfront.entity.MapHasgo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MapHasgoMapper  {

    @Select("SELECT id,date,memo,province,userid,pos_x posX,pos_y posY FROM map_hasgo WHERE userid = #{userid}")
    public List<MapHasgo> selectByUserId(@Param("userid")long userId);

    @Select("SELECT id,date,memo,province,userid,pos_x posX,pos_y posY FROM map_hasgo WHERE userid = #{userid} and province = #{province}")
    public MapHasgo selectByUserIdAndProvince(@Param("userid")long userId,@Param("province")String province);

    @Insert("INSERT INTO map_hasgo(date,memo,province,create_time,userid,pos_x,pos_y) " +
            "VALUES(#{model.date},#{model.memo},#{model.province},now(),#{model.userid},#{model.posX},{model.posY})")
    public int insert(@Param("model") MapHasgo model);
}
