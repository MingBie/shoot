package Shoot;

import java.awt.image.BufferedImage;

/**
 * 小敌机类：继承飞行物父类、加分数接口
 */
public class Airplane extends Flyingobject implements AddScoreType{
    private int speed; // y坐标改变的速度
    private int score; // 打掉小敌机加的分数

    // 无参构造器进行赋值
    public Airplane() {
        // x坐标是随机的 y坐标是图片高度的负值
        super(Main.airplane,(int)(Math.random() * (Main.WIDTH - Main.airplane.getWidth())),-Main.airplane.getHeight(),1);
        speed = 4;
        score = 5;
        // 初始化灰烬图
        ember = new BufferedImage[]{Main.airplane_ember0,Main.airplane_ember1,Main.airplane_ember2,Main.airplane_ember3};
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
}
