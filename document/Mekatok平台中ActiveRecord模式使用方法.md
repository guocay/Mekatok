## ORM框架

> Active Record 和 Data Mapper 可能是最受欢迎的两种ORM结构。他们各自有各自的优缺点。

1. Active Record 的ORM框架会把对象（object）保存为数据库的一行（row），所以上面这个例子中user对象（object）被放入了数据库中的一行（row）。如果你使用Active Record你也不需要定义对象（object）的内容以及其和数据库的关系,因为model会自动匹配数据库的模式。同时你也只需要在对象（object）调用save（）方程来升级数据库。

```java
var user = User.of();
user.setId("001").setName("guokai");
user.save();
```

2. 和Active Record不同，Data Mapper完全的把域（doamin）从持久层（persistence layer）中分离出来了。所以对象（object）完全不需要和数据库有任何联系。

```java
var user = User.of();
user.setId("001").setName("guokai");
userDao.insert(user);
```

两种模式各有优劣,AR模式虽对单表操作更简便,但对于多表联查却不容易抽象.DM模式通过剥离数据与dao之间的联系,弥补了AR模式下问题,但却增加了单表操作的代码冗余.

在Mekatok中,将所有的数据库CRUD分为了两种,一种是单表操作,我们推荐使用AR模式.一种是多表操作,我们推荐使用DM模式 ***(此处仅演示AR模式操作方式,DM模式与MyBatis一致)***;

```java
/* AR 模式 */
// 创建数据表对象
public class User extends Table<User> {}

var user = User.of();

// 根据ID查询详情,返回当前user对象.
// 默认走缓存, 不走缓存可使用 detailByDb()
User _user = user.setId("001").detail(); 

// 插入数据,返回包含主键的当前user对象
// 将会更新缓存
User _user = user.setId("001").setName("Guokai").insert();

// 更新数据,返回包含更新后值的当前user对象
// 将会更新缓存
User _user = user.setId("001").setName("Guokai").update();

// 判断当前对象的主键在数据库中是否存在
// PS 执行 has() 函数后,如果存在 将更新当前user对象 并放入缓存
Boolean has = user.setId("001").has();

// 判断当前对象是否存在主键.存在则走 update(), 否则走 insert().
User _user = user.setId("001").setName("Guokai").save();

// 删除数据
// 将会移出缓存
Boolean has = user.setId("001").delete();

// 查询集合,将user对象所有属性的值拼成一个Wrapper后查询数据库. 获取符合条件的所有数据
// 配合 @TableField 的 condition 参数,可实现 equal, not equal, like
// 不走缓存,可自行添加.
List<User> list = user.setName("Guokai").selectList();

// 查询条数, 将user对象所有属性的值拼成一个Wrapper后查询数据库.获取符合条件的数据的总条数
// 不走缓存,可自行添加.
Integer count = user.setName("Guokai").count();

// 查询分页,将user对象所有属性的值拼成一个Wrapper后查询数据库. 获取符合条件的数据(分页)
// 分页数据会从 当前环境 的 request 上下文中自动获取, 使用者无需关心.
// 不走缓存,可自行添加.
IPage<User> page = user.setName("Guokai").selectPage();


```



