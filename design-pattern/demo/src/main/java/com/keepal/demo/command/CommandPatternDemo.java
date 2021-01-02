package com.keepal.demo.command;

/**
 * 命令模式demo
 */
public class CommandPatternDemo {

    /**
     * 命令模式主要是一种面向对象的设计思想
     * 可以将一类命令抽取出来，然后通过统一的Invoker去执行不同的命令
     * 这样可以让代码风格统一，更好理解和维护
     * 常用于：读/写请求处理
     */
    public static void main(String[] args) {
        Command commandA = new CommandA();
        Command commandB = new CommandB();
        Invoker invoker = new Invoker();

        invoker.setCommand(commandA);
        invoker.exec();

        invoker.setCommand(commandB);
        invoker.exec();
    }

    public static interface Command{
        void exec();
    }

    public static class CommandA implements Command{

        public void exec() {
            System.out.println("执行命令A");
        }
    }
    public static class CommandB implements Command{

        public void exec() {
            System.out.println("执行命令B");
        }
    }

    public static class Invoker {
        private Command command;

        public Command getCommand() {
            return command;
        }

        public void setCommand(Command command) {
            this.command = command;
        }

        public void exec(){
            command.exec();
        }
    }
}
