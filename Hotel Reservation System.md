# Hotel Reservation System

这是一个用于练习的项目，完成了一个简单酒店预订系统的最基础的功能。该酒店预订系统使用命令行作为 UI 与用户及管理员交互。UI 层用过 API 接口与服务层相互分隔，实现功能上的解耦合（大概）。所有用户数据均储存于内存中，程序退出则信息全部消失。所有功能均通过 Java 实现。

该酒店预订系统功能如下：

- 顾客可以通过给出一个时间段，来获取该段时间内可供预定的房间的信息，并决定是否需要预定其中一个房间。
- 顾客的信息通过邮箱和姓名储存在系统中，作为身份的凭证来预定房间。
- 顾客可以在预定完成后查看自己的预定信息
- 管理员可以在管理员界面查看所有的房间，已注册顾客和所有预定房间的信息
- 管理员可以添加新的房间



## 1. Model Package

model 包用来存放各种基础类及其方法，不作为功能实现的直接对象。

### Customer

Customer 类需要定义储存顾客信息的基本方式，顾客的信息主要由**姓**，**名**和**邮箱**组成，其中邮箱可以作为用户的ID。

#### Email adress

用户输入的邮箱应是有效的邮箱，此处采用正则判断邮箱是否符合`*@*.*`的样式。如不符，则返回 "Error, Invalid email" 并拒绝记录用户信息，返回上级菜单。



### Room

#### IRoom interface

接口定义四个方法：

- `String getRoomNumber()`
- `Double getRoomPrice()`
- `Room.RoomType getRoomType()`
- `boolean isFree()`

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

存放储存信息的数据结构及对其进行访问，实现服务逻辑功能并给前端反馈。	

### Customer Service

继承于Customer类。

#### Data structure 

1. `Map<String, Customer> mapOfCustomers`

用一个hashmap记录所有顾客的信息，用唯一的邮箱作为索引。向该map内添加新元素须保证key不重复。

#### Methods

1. `void addCustomer(String email, String firstName, String lastName)`

向`mapOfCustomer`内添加顾客信息的方法，需要保证**添加的邮箱地址有效**和**用户邮箱尚未创建**。

2. `Customer getCustomer(String customerEmail)`

通过唯一邮箱地址从`mapOfCustomer`内获取顾客对象的方法，同样需要**保证邮箱有效**和**保证当输入邮箱不存在map中时做出正确反馈**。

3. `Collection<Customer> getAllCustomers()`

直接返回`mapOfCustomer`的值。



### Reservation Service

处理所有预定房间相关的服务，包括储存顾客预定的房间。

#### Data structure

1. `Map<String, IRoom> mapOfRooms`

储存所有由 admin 添加的可使用的房间，以房间号码（roomID）作为唯一索引。

2. `Map<String, Reservation> mapOfReservations`

储存所有房间预定的信息，以顾客的邮箱地址作为唯一索引。但因此导致了一个邮箱地址只能够预定一个房间的问题。

#### Methods

1. `void addRoom(IRoom room)`

向`mapOfRooms`中添加一个新的可用的房间，须能够在重复添加房间（相同的房间号码）时给出正确反馈。

2. `IRoom getRoom(String roomID)`

通过房间号从表中获取一个房间对象。

3. `Collection<IRoom> getAllRoom()`

获取储存在`mapOfRooms`中所有房间的信息，返回一个元素为房间对象的 List 。

4. `Reservation reserveARoom(Customer customer, IRoom room, Date checkInData, Date checkOutData)`

将顾客预定房间信息储存在`mapOfReservations`中。

5. `Collection<IRoom> findRooms(Date checkInData, Date checkOutData)`

预定房间功能实现，需要通过给出的一段时间来检索该时间段内未被预定的空房间，将其储存于一个`List`内并返回。目前是通过逐个比较房间预定时间从而判断该房间是否符合顾客需求，但存在一旦房间存在多个预定则可能会因为需求符合其中一个预定而被系统误认为符合顾客要求。一种解决方案是当否决掉一个房间时检测它是否已经存在于最终 List 中，如果已存在则删除它。该部分仍需大量修改及优化。

6. `Collection<Reservation> getCustomerReservation(Customer customer)`

通过顾客邮箱在`mapOfReservations`中检索其预定信息。问题在于一个邮箱地址只能够预定一个房间，需要在数据结构上进一步修改。

7. `void printAllReservation()`

for each 遍历输出`mapOfReservations`中储存所有的 Reservation 对象，需要在没有任何对象时给出正确反馈。



## 3 API Package

### Hotel Resourse

- Customer getCustomer(String email)
- void createCustomer(String email, String firstName, String lastName)
- IRoom getRoom(String roomNumber)
- Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate)
- Collection<Reservation> getCustomerReservations(String customerEmail)
- findARoom(Date checkInDate, Date checkOutDate)

### AdminResourse

- Customer getCustomer(String email)
- void addRoom(Room room)
- Collection<IRoom> getAllRooms()
- Collection<Customer> getAllCustomers()
- void displayAllReservations()



## 4 UI (CLI)

UI 层通过 API 接口访问服务层。

### MainMenu

主菜单可以允许用户输入数字来选择功能：

1. Find and reserve a room
2. See my reservations
3. Create a account
4. Admin
5. Exit

主 while 循环打印主菜单，除非用户选择退出应用。

#### `void findAndReserveRoom()`

询问用户想要预定房间的日期，在系统给出可供预定的房间后，再询问用户是否预定其中一个房间。较为困难之处在于如何从用户输入读取日期和枚举类型。这里直接搬运了别人已经写好的`getInputDate`方法：首先使用`SimpleDAteFormat`类格式化日期（格式为`String DEFAULT_DATE_FORMAT = "MM/dd/yyyy"`），再调用`.parse`方法转换字符串为 Date 类型，还需要 try 无效输入。

#### `void confirm()`

在每次向用户展示信息后，都需要用户按任意键确认才返回菜单界面。

> 另外 UI 层理应能够处理任何情况下用户的异常输入，提示用户正确的输入格式并提供再次输入相关信息的机会，目前应用还未进行该方面的完善。

### AdminMenu

管理员有关的功能界面，可以从主菜单进入。

功能：

1. See all Customers
2. See all Rooms
3. See all Reservations
4. Add a room
5. Add Test Data (unfinished)
6. Back to Main Menu

较难处理的问题是输入枚举类型和在管理员重复输入已存在的房间 ID 时给出恰当的反馈。
