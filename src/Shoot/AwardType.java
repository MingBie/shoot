package Shoot;

public interface AwardType {
    // 定义常量 奖励的类型
    public static int ADD_LIFE = 0;
    public static int DOUBLE_FIRE = 1;
    //获得奖励类型
    public abstract int getAward();
}
