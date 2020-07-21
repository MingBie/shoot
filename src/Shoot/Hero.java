package Shoot;

import java.awt.image.BufferedImage;

/**
 * 英雄机类：继承飞行器父类
 * 成员变量：
 *        生命值
 *        分数
 * 成员变量：
 *        move（需要重写）
 */
public class Hero extends Flyingobject {
    private int score; // 分数 默认是0

    // 无参构造函数进行初始化（是固定的）
    public Hero() {
        super(Main.hero0,150,400,3); // 调用父类有参构造函数
        // 初始化灰烬图
        ember = new BufferedImage[]{Main.hero_ember0,Main.hero_ember1,Main.hero_ember2,Main.hero_ember3};
    }

    private int count = 0; // 用来计数
    private BufferedImage[] heroImage = {Main.hero0,Main.hero1}; // 存储英雄机 move 方法的两张图片
    // 重写move方法
    @Override
    public void move() {
        // 图片的切换
        count ++;
        this.setImage(heroImage[count % 2]);
    }
    // 定义双倍子弹的次数
    private int doubleFireCount = 0;
    // 双倍子弹
    public void doubleFire() {
        doubleFireCount += 20;
    }
    // 定义三倍子弹的次数
    private int thirdFireCount = 0;
    // 三倍子弹
    public void thirdFire() {
        thirdFireCount += 10;
    }
    // 发射子弹
    public Bullet[] shoot() {
        // 用两种情况的子弹 用数组来存储
        // 单发和双发
        Bullet[] bullet;
        // 判断子弹颗数
        if (thirdFireCount != 0) {
            bullet = new Bullet[3];
            bullet[0] = new Bullet(getX() + (getWidth() / 4),getY());
            bullet[1] = new Bullet(getX() + (getWidth() / 2),getY());
            bullet[2] = new Bullet(getX() + (getWidth() / 4 * 3),getY());
            thirdFireCount --;
        } else {
            if (doubleFireCount == 0) {
                bullet = new Bullet[1];
                // 单发情况
                bullet[0] = new Bullet(getX() + getWidth() / 2,getY());
            } else {
                // 双倍子弹情况
                bullet = new Bullet[2];
                bullet[0] = new Bullet(getX() + (getWidth() / 4),getY());
                bullet[1] = new Bullet(getX() + (getWidth() / 4 * 3),getY());
                doubleFireCount --;
            }
        }
        // 返回子弹 调用shoot时接收子弹存储在子弹列表中
        return bullet;
    }
    // 打掉敌机加分数
    public void addScore(int score) {
        this.score += score;
    }
    // 生命值加1
    public void addLife() {
        this.setLife(this.getLife() + 1);
    }
    // 判断英雄机是否与飞行物相撞
    public boolean shootByHero(Flyingobject fly) {
        // 分别判断 x和y
        if (this.getX() >= (fly.getX() - this.getWidth()) && this.getX() <= (fly.getX() + fly.getWidth()) &&
    this.getY() >= (fly.getY() - this.getHeigth()) && this.getY() <= (fly.getY() + fly.getHeigth())) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
