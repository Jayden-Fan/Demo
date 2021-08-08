# 一.Springboot启动原理

```java
@SpringBootApplication
@MapperScan("com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
```

@**SpringBootApplication:** 标注在某个类说明该类是SpringBoot的主配置类，通过运行该类的main方法来启动SpringBoot应用。

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
```

@**SpringBootConfiguration**:Spring Boot的配置类；

​	标注在某个类上，表示这是一个Spring Boot的配置类；

​	@**Configuration**:在配置类上标注这个注解；

​		配置类 ---- 配置文件；配置类也是容器中的一个组件；

@Component : 表示这是一个组件



@**EnableAutoConfiguration**: 开启自动配置功能；

```java
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
```

@**AutoConfigurationPackage**:将添加该注解的类所在的package作为自动配置package进行管理。

​	@**Import**({Registrar.class})：通过Registrar将主配置类的所在包及下面所有子包里面的所有组件扫描到Spring容器。

@**Import**：用来导入配置类或者一些需要前置加载的类

@Import({AutoConfigurationImportSelector.class})：给容器导入非常多的自动配置类。

