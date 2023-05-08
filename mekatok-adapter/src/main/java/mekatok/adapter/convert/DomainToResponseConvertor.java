package mekatok.adapter.convert;

import mekatok.core.component.extension.Convertor;
import mekatok.core.definition.AggregateObject;

/**
 * 领域对象转响应对象 工具类
 * @author GuoCay
 * @since 2023.03.09
 */
public interface DomainToResponseConvertor<IN extends AggregateObject> extends Convertor<IN> {
}
