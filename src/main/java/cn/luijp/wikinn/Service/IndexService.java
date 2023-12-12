package cn.luijp.wikinn.Service;

import cn.luijp.wikinn.Pojo.Page;

public interface IndexService {
    Page GetContent(Long Id);

    void GetMeta(Long Id);

    Long GetIdByTitle(String Title);
}
