package cn.luijp.wikinn.Mapper;

import cn.luijp.wikinn.Pojo.SiteConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface SiteConfigMapper extends BaseMapper<SiteConfig> {
}
