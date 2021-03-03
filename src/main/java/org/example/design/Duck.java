package org.example.design;

/**
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-03-02 20:05
 */

/**
 * Strategy Pattern
 * 1：策略模式是：将可变的部分从程序中抽象分离成算法接口，在该接口下分别封装一系列的算法实现
 * 2：复合优于继承
 * 3：多组合，少继承
 * 4：Favor composition over inheritance   Effective Java
 * 5: What is composition?
 *            在类中增加一个私有域，引用另一个已有类的实例，通过调用引用实例的方法从而获得新的功能，这种设计称为组合（复合）
 * 6:设计原则    面向接口变成，而不是面向实现编程
 * 7：优点    (1)使用了组合，使架构更加灵活
 *            (2)富有弹性，可以较好的应对变化（开闭原则）
 *            (3)更好的代码复用性（相对于继承）
 *            (4)消除大小的条件语句
 * 8：缺点：            (1)增加对象的数目
 *             (2)客户代码需要了解每个策略实现的细节
 *
 * 9：使用场景：   (1)许多相关的类仅仅是行为差异
 *            (2)运行时选取不同的算法变体
 *             (3)通过条件语句在多个分支中选取其一
 *
 */
public abstract class Duck {

    public void quack() {
        System.out.println("嘎嘎嘎");
    }

    public abstract void display();

    //采用组合的的方式
    private FlyingStragety flyingStragety;

    public void setFlyingStragety(FlyingStragety flyingStragety) {
        this.flyingStragety = flyingStragety;
    }

    public void fly() {
        flyingStragety.performFly();
    }


    public static void main(String[] args) {
        System.out.println("测试鸭子程序");
        System.out.println("************************");
        Duck duck = null;
        duck = new RedheadDuck();
        duck = new BigYellow();
        duck = new SpaceDuck();

        duck.display();
        duck.quack();
        duck.fly();
        System.out.println("************************");
        System.out.println("测试完毕");

    }
}

interface FlyingStragety {
    //顶一个飞的行为
    void performFly();
}

class FlyNoWay implements FlyingStragety {
    @Override
    public void performFly() {
        System.out.println("其实我不会飞");
    }
}

class FlyWithRocket implements FlyingStragety {
    @Override
    public void performFly() {
        System.out.println("其实用火箭在太空遨游");
    }
}

class FlyWithWin implements FlyingStragety {
    @Override
    public void performFly() {
        System.out.println("其实我是振翅高飞！");
    }
}

/**
 * 大黄鸭
 */
class BigYellow extends Duck {
    public BigYellow() {
        super();
        super.setFlyingStragety(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("我身体很大，全身黄黄");
    }
}

/*
 * 红头鸭
 */
class RedheadDuck extends Duck {
    public RedheadDuck() {
        super();
        super.setFlyingStragety(new FlyWithWin());
    }

    @Override
    public void display() {
        System.out.println("我的头是红色的");
    }
}

/**
 * 太空鸭子
 */
class SpaceDuck extends Duck {
    public SpaceDuck() {
        super();
        super.setFlyingStragety(new FlyWithRocket());
    }

    @Override
    public void display() {
        System.out.println("我头戴宇航头盔");
    }

    @Override
    public void quack() {
        System.out.println("我通过无线电与你通信");
    }
}


