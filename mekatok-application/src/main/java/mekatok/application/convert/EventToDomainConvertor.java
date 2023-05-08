package mekatok.application.convert;

import mekatok.application.event.AbstractEventObject;
import mekatok.core.component.extension.Convertor;

/**
 * 事件对象转领域对象 工具类
 * @author GuoCay
 * @since 2023.03.09
 */
public interface EventToDomainConvertor<IN extends AbstractEventObject> extends Convertor<IN> {
}
