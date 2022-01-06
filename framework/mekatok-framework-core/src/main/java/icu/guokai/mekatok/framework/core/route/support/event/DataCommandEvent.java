package icu.guokai.mekatok.framework.core.route.support.event;

import com.baomidou.mybatisplus.annotation.TableName;
import icu.guokai.mekatok.framework.core.event.Event;
import icu.guokai.mekatok.framework.core.model.domain.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author GuoKai
 * @date 2022/1/6
 */
@ToString
@EqualsAndHashCode
public class DataCommandEvent extends Event<Table<?>> {

    /**
     * 命令类型
     */
    private final Commands command;

    /**
     * 构造器
     * @param source 元数据
     */
    public DataCommandEvent(Table<?> source) {
        super(source);
        this.command = Commands.DEFAULT;
    }

    /**
     * 构造器
     * @param source 元数据
     * @param command 命令模型
     */
    public DataCommandEvent(Table<?> source, Commands command){
        super(source);
        this.command = command;
    }

    /**
     * 是否 指定 命令模型
     * @param command 命令
     * @return 是否
     */
    public Boolean is(Commands command){
        return this.command.equals(command);
    }

    /**
     * 判断 是否 当前表的数据
     * @param tableName 表名
     * @return 是否
     */
    public Boolean is(String tableName){
        try {
            return tableName.equals(getMeta().getClass().getAnnotation(TableName.class).value());
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public String description() {
        return "数据命令事件";
    }
}
