package cn.luijp.wikinn.Service.Impl;

import cn.luijp.wikinn.Service.DBSiteConfigService;
import cn.luijp.wikinn.Service.GlobalModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
public class GlobalModelServiceImpl implements GlobalModelService {
    private final DBSiteConfigService mDBSiteConfigService;

    @Autowired
    public GlobalModelServiceImpl(DBSiteConfigService mDBSiteConfigService) {
        this.mDBSiteConfigService = mDBSiteConfigService;
    }

    @Override
    public Model GetDefault(Model model) {
        Map<String, String> SiteConfigMap = mDBSiteConfigService.GetAll();
        model.addAttribute("ENV_SiteName",SiteConfigMap.get("ENV_SiteName"));
        model.addAttribute("ENV_Title_Prefix", SiteConfigMap.get("ENV_Title_Prefix"));
        model.addAttribute("ENV_Title_Suffix",SiteConfigMap.get("ENV_Title_Suffix"));

        return model;
    }
}
