package domain;

public class Car {

  private Engine engine;
  private Transmission transmission;

  public Car(Engine engine, Transmission transmission) {
    this.engine = engine;
    this.transmission = transmission;
  }

  @Override
  public String toString() {
    return String.format("Engine: %s Transmission: %s", engine, transmission);
  }
}
