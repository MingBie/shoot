package Shoot;
/**
 * 父类：飞行器类
 * 成员变量：
 *        图片
 *        宽度
 *        高度
 *        x坐标
 *        y坐标
 * 成员方法：
 *        移动方法（抽象的）
 */

import java.awt.image.BufferedImage;

public abstract class Flyingobject {
    private BufferedImage image; // 图片
    private int width; // 宽度
    private int heigth; // 高度
    private int x; // x坐标
    private int y; // y坐标
    private int life; // 生命值
    // 保护型 给子类调用 各自初始化灰烬图
    protected BufferedImage[] ember; // 灰烬图

    public Flyingobject() {

    }
    // 有参构造函数进行初始化
    protected Flyingobject(BufferedImage image,int x,int y,int life) {
        this.image = image;
        this.width = image.getWidth();
        this.heigth = image.getHeight();
        this.x = x;
        this.y = y;
        this.life = life;
    }

    // 抽象方法 move
    public abstract void move();
    // 判断子弹与飞行物是否相撞
    public boolean shootByFlyingObject(Bullet bullet) {
        // 分别判断x和y
        if (bullet.getX() >= (this.x - bullet.getWidth()) && bullet.getX() <= (this.x + this.width) &&
        bullet.getY() >= (this.y - bullet.getHeigth()) && bullet.getY() <= (this.y + this.heigth)) {
            return true;
        }
        return false;
    }
    // 相撞时生命值减1
    public void minusLife() {
        this.life --;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
