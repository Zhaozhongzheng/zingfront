package com.zingfront.service;

import com.zingfront.entity.MapHasgo;
import com.zingfront.entity.MapPlango;
import com.zingfront.mapper.MapHasgoMapper;
import com.zingfront.mapper.MapPlangoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapHasgoService {

    @Autowired
    private MapHasgoMapper mapHasgoMapper;

    public List<MapHasgo> selectByUserId(long userid){
        return mapHasgoMapper.selectByUserId(userid);
    }

    public MapHasgo selectByUserIdAndProvince(long userid,String province){
        return mapHasgoMapper.selectByUserIdAndProvince(userid,province);
    }

}
