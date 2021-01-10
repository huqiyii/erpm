package hnu.hxj.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hnu.hxj.sys.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface UserMapper extends BaseMapper<User> {
}
