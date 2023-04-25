package com.github.guokaia.mekatok.common.model;

import com.github.guokaia.mekatok.core.model.Packing;
import com.github.guokaia.mekatok.core.model.Paging;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 通用的分页对象
 * @author GuoKai
 * @date 2022/2/4
 */
@Data
@ApiModel("分页对象")
public class GeneralPaging<T extends Packing<T>> implements Paging<T> {

    /**
     * 记录
     */
    @ApiModelProperty("记录")
    private List<T> records;

    /**
     * 总数
     */
    @ApiModelProperty("总数")
    private Long total;

    /**
     * 每页条数
     */
    @ApiModelProperty("每页条数")
    private Long size;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    private Long current;

    /**
     * 操作返回的容器表示成功
     */
    private Boolean success = Boolean.TRUE;

    /**
     * 当前时间
     */
    private LocalDateTime timestamp;

    /**
     * 无参构造器
     */
    public GeneralPaging(){
        this(new ArrayList<>(), 0L, -1L, 1L);
    }

    /**
     * 构造函数
     * @param packing 包装壳
     */
    public GeneralPaging(T packing){
        this();
        this.records.add(packing);
        if (Objects.nonNull(packing)){
            this.total = 1L;
        }
    }

    /**
     * 构造函数
     * @param records 记录
     */
    public GeneralPaging(List<T> records){
        this(records, (long) records.size(), -1L, 1L);
    }

    /**
     * 构造函数
     * @param records 记录
     * @param total 总数
     * @param size 每页大小
     * @param current 当前页
     */
    public GeneralPaging(List<T> records, Long total, Long size, Long current){
        this.records = records;
        this.total = total;
        this.size = size;
        this.current = current;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * 静态构造函数
     * @param packing 包装壳
     * @param <T> 泛型
     * @return 容器
     */
    public static <T extends Packing<T>> GeneralPaging<T> of(T packing){
        return new GeneralPaging<>(packing);
    }

    /**
     * 静态构造函数
     * @param list 包装壳集合
     * @param <T> 泛型
     * @return 容器
     */
    public static <T extends Packing<T>> GeneralPaging<T> of(List<T> list){
        return new GeneralPaging<>(list);
    }

    /**
     * 静态构造函数
     * @param <T> 泛型
     * @param records 记录
     * @param total 总数
     * @param size 每页大小
     * @param current 当前页
     * @return 容器
     */
    public static <T extends Packing<T>> GeneralPaging<T> of(List<T> records, Long total, Long size, Long current){
        return new GeneralPaging<>(records, total, size, current);
    }

    /**
     * 静态构造函数
     * @param <T> 泛型
     * @param records 记录
     * @param total 总数
     * @param size 每页大小
     * @param current 当前页
     * @return 容器
     */
    public static <T extends Packing<T>> GeneralPaging<T> of(List<T> records, Integer total, Integer size, Integer current){
        return new GeneralPaging<>(records, total.longValue(), size.longValue(), current.longValue());
    }

}
