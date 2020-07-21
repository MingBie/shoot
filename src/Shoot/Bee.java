package Shoot;

import java.awt.image.BufferedImage;

/**
 * 小蜜蜂类：继承飞行器父类、奖励接口
 * 成员方法：
 *        move（需要重写）
 */
public class Bee extends Flyingobject implements AwardType {
    private int x_speed; // 坐标改变的速度
    private int y_speed;
    private int award; // 定义奖励的类型
    // 无参构造函数进行初始化
    public Bee() {
        // x坐标是随机的，等于 窗口的宽度 - bee图片的宽度
        // y坐标等于 图片高度的负值
        super(Main.bee,(int)(Math.random()*(Main.WIDTH - Main.bee.getWidth())),-Main.bee.getHeight(),1);
        x_speed = 1;
        y_speed = 1;
        award = (int)(Math.random() * 2);
        // 初始化灰烬图
        ember = new BufferedImage[]{Main.bee_ember0,Main.bee_ember1,Main.bee_ember2,Main.bee_ember3};
    }
    // 重写 move 方法
    @Override
    public void move() {
        // y坐标一直增大
        // x坐标先增大，当达到边界值时，开始减小
        this.setX(this.getX() + x_speed);
        this.setY(this.getY() + y_speed);
        // 判断x是否到达边界
        if (this.getX() >= (Main.WIDTH - Main.bee.getWidth())) {
            x_speed = -1; // 到达右边界 x坐标开始减小
        } else if (this.getX() == 0) {
            x_speed = 1; // 到达左边界 x坐标开始增大
        }
    }

    @Override
    public int getAward() {
        return award;
    }
}
