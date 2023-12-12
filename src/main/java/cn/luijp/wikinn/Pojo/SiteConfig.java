package cn.luijp.wikinn.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;


@Data
@TableName("site_config")
@Repository
public class SiteConfig {
    @TableId
    @TableField("id")
    private Long Id;
    @TableField("config_name")
    private String ConfigName;
    @TableField("config_val")
    private String ConfigVal;
    @TableField("update_time")
    private Timestamp UpdateTime;
}
