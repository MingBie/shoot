package Shoot;

public interface AwardType {
    // 定义常量 奖励的类型
    public static int ADD_LIFE = 0; // 加分数
    public static int DOUBLE_FIRE = 1; // 双倍子弹
    public static int THIRD_FIRE = 2; // 三倍子弹
    //获得奖励类型
    public abstract int getAward();
}
