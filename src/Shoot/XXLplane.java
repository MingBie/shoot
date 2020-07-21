package Shoot;

import java.awt.image.BufferedImage;

public class XXLplane extends Flyingobject implements AddScoreType,AwardType{
    private int speed; // y坐标改变的速度
    private int score; // 打掉超大敌机加的分数
    private int award; // 奖励类型

    public XXLplane() {
        // x坐标是随机的，y坐标是高度的负值，生命值 15
        super(Main.extraplane_n1,(int)(Math.random() * (Main.WIDTH - Main.extraplane_n1.getWidth())),-Main.extraplane_n1.getHeight(),15);
        this.speed = 2;
        this.score = 25;
        // 初始化灰烬图组
        ember = new BufferedImage[]{Main.extraplane_n2,Main.extraplane_hit, Main.extraplane_ember0,Main.extraplane_ember1,
                Main.extraplane_ember2,Main.extraplane_ember3,Main.extraplane_ember4,Main.extraplane_ember5};
        award = 2; // 三倍子弹
    }
    @Override
    public void move() {
        // y坐标增大
        this.setY(this.getY() + speed);
    }

    @Override
    public int getAward() {
        return award;
    }

    @Override
    public int getScore() {
        return score;
    }

}
