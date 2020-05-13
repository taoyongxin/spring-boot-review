# Spring-boot-application模块
> 在Spring Boot的入口类中，我们通常是通过调用SpringApplication的run方法来启动Spring Boot项目
> 因此，了解SpringApplication的运行机制是有必要的

## 1、SpringApplication 启动类
 * 禁用默认启动
 * 构建SpringApplication类对象
 * 自定义设置
 * 调用该对象的run()方法启动

## 2、SpringApplication实例的初始化
* 推断应用的类型：创建的事REACTIVE应用、SERVLET应用、NONE三种中的某一个
* 使用SpringFactoriesLoader查找并加载classpath下META-INF/spring.factories文件中所有可用的ApplicationContextInitializer
* 使用SpringFactoriesLoader查找并加载classpath下META-INF/spring.factories文件中的所有可用的ApplicationListener
* 推断并设置main方法的定义类

## 3、SpringApplication的run()方法
* 通过SpringFactoriesLoader加载META-INF/spring.factories文件，获取并创建SpringApplicationRunListener对象
* 然后由SpringApplicationRunListener来发出starting消息
* 创建参数，并配置当前SpringBoot应用将要使用的Environment
* 完成之后，依然由SpringApplicationRunListener来发出EnvironmentPrepared消息
* 创建ApplicationContext
* 初始化ApplicationContent，并设置Environment，加载相关配置等
* 由SpringApplicationRunListener来发出contentPrepared消息，告知SpringBoot应用使用ApplicationContext已准备OK
* 将各种beans装载入ApplicationContext，继续由SpringApplicationRunListener来发出contextLoaded消息，告知SpringBoot应用使用的ApplicationContext已装填OK
* refresh ApplicationRunListener来发出started消息
* 完成最终的程序的启动
* 由SpringApplicationRunListener来发出running消息，告知程序已运行起来了