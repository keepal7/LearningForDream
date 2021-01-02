package com.keepal.demo.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 */
public class VisitorPatternDemo {

    /**
     * 其核心思想就是基于[组合模式]处理层级数据的时候，
     * 将具体的处理逻辑再进一步封装成一个个的visitor，
     * 从而达成更好的可扩展性
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

        Visitor removeVisitor = new RemoveVisitor();
        parentDept.accept(removeVisitor);

        Visitor updateVisitor = new UpdateVisitor();
        parentDept.accept(updateVisitor);
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

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public List<Department> getChildren() {
            return children;
        }

        // 接收传入的visitor，传入this表示对当前对象执行以下操作
        // 把操作内容单独抽取出来，成为visitor
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public static interface Visitor {
        void visit(Department dept);
    }


    public static class RemoveVisitor implements Visitor {
        // 在具体的visitor.visit函数执行具体的业务逻辑
        public void visit(Department dept) {
            if (dept.getChildren().size() > 0) {
                for (Department child : dept.getChildren()) {
                    child.accept(this);
                }
            }
            System.out.println(dept.getName() + "执行删除");
        }
    }

    public static class UpdateVisitor implements Visitor {
        // 在具体的visitor.visit函数执行具体的业务逻辑
        public void visit(Department dept) {
            if (dept.getChildren().size() > 0) {
                for (Department child : dept.getChildren()) {
                    child.accept(this);
                }
            }
            System.out.println(dept.getName() + "执行更新");
        }
    }

}
