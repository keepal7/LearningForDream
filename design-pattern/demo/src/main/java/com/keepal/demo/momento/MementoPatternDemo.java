package com.keepal.demo.momento;

/**
 * 备忘录设计模式，其实主要用于就是中间数据需要被修改的情况
 *
 * 有两个角色：管理器和备忘录，
 * 备忘录在操作之前得到，然后存在管理器中
 * 需要恢复的时候，从管理器里面取出
 */
public class MementoPatternDemo {

    public static void main(String[] args) {
        Originator originator = new Originator();

        // 准备好了中间数据
        originator.prepare();
        // 将中间数据保存到备忘录中去
        Memento memento = originator.createMemento();
        // 将备忘录保存到备忘录管理器中去
        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(memento);
        // 基于中间数据执行了A方法，但是此时中间数据已经改变了
        originator.executeA();
        // 从备忘录管理器中获取备忘录
        memento = caretaker.retrieveMemento();
        // 将备忘录中保存好的中间数据重新设置到原发器中去，就将中间数据恢复成了之前备忘的状态
        originator.setMemento(memento);
        // 接着再次执行方法B
        originator.executeB();

        // 面临的场景
        // 你的系统会生产出来一份中间数据，这份中间数据要么是没法一直在内存里保留，要么是可能会被修改
        // 所以逼得你迫不得已，必须得通过备忘录的方式，将中间数据暂存一份儿
        // 在一堆操作过后，可能之前内存中的中间数据都弄丢了，也可能中间数据被人篡改了
        // 接下来，你需要从备忘录中恢复我们的中间数据
        // 基于恢复后的中间数据，再次执行后面的操作
    }

    public interface Memento {

    }

    public static class Originator {

        private String state;

        public void prepare() {
            this.state = "中间数据";
        }

        public void executeA() {
            String s1 = state;
            System.out.println("基于中间数据【" + state +"】执行了A方法的逻辑");
            // 将state所代表的中间数据做出了修改
            // 这里实际上是修改了原本的state对象
            // 而之前的备忘录就是保存的原有的state的指针而已
            // 如果是具体某个引用类型的对象内部属性被修改了，那么实际上要备忘录的话还是只能深拷贝才行
            state += "，A方法的结果数据";
            System.out.println(s1 == state);// false
        }

        public void executeB() {
            System.out.println("基于中间数据【" + state +"】执行了B方法的逻辑");
            state += "，B方法的结果数据";
        }

        public Memento createMemento() {
            return new MementoImpl(state);
        }

        public void setMemento(Memento memento) {
            MementoImpl mementoImpl = (MementoImpl)memento;
            this.state = mementoImpl.getState();
        }

        private static class MementoImpl implements Memento {

            private String state;

            public MementoImpl(String state) {
                this.state = state;
            }

            public String getState() {
                return state;
            }

        }

    }

    public static class Caretaker {

        private Memento memento;

        public void saveMemento(Memento memento) {
            this.memento = memento;
        }

        public Memento retrieveMemento() {
            return this.memento;
        }

    }

}
