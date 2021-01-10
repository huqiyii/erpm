package hnu.hxj.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hnu.hxj.sys.mapper.UserMapper;
import hnu.hxj.sys.entity.User;
import hnu.hxj.sys.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
