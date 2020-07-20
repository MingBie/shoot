package Shoot;

import java.awt.image.BufferedImage;

/**
 * 灰烬类
 */
public class Ember {
    private BufferedImage[] images; // 灰烬图组
    private BufferedImage image; // 每一张灰烬图
    private int interval, i; // 切换每一张图的频率
    private int x, y; // 灰烬 x，y坐标
    private int index; // 下标
    // 有参构造函数初始化
    public Ember(Flyingobject fly) {
        this.images = fly.ember;
        this.x = fly.getX();
        this.y = fly.getY();
        this.interval = 10;
        this.i = 0;
        this.index = 0;
    }

    public boolean burnDown() {
        i ++;
        if (i % 10 == 0) {
            if (index == images.length) {
                return true;
            }
            image = images[index];
            index ++;
        }
        return false;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
