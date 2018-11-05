package ca.gc.aafc.seqdb.api.repository.aspect;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Named;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * Intercepts JpaResourceRepository methods to trim all string properties on modified resources.
 * e.g. " Mat " becomes "Mat"
 */
@Aspect
@Named
@ConditionalOnProperty(name = "seqdb.trim-resource-string-properties", havingValue = "true")
public class TrimResourceStringPropertiesAspect {

  /**
   * Intercepts the "create" operation to trim String properties.
   * 
   * @param joinPoint
   *          Provides reflective access to both the state available at a join point and static
   *          information about it.
   * @param resource
   *          The input DTO to be saved.
   * @return The saved DTO.
   * @throws Throwable
   */
  @Around(
      "execution(* ca.gc.aafc.seqdb.api.repository.JpaResourceRepository+.create(..))"
      + " && args(resource)"
  )
  public Object createInterceptor(ProceedingJoinPoint joinPoint, Object resource) throws Throwable {
    this.trimStringFields(resource);
    return joinPoint.proceed(joinPoint.getArgs());
  }

  /**
   * Intercepts the "save" operation to trim String properties.
   * 
   * @param joinPoint
   *          Provides reflective access to both the state available at a join point and static
   *          information about it.
   * @param resource
   *          The input DTO to be saved.
   * @return The saved DTO.
   * @throws Throwable
   */
  @Around(
      "execution(* ca.gc.aafc.seqdb.api.repository.JpaResourceRepository+.save(..))"
      + " && args(resource)"
  )
  public Object saveInterceptor(ProceedingJoinPoint joinPoint, Object resource) throws Throwable {
    this.trimStringFields(resource);
    return joinPoint.proceed(joinPoint.getArgs());
  }

  /**
   * Trims all string properties on a resource DTO.
   * e.g. " Mat " becomes "Mat".
   * 
   * @param resource
   */
  private void trimStringFields(Object resource) {
    List<PropertyDescriptor> stringFields = Stream
        .of(BeanUtils.getPropertyDescriptors(resource.getClass()))
        .filter(field -> field.getPropertyType().equals(String.class)).collect(Collectors.toList());

    for (PropertyDescriptor stringField : stringFields) {
      Method readMethod = stringField.getReadMethod();
      Method writeMethod = stringField.getWriteMethod();
      try {
        String value = (String) readMethod.invoke(resource);
        if (value != null) {
          writeMethod.invoke(resource, readMethod.invoke(resource).toString().trim());
        }
      } catch (IllegalAccessException | InvocationTargetException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
