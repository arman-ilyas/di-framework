package config;

import dependencyinjection.CustomBean;
import domain.Engine;
import domain.Transmission;

public class Config {

  @CustomBean
  public Engine engine() {
    return new Engine("v8", 5);
  }

  @CustomBean(scope = "prototype")
  public Transmission transmission() {
    return new Transmission("sliding");
  }
}
