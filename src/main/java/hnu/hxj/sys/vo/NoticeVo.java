package hnu.hxj.sys.vo;

import hnu.hxj.sys.entity.Loginfo;
import hnu.hxj.sys.entity.Notice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class NoticeVo extends Notice {

    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

    private  Integer[] ids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
