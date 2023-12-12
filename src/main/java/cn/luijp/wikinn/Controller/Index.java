package cn.luijp.wikinn.Controller;


import cn.luijp.wikinn.Pojo.Page;
import cn.luijp.wikinn.Service.*;
import cn.luijp.wikinn.Service.Impl.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Index {

    private final GlobalModelService mGlobalModelService;
    private final MdRenderService mMdRenderService;

    private final IndexService mIndexService;


    @Autowired
    public Index(GlobalModelService mGlobalModelService, MdRenderService mMdRenderService, IndexService mIndexService) {
        this.mGlobalModelService = mGlobalModelService;
        this.mMdRenderService = mMdRenderService;
        this.mIndexService = mIndexService;
    }


    @GetMapping("/")
    public String Index(Model model) {
        model = mGlobalModelService.GetDefault(model);

        Long PageId = mIndexService.GetIdByTitle("/index");
        Page PageContent = mIndexService.GetContent(PageId);
        model.addAttribute("Title",PageContent.getTitle());
        String MainMdText = PageContent.getText();
        model.addAttribute("Content",mMdRenderService.Render(MainMdText));
        return "index";
    }

    @GetMapping("/title/{Title}")
    public String ContentPage(Model model, @PathVariable String Title) {
        model = mGlobalModelService.GetDefault(model);
        return "content";
    }
}
