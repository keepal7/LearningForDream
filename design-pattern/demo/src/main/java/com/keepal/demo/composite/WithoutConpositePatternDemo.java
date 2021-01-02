package com.keepal.demo.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用组合设计模式来处理树形数据
 */
public class WithoutConpositePatternDemo {


    /**
     * 场景：
     * 就是说父部门下面有很多子部门，然后子部门下面还有叶子部门，现在需要删除父部门及其下面的子部门
     *
     * 存在的问题
     * 如果在删除的地方按照下面的N层for循环去写的话
     * 会导致这个代码嵌套太深，难以阅读和维护
     *
     */
    public static void main(String[] args) {
        Department leafDept1 = new Department("叶子部门1");
        Department leafDept2 = new Department("叶子部门2");
        Department leafDept3 = new Department("叶子部门3");

        Department subDept1 = new Department("子部门1");
        subDept1.getChildren().add(leafDept1);
        subDept1.getChildren().add(leafDept2);

        Department subDept2 = new Department("子部门2");
        subDept2.getChildren().add(leafDept3);

        Department parentDept = new Department("父部门");
        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);
        // 多层嵌套循环
        for (Department subDept : parentDept.getChildren()) {
            if (subDept.getChildren().size() > 0) {
                for (Department leafDept : subDept.getChildren()) {
                    leafDept.remove();
                }
            }
            subDept.remove();
        }
        parentDept.remove();
    }


    public static class Department {

        private String name;
        private List<Department> children = new ArrayList<Department>();

        public Department(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildren() {
            return children;
        }

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public void remove() {
            System.out.println("删除部门【" + name + "】");
        }

    }
}
