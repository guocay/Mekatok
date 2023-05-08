package mekatok.infrastructure.convert;

import mekatok.core.component.extension.Convertor;
import mekatok.core.definition.AggregateObject;

/**
 * 领域对象转换为映射对象的工具类
 * @author GuoCay
 * @since 2023/3/6
 */
public interface DomainToMappedConvertor<IN extends AggregateObject> extends Convertor<IN> {
}
