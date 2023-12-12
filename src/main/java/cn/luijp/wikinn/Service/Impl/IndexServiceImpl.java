package cn.luijp.wikinn.Service.Impl;

import cn.luijp.wikinn.Exception.PageNotFoundException;
import cn.luijp.wikinn.Mapper.PageMapper;
import cn.luijp.wikinn.Mapper.SiteConfigMapper;
import cn.luijp.wikinn.Pojo.Page;
import cn.luijp.wikinn.Pojo.SiteConfig;
import cn.luijp.wikinn.Service.IndexService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IndexServiceImpl implements IndexService {
    private final SiteConfigMapper siteConfigMapper;

    private final PageMapper pageMapper;

    @Autowired
    public IndexServiceImpl(SiteConfigMapper siteConfigMapper, PageMapper pageMapper) {
        this.siteConfigMapper = siteConfigMapper;
        this.pageMapper = pageMapper;
    }

    @Override
    public Page GetContent(Long Id) {
        Page PageContent = pageMapper.selectById(Id);
        if(PageContent == null)
        {
            log.warn(Id + " has no record");
            throw new PageNotFoundException();
        }
        return PageContent;
    }

    @Override
    public void GetMeta(Long Id) {

    }

    @Override
    public Long GetIdByTitle(String Title) {
        List<Page> PageSearched = pageMapper.selectList(new QueryWrapper<Page>().eq("title", Title));
        if(PageSearched.isEmpty())
        {
            throw new PageNotFoundException();
        }
        if(PageSearched.size() > 1)
        {
            log.warn(Title + " has multiple records");
        }
        return PageSearched.get(0).getId();
    }
}
