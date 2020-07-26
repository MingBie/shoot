package Shoot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

// Main类继承JPanel类来实现 paint 功能
public class Main extends JPanel{
    // 静态的成员变量可以在静态代码块中进行调用
    // public 可以使同包中的其他类调用静态成员变量
    // 不能定义局部变量，局部变量在方法结束时就消失了
    //public static BufferedImage shoes;
    public static BufferedImage shoe;
    public static BufferedImage shoe_demo01;
    public static BufferedImage shoe_demo02;
    public static BufferedImage shoe_demo03;
    public static BufferedImage background_demo01;
    public static BufferedImage airplane;
    public static BufferedImage airplane_ember0;
    public static BufferedImage airplane_ember1;
    public static BufferedImage airplane_ember2;
    public static BufferedImage airplane_ember3;
    public static BufferedImage background;
    public static BufferedImage bee;
    public static BufferedImage bee_ember0;
    public static BufferedImage bee_ember1;
    public static BufferedImage bee_ember2;
    public static BufferedImage bee_ember3;
    public static BufferedImage bigplane;
    public static BufferedImage bigplane_ember0;
    public static BufferedImage bigplane_ember1;
    public static BufferedImage bigplane_ember2;
    public static BufferedImage bigplane_ember3;
    public static BufferedImage bullet;
    public static BufferedImage extraplane_ember0;
    public static BufferedImage extraplane_ember1;
    public static BufferedImage extraplane_ember2;
    public static BufferedImage extraplane_ember3;
    public static BufferedImage extraplane_ember4;
    public static BufferedImage extraplane_ember5;
    public static BufferedImage extraplane_hit;
    public static BufferedImage extraplane_n1;
    public static BufferedImage extraplane_n2;
    public static BufferedImage gameover;
    public static BufferedImage hero0;
    public static BufferedImage hero1;
    public static BufferedImage hero_ember0;
    public static BufferedImage hero_ember1;
    public static BufferedImage hero_ember2;
    public static BufferedImage hero_ember3;
    public static BufferedImage pause;
    public static BufferedImage start;
    // 静态代码块来实现图片的加载
    // 类加载时进行加载，节省了内存的空间
    static {
        try {
            shoe = ImageIO.read(Main.class.getResourceAsStream("pic/shoe.png"));
            shoe_demo01 = ImageIO.read(Main.class.getResourceAsStream("pic/shoe_demo01.png"));
            shoe_demo02 = ImageIO.read(Main.class.getResourceAsStream("pic/shoe_demo02.png"));
            shoe_demo03 = ImageIO.read(Main.class.getResourceAsStream("pic/shoe_demo03.png"));
            background_demo01 = ImageIO.read(Main.class.getResourceAsStream("pic/background_demo01.jpg"));
            airplane = ImageIO.read(Main.class.getResourceAsStream("pic/airplane.png"));
            airplane_ember0 = ImageIO.read(Main.class.getResourceAsStream("pic/airplane_ember0.png"));
            airplane_ember1 = ImageIO.read(Main.class.getResourceAsStream("pic/airplane_ember1.png"));
            airplane_ember2 = ImageIO.read(Main.class.getResourceAsStream("pic/airplane_ember2.png"));
            airplane_ember3 = ImageIO.read(Main.class.getResourceAsStream("pic/airplane_ember3.png"));
            background = ImageIO.read(Main.class.getResourceAsStream("pic/background.png"));
            bee = ImageIO.read(Main.class.getResourceAsStream("pic/bee.png"));
            bee_ember0 = ImageIO.read(Main.class.getResourceAsStream("pic/bee_ember0.png"));
            bee_ember1 = ImageIO.read(Main.class.getResourceAsStream("pic/bee_ember1.png"));
            bee_ember2 = ImageIO.read(Main.class.getResourceAsStream("pic/bee_ember2.png"));
            bee_ember3 = ImageIO.read(Main.class.getResourceAsStream("pic/bee_ember3.png"));
            bigplane = ImageIO.read(Main.class.getResourceAsStream("pic/bigplane.png"));
            bigplane_ember0 = ImageIO.read(Main.class.getResourceAsStream("pic/bigplane_ember0.png"));
            bigplane_ember1 = ImageIO.read(Main.class.getResourceAsStream("pic/bigplane_ember1.png"));
            bigplane_ember2 = ImageIO.read(Main.class.getResourceAsStream("pic/bigplane_ember2.png"));
            bigplane_ember3 = ImageIO.read(Main.class.getResourceAsStream("pic/bigplane_ember3.png"));
            bullet = ImageIO.read(Main.class.getResourceAsStream("pic/bullet.png"));
            extraplane_ember0 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_ember0.png"));
            extraplane_ember1 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_ember1.png"));
            extraplane_ember2 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_ember2.png"));
            extraplane_ember3 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_ember3.png"));
            extraplane_ember4 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_ember4.png"));
            extraplane_ember5 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_ember5.png"));
            extraplane_hit = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_hit.png"));
            extraplane_n1 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_n1.png"));
            extraplane_n2 = ImageIO.read(Main.class.getResourceAsStream("pic/extraplane_n2.png"));
            gameover = ImageIO.read(Main.class.getResourceAsStream("pic/gameover.png"));
            hero0 = ImageIO.read(Main.class.getResourceAsStream("pic/hero0.png"));
            hero1 = ImageIO.read(Main.class.getResourceAsStream("pic/hero1.png"));
            hero_ember0 = ImageIO.read(Main.class.getResourceAsStream("pic/hero_ember0.png"));
            hero_ember1 = ImageIO.read(Main.class.getResourceAsStream("pic/hero_ember1.png"));
            hero_ember2 = ImageIO.read(Main.class.getResourceAsStream("pic/hero_ember2.png"));
            hero_ember3 = ImageIO.read(Main.class.getResourceAsStream("pic/hero_ember3.png"));
            pause = ImageIO.read(Main.class.getResourceAsStream("pic/pause.png"));
            start = ImageIO.read(Main.class.getResourceAsStream("pic/start.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Hero hero = new Hero(); // 创建 Hero类 对象
    public static final int START = 0; // 定义游戏开始状态
    public static final int RUNNING = 1; // 定义游戏运行状态
    public static final int PAUSE = 2; // 定义游戏暂停状态
    public static final int GAMEOVER = 3; // 定义游戏结束状态
    private int state = START; // 定义游戏最初状态是开始状态
    // 用来存储飞行物（小敌机，大敌机，小蜜蜂）
    private ArrayList<Flyingobject> flys;
    // 用来存储子弹
    private ArrayList<Bullet> bullets;
    // 用来存储灰烬
    private ArrayList<Ember> embers;
    // 无参构造函数进行初始化
    Main() {
        // ArrayList<> 不会为null
        flys = new ArrayList<Flyingobject>();
        bullets = new ArrayList<Bullet>();
        embers = new ArrayList<Ember>();
    }
    // 定时器
    private java.util.Timer timer = new java.util.Timer();
    private void timerRun() {
        timer.schedule(new TimerTask() {
            // 重写循环方法
            @Override
            public void run() {
                // 创建飞行物（小敌机，大敌机，小蜜蜂）
                createFlyingObject();
                // 移动飞行物（小敌机，大敌机，小蜜蜂）
                moveFlyingObject();
                // 创建子弹
                createBullet();
                // 移动子弹
                moveBullet();
                // 英雄机震动
                moveHero();
                // 判断是否出界
                outOfBound();
                // 判断飞行物是否与子弹相撞
                bangBullet();
                // 判断飞行物是否与英雄机相撞
                bangHero();
                // 创建灰烬图
                switchEmber();
                // 重新画图
                repaint();
            }
        },20,10);
        // 监听器
        // 创建适配器 匿名内部类
        MouseAdapter adapter = new MouseAdapter() {
            // 鼠标点击
            @Override
            public void mouseClicked(MouseEvent e) {
                if (state == START) {
                    state = RUNNING; // 游戏开始状态 鼠标点击一下 变成游戏运行状态
                } else if (state == GAMEOVER) {
                    state = START; // 游戏结束状态 鼠标点击一下 变成游戏开始状态
                    // 把英雄机恢复成最初状态
                    hero.setX(150);
                    hero.setY(400);
                    hero.setLife(3);
                    hero.setScore(0);
                    // 清空子弹列表
                    bullets.clear();
/*                    Bullet bullet;
                    for(int i = 0; i < bullets.size(); i++) {
                        bullet = bullets.get(i);
                        bullet = null;
                    }*/
                    // 清空飞行物列表
                    flys.clear();
/*                    Flyingobject fly;
                    for(int i = 0; i < flys.size(); i++) {
                        fly = flys.get(i);
                        fly = null;
                    }*/
                }
            }
            // 鼠标进入
            @Override
            public void mouseEntered(MouseEvent e) {
                if (state == PAUSE) {
                    state = RUNNING; // 游戏暂停状态 鼠标移入窗口 变成游戏运行状态
                    // 重画
                    repaint();
                }
            }
            // 鼠标退出
            //@Override
            public void mouseExited(MouseEvent e) {
                if (state == RUNNING) {
                    int mouse_x = e.getX();
                    int mouse_y = e.getY();
                    // 判断是否超过窗口边界
                    if (mouse_x > WIDTH || mouse_x < 0 || mouse_y > HEIGHT || mouse_y < 0)
                    {
                        state = PAUSE; // 游戏运行状态 鼠标移出窗口 变成游戏暂停状态
                    }
                }
            }
            // 鼠标移动
            @Override
            public void mouseMoved(MouseEvent e) {
                if (state == RUNNING) {
                    int mouse_x = e.getX();
                    int mouse_y = e.getY();
                    hero.setX(mouse_x - (Main.hero0.getWidth() / 2));
                    hero.setY(mouse_y - (Main.hero0.getHeight() / 2));
                    // 重画
                    repaint();
                }
            }
        };
        this.addMouseListener(adapter); // 实现英雄机随鼠标点击、进入、退出
        this.addMouseMotionListener(adapter); // 实现英雄机随鼠标移动
    }

    // 用来计数，控制创建飞行物的时间
    private int createFlyingObjectCount = 0;
    // 创建飞行物（小敌机，大敌机，小蜜蜂）
    private void createFlyingObject() {
        // 在游戏运行状态时 才创建
        if (state == RUNNING) {
            createFlyingObjectCount ++;
            if (createFlyingObjectCount % 45 == 0) {
                // 多态创建各个飞行物
                Flyingobject fly;
                // 根据概率来创建各个飞行物
                int ran = (int)(Math.random() * 20);
                if (ran == 0) {
                    fly = new Bee(); // 创建小蜜蜂
                } else if (ran == 1 || ran == 2) {
                    fly = new Bigplane(); // 创建大飞机
                } else if (ran == 3 || ran == 4){
                    fly = new XXLplane(); // 创建超大飞机
                } else {
                    fly = new Airplane(); // 创建小敌机
                }
                // 把创建的飞行物存储到飞行物列表中
                flys.add(fly);
            }
        }
    }
    // 移动飞行器
    private void moveFlyingObject() {
        // 在游戏状态为运行时 才移动
        if (state == RUNNING) {
            for(int i = 0; i < flys.size(); i++) {
                // 从飞行物列表中获得各个飞行物
                Flyingobject fly = flys.get(i);
                // 调用各个飞行物的移动方法
                fly.move();
            }
        }
    }
    // 计数 控制创建子弹的时间
    private int createBulletCount = 0;
    // 创建子弹
    private void createBullet() {
        // 在游戏状态为运行时 才创建
        if (state == RUNNING) {
            createBulletCount ++;
            if (createBulletCount % 10 == 0) {
                // 接收英雄机发射的子弹
                Bullet[] bs = hero.shoot();
                for(int i = 0; i < bs.length; i++) {
                    // 将每个子弹加到子弹列表中
                    Bullet bullet = bs[i];
                    bullets.add(bullet);
                }
            }
        }
    }
    // 移动子弹
    private void moveBullet() {
        // 在游戏状态为运行时 才移动
        if (state == RUNNING) {
            for(int i = 0; i < bullets.size(); i++) {
                // 调用每个子弹的 move 方法
                Bullet bullet = bullets.get(i);
                bullet.move();
            }
        }
    }
    // 英雄机震动
    private void moveHero() {
        // 只有在游戏运行状态 才震动
        if (state == RUNNING) {
            hero.move();
        }
    }
    // 判断是否出界
    private void outOfBound() {
        // 判断飞行物是否出界
        for(int i = 0; i < flys.size(); i++) {
            // 从飞行物列表中获得各个飞行物
            Flyingobject fly = flys.get(i);
            // 飞行物的y坐标大于等于窗口高度
            if (fly.getY() >= Main.HEIGHT) {
                // 从飞行物列表中移除
                flys.remove(i);
                // 移除后列表会往前移 所以需要原位继续判断
                i --;
            }
        }
        // 判断子弹是否出界
        for(int i = 0; i < bullets.size(); i++) {
            // 从子弹列表中获得各个子弹
            Bullet bullet = bullets.get(i);
            // 子弹的y坐标小于等于负的子弹高度（而不是0）
            if (bullet.getY() <= -bullet.getHeigth()) {
                bullets.remove(i);
                // 移除后列表会往前移 所以需要原位继续判断
                i --;
            }
        }
    }
    // 判断子弹与飞行物是否相撞
    private void bangBullet() {
        Bullet bullet;
        Flyingobject fly;
        for(int i = 0; i < bullets.size(); i++) {
            bullet = bullets.get(i);
            for(int j = 0; j < flys.size(); j++) {
                fly = flys.get(j);
                // 判断子弹与飞行物
                if (fly.shootByFlyingObject(bullet)) {
                    // 飞行物生命值减1
                    fly.minusLife();
                    // 飞行物生命值为0时
                    if (fly.getLife() == 0) {
                        flys.remove(j); // 把飞行物从飞行物列表中移除
                        // 判断是否是加分数类型
                        if (fly instanceof AddScoreType) {
                            AddScoreType addScoreType = (AddScoreType)fly;
                            // 加分数
                            hero.addScore(addScoreType.getScore());
                        }
                        // 判断是否是奖励类型（有概率）
                        if (fly instanceof AwardType) {
                            AwardType awardType = (AwardType)fly;
                            if (awardType.getAward() == AwardType.ADD_LIFE) {
                                // 加生命值
                                hero.addLife();
                            } else if (awardType.getAward() == AwardType.DOUBLE_FIRE) {
                                // 双倍子弹
                                hero.doubleFire();
                            } else {
                                // 三倍子弹
                                hero.thirdFire();
                            }
                        }
                        // 创建清除的飞行物灰烬
                        Ember ember = new Ember(fly);
                        // 把灰烬加到灰烬列表上
                        embers.add(ember);
                    }
                    bullets.remove(i); // 把子弹从子弹列表中删除
                    i--; // 回到列表原来的位置重新开始判断新的子弹
                    break; // 跳出循环判断下一个子弹
                }
            }
        }
    }
    // 判断飞行物是否与英雄机相撞
    private void bangHero() {
        Flyingobject fly;
        for(int i = 0; i < flys.size(); i++) {
            fly = flys.get(i);
            // 判断
            if (hero.shootByHero(fly)) {
                hero.minusLife(); // 生命值减1
                flys.remove(i); // 把飞行物从飞行物列表中移除
                // 创建英雄机灰烬
                Ember ember = new Ember(hero);
                // 把英雄机灰烬加到灰烬列表上
                embers.add(ember);
                // 当英雄机生命值为0是 游戏结束
                if (hero.getLife() == 0) {
                    state = GAMEOVER;
                }
            }
        }
    }
    // 切换每一张灰烬图
    private void switchEmber() {
        Ember ember;
        for(int i = 0; i < embers.size(); i++) {
            ember = embers.get(i);
            // 获得每一张灰烬图
            if (ember.burnDown()) {
                // 切换完后从灰烬列表中移除灰烬
                embers.remove(i);
            }
        }
    }

    // 画板（画图）
    // 需要重写 paint 方法
    @Override
    public void paint(Graphics g) {
        // 不能放在最后
        // 清楚视图内容
        super.paint(g);
        // 画背景图（要放在最前面，因为要在最里层）
        //paintBackground(g);
        // 画生命值和分数
        paintString(g);
        // 画开始图
        paintStart(g);
        // 画英雄机
        paintHero(g);
        // 画飞行物（小敌机、大敌机、小蜜蜂）
        paintFlyingObject(g);
        // 画子弹
        paintBullet(g);
        // 画灰烬
        paintEmber(g);
        // 画暂停图
        paintPause(g);
        // 画游戏结束图
        paintGameover(g);
    }
    // 画背景图
/*    private void paintBackground(Graphics g) {
        g.drawImage(background,0,0,this);
    }*/
    private void paintBackground(Graphics g) {
        g.drawImage(background_demo01,0,0,this);
    }
    // 画英雄机
    private void paintHero(Graphics g) {
        g.drawImage(hero.getImage(),hero.getX(),hero.getY(),this);
    }
    // 画生命值和分数
    private void paintString(Graphics g) {
        g.drawString("分数: " + hero.getScore(),10,20);
        g.drawString("生命值: " + hero.getLife(),10,40);
    }
    // 画开始图
    private void paintStart(Graphics g) {
        if (state == START) {
            g.drawImage(start,0,0,this);
        }
    }
    // 画暂停图
    private void paintPause(Graphics g) {
        if (state == PAUSE) {
            g.drawImage(pause,0,0,this);
        }
    }
    // 画游戏结束图
    private void paintGameover(Graphics g) {
        if (state == GAMEOVER) {
            g.drawImage(gameover,0,0,this);
        }
    }
    // 画飞行物（小敌机、大敌机、小蜜蜂）
    private void paintFlyingObject(Graphics g) {
        // 游戏状态为运行、暂停、结束时都存在飞行物
        if (state != START) {
            for(int i = 0; i < flys.size(); i++) {
                // 从飞行物列表中依次获得飞行物
                Flyingobject fly = flys.get(i);
                // 画各个飞行物
                g.drawImage(fly.getImage(),fly.getX(),fly.getY(),this);
            }
        }
    }
    // 画子弹
    private void paintBullet(Graphics g) {
        // 游戏状态为运行、暂停、结束时都存在子弹
        if (state != START) {
            for(int i = 0; i < bullets.size(); i++) {
                // 从子弹列表中依次获得子弹
                Bullet bullet = bullets.get(i);
                // 画各个子弹
                g.drawImage(bullet.getImage(),bullet.getX(),bullet.getY(),this);
            }
        }
    }
    // 画灰烬
    private void paintEmber(Graphics g) {
        Ember ember;
        for(int i = 0; i < embers.size(); i++) {
            ember = embers.get(i);
            // 画每一张灰烬图
            g.drawImage(ember.getImage(),ember.getX(),ember.getY(),this);
        }

    }

    // 设置常量
    // 窗口的宽和高
    public static final int WIDTH = 400;
    public static final int HEIGHT = 650;
    public static void main(String[] args){
        JFrame window = new JFrame();
        Main paint = new Main();
        // 定时器
        paint.timerRun();
        window.add(paint);
        // 创建窗口大小
        window.setSize(WIDTH,HEIGHT);
        // 默认关闭窗口
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 置顶
        window.setAlwaysOnTop(true);
        // 居中
        window.setLocationRelativeTo(null);
        // 去掉边框
        window.setUndecorated(true);
        // 显示窗口 尽快调用 paint 方法
        window.setVisible(true);
    }
}
