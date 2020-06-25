import config.Config;
import dependencyinjection.CustomApplicationContext;
import domain.Car;

public class DependencyInjectionApplication {

  public static void main(String[] args) {
    Car toyota = (Car) getCarFromJavaConfig();
    System.out.println(toyota);
  }

  private static Object getCarFromJavaConfig() {
    CustomApplicationContext context = new CustomApplicationContext(Config.class);
    return context.getBean(Car.class);
  }


}
