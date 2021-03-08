package org.example.design;

/**
 * Attach additional responsibilities to an object dynamically keeping the same interface.
 * Decorator provide a flexible alternative to subclassing for extending functionality.
 * 动态的给一些对象添加一些额外的职责。
 * 就增加功能来说，装饰模式相比生成子类更加灵活
 *
 * @author 柳敏 minliu
 * @since 2021-03-02 20:32
 */
public abstract class SchoolReport {

    public abstract void report();

    public abstract void sign(String name);

}

class FouthGradeSchoolReport extends SchoolReport {

    @Override
    public void report() {
        System.out.println("向家长展示成绩");
        System.out.println("数学成绩是60分！");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签字");
    }
}

class Father {
    public static void main(String[] args) {
        SchoolReport sr = new FouthGradeSchoolReport();
        sr.report();
    }
}
//==============================代码分割线===========

class SugarFouthGradeSchoolReport extends FouthGradeSchoolReport {
    private void reportHighScore() {
        System.out.println("这次数学考试最高分是62分！");
    }

    private void reportSort() {
        System.out.println("我排名第12！");
    }


    @Override
    public void report() {
        this.reportHighScore();
        super.report();
        this.reportSort();
    }
}

class Father2 {
    public static void main(String[] args) {
        SchoolReport sr = new SugarFouthGradeSchoolReport();
        sr.report();
        sr.sign("孩他爸！");
    }
}

//==============================代码分割线===========

abstract class Decorator extends SchoolReport {
    private SchoolReport sr;

    public Decorator(SchoolReport sr) {
        super();
        this.sr = sr;
    }

    @Override
    public void report() {
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}


class HightScoreDecorator extends Decorator {
    public HightScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportHighScore() {
        System.out.println("这次数学考试最高分是62分！");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}

class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportSort() {
        System.out.println("我排名第12！");
    }

    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}

class Father3 {
    public static void main(String[] args) {
        SchoolReport sr;
        sr = new FouthGradeSchoolReport();
        sr = new HightScoreDecorator(sr);
        sr = new SortDecorator(sr);
        sr.report();
        sr.sign("孩他爸！");
    }
}



