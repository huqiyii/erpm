# 1.10

## 项目模板修改

- 下载layui模板：https://gitee.com/layuicms/layuicms2.0?_from=gitee_search

- 修改模板

- layui版本更新：layui.js、layui.css

  ```
  #layui.js
  //防止页面单独打开【登录页面除外】
  if(/layuicms2.0\/page/.test(top.location.href) && !/login.html/.test(top.location.href)){
      top.window.location.href = window.location.href.split("layuicms2.0/page/")[0] + 'layuicms2.0/';
  }
  //外部图标链接
  var iconUrl = "https://at.alicdn.com/t/font_400842_q6tk84n9ywvu0udi.css";
  
  #layui.css
  /* 自添加样式*/
  @import "https://at.alicdn.com/t/font_400842_q6tk84n9ywvu0udi.css";
  .layui-icon{ font-size:16px !important;}
  .mag0{ margin:0 !important; }
  ::selection { background: #ff5722; color: #fff; }
  .layui-red{ color:#f00 !important; font-weight:bold;}
  .layui-blue{ color:#01AAED !important;}
  
  
  ```

  

## 项目框架搭建

###　数据库

- 新建数据库：`create database erp character set utf8mb4 collate utf8mb4_general_ci  `
- 跑数据表创建文件

### 创建项目

- 创建springboot项目 （jdbc、mysql、springweb、lombok、dev、thymeleaf、configuration）

- 修改pom文件（mybatisPlus、shiro、druid、log4j、aop、hutool）
- 修改yml文件

### 用户登录

- 用户生成

- 写代码
	![image-20210110151257437](/home/hxj/.config/Typora/typora-user-images/image-20210110151257437.png)

- 写ActiverUser类 （**这几个注解还没搞懂，记得看shiro**）
	![image-20210110151759751](/home/hxj/.config/Typora/typora-user-images/image-20210110151759751.png)

- 写UserRealm类（这几个类都是为shiro服务的）

- 创建static/index.html

- 原来把静态资源再放到一个resources里面是为了用shiro控制权限，在static下面新建一个index.html，同样可以用一个controller来控制访问

- 写ResultObj类

- 写Constast类

  ...等等类

  

### 左边的导航树

- 生成permission

- 生成permissionDao

- 生成PermisssionService

- 生成PermissionServiceImpl

- 生成PermisionController

- 创建MenuController, (使用DataGridView定义返回数据格式)

- 创建PermissionVo (**暂时还不知道干嘛用的**)

- 创建MenuController

- 创建Constast

- 创建TreeNode

- 创建TreeNodeBuilder

- 修改页面 (获取方式)

  

  