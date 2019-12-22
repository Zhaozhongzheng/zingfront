package com.zingfront.service;

import com.zingfront.entity.MapHasgo;
import com.zingfront.entity.MapPlango;
import com.zingfront.mapper.MapHasgoMapper;
import com.zingfront.mapper.MapPlangoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapPlangoService {

    @Autowired
    private MapPlangoMapper mapPlangoMapper;

    public int insertPlanGo(MapPlango plango){
        return mapPlangoMapper.insert(plango);
    }

    public List<MapPlango> selectByUserId(long userid){
        return mapPlangoMapper.selectByUserId(userid);
    }

    public MapPlango selectByUserIdAndProvince(long userid,String province){
        return mapPlangoMapper.selectByUserIdAndProvince(userid,province);
    }
}
