package mekatok.infrastructure.convert;

import mekatok.core.component.extension.Convertor;
import mekatok.core.definition.MappedObject;

/**
 * @author aCay
 * @since 2023.03.09
 */
public interface MappedToDomainConvertor<IN extends MappedObject> extends Convertor<IN> {
}
