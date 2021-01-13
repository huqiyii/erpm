## *项目模板修改*

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



### 工作台的管理

- 创建deskManager.html （js放静态文件里和放同一个文件里好像不一样， 放静态文件里没法加载session里面的东西）

- 修改index.html
- 修改SystemController，添加拦截

###　日志管理

#### 查询

- 生成logingo
- 生成loginfoMapper、LoginfoService等等....
- 创建LoginfoVo
- 创建system/loginfo/loginfoManager.html

- 配置mybatis分页插件



为啥这里要加空格
![image-20210111134437607](/home/hxj/.config/Typora/typora-user-images/image-20210111134437607.png)



**再也别搞错date和data！！**

#### 删除

- 修改loginfoVo
- 修改LoginController
- 修改loginfoManager

####　记录登录日志

- 修改loginController

### 公告管理

#### 查询

- 生成代码 ...
- 创建NoticeVo、NoticeController

#### 添加和修改

*layedit not found:*

*修改layui/lay/modules/layedit/  replace ‘’layedit.sync“ ”this.sync“* 

#### 删除公告

#### 查看公告

### 部门管理

#### 查询

- 生成代码...
- 修改DeptServerImpl
- 创建dept/deptManager.html
- 创建dept/deptLeft.html
- 创建dept/deptLeftRight.html

*使用<frmaeset>分割两个页面 不过现在这种方法好像已经被跑起来了*

- 创建SystemController

#### 添加修改

#### 删除　



----

1.12 放弃继续 感觉这个老师大多数讲的都是前端的 特别是前端技术栈用的比较老 在东西很杂的前端领域没有太大的普适性 对一个目标为后端的我来说时间花的有点划不来 ...

不过还是从这个老师这学习到很多优秀的习惯、以及熟悉了使用springboot、mybatispuls、mysql以及shiro的搭建过程，项目具体的业务无非增删改查

- 使用Vo类集成Entity，与前端进行交互，能够兼容一些前端传过来的属性，然后在此基础上做一些业务上写的逻辑，相当于一个数据库和展示层数据交互的中间处理的过程，

- 缓存的设计，编写一个缓存类，利用aop的环绕通知对service中的增删改查业务进行增强，查询的时候可以直接从缓存中查，其他操作同步更新数据库

  **问题：哪些地方需要加缓存？**

- 静态方法获取Ioc容器中的东西的方式：

  定义一个类继承ApplicationContextAware，spring加载时会扫描整个包中实现了ApplicationContextAware接口的类，并调用回调方法，这个时候就能获取applicationContext对象，然后我们可以通过applicationContext对象来获取IOC容器中的bean

  ![image-20210112163659245](/home/hxj/.config/Typora/typora-user-images/image-20210112163659245.png)

使用该工具类：

![image-20210112163907478](/home/hxj/.config/Typora/typora-user-images/image-20210112163907478.png)



