package cn.luijp.wikinn.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@TableName("page")
@Repository
public class Page {
    @TableId
    @TableField("id")
    private Long Id;
    @TableField("title")
    private String Title;
    @TableField("text")
    private String Text;
}
