package mekatok.core.definition;

/**
 * 命令类型
 * @author aCay
 * @since 2023/3/6
 */
public enum EventType {

    /**
     * 其他
     */
    OTHER(0),
    /**
     * 命令
     */
    COMMAND(1),
    /**
     * 查询
     */
    QUERY(2);

    private int type = 0;

    EventType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
