package Shoot;

/**
 * 子弹类：继承飞行器父类
 * 成员方法：
 *        move（需要重写）
 */
public class Bullet extends Flyingobject {
    private int speed; // 坐标改变的速度

    public Bullet() {

    }
    // 有参构造函数进行初始化
    public Bullet(int x,int y) {
        // x，y坐标随英雄机而改变
        super(Main.bullet,x,y,1);
        speed = 5;
    }

    @Override
    public void move() {
        //y坐标减小
        this.setY(this.getY() - speed);
    }
}
