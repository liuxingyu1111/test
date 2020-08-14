package com.hy.ssm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.ssm.bean.Shuxin;
import com.hy.ssm.mapper.ShuxinMapper;
import com.hy.ssm.utils.MenuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IShuxinService extends ServiceImpl<ShuxinMapper, Shuxin> implements ShuxinService {
    @Autowired
    private ShuxinMapper shuxinMapper;

    public List<MenuUtils> aa(){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sid",-1);
        List<Shuxin> list=shuxinMapper.selectList(queryWrapper);
        List<MenuUtils> list2=new ArrayList<>();
        for(Shuxin list1:list){
            QueryWrapper queryWrapper1=new QueryWrapper<>();
            queryWrapper1.eq("sid",list1.getId());
            List<Shuxin> list3=shuxinMapper.selectList(queryWrapper1);
            List<MenuUtils> list4=new ArrayList<>();
            for(Shuxin list5:list3){

                QueryWrapper queryWrapper2=new QueryWrapper<>();
                queryWrapper2.eq("sid",list5.getId());
                List<Shuxin> list7=shuxinMapper.selectList(queryWrapper2);
                List<MenuUtils> list8=new ArrayList<>();
                for (Shuxin list6:list7){
                    MenuUtils menuUtils1=new MenuUtils();
                    menuUtils1.setTitle(list6.getName());
                    list8.add(menuUtils1);
                }
                MenuUtils menuUtils=new MenuUtils();
                menuUtils.setTitle(list5.getName());
                menuUtils.setChildren(list8);
                list4.add(menuUtils);

            }

            MenuUtils menuUtils=new MenuUtils();
            menuUtils.setTitle(list1.getName());
            menuUtils.setChildren(list4);
            list2.add(menuUtils);
        }
        return list2;
    }
}
