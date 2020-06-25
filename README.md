# My Dependency Injection Framework

This code will inject the dependencies through the object's constructor and return constructed object without using Spring or any other framework.

## Getting Started / Usage Guide

Just run the main method inside the DependencyInjectionApplication.class. 

## Design considerations
### Java Config File
This app is designed in such a way that we are reading java config file which specifies the scope and beans that should be loaded to the application context.
Java config file also specifies how the beans should be created. i.e. it's values <br />
### Custom application Context and getting the beans
When we call getBean(Class class) we will retrieve the constructor's parameters. These are the dependencies that we need to inject. <br />
Once we know what are the required dependencies by reading the constructor's parameter types, then we will look them up inside the map that stores previously initialized beans from the config files.
<br />Then we will construct the required object by calling it's constructor and by providing the dependencies to consructor.<br />
Just as POC we can call toString() method and see if we can inject correct dependencies.<br />

## Tech Used
* Java Custom Annotations
* Java Reflection

## Oooopppsss
This project doesn't have any unit tests because of the time limitations.

## License

This project is licensed under the GNU General Public License v3.0 - see the [LICENSE](LICENSE) file for details
