package cn.luijp.wikinn.Service.Impl;

import cn.luijp.wikinn.Mapper.SiteConfigMapper;
import cn.luijp.wikinn.Pojo.SiteConfig;
import cn.luijp.wikinn.Service.DBSiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DBSiteConfigServiceImpl implements DBSiteConfigService {

    private final SiteConfigMapper siteConfigMapper;

    @Autowired
    public DBSiteConfigServiceImpl(SiteConfigMapper siteConfigMapper) {

        this.siteConfigMapper = siteConfigMapper;
    }

    @Override
    public Map<String, String> GetAll() {
        Map<String, String> SiteConfigMap = new HashMap<>();
        for(SiteConfig siteConfig : siteConfigMapper.selectList(null))
        {
            SiteConfigMap.put(siteConfig.getConfigName(),siteConfig.getConfigVal());
        }
        return SiteConfigMap;
    }
}
