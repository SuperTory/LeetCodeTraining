## Java字符串

在 Java 中字符串被作为 String 类型的对象处理。 String 类位于 java.lang 包中，默认情况下该包自动导入。

String对象创建后不会被修改，当我们修改某个字符串对象实际上是将原引用指向了新创建的内存空间。并且相同的字符串常量Java不会分配两个内存空间，而是将两个引用指向相同的空间。
```java
public class MyString {
    public static void main(String[] args) {
        String s1="字符串";
        String s2="字符串";
        String s3=s1;
        System.out.println(s1==s2);     // s1、s2字符串内容相同，指向相同的内存空间，输出：true
        System.out.println(s1==s3);     // 修改之前s1与s3相同，输出：true
        s1="修改字符串";
        System.out.println(s1==s3);     // 修改之后s1指向新的内存空间，与s3不同，输出：false
    }
}
```

String中常用的方法：
```java
str.length()    //返回当前字符串的长度
str.indexOf(int ch)    //查找ch字符在该字符串中第一次出现的位置，若无返回-1
str.indexOf(subStr)    //查找str子字符串在该字符串中第一次出现的位罝
str.lastIndexOf(ch)    //查找ch字符在该字符串中最后一次出现的位置
str.lastlndexOf(subStr)查找St子字符串在该字符串中最后一次出现的位置
str.substring(beginlndex)    //获取从beginlndex位置幵始到结朿的子字符串
str.substring(beginlndex, endlndex)    //获取从beginlndex位置幵始到endlndex位M的子字符串
str.trim()        //返回去除了前后空格的字符串
str.equals(obj)        //将该字符串与指定对象比较，返回true或false
str.toLowerCase()        //将字符串转换为小写
str.toUpperCase()        //将字符串转换为大写
str.charAt(int index)    //获取字符串中指定位置的字符
str.setCharAt(i,c)    //设置某个位置的字符串
str.split(String regex, int limit)        //将字符串分割为子字符串，返回字符串数组
str.concat(str2)        //将str2拼接到末尾
str.getBytes()        /将该字符串转换为byte数组
str.toCharArray()        //转化为字符数组
```

如果需要使用经常修改的字符串，可以用**StringBuilder**类来保存，可以通过`append()`、`replace()`等方法对字符串进行修改，修改之后仍然指向同一块内存地址
```java
public class MyString {
    public static void main(String[] args) {
        StringBuilder s4=new StringBuilder("初始字符串");
        StringBuilder s5=s4;
        s4.replace(0,10,"修改后的字符串");
        System.out.println(s4);
        System.out.println(s4==s5);     // 修改后仍然指向同一块内存，因此输出：true
    }
}
```
 通过`String.valueOf()`可以将其他类型数据转化为字符串。
```java
char[] arr={'a', 'd', 'e'};
String s=String.valueOf(arr);
```
## Java中的包装类

Java中的基本数据类型如int、double等都不具有对象的特性，为了像其他对象一样拥有自己的方法，Java为每个基本数据类型提供了包装类，像对象那样来操作基本数据类型。包装类的基本方法用于实现类型之间的相互转换。

Java包装类可以自动装箱/拆箱，即通过=运算符自动完成基本类型和包装类之间的类型转换。

|基本类型| 对应包装类 |
|----------|--|
|    byte      | Byte |
|   short |Short  |
| int   |Integer  |
|    long|Long  |
|  float  |Float  |
| double   |Double  |
| char   |Character  |
|  boolean  |Boolean  |

```java
// 定义int类型变量，值为86
int score1 = 86;       
// 使用int创建Integer包装类对象，手动装箱
Integer score2=new Integer(score1);  
Integer score2=score1;    //自动装箱      
// 将Integer包装类转换为double类型
double score3=score2.doubleValue();        
// 将Integer包装类转换为float类型
float score4=score2.floatValue();        
// 将Integer包装类转换为int类型，手动拆箱
int score5 =score2.intValue();	
int score5 = score2        // 自动拆箱	
// 将字符串转为int
int score6 = Integer.parseInt("666");
```

基本类型与字符串之间的互相转换：
```java
//基本类型转字符串
int c = 10;
String s1 = Integer.toString(c);
String s2 = String.valueOf(c);
String s3 = c + "";
//字符串转基本类型
String s = "10";
int i1 = Integer.parseInt(s);
int i2 = Integer.valueOf(s);
```

通过`Integer.MAX_VALUE`可以获得最大整数值

使用 java.util 包中的 **Date** 类可以创建时间对象，使用java.text 包中的 `SimpleDateFormat` 类可以将时间转化为所需格式的字符串，其中 “yyyy-MM-dd HH:mm:ss” 为预定义字符串， yyyy 表示四位年， MM 表示两位月份， dd 表示两位日期， HH 表示小时(使用24小时制)， mm 表示分钟， ss 表示秒，这样就指定了转换的目标格式，最后调用 `format()` 方法将时间对象Date转换为指定的格式的字符串，反之`parse()`方法可以将普通字符串转化为Date对象。
```java
///创建Date对象，表示当前时间
Date d = new Date();
//创建SimpleDateFormat对象，指定目标格式
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//调用format() 方法，格式化时间，转换为指定格式字符串
String today = sdf.format(d);
//输出转换后的字符串
System.out.println(today);
```

java.util.Calendar 类可以更加方便地进行时间的处理，通过调用 getInstance() 静态方法获取一个 **Calendar** 对象，默认代表当前时间，可以通过`c.getTime()`将其转化为Date对象。Calendar对象的更多方法如下
```java
Calendar c = Calendar.getInstance();// 创建Canlendar对象
int year = c.get(Calendar.YEAR); // 获取年
int month = c.get(Calendar.MONTH) + 1; // 获取月份，0表示 1 月份
int day = c.get(Calendar.DAY_OF_MONTH); // 获取日期
int hour = c.get(Calendar.HOUR_OF_DAY); // 获取小时
int minute = c.get(Calendar.MINUTE); // 获取分钟
int second = c.get(Calendar.SECOND); // 获取秒
System.out.println("当前时间：" + year + month + day + hour + ":" + minute + ":" + second);
```

**Math** 类位于 java.lang 包中，包含用于执行基本数学运算的方法， Math 类的所有方法都是静态方法，所以使用该类中的方法时，可以直接使用类名.方法名，如： Math.round();
```java
int minNum=Math.min(2, 3);    //获取最小值
int maxNum=Math.max(2, 3);    //获取最大值

long round=Math.round(3.1415);      //四舍五入
double floor=Math.floor(3.1415);    //向下取整
double ceil=Math.ceil(3.1415);      //向上取整
double random=Math.random();        //取[0,1)之间的随机数
```
## 3、Java容器

在各种基本数据类型的基础上，Java使用集合类当作容器来储存具有相同属性的对象。通过集合类组织数据可以实现对特定数据的快速插入、删除与查询操作。而且与数组相比，集合的长度灵活可变，而且查找方式也不只有下标一种。Java中常见的集合类分为两个接口Collection和Map，其中Collection有三个子接口链表List、队列Queue、集Set，List常见的实现类为数组序列ArrayList，Queue实现类为LinkedList称为链表，Set实现类为哈希集。Collection中按照一个一个对象来存储数据，Map中按照键值对<key,value>来存储数据。Collection接口规定了ArrayList、Set等具体实现类的接口方法，例如它们都使用add()方法来添加元素，因此一些方法名在各个类实现中是通用的。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200130192733251.png?#pic_center =450x)
### ArrayList

ArrayList是类似于数组的容器，将对象储存进ArrayList之中便于组织和管理。通过`add()`方法可以将单个对象插入列表，`addAll()`可以将多个对象组成的子列表插入父列表中，插入时可以指定插入的位置，可以通过`Arrays.asList()`将数组转化为列表，通过`toArray()`方法可以将列表转为Object[]数组，可以向其中传入泛型参数从而返回特定类型的数组。

需要注意的是通过Arrays.asList()转化成的List长度是固定的，不能进行add()操作，会报错；我们可以将其作为子列表添加到一个新的List列表，然后再进行插入操作。

例如向列表courseList中插入Course对象：
```java
public void addCourse(){
    Course c1=new Course(1,"数据结构");
    Course c2=new Course(2,"操作系统");
    Course[] cArr={new Course(3,"组成原理"),new Course(4,"计算机网络")};

    courseList.add(c1);                         // 向数组列表中添加对象
    courseList.add(0,c2);                 // 向指定位置添加对象
    courseList.addAll(Arrays.asList(cArr));     // 向列表中添加子列表，前加数字表示插入位置
    Course tmp=(Course)courseList.get(0);       // 从列表中取出对象
    Course[] courseArr=courseList.toArray(new Course[courseList.size()]);    // 转换为特定类型的数组
}
```
特别地，`int[]`与`List<Integer>`之间无法直接使用asList()/toArray()方法进行互相转换，可以经过如下流操作完成转换；或者遍历int[]逐个添加到List
```java
int[] nums=new int[]{3,1,5,8};
//arr转list
List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//list转arr
int[] arr = numList.stream().mapToInt(Integer::valueOf).toArray();
```
通过`size()`方法可以获取列表长度，通过`get()`方法可以获取指定位置的对象，进而通过for循环遍历每个对象，也可以使用`for each`的方式遍历每个元素。还可以通过迭代器实现对每个对象的访问。值得注意的是，每个对象在列表中都是以Object对象的方式储存的，因此在取出之后需要通过强制类型转换为原来的对象类型，例如(Course)转为Course类的对象
```java
    public void showCourse(){
        int listLength=courseList.size();           // 获取列表长度
        for (int i=0;i<listLength;i++) {
            Course c=(Course)courseList.get(i);     // 获取列表第i个元素
            System.out.println(c.name);
        }
    }

    public void iteratorCourse(){
        Iterator it=courseList.iterator();          // 获取迭代器
        while (it.hasNext()){                       // 如果仍有下一个元素
            Course c=(Course)it.next();             // 取出下一个元素
            System.out.println(c.name);
        }
    }
```
通过`set()`方法对列表指定位置的元素进行修改。通过`remove()`方法移除指定位置或者指定对象。通过`removeAll()`删除父列表中包含的所有子列表中的元素，通过`clear()`可以清空列表。
```java
    public void modifyCourse(){
        courseList.set(2,new Course(5,"离散数学"));     // 修改2位置上的对象
    }

    public void removeCourse(){
        courseList.remove(3);               // 删除3位置上的对象
        Course c1= (Course) courseList.get(1);
        Course c2=(Course) courseList.get(2);
        courseList.remove(c1);                      // 删除指定对象
        Course[] cArr={c1,c2};
        courseList.removeAll(Arrays.asList(cArr));  // 删除courseList中所包含的cArr的元素
    }
```

通过`contains()`、`containsAll()`方法判断List是否包含某个或者某几个对象，其实现原理是遍历List中的每个对象调用其equals()方法和目标对象进行比较，如果存在返回true，否则返回false。因此我们可以重写Course类的equals()方法，进而调用contains()方法判断List中是否包含指定Course对象。类似地`indexOf()`方法可以通过调用equals()找到元素在List中第一次出现的位置。
```java
    // 重写Course类的equals()方法
    public boolean equals(Object o) {
        if (this == o) return true;     // 如果两个对象的地址相同，肯定相同
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return id == course.id &&       // 判断两个Course对象的id和name相同
                name.equals(course.name);
    }

    // 在CourseList中调用contains()判读是否包含某个对象
    public void containCourse(){
        Course nc=new Course(5,"数据结构");
        if(courseList.contains(nc)) {                     // 判断List中是否包含Course对象nc
            int index = courseList.indexOf(nc);           // 获取元素在List中的位置
            System.out.println("列表中包含该课程，位置：" + index);
        }
    }
```
之前提到集合中存放的都是对象的引用(Object)，每次存入时集合会忽略对象的具体类型，有时存入其他类型对象则会在运行时出错，而且每次取出时则需要进行类型的强制转换还原回来。可以使用泛型规定某个集合只能存放特定类型或者其子类型的对象，这样就会在编译期间进行类型检查，而且在取出时可以直接返回特定类型的对象。注意泛型不能用于基本数据类型，例如`List <int>`会报错，而应该使用其包装类`List <Integer>`。
```java
// 创建元素类型为Course的列表
public List<Course> courseList=new ArrayList<Course>();

public void addCourse(){
    Course c=new Course(6,"数据结构");
    courseList.add(c);
//        courseList.add("字符串");    // 尝试向列表中添加非Course类型的对象，报错
    Course c2=courseList.get(0);        // 可以直接取出为Course类型对象
    System.out.println(c2.name);
}
```
通过集合的工具类`Collections.sort()`方法可以实现对List对象的排序，其实现的原理是调用每个元素的`compareTo()`方法实现对象之间的比较进而排序。因此每个对象必须是可比较的类型，即必须实现了`Comparable` 接口的对象。

如下所示首先定义可比较类Student，再定义学生列表studentLis添加学生对象后，调用Collections.sort()方法对列表进行排序，或者直接使用studentList.sort()。
```java
public class Student implements Comparable<Student> {   // 定义Student类实现Comparable接口
    public String name;
    public int id;

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(Student o) {        // 实现接口的方法，根据id大小对学生进行比较
        if (this.id>o.id){          // 如果大于o返回1
            return 1;
        }else if (this.id<o.id){    // 小于返回-1
            return -1;
        }else {                     // 等于返回0
            return 0;
        }
    }
}

public class ListSort {
    public List<Student> studentList=new ArrayList<Student>();    // 学生列表

    public void sortStudent(){
        Student s1=new Student(1011,"小明");
        Student s2=new Student(1005,"小赵");
        Student s3=new Student(1021,"小钱");
        Student[] sArr={s1,s2,s3};
        studentList.addAll(Arrays.asList(sArr));
        Collections.sort(studentList);                // 调用方法对学生列表进行排序
        for (Student s:studentList) {
            System.out.println(s.id+":"+s.name);
        }
    }
}
```
也可以在调用sort()方法时传入一个自定义的比较器对象`Comparator`，通过重写compare()方法来实现两个对象的比较。这里很明显可以看到上面的Comparable接口是被比较对象自身实现的，用于自身和其他对象比较；而Comparator是第三方对象实现的接口，用于比较两个对象。
```java
// 自定义比较器类来实现两个Student对象的比较
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.id>o2.id){          // 如果大于o返回1
            return 1;
        }else if (o1.id<o2.id){    // 小于返回-1
            return -1;
        }else {                     // 等于返回0
            return 0;
        }
    }
}

// 调用sort()方法时传入比较器
Collections.sort(studentList,new StudentComparator());
```
### HashSet

哈希集是Set的一个实现类，与list不同，set中的元素是无序且不可以重复的。

和List一样，在Set中通过`add()`、`remove()`等方法实现元素的增加删除等操作。由于Set是无序的，因此没有set()、get()方法实现在指定位置插入/获取元素，在遍历元素时通过for each、iterator来实现，而且每次遍历的结果顺序是不确定的。

注意HashSet中的`contains()`方法会首先调用对象的hashCode()方法比较哈希码，再调用equals()方法，两个都为true才会认为两个对象相同。

例如通过HashSet来存储学生所选课程
```java
public class Student {
    public String name;
    public int id;
    public Set<Course> courses;     // 用set保存学生所选课程

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
        this.courses=new HashSet<Course>();     //创建Hash集
    }

    public static void main(String[] args){
        Course c=new Course(1,"数据结构");
        Student s=new Student(101,"小明");     
        s.courses.add(c);               // 向集中添加对象
        for (Course course:s.courses) {         // 遍历集
            System.out.println(course.name);
        }
    }
}
```
### HashMap

Map以一一对应的键值对<key,value>的形式储存数据，key值不能重复，通过映射关系可以实现key快速查找value。Map也支持泛型Map<K,V>，注意K，V不能是Java基本类，而是包装类。

通过`put(key,value)`向Map中添加键值对，`get(key)`通过键获取值，`remove(key)`移除键。修改Map键值对也使用put()方法，新的键值对会覆盖原有的值。通过`containsKey(key)`方法可以返回Map中是否包含某个key值，`containsValue(value)`返回Map中是否包含某个值，它通过调用对象的equals()方法比较来返回是否存在。

还可以通过`keySet()`、`values()`、`entrySet()`方法分别获取Map的键、值、键值对`Map.Entry`，返回的键值对Entry仍然可以定义泛型类型。
```java
    // 创建存储学生类的哈希Map
    public Map<Integer,String> studentMap=new HashMap<Integer, String>();

    public void addStudent(){
        Scanner input=new Scanner(System.in);
        System.out.print("请输入学生ID：");
        int studentID=input.nextInt();
        String s=studentMap.get(studentID);        // 根据key值获取对应的value
        if (s!=null){                              // 如果s不为空说明该key已经存在
            System.out.println("该学生ID已存在！");
        }else {
            System.out.print("请输入姓名：");
            String name=input.next();
            studentMap.put(studentID,name);     // 将<ID,name>键值对添加到Map中
        }
    }

    public void showStudent(){            //通过foreach遍历HashMap
        // 获取Map的键值对Entry并对其泛型进行定义
        Set<Map.Entry<Integer,String>> entrySet=studentMap.entrySet();
        for(Map.Entry<Integer,String> entry:entrySet){
            int key= entry.getKey();                    // 从Entry中获取key
            String name=entry.getValue();               // 从Entry中获取value
            System.out.println(key+":"+name);
        }
    }

    public void showStudent2(){            //通过迭代器遍历HashMap
    　　Iterator iter = studentMap.entrySet().iterator();
　　    while (iter.hasNext()) {
　　        Map.Entry entry = (Map.Entry) iter.next();
　　        Int key= entry.getKey();
　　        String name = entry.getValue();
            System.out.println(key+":"+name);
        }
　　}
```
## 4、工具类
### Stack

栈的创建和简单使用如下所示
```java
        Stack<Integer> st = new Stack<>();      //新建栈
        st.push(3);
        int peek=st.peek();     //获取栈顶元素
        System.out.println(peek);
        int pop=st.pop();       //弹出栈顶元素
        System.out.println(pop);
        System.out.println(st.empty());     //判断栈是否为空
```
### Queue

**LinkedList**类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。队列的使用如下
```java
Queue<Integer> queue = new LinkedList<>();    //创建并初始化队列
queue.offer(1);     //元素入队
queue.offer(3);
queue.offer(5);

for(int num:queue)      //遍历队列
	System.out.println(num);
int pNum=queue.peek()    //获取第一个元素
int qNum=queue.poll();  //元素出队
System.out.println(qNum);
```
### Deque

Deque是一个线性collection，支持在两端插入和移除元素。名称 deque 是“double ended queue（双端队列）”的缩写，通常读为“deck”。常见的实现类有LinkedList和ArrayDeque，其中`LinkedList`是用链表实现的；`ArrayDeque`是用数组实现的，适用于已知Deque长度的情况，在过万的大数据量下ArrayDeque性能更好。
```java
Deque<Integer> deque = new LinkedList();
Deque<Integer> deque = new ArrayDeque<>(len);
```

Deque可以从首尾两端进行插入、移除和获取首个元素。每种方法都存在两种形式：一种在操作失败时抛出异常，另一种返回一个特殊值（null 或 false）。

下表总结了上述 12 种方法：

||抛出异常    |特殊值    |抛出异常    |特殊值|
|--|--|--|--|--|
|插入    |addFirst(e)    |offerFirst(e)    |addLast(e)   | offerLast(e)|
|删除    |removeFirst()   | pollFirst()   | removeLast()    |pollLast()|
|首个元素 |   getFirst()   | peekFirst() |   getLast()   | peekLast()|

Deque继承自 Queue 接口。将其用作队列时，元素从尾部入队并从头部出队。从 Queue 接口继承的方法完全等效于 Deque 方法，如下表所示：
|Queue方法  |  等效Deque方法|
|--|--|
|add add(e)   | addLast(e)
|offer(e)   | offerLast(e)
|remove()  |  removeFirst()
|poll()   | pollFirst()
|element()   | getFirst()
|peek()    |peekFirst()

Deque也可用作后进先出的堆栈。Java推荐用Deque取代原始的Stack类。在将双端队列用作堆栈时，元素从Deque的头部压入和弹出。堆栈方法完全等效于 Deque 方法，如下表所示：
|堆栈方法    |等效Deque方法
|--|--|
|push(e)   | addFirst(e)
|pop()   | removeFirst()
|peek()  |  peekFirst()


