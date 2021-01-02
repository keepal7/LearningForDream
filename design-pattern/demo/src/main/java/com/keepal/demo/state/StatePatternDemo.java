package com.keepal.demo.state;

/**
 * 使用状态模式处理有状态的事务
 */
public class StatePatternDemo {

    /**
     * 场景：
     * 处理出库单的状态流转
     *
     * 状态模式的核心在于将状态流转的控制抽取到一个context里面去做统一管理
     * 而不是在代码中到处乱写状态更改的逻辑
     * 这样可读性可可维护性都很好
     */
    public static void main(String[] args) {
        Context context = new Context(new NewState());
        context.execute(1);
        context.execute(2);
        context.execute(3);
    }

    public static class Context {
        private State state;

        public Context(State state) {
            this.state = state;
            // 执行初始状态
            state.execute();
        }

        public void execute(int stateType) {
            if (stateType == 1) {
                this.state = new ApprovingState();
                this.state.execute();
            } else if (stateType == 2) {
                this.state = new ApprovedState();
                this.state.execute();
            } else if (stateType == 3) {
                this.state = new FinishedState();
                this.state.execute();
            }
        }
    }
    public interface State {
        void execute();
    }

    public static class NewState implements State {

        public void execute() {
            System.out.println("执行销售出库单新建状态的逻辑");
        }

    }

    public static class ApprovingState implements State {

        public void execute() {
            System.out.println("执行销售出库单待审批状态的逻辑");
        }

    }

    public static class ApprovedState implements State {

        public void execute() {
            System.out.println("执行销售出库单已审批状态的逻辑");
        }

    }

    public static class FinishedState implements State {

        public void execute() {
            System.out.println("执行销售出库单已完成状态的逻辑");
        }

    }
}
