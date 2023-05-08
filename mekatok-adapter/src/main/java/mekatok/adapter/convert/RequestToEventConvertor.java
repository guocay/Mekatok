package mekatok.adapter.convert;

import mekatok.core.component.extension.Convertor;
import mekatok.core.definition.RequestObject;

/**
 * 请求对象转事件对象 工具类
 * @author GuoCay
 * @since 2023.03.09
 */
public interface RequestToEventConvertor<IN extends RequestObject> extends Convertor<IN> {
}
