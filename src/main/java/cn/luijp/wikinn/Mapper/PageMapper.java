package cn.luijp.wikinn.Mapper;

import cn.luijp.wikinn.Pojo.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface PageMapper extends BaseMapper<Page> {
}
