package hnu.hxj.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import hnu.hxj.sys.common.*;
import hnu.hxj.sys.entity.Permission;
import hnu.hxj.sys.entity.User;
import hnu.hxj.sys.service.IPermissionService;
import hnu.hxj.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author huqiyi
 * @since 2021-01-10
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo) {
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", Constast.TYPE_MNEU);
        queryWrapper.eq("available", Constast.AVAILABLE_TRUE);

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list = null;
        if (user.getType().equals(Constast.USER_TYPE_SUPER)) {
            list = permissionService.list(queryWrapper);
        } else {
            list = permissionService.list(queryWrapper);
        }

        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission permission : list) {
            Integer id = permission.getId();
            Integer pid = permission.getPid();
            String title = permission.getTitle();
            String icon = permission.getIcon();
            String href = permission.getHref();
            Boolean spread = permission.getOpen() == Constast.OPEN_TRUE ? true: false;
            treeNodes.add(new TreeNode(id, pid, title, icon, href, spread));
        }

        List<TreeNode> menu = TreeNodeBuilder.build(treeNodes, 1);

        return new DataGridView(menu);
    }
}

