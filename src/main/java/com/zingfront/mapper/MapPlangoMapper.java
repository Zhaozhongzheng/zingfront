package com.zingfront.mapper;

import com.zingfront.entity.MapHasgo;
import com.zingfront.entity.MapPlango;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MapPlangoMapper {
    @Select("SELECT id,userid,province,content,create_time createTime,pos_x posX,pos_y posY FROM map_plango WHERE userid = #{userid}")
    public List<MapPlango> selectByUserId(@Param("userid")long userId);

    @Insert(" INSERT INTO map_plango(content,userid,create_time,pos_x,pos_y,province) " +
            " VALUES(#{model.content},#{model.userid},now(),#{model.posX},#{model.posY},#{model.province})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insert(@Param("model") MapPlango model);

    @Select("SELECT content,userid,create_time createTime,pos_x posX,pos_y posY,province " +
            "FROM map_plango WHERE userid = #{userid} and province = #{province}")
    public MapPlango selectByUserIdAndProvince(@Param("userid")long userId,@Param("province")String province);

}
