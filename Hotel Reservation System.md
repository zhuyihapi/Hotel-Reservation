# Hotel Reservation System



## 1. Model Package

model 包用来存放各种基础类及其方法，不作为功能实现的直接对象。

### 1.1 Customer

#### 1.1.1 Customer class

Customer 类需要定义储存顾客信息的基本方式，顾客的信息主要由姓，名和邮箱组成，其中邮箱可以作为用户的ID。这些信息不应该被随意访问，故变量全部设为 private 类型。

##### Email adress

用户输入的邮箱应是有效的邮箱，此处采用正则判断邮箱是否符合`*@*.*`的样式。如不符，则返回 "Error, Invalid email" 并拒绝记录用户信息，返回上级菜单。



### 1.2 Room

#### 1.2.1 IRoom interface

接口定义四个方法：

- String getRoomNumber()
- Double getRoomPrice()
- Room.RoomType getRoomType()
- boolean isFree()

其中 `RoomType` 为定义在 Room 类中的内部类。

#### 1.2.2 Room class

##### enum RoomType

SINGLE and DOUBLE, 单人间和双人间

##### Room class

房间的三个属性：房间号，房间价格，房间类型，根据封装的原则设为 private

获取房间属性信息的 get 方法

#### 1.2.3 FreeRoom class

继承于 Room 类，设定空房间的价格为0.0$。



## 2. Service Package

### 2.1 Customer Service





