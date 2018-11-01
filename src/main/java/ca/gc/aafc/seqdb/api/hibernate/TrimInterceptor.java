package ca.gc.aafc.seqdb.api.hibernate;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.EmptyInterceptor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Configuration;

/**
 * Intercepts Hibernate events to trim all string properties on modified entities.
 * e.g. " Mat " becomes "Mat"
 */
@SuppressWarnings("serial")
@Configuration
public class TrimInterceptor extends EmptyInterceptor {

  /**
   * Called before Hibernate's flush operation to trim all string properties on modified entities.
   */
  @SuppressWarnings("unchecked")
  @Override
  public void preFlush(Iterator entities) {
    entities.forEachRemaining(this::trimStringFields);
  }

  /**
   * Trims all string properties on a JPA entity instance.
   * e.g. " Mat " becomes "Mat".
   * 
   * @param entity
   */
  private void trimStringFields(Object entity) {
    List<PropertyDescriptor> stringFields = Stream
        .of(BeanUtils.getPropertyDescriptors(entity.getClass()))
        .filter(field -> field.getPropertyType().equals(String.class)).collect(Collectors.toList());

    for (PropertyDescriptor stringField : stringFields) {
      Method readMethod = stringField.getReadMethod();
      Method writeMethod = stringField.getWriteMethod();
      try {
        String value = (String) readMethod.invoke(entity);
        if (value != null) {
          writeMethod.invoke(entity, readMethod.invoke(entity).toString().trim());
        }
      } catch (IllegalAccessException | InvocationTargetException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
