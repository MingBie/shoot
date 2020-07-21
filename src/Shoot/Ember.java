package Shoot;

import java.awt.image.BufferedImage;

/**
 * 灰烬类
 * 成员变量：
 *        灰烬图组
 *        每一张灰烬图
 *        切换每一张图的频率
 *        x，y坐标
 *        灰烬图组下标
 * 成员方法：
 *        切换灰烬图片
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
    // 切换灰烬图片
    // 图片全部切换完时返回true
    public boolean burnDown() {
        // 控制切换灰烬的频率
        i ++;
        if (i % interval == 0) {
            // 判断灰烬图片是否全部切换完
            if (index == images.length) {
                return true;
            }
            // 获得每一张灰烬的图片
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
