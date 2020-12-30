package com.keepal.demo.Iterator;


import java.util.ArrayList;
import java.util.List;

/**
 * 使用迭代器设计模式的意义在于：
 * 操作类内部集合的时候，避免直接向外暴露集合的真实类型，而向外部提供一个统一的迭代接口
 * 即内部的迭代器。
 *
 * 这样在使用到这个内部集合的时候，就只感知到迭代器，而对内部接口实现并不感知。
 * 以此来增强可扩展性
 *
 */
public class IteratorDemo {


    public static void main(String[] args) {
        // 数据准备
        Student s1 = new Student("1");
        Student s2 = new Student("2");
        ClassRoom classRoom = new ClassRoom();
//        classRoom.setStudents(new Student[]{s1, s2});
        // 在内部集合类型修改之后，需要修改的只有数据构造
        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        classRoom.setStudents(students);


        // 通过迭代器遍历
        MyIterator myIterator = classRoom.iterator();
        while (myIterator.hasNext()) {
            Student student = (Student) myIterator.next();
            System.out.println(student.getName());
        }


    }

    // 学生类
    public static class Student {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(String name) {
            this.name = name;
        }
    }

    /**
     * 自实现的迭代器接口，主要定义两个函数
     *
     */
    private static interface MyIterator {
        abstract boolean hasNext();
        abstract Object next();
    }

    /**
     * classRoom所需的迭代器类
     * 内部持有classRoom的引用，以及能获取到内部集合的方法
     */
    private static class ClassRoomIterator implements MyIterator {

        private ClassRoom classRoom;
        private int index;

        public ClassRoomIterator(ClassRoom classRoom) {
            this.classRoom = classRoom;
            index = 0;
        }

        // 根据当前索引位置判断是否有剩余元素
        public boolean hasNext() {
            return classRoom.getLenght() > index;
        }

        // 通过classRoom引用拿到集合元素
        public Object next() {
            return classRoom.getStudentByIndex(index++);
        }
    }

    /**
     * 这是代表一个集合接口
     * 只要实现了这个接口，就需要实现一个迭代器函数
     * 其中就需要返回当前类实现的迭代器逻辑
     */
    private static interface Aggregate {
        public abstract MyIterator iterator();
    }

    public static class ClassRoom implements Aggregate {
//        private Student[] students;

//        public Student[] getStudents() {
//            return students;
//        }
//
//        public void setStudents(Student[] students) {
//            this.students = students;
//        }
//
//        public Student getStudentByIndex(int index) {
//            return students[index];
//        }
//        private int getLenght(){
//            return students.length;
//        }


        private List<Student> students;

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        // 在内部集合类型修改后 只需要修改集合对应的操作部分接口
        // 在集合使用处 和 接口部分都不需要修改
        private Student getStudentByIndex(int index) {
            return students.get(index);
        }
        private int getLenght(){
            return students.size();
        }

        public MyIterator iterator() {
            return new ClassRoomIterator(this);
        }
    }
}
