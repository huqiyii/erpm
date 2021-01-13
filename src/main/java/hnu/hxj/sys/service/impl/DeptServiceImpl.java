package hnu.hxj.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import hnu.hxj.sys.entity.Dept;
import hnu.hxj.sys.mapper.DeptMapper;
import hnu.hxj.sys.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huqiyi
 * @since 2021-01-12
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Override
    public Dept getOne(Wrapper<Dept> queryWrapper, boolean throwEx) {
        return super.getOne(queryWrapper, throwEx);
    }

    @Override
    public boolean update(Wrapper<Dept> updateWrapper) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
