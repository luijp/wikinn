package cn.luijp.wikinn.Service.Impl;

import cn.luijp.wikinn.Service.MdRenderService;
import org.springframework.stereotype.Service;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

@Service
public class MdRenderServiceImpl implements MdRenderService {
    @Override
    public String Render(String Text){
        Node Document = Parser.builder().build().parse(Text);
        return HtmlRenderer.builder().build().render(Document);

    }
}
