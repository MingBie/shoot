package Shoot;

import java.awt.image.BufferedImage;

/**
 * 大敌机类：继承飞行器父类、分数接口、奖励接口
 * 成员变量：
 *        生命值
 * 成员方法：
 *        move（需要重写）
 */
public class Bigplane extends Flyingobject implements AddScoreType,AwardType {
    private int speed; // 坐标改变的速度
    private int score; // 打掉大敌机加的分数；
    private int award; // 定义奖励的类型
    // 无参构造函数进行初始化
    public Bigplane() {
        // x坐标是随机的，y坐标是高度的负值
        super(Main.bigplane,(int)(Math.random()*(Main.WIDTH - Main.bigplane.getWidth())),-Main.bigplane.getHeight(),5);
        speed = 2;
        score = 15;
        award =(int)(Math.random() * 2);
        // 初始化灰烬图
        ember = new BufferedImage[]{Main.bigplane_ember0,Main.bigplane_ember1,Main.bigplane_ember2,Main.bigplane_ember3};
    }

    @Override
    public void move() {
        // y坐标增大
        this.setY(this.getY() + speed);
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getAward() {
        return award;
    }

}
