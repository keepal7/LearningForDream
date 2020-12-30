package com.keepal.demo.Iterator;


import java.util.LinkedList;
import java.util.List;

/**
 * 没有用迭代器设计模式遍历集合
 */
public class WhitoutIteratorPatternDemo {

    public static void main(String[] args) {
        // 数据准备
        Student s1 = new Student("1");
        Student s2 = new Student("2");
        ClassRoom classRoom = new ClassRoom();
//        Student[] students = {s1, s2};
//        classRoom.setStudents(students);
//        // 遍历集合 -> 直接获取集合类型 导致遍历代码报错
//        Student[] studentsRes = classRoom.getStudents();
//        for (Student student : studentsRes) {
//            System.out.println(student.getName());
//        }

        // 如果classRoom的students类型由数组变为List
        // 数据准备
        List<Student> students = new LinkedList<Student>();
        students.add(s1);
        students.add(s2);
        classRoom.setStudents(students);
        // 直接命中类型 容易在遍历内部集合的时候，修改集合类型时不够灵活
        List<Student> studentsRes = classRoom.getStudents();
        for (Student student : studentsRes) {
            System.out.println(student.getName());
        }

    }


    public static class Student {
        private String name;


        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ClassRoom {
//        Student[] students;
//
//        public Student[] getStudents() {
//            return students;
//        }
//
//        public void setStudents(Student[] students) {
//            this.students = students;
//        }

        private List<Student> students;

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }
    }
}
