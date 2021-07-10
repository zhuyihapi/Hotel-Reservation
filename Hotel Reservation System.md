# Hotel Reservation System



## 1. Model Package

model 包用来存放各种基础类及其方法，不作为功能实现的直接对象。



### 1.1 Customer

Customer 类需要定义储存顾客信息的基本方式，顾客的信息主要由**姓**，**名**和**邮箱**组成，其中邮箱可以作为用户的ID。

#### Email adress

用户输入的邮箱应是有效的邮箱，此处采用正则判断邮箱是否符合`*@*.*`的样式。如不符，则返回 "Error, Invalid email" 并拒绝记录用户信息，返回上级菜单。



### 1.2 Room

#### IRoom interface

接口定义四个方法：

- String getRoomNumber()
- Double getRoomPrice()
- Room.RoomType getRoomType()
- boolean isFree()

其中 `RoomType` 为定义在 Room 类中的内部类。

#### Room class

##### enum RoomType

SINGLE and DOUBLE， 单人间和双人间，分别标记为 Lable "s" 和 Lable "d" 。

##### Room class

- 房间的三个属性：**房间号**，**房间价格**，**房间类型**，根据封装的原则设为 private。

- 获取房间属性信息的 get 方法。

- 重写`toString`方法，便于打印房间对象的有关信息。

#### FreeRoom class

继承于 Room 类，设定空房间的价格为0.0$。

然而这个类并没有被使用到。



## 2. Service Package

存放储存信息的数据结构和实现服务的方法。



### 2.1 Customer Service

继承于Customer类

#### Data structure 

1. `Map<String, Customer> mapOfCustomers`

用一个hashmap记录所有顾客的信息，用唯一的邮箱作为索引。向该map内添加新元素须保证key不重复。

#### Methods

1. `void addCustomer(String email, String firstName, String lastName)`

向`mapOfCustomer`内添加顾客信息的方法，需要保证**添加的邮箱地址有效**和**用户邮箱尚未创建**。

2. `Customer getCustomer(String customerEmail)`

通过唯一邮箱地址从`mapOfCustomer`内获取顾客对象的方法，同样需要**保证邮箱有效**和**保证当输入邮箱不存在map中时做出正确反馈**。

3. `Collection<Customer> getAllCustomers()`

直接返回`mapOfCustomer`的值



### 2.2 Reservation Service







