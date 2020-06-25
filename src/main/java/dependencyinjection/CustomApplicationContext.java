package dependencyinjection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CustomApplicationContext {

  private Map<String, Object> appContext;


  public CustomApplicationContext(Class configFile) {
    initializeBeans(configFile);
  }

  public Object getBean(Class beanClass) {
    Constructor[] constructors = beanClass.getConstructors();
    Object object = null;
    try {
      Class[] constructorClasses = constructors[0].getParameterTypes();
      Object[] initializedBeans = new Object[constructorClasses.length];
      for (int i = 0; i < constructorClasses.length; i++) {
        initializedBeans[i] = appContext.get(constructorClasses[i].getSimpleName());
      }
      object = constructors[0]
          .newInstance(initializedBeans);
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return object;
  }

  private void initializeBeans(Class configClass) {
    appContext = new HashMap<>();
    try {
      for (Method method : configClass.getDeclaredMethods()) {
        if (method.isAnnotationPresent(CustomBean.class)) {
          CustomBean methodAnno = method.getAnnotation(CustomBean.class);
          method.setAccessible(true);
          Object initializedObject = method.invoke(configClass.newInstance());
          if (methodAnno.scope().equalsIgnoreCase("singleton")) {
            if (appContext.get(initializedObject.getClass().getSimpleName()) != null) {
              return;
            }
          }
          appContext.put(initializedObject.getClass().getSimpleName(), initializedObject);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
