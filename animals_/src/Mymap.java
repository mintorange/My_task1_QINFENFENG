

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class Age implements Comparator<Map.Entry<Integer,Mymap>>//比较器的重写，实现按成绩排名，从大到小
{
    public int compare(Entry<Integer, Mymap> o1, Entry<Integer, Mymap> o2)
    {
        if (o1.getValue().age<o2.getValue().age)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
public class Mymap //主类
{   int  id;
    String name;
    int age;
    int sex;


    public Mymap(String name, int age)
    {
        this.name = name;
        this.age = age;
         //this.sex=sex;
    }
    public String toString() //重写toString方法，按格式打印测试结果
    {
        return   "   "+name   +"   "+   age;
    }
    public static void menu(Map<Integer, Mymap> map)//执行测试结果的方法
    {
        map.put(1,new Mymap("长颈鹿",23));
        map.put(2, new Mymap("狮子",19));
        map.put(3, new Mymap("袋鼠",9));
        map.put(4, new Mymap("猴子",10));
        map.put(5, new Mymap("熊猫",14));
        String str1="y";
        while (str1.equals("y")||str1.equals("Y"))//功能操作的循环，为了更好的查看测试结果
        {
            System.out.println("性别                种类              年龄");
            for (Map.Entry<Integer, Mymap> i:map.entrySet())
            {
                System.out.println(i.getKey()+" "+i.getValue());
            }


            System.out.println("请选择你要进行的操作");
            System.out.println("1、查找动物信息");
            System.out.println("2、修改动物信息");
            System.out.println("3、删除动物信息");
            System.out.println("4、增加动物信息内容");
            System.out.println("5、查看全部动物信息");
            System.out.println("6、按年龄从大到小排序");



            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            switch (a)
            {
                case 1:
                    search(map);
                    break;
                case 2:
                    change(map);
                    break;
                case 3:
                    delete(map);
                    break;
                case 4:
                    add(map);
                    break;
                case 5:
                    information(map);
                    break;
                case 6:
                    agecompare(map);
                    break;
            }
            System.out.println("是否继续y/n");
            str1=sc.next();
        }
    }
    public static void search(Map<Integer, Mymap> map){
        System.out.println("请输入要查找的编号");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        Integer A=new Integer(a);
        int l=1;
        for (Map.Entry<Integer, Mymap> i:map.entrySet())
        {
            if (A.equals(i.getKey()))
            {
                l=2;
                System.out.println("                               编号     种类   年龄");
                System.out.println("查询到的内容为："+i.getKey()+" "+i.getValue());
            }
        }
        if (l==1)
        {
            System.out.println("没有匹配到相关内容！");
        }
    }
    public static void change(Map<Integer,Mymap> map)
    {
        System.out.println("请输入要修改的编号");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        Integer A=new Integer(a);
        int l=1;
        for (Map.Entry<Integer, Mymap> i:map.entrySet())
        {
            if (A.equals(i.getKey()))
            {
                l=2;
                System.out.println("                               学号     名字   分数");
                System.out.println("将要修改的内容："+i.getKey()+" "+i.getValue());
                System.out.println("请输入新的编号");
                int a1=sc.nextInt();
                Integer A1=new Integer(a1);
                A=A1;
                System.out.println("请输入新的种类");
                i.getValue().name=sc.next();
                System.out.println("请输入新的年龄");
                i.getValue().age=sc.nextInt();
                System.out.println("修改成功，修改后的信息如下");
                for (Map.Entry<Integer, Mymap> k:map.entrySet())
                {
                    System.out.println(k.getKey()+" "+k.getValue());
                }
            }
        }
        if (l==1)
        {
            System.out.println("没有匹配到相关内容！");
        }
    }
    public static void delete(Map<Integer,Mymap>map)//删除
    {
        System.out.println("请输入要删除的编号");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        Integer A=new Integer(a);//int型要封装成integer型
        int l=1;
        for (Map.Entry<Integer, Mymap> i:map.entrySet())
        {
            if (A.equals(i.getKey()))
            {

                System.out.println("                               编号     种类   年龄");
                System.out.println("要删除的内容为："+i.getKey()+" "+i.getValue());
                l=2;
            }
        }
        if (l==1)
        {
            System.out.println("没有匹配到相关内容！");
        }
        else
        {
            if (l==2)
            {
                map.remove(A);
                System.out.println("成功删除！，删除后的内容如下：");
                for (Map.Entry<Integer, Mymap> k:map.entrySet())
                {
                    System.out.println(k.getKey()+" "+k.getValue());
                }
            }
        }
    }
    public static void add(Map<Integer,Mymap> map)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入新的编号");
        int a1=sc.nextInt();
        for (Map.Entry<Integer, Mymap> i:map.entrySet())
        {
            if (a1==i.getKey())
            {
                System.out.println("这个编号已存在！请重新输入");
                a1=sc.nextInt();
            }
        }
        Integer A1=new Integer(a1);
        System.out.println("请输入新的种类");
        String str=sc.next();
        System.out.println("请输入新的年龄");
        int a11=sc.nextInt();
        map.put(A1,new Mymap(str,a11));
        Map<Integer,Mymap> map1=new TreeMap<Integer,Mymap>();
        map1.putAll(map);
        System.out.println("添加成功！，添加后的内容如下：");
        for (Map.Entry<Integer, Mymap> i:map1.entrySet())
        {
            System.out.println(i.getKey()+" "+i.getValue());
        }
    }
    static void information(Map<Integer, Mymap> map)
    {
        System.out.println("编号                种类              年龄");
        for (Map.Entry<Integer, Mymap> i:map.entrySet())
        {
            System.out.println(i.getKey()+" "+i.getValue());
        }
    }
    static void agecompare(Map<Integer, Mymap> map)
    {
        List<Map.Entry<Integer,Mymap>> list=new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list,new Age());
        System.out.println("编号                种类              年龄");
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
}
