Spring Boot 
============

## 1. 不用Spring Boot的痛苦是什么

+ 各种技术整合在一起，版本混乱，大量依赖自己去找，依赖冲突
+ 基于xml格式的配置文件，对各种技术框架进行大量的繁琐配置，mvc-servlet.xml，applicationContext.xml，mybatis-config.xml，web.xml
+ web系统跑起来测一下，需要与tomcat等web容器整合起来才能测试
+ 单元测试的时候需要自己去选择和导入需要的各种测试组件的依赖，junit，hamcrest，mockito，很多组件
+ 部署打包的时候需要自己去配置打包插件
+ 部署应用上线之后，没法去对线上的应用，包括jvm堆栈等方方面面进行监控，没有方便的办法去看到这些东西

传统的以spring为核心的web系统开发，从启动项目、开发、测试、部署以及监控，都很麻烦，有大量需要手工做的事情

***

## 2. 用了Spring Boot以后的好处是什么

spring社区意识到了这些问题，开发人员一定是最讨厌繁琐的，希望的都是用技术提高工作效率。因此推出了spring boot框架，作为开发spring项目的一个脚手架，脚手架，类似于一个封装在各种技术之上的一个基础框架，基础模板。脚手架帮助我们快速整合需要使用的技术框架，快速开发、测试以及部署和监控，节约我们的成本。如果没有spring boot，很多公司，特别是一些大公司，会将spring mvc 、mbatis、spring这些框架再度根据自己公司的开发经验、规范和实际情况，再度封装，进一步简化每个新项目使用框架的一个成本

Spring Boot是spring官方社区推出的，设计思想，架构思想，是更好的，更加优雅的

+ spring boot负责统一各个依赖的版本，保证各种技术的版本之间兼容，自动引入需要的各种依赖。spring boot 1.5.9，在这个版本基础之上，你引入的spring、mybatis、spring mvc、redis、zookeeper、kafka、mongodb，等等各种技术，在spring boot1.5.9这个大版本的基础之上，其实所有技术的版本都是互相兼容的，省去了我们自己去寻找版本整合，解决不兼容问题的一个过程

+ 所有技术整合进来之后，不需要xml配置，spring boot全部是大量基于按照约定的自动配置，自动生成那些技术相关的一些bean，注入spring容器供使用，基于注解进行少量注释，基于application.properties，少量的配置即可

+ spring boot支持内嵌的web容器，上来直接启动一个main方法就可以启动一个内嵌的tomcat web容器+web程序，快速上手测试，http://localhost:8080/

+ 一键引入需要的所有单元测试组件依赖，所有测试组件的版本兼容，支持controller、service、dao各种测试

+ 默认声明一个插件，自己给你把插件配置好了，支持打包成可以执行的jar包或者是war包

+ 系统上线之后，默认支持大量的线上应用的监控metrics，可以看到线上应用的jvm堆栈，等等信息

***


## 3. 对于Spring Boot这种框架型技术该如何学习？

+ spring core，那么多复杂的功能，你都学习了吗？spring mvc那么多复杂的功能，你都学习了吗？否，20%。

+ 你在工作中都会用到spring core和spring mvc，这些框架100%的功能，你都使用了吗？否，20%。

+ 在面试的时候，有面试官不会揪着spring core和spring mvc的各种生僻冷门的功能、api/方法的细节

+ **技术分成五种：框架性的技术，中间件的技术，架构，项目经验，底层技术。框架型的技术**，28法则，20%的核心功能，就足够项目中的使用了。学了剩下80%的功能，几乎很少用到，而且功能性的东西，学习，几乎是零成本，你只要掌握了20%的功能，就已经学会了这个技术的基础了，如果你后面项目里需要80%的冷门功能，百度，官网，只要是个大脑正常的工程师，自己都可以搞定。

+ **重要的是，迅速掌握20%核心功能，务必熟练，然后就用这20%的核心功能，80%的项目**，你都可以做了；接着对剩下百分之80的冷门功能，可以先看一看，项目不一定能用到，未来20%的特殊项目中有需要的时候，迅速通过百度+官网，找到80%的冷门功能中哪些是你需要使用的，快速学习一下，引入项目中来使用即可；最后有些冷门的东西，包括概念和功能，也许你一辈子都用不到。spring core那份官方文档里，可能有50%的东西，我工作10年+，项目，几乎从没用过。如果有些课程没讲到的冷门东西，你项目中真要使用，很简单，百度一下，或者看一下官网，这是工程师的必备能力，总不能饿永远靠着课程里教的东西在活着吧，学习能力很重要

+ **对于框架型技术来说，更重要的，是看源码，掌握其底层的设计原理和架构思想，包括技术亮点，提升自己的内功修为**。工作中用这个技术遇到报错，直接源码分析定位，不用借助他人，hold住全场；很厉害的，spring boot，spring ，mybatis，spring mvc，真正难的不是使用，难的是在工作中遇到了各种报错，看到了异常堆栈，傻眼了，没法处理。架构师，一条，hold住全场，你去大部分的公司，大公司，小公司，技术问题的方方面面，能hold住全场，任何问题出了你是公司的技术力量的制高点，最后一道防线，你一定能解决任何的问题。可以称之为技术专家，高级技术专家，资深技术专家，架构师。提升你的技术内功的修为，大量的借鉴开源框架源码中的设计思想、架构思想、核心技术，应用到自己的系统设计中；读更多的优秀的开源框架的源码，你的内功修为就越高，你在设计自己的系统的时候，系统架构设计的更好

+ **技术每隔几年就翻新一次，如果每次都是跟着学一些框架功能和使用，费力不讨好，如果不断研究源码，内功修为深厚，会发现大道相通，每次技术更新，你都能快速掌握新的技术。**struts2+spring+hibernate, spring mvc+spring+mybatis, spring boot+spring mvc+spring+mybatis, spring cloud+spring boot+spring mvc+spring+mybatis。每次出一个新技术，光是看一看功能，你就能猜测到背后的源码是怎么写的，站在这种内功修为的基础之上，你学习任何新技术，事半功倍，效率是普通的几倍。对技术你掌握到了源码层面，面试有强大优势和竞争力，这是程序员的硬功夫，立身之本，出去面试可以甩开99%的普通工程师几条街。学会用一个框架，只要不是傻子，都能学会，所以如果你工作很多年，仅仅只是会用一些技术框架，你觉得你的技术有什么竞争力可言？但是读懂大量的开源框架的源码，积累深厚的技术功底，这个是需要大量的时间去积累的，有一个老师能够带着你给你去讲解，90%的人靠自己读源码，不现实，功力不够，读不会，读不懂，最后没法读源码，能尝试读懂一点点源码，但是没法彻底吸收，融会贯通。源码读懂，吸收，融会贯通。核心竞争力，不是说普通人可以随随便便赶上你的了。

+ 按照这个思路学习框架型技术的效果, 出去工作，20%的功能会用，没问题，上手开发一点问题都没有；出去面试，有源码兜底，强悍的竞争力

***

## 4. 我们的课程对spring boot框架型技术的学习思路
#### 看一下网上别人的spring boot类技术课程，还有书籍，讲的大而全，spring boot的方方面面都有了。但是看了一遍，都是理论，根本不知道项目中怎么使用

书籍：大而全，什么都有，专注于完整的功能讲解
视频课程：大而全，什么都有，专注于完整的功能的讲解

如果这么去学习一门技术的话，如果我们这个课程跟他们一样，按照一样的思路去讲解spring boot技术，那我觉得我是失败的。因为我是不认可这种技术学习的思路的。你学到的就是一堆理论型的技术而已，你不知道在项目里应该怎么结合项目、业务需求、业务功能来使用，而且你光是学纯理论，过一段时间就忘了；如果你能在项目中大量的去实践这个技术，记忆和印象会非常的深刻

不能对框架型的技术学习，不能这样子学，大而全的，一方面很多东西，如果不能立刻用到项目中去，你的掌握很薄弱，你不知道这些技术怎么结合项目来使用；如果没有办法将学到的技术，立即投入项目中去使用，你很快会忘记，记忆会很不深刻

技术能力，其实都是围绕着我们的工作经历，项目经验，发展起来的。我做过这个东西，我学过这个东西。你的理解很深刻， 记忆很深刻，你实际知道这个东西是怎么在项目里用的。

技术的学习，无论是什么，都务必要跟项目和实践结合起来，否则的就是纸上谈兵，很容易遗忘，出去找工作，面试

#### 在每个阶段，针对这个阶段项目要做的事情，我们就学习这个框架需要使用的功能，过框架学习的时候，速度要快，别耗费太多精力在这里扣细节，框架学习的重点是快速学会后用到项目里去，大量开发业务需求，实践中来掌握
spring boot，会被拆分为多个阶段去学习，我们会完全按照公司里的随着项目演进，不断加深学习一门技术和不断实践的一个思路，带着大家去走

我们的项目是分成很多个阶段，阶段一，阶段一的技术挑战是比较小的，我们就去学习spring boot 20%的核心功能即可，我们快速几个小时学完以后，每个人都能上手开干，立即投入项目中，大量的去写业务功能，实践，加深你的印象

当然，阶段一，重点会剖析spring boot框架的核心源码，才是我们真正要花费实践在spring boot上的，竞争力

后面随着每个阶段的进展，比如我们的阶段二，要使用redis技术，然后我们就先学spring boot如何跟redis整合使用，立刻投入到项目中，大量跟项目整合来使用，印象会非常深刻，我们会同步剖析spring boot跟redis整合部分的源码

#### 随着项目阶段不断前进，对于框架型技术的学习会逐步完善，而且每一块的学习，都会是快速过功能，然后迅速用到项目中去实践的思路

#### 但是对核心框架的源码，必须100%要分析，因为这才是真正的重点和工程师的核心竞争力
我们整个技术体系里，框架型技术，实际上不多，spring boot，spring cloud

很多的技术，是中间件型的技术，redis、zookeeper、kafka。中间件型的技术，学习的思路就完全不一样了。非常非常重要的，务必是说把80%的核心功能都要掌握，然后尽可能在项目中将80%的核心功能都给实践了，同时尽量对重要的中间件，都要去剖析里面的源码。招聘需求的时候，深刻理解分布式的消息、缓存、存储、搜索，redis内核源码、zookeeper内核源码、kafka内核源码、elasticsearch内核源码。让大家不是仅仅只是学会用一个中间件技术，而是要从根本上的底层原理，去掌握分布式的缓存、分布式的协调、分布式的消息、分布式的搜索、分布式的存储。

***

## 5. 我们这个小阶段学什么

阶段一，其实只要掌握spring boot 20%的核心功能，就足够了，立刻就开始动手开发，去做项目

+ Spring Boot快速入门
+ Spring Boot与Spring MVC+Spring+MyBatis的整合使用以及RESTful接口的支持
+ Spring Boot框架配置
+ Spring Boot单元测试
+ Spring Boot打印日志
+ Spring Boot应用部署
+ Spring Boot应用监控

按照公司的规范，编写一份Spring Boot的技术调研文档

上面这些东西就完全可以支持我们阶段一的项目开发了，其实我们就是要用spring boot整合spring mvc+spring+mybatis来进行基础的开发，对外提供restful接口，进行单元测试，打印日志，最终部署一个单块的web应用，然后线上可以进行监控，仅此而已，完全足够我们用了

在开发完电商系统v1.0之后，我们来剖析一下spring boot使用到的这些部分的源代码，看源码，将从这里开始，同时还会讲解如何手写starter来支持任意技术与spring boot整合，比如公司自行研发的框架之类的东西

***

## 6. 我们这个小阶段不学什么以及未来阶段学什么

**Spring Boot与thymeleaf、freemarker等模板技术的整合**

这个阶段暂时不学习

纯后端放所有的java代码和前端模板页面，因为这个未来不是主流趋势了，主流趋势是前后端分离，我们后端工程师不再关注页面上的东西，纯碎关注后台架构，提供RESTful接口或者是rpc接口给前端工程师调用。大公司全部是这样，中小型公司未来主流也该是这样。

未来只有那种非常小的项目，前台后台都是一个人写的项目，大学生的毕业设计，适合采用jsp、thymleaf模板放java工程里，后端工程师一个人写了

我们会提到一点，但是不会耗费大量精力去琢磨spring boot跟各种模板技术整合的细节

到了后面，做高并发系统架构的时候，一定会涉及到大型电商系统的复杂的页面静态化架构，那个时候我们再来结合具体的架构和项目讲解与模板技术的整合


**Spring Boot与Spring Data JPA的整合**

不学习， JPA，Java Persistence API，java持久化API，ORM的概念，hibernate。就是不需要你写sql，直接你就是面向对象去操作和开发，从一个对象里面去get一个集合，此时hibernate会自动给发送sql查询数据。hibernate，性能很低，自动生成的sql都有问题。开发效率很高，很好维护，不需要写sql.

ORM框架很好，但是比较适合传统IT行业，性能要求不高，开发速度要求很高。我最近这么多年的工作，已经很少见到有用hibernate的了。一般都是mybatis类的框架，支持写SQL，加上一些mybatis对sql的特殊功能的支持。java工程师精通写sql必须的，写sql不是java工程师的活儿，是dba的活儿，java工程师只要面向对象就可以了。

暂时没看到需要学习这块的必要性


**Spring Boot与中间件技术的整合**

mongodb、redis、elasticsearch、cache支持、分布式session支持、zookeeper、kafka 暂时不学习

spring boot整合mongodb，mongodb的核心概念以及CRUD的操作

等到后面项目进展到要用mongodb、redis、elasticsearch的时候，自然就会学习如何Spring Boot与这些技术整合在一起使用了，这都不是事儿，学完了立即投入项目中，剖析他的源码

等项目进展到要搭建缓存架构的时候，自然会学习cache支持，项目做成分布式系统之后，要用到分布式session的时候，自然会学习分布式session的支持，引入zookeeper、kafka的时候，自然会学习如何整合


**Spring Boot与jdbcTemplate的整合**

这种技术都没必要讲解了吧，包括jdbc的使用之类的，太原始了，spring boot为了大而全提供了这个支持，但是不意味着我们要讲解和使用，现在机会很少见到项目是用JdbcTemplate的


**Spring Boot与websocket、webservice的整合**

这些其实都是spring boot提供的功能，同上，为了大而全，spring boot一定会提供大量的功能，但是我们不一定要使用。websocket是一个很不错的技术，常用于浏览器和服务端进行频繁大量的通信，就是浏览器需要主动跟服务端进行频繁的大量的交互，不断的刷新和更新数据。

不是普通的那种系统开发要用的技术，常见的场景是：社交聊天、弹幕、网页游戏、股票基金实时价格、体育实况更新、视频会议、在线教育，等等。

这个我们看后面课程具体的发展情况，如果有合适的场景，比如电商系统的聊天系统，让用户与客服沟通，可以使用websocket技术，等真正用到这个技术的时候，我们再来讲解

而至于webservice，未来都是微服务的天下了，这类webservice，SOA，技术以后可能会逐步退出历史舞台

**Spring Boot与安全技术的整合**

spring security，oauth2

这个不会放这儿讲解，会放到后面专门的一大块安全性架构中去讲解，针对各种安全性需求，spring boot这块可以做什么


**Spring Boot对定时调度的支持**

这个以后电商系统里一定会有定时调度的需求的，到时候再讲解

其实你能在网上看到的一些书籍或者视频课程里的东西，我们的整套课程后面是一定都会包含的，只不过采取我的授课思路，逐步演进式的学习

spring boot官方手册里的一些东西，随着我们系统的不断深入，如果要使用到一些东西，我都会带着大家不断的去学习使用的

***



## 7. Spring Boot 初体验
#### 创建 Spring Boot 工程
- 创建一个空的maven工程
- 在pom.xml中引入spring boot的依赖
```xml
<!-- 继承spring boot的父工程 -->
<!-- spring boot父工程直接约束了常用依赖的版本 -->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
</parent>
<!-- 添加一个支持web应用的spring boot依赖 -->
<!-- spring boot会根据我们引入的依赖，判断出来我们要开发一个web工程 -->
<!-- 接着会对web工程需要的东西，比如tomcat服务器，自动进行配置 -->
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
<!-- 引入一个spring boot插件，可以支持我们打包程序 -->
<!-- 打包时是需要将所有依赖的第三方jar包都打进来的，spring boot这个插件可以支持 -->
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>

```
- 编写代码
```java
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
// @RestController会告诉spring boot，这是一个spring mvc的controller
// 同时@RestController默认就是支持将返回值直接给浏览器的，而不是去渲染视图
@RestController
// auto configuration，是spring boot最最重要和核心的功能之一
// spring boot的核心思想，就是不要去做太多的xml配置，全部基于约定的一些规则，自动完成一些配置
// auto configuration，就会根据我们引入的一些依赖，比如引入spring-boot-starter-web，就会根据我们要开发web程序的特点，自动完成tomcat服务器等相关的web配置
@EnableAutoConfiguration
public class HelloWorldApplication {
    // @RequestMapping，就是做http请求的路由
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello world";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
```
- 直接在eclipse中执行main方法，就可以启动spring boot应用
- 将spring boot应用打包成可以直接执行的jar包   
    + 因为我们之前使用了spring-boot-maven-plugin插件，所以可以直接打包，就会包含依赖的所有第三方jar包，成为一个可以执行的jar包
    + mvn pakcage
    + 执行这个jar包：java -jar target\springboot-demo-1.0.0.jar

#### Spring Boot 知识点梳理
**spring-boot-starter-parent的作用**

+ 默认的编译级别是JDK 1.6
+ 指定了UTF-8为source coding
+ 有一个<dependencyManagement>声明，对spring boot可以集成的大部分流行第三方依赖，都指定了对应的可以互相兼容的版本
+ 开启了资源过滤器，支持对应资源文件中占位符的替换
+ 指定了多个插件：exec、surefire、git commit id、shade，用来支持运行、测试、版本控制、打包

**不直接继承spring-boot-starter-parent**

如果要继承自己的parent工程，而不是直接继承spring-boot-starter-parent，那么可以考虑使用import方式，将spring-boot-start-parent中的dependency management引入进来。但是这样的话，就没法用到plugin management了
```xml
<dependencyManagement>
     <dependencies>
        <dependency>
            <!-- Import dependency management from Spring Boot -->
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>1.5.9.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
**自己指定JDK版本**
```xml
<properties>
    <java.version>1.8</java.version>
</properties>

```
**使用spring boot的打包插件**

spring-boot-starter-parent指定了pluginManagement，配置好了一系列的插件，其中一个就是用于打成可执行jar包的shade插件。如果我们要使用的话，需要自己手动声明这个插件，然后通过mvn pakcage命令就可以将工程打包成可以执行的jar包了。
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```
**spring-boot-starter-***

spring-boot提供了一些列的starter类依赖，跟流行的常用项目进行整合，比如mybatis、redis、mongodb、elasticsearch，等等。
我们只要声明对应的spring-boot-starter-*，就可以直接使用对应版本的依赖，多个依赖的版本都是兼容的。可能就是通过application.properties，注解，少量的配置，就可以快速整合进来一个技术开始使用

**基于spring boot进行开发需要遵守的约定规则**

一般建议基于spring boot来开发的时候，按照spring boot约定的规则来设置我们的包结构、代码布局，比如下面这样，这样spring boot在按照约定搜索各种注解的时候，一般不会出现什么问题
```
com
 +- zhss
     +- springboot
         +- Application.java
         |
         +- domain
         |   +- User.java
         +- dao
         |   +- UserDAO.java
         +- service
         |   +- UserService.java
         +- web
             +- UserController.java
```


用于启动的类一般会按照下面这样来写
```java
package com.zhss.springboot;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

**@Configuration(对类进行配置)**

spring boot的一个核心思想，就是尽量消除掉各种复杂的xml配置文件，所以一般建议如果要进行一些配置，可以采用Configuration类，在Java类中做一些配置
而且通常比较好的实践是，就将用来放main方法的Application类，作为Configuration类，所以一般会给Application类加@Configuration注解
如果不想将所有的配置都放在Application类中，也可以使用@Import注解将其他的Configuration类引入进来，或者是依靠@ComponentScan注解自动扫描其他的Configuration类

即使一定要使用一个xml配置文件，建议是用@ImportResource来导入一个xml配置文件

**Auto Configuration(@Configuration + @EnableAutoConfiguration)**

**什么是Auto Configuration**

AutoConfiguration是spring boot中非常核心的一个功能，因为spring boot的一个核心思想，就是尽可能减少我们要配置的东西，尽量才有约定规则自动完成一些配置。
这个Auto Configuration功能，就会根据我们引入的依赖，来推测我们做什么事情，然后自动给我们完成需要的一些配置。
AutoConfiguration是spring boot中各种功能的@Configuration的配置类，比如 WebMvcAutoConfiguration
举个例子，如果依赖了HSQLDB，那么spring boot会基于HSQLDB自动配置和创建一个内存数据库。

**如何启用Auto Configuration**

我们给@Configuration类，增加了@EnableAutoConfiguration注解之后，就会开启Auto Configuration功能。
而且一般推荐使用使用@EnableAutoConfiguration开启Auto Configuration功能

**Spring核心框架进行整合使用**

spring boot可以无缝与spring框架进行整合使用，一般就是在Application类上加@ComponentScan注解，启用自动扫描所有的spring bean，同时搭配好@Autowired注解来进行自动装配。只要按照上面的那个约定，将Application类放在最顶层的包结构中，那么使用了@ComponentScan之后，就可以自动扫描和搜索到所有的spring bean，包括了：@Component、@Contorller、@Service、@Repository

**@SpringBootApplication**

大多数的spring boot项目，都会在main类上标注：@Configuration、@EnableAutoConfiguration、@ComponantScan，因为这个实在是太过于常见了，所以spring boot提供了一个@SpringBootApplication注解，这个注解就相当于是上面3个注解的综合。所以实际上在开发的时候，一般就会在main类上加一个@SpringBootApplication注解

**启动spring boot程序**

spring boot的另外一个核心思想，就是尽量简化各种应用的开发。比如最常见的web应用程序，如果使用传统的方式来开发，需要安装和配置tomcat/jetty服务器，然后还需要将web程序打包后放入tomcat中才可以运行。
或者是需要将eclipse等ide工具配置支持tomcat，才能在eclipse中直接启动web程序。

而在spring boot中，直接基于了内置的tomcat/jetty容器，可以在写好代码之后，一键启动web程序，然后就可以在浏览器中访问了。
对于本地开发、测试以及debug个调试，都是非常的方便的

+ 在IDE中启动spring boot程序
+ 在命令行执行jar包来启动spring boot程序, $ java -jar target/myproject-0.0.1-SNAPSHOT.jar
+ 在命令行通过maven启动，$ mvn spring-boot:run

 

## 8. devtools工具
spring boot为了贯彻简化开发过程的原则，提供了一个devtools工具，基于这个工具，可以在开N发的各个环节，尽可能地简化工作
如果我们启动一个打好包的spring boot应用程序，这个应用程序会被认为是生产应用，那么此时是不会让devtools生效的。而且一般推荐将optional设置为true，这样如果我们的项目被别人依赖，devtools是不会传递过去的

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>

```
让系统在代码变化的时候自动重启（常见于本地开发和调试）
如果我们的应用程序使用了devtools，此时如果在IDE中直接启动，则会认为是开发调试过程。则此时如果classpath中的任何一个文件变化了，就会自动重启应用程序。在IDE中启动程序的时候，这个功能时很有用的，因为我们启动了一个web程序之后，会随时调试和修改代码，代码修改之后，不需要手动重启，web程序自己就重启了
但是上面介绍中也说了，打成一个jar包，java -jar启动一个jar包，对于执行jar包的情况下，spring boot会认为这是生产环境，则不会启用devtools的任何功能，包括这个自动重启功能

devtools使用了两个classloader来加载类

+ 一个是base classloader来加载第三方依赖的类
+ 一个是restart classloader来加载我们自己编写的文件。

如果我们自己编写的文件改动了，则此时会重新创建一个restart classloader来重新加载我们的类，这个速度是很快的，因为base classloader是始终保持的，不需要重新加载第三方依赖的类
如果要排除掉某些资源文件的变动不要自动重启，那么可以进行如下的配置，application.properties
spring.devtools.restart.exclude=static/**,public/**

如果要彻底禁用自动重启功能，需要做如下配置，application.properties
spring.devtools.restart.enabled=false

**将本地修改的代码同步到远程服务器上部署的应用(不推荐使用)**

devtools也可以用来管理远程机器部署的系统，如果要启用远程系统管理支持，需要进行如下配置，下面的配置可以确保说打包后的程序是包含devtools的。但是要记住的一点是，使用devtools管理远程部署的系统，是比较危险的，尤其在生产环境中，一般强烈建议不要基于devtools来管理

你在eclipse里面修改代码，直接就可以将修改后的代码，热同步到远程服务器上启动的spring boot应用中去。绝对绝对不要用于生产环境。如果你要用于测试环境，假设你要修复bug，速度要快一些，可以用这个功能，直接将本地修复好bug的代码同步到测试服务器上的spring boot应用中去。

Git工作流，集成测试，develop在本地复现代码，commit提交，push到远程gitlab上的分支上去跟别人的代码做集成，接着再次部署这个develop分支的代码到咱们的测试服务器上去。也不支持去用这个功能

配置pom文件和properties文件
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
</dependencies>
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <excludeDevtools>false</excludeDevtools>
            </configuration>
        </plugin>
    </plugins>
</build>
```
```properties
spring.devtools.remote.secret=123456
```
做了上面的配置之后，如果我们将这个程序打包后，在我们的某台机器上启动，此时会基于devtools暴露出来一个可以连接的端口，如果我们设置了上面的那个参数之后，这个远程服务器上的服务组件，就会自动启用
然后我们需要在本地手动运行一个客户端组件，一般就是在IDE中启动即可，在IDE中需要使用run configurations，对我们的应用程序，使用org.springframework.boot.devtools.RemoteSpringApplication，作为main class。同时将http://localhost:8080/作为启动参数传递过去

此时连接上以后，一个好处就是，如果在本地写代码，会直接将更新后的代码文件传输到远程机器上然后自动进行重启

***

## 9. SpringApplication高阶功能介绍
#### SpringApplication介绍
通常我们开发spring boot应用程序，非常重要的一个地方，就是在Application类的main方法中，使用SpringApplication类来启动应用程序

```java
package com.zhss.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.zhss.springboot.config.DruidDBConfig;
@SpringBootApplication
@Import(DruidDBConfig.class)  
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); 
    }
    
}
```

#### 启动失败的处理
如果启动失败了，那么失败的异常会交给spring boot预先注册好的某个FailureAnalyzer来处理，这个FailureAnalyzer就会打印出完整的失败原因以及解决的办法，比如说，如果启动要使用的8080端口被占用了，会显示下面的内容：
```text
***************************
APPLICATION FAILED TO START
***************************
Description:
Embedded servlet container failed to start. Port 8080 was already in use.
Action:
Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
```

spring boot内置了多个FailureAnalyzer，分别用于处理不同的启动失败问题
此外，我们还可以在启动应用程序的时候，打开debug开关，这样，即使没有一个FailureAnalyzer可以处理启动失败，也会打印出完整的auto configuration信息，供我们参考，比如下面这样
```shell script
$ java -jar myproject-0.0.1-SNAPSHOT.jar --debug
```

```text
=========================
AUTO-CONFIGURATION REPORT
=========================

Positive matches:
-----------------

   DispatcherServletAutoConfiguration matched:
      - @ConditionalOnClass found required class 'org.springframework.web.servlet.DispatcherServlet'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
      - @ConditionalOnWebApplication (required) found StandardServletEnvironment (OnWebApplicationCondition)

Negative matches:
-----------------

   ActiveMQAutoConfiguration:
      Did not match:
         - @ConditionalOnClass did not find required classes 'javax.jms.ConnectionFactory', 'org.apache.activemq.ActiveMQConnectionFactory' (OnClassCondition)
```

#### 传递应用启动参数
如果要在系统中其他组件处要获取传递给应用的启动参数，可以用下面的方式来实现。给组件注入一个ApplicationArguments bean，在里面可以获取到所有的参数
```java
import org.springframework.boot.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
@Component
public class MyBean {
    @Autowired
    public MyBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
    }
}
```

#### ApplicationRunner / CommandLineRunner
如果要在SpringApplication.run()开始运行，但是完成应用启动之前，同时并行运行某些代码，比如一些系统初始化的工作，那么可以用ApplicationRunner / CommandLineRunner。
两者唯一的区别，就是ApplicationRunner会传递进来ApplicationArguments，CommandLineRunner会传递进来数组

```java
import org.springframework.boot.*;
import org.springframework.stereotype.*;
@Component
public class MyBean implements CommandLineRunner {
    public void run(String... args) {
        // Do something...
    }
}

```
***


## 8. Spring Boot, Spring MVC, Spring, Mybatis 整合
#### Spring Boot + Spring Core
Spring Boot默认原生就是支持Spring Core的，只要在main类上加了
+ **@ComponantScan**，就会自动去扫描各种spring bean
+ 同时基于**@Autowired可**以完成自动装配

#### Spring Boot + Spring MVC + Spring Core
在pom.xml中声明对spring-boot-starter-web的依赖，可以让spring boot自动配置好内置tomcat容器，同时支持spring mvc接收http请求

Controller而言，一般会使用@RestController注解，因为现在大多数都是前后端彻底分离的架构，很少再有Controller接收请求之后再去渲染视图的了，只要提供RESTful接口即可

Controller可以基于@Autowired来装配后面的@Service业务逻辑组件

#### Spring Boot + Spring MVC + Spring Core + MyBatis

对于常规的j2ee应用来说，一般都是轻量级的Spring MVC + Spring Core + MyBatis框架架构来进行开发，Spring MVC负责MVC层，Spring Core负责业务逻辑层，MyBatis负责ORM层，那么就需要将MyBatis整合到Spring Boot中来使用

pring boot 1.5以上的版本，对应的是mybatis-spring-boot-starter的1.3版本

mybatis-spring-boot-starter的工作原理如下

+ 自动发现一个注册好的DataSource：applicationContext.xml手动配置，不用了 -> @Configuration作用替代掉以前的xml配置文件
+ 自动创建一个SqlSessionFactory，并且将DataSource传入SqlSessionFactory中
+ 自动基于SqlSessionFactory创建一个SqlSessionTemplate
+ 扫描所有的Mapper，将SqlSessionTemplate注入其中，然后将Mapper注册到Spring容器上下文中

#### 代码
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- 引入mybatis-spring-boot-starter依赖，用于mybatis与spring boot整合 -->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.1</version>
    </dependency>
    <!-- 引入mysql驱动依赖 -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    <!-- 引入spring-boot-starter-data-jpa依赖 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- 引入阿里的druid连接池依赖 -->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.6</version>
    </dependency>
</dependencies>
```
```properties
# 驱动配置信息
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource  
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/oa?useUnicode=true&characterEncoding=utf-8  
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.jdbc.Driver
   
# 连接池的配置信息  
# 连接池初始大小
spring.datasource.initialSize=5  
# 连接池最小空闲连接数量
spring.datasource.minIdle=5  
# 连接池最大活跃连接数量
spring.datasource.maxActive=20  
spring.datasource.maxWait=60000  
spring.datasource.timeBetweenEvictionRunsMillis=60000  
spring.datasource.minEvictableIdleTimeMillis=300000  
spring.datasource.validationQuery=SELECT 1 FROM DUAL  
spring.datasource.testWhileIdle=true  
spring.datasource.testOnBorrow=false  
spring.datasource.testOnReturn=false  
spring.datasource.poolPreparedStatements=true  
spring.datasource.maxPoolPreparedStatementPerConnectionSize=20  
spring.datasource.filters=stat,wall,log4j  
spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000 
```
```java
@Configuration  
public class DruidDBConfig {  
   
    // 因为spring boot是默认开启了资源过滤的
    // 所以这里的配置，都会自动从application.properties配置文件中加载出来，设置到这个@Configuration类中
    @Value("${spring.datasource.url}")  
    private String dbUrl;  
    @Value("${spring.datasource.username}")  
    private String username;  
    @Value("${spring.datasource.password}")  
    private String password;  
    @Value("${spring.datasource.driverClassName}")  
    private String driverClassName;  
    @Value("${spring.datasource.initialSize}")  
    private int initialSize;  
    @Value("${spring.datasource.minIdle}")  
    private int minIdle;  
    @Value("${spring.datasource.maxActive}")  
    private int maxActive;  
    @Value("${spring.datasource.maxWait}")  
    private int maxWait;  
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")  
    private int timeBetweenEvictionRunsMillis;  
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")  
    private int minEvictableIdleTimeMillis;  
    @Value("${spring.datasource.validationQuery}")  
    private String validationQuery;  
    @Value("${spring.datasource.testWhileIdle}")  
    private boolean testWhileIdle;  
    @Value("${spring.datasource.testOnBorrow}")  
    private boolean testOnBorrow;  
    @Value("${spring.datasource.testOnReturn}")  
    private boolean testOnReturn;  
    @Value("${spring.datasource.poolPreparedStatements}")  
    private boolean poolPreparedStatements;  
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
    private int maxPoolPreparedStatementPerConnectionSize;  
    @Value("${spring.datasource.filters}")  
    private String filters;  
    @Value("{spring.datasource.connectionProperties}")  
    private String connectionProperties;  
      
    // 在这个配置类中，直接基于配置信息，创建出了一个bean
    // 这个bean就是一个DataSource
    // 这个DataSource bean就会被纳入spring容器的管理范围之内
    @Bean     
    @Primary  
    public DataSource dataSource(){  
        // 这里就是用外部加载进来的配置信息，创建出来一个Druid连接池
        DruidDataSource datasource = new DruidDataSource();  
          
        datasource.setUrl(this.dbUrl);  
        datasource.setUsername(username);  
        datasource.setPassword(password);  
        datasource.setDriverClassName(driverClassName);  
          
        //configuration  
        datasource.setInitialSize(initialSize);  
        datasource.setMinIdle(minIdle);  
        datasource.setMaxActive(maxActive);  
        datasource.setMaxWait(maxWait);          
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);  
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);  
        datasource.setValidationQuery(validationQuery);  
        datasource.setTestWhileIdle(testWhileIdle);  
        datasource.setTestOnBorrow(testOnBorrow);  
        datasource.setTestOnReturn(testOnReturn);  
        datasource.setPoolPreparedStatements(poolPreparedStatements);  
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);  
        try {  
            datasource.setFilters(filters);  
        } catch (SQLException e) {  
            e.printStackTrace();
        }  
        datasource.setConnectionProperties(connectionProperties);  
          
        return datasource;  
    }   
}
```
编写这个类之后，还需要在Application类中导入这个配置管理类
@Import可以不添加，因为@SpringBootApplication会自动导入所有的配置类并启动
```java
@SpringBootApplication
@Import(DruidDBConfig.class)  
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); 
    }
    
}
```
编写Domain类
```java
public class User {
    
    private Long id;
    private String name;
    private Integer age;
}
```
编写Dao类
```java
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> listUsers();
}

 
public interface UserDAO {
    List<User> listUsers();
}

 
@Repository
public class UserDAOImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;
    
    public List<User> listUsers() {
        return userMapper.listUsers();
    }
}
```
编写Service类
```java
public interface UserService {
    List<User> listUsers();
}

 
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    
    public List<User> listUsers() {
        return userDAO.listUsers();
    }
}

```
编写controller类
```java
@RestController 
@RequestMapping(value="/user")     
public class UserController { 
 
    @Autowired
    private UserService userService;
 
    // GET请求代表着是查询数据
    @RequestMapping(value="/", method=RequestMethod.GET) 
    public List<User> listUsers() { 
        return userService.listUsers();
    }
}
```
编写测试http文件
```shell script
POST http://localhost:8080/user/
Content-Type: application/json
{
  "name": "李四",
  "age": 35
}
###

GET http://localhost:8080/user/
Content-Type: application/json
###

GET http://localhost:8080/user/1
Content-Type: application/json
###

PUT http://localhost:8080/user/1
Content-Type: application/json
{
  "id": 1,
  "name": "张三",
  "age": 28
}
###

DELETE http://localhost:8080/user/2
Content-Type: application/json

###
```
#### 梳理一下此时的几个框架整合的思路
+ 系统启动的时候，首先会去扫描DruidDBConfig类，这就可以将外部的druid连接池配置加载进来，同时初始化出来一个druid连接池的DataSource bean
+ mybatis-spring-boot-starter接着开始干活儿，发现了一个DataSource bean，就会将其注入SqlSessionFactory，再创建SqlSessionTemplate，接着扫描Mapper接口，将SqlSessionTemplate注入每个Mapper，然后将Mapper放入spring容器中来管理
+ spring boot的@ComponantScan注解开始干活儿，自动扫描所有的bean，依次初始化实例以及注入依赖，EmployeeServiceImpl（将EmployeeMapper注入其中），EmployeeCongtroller（将EmployeeServiceImpl注入其中）
+ 此时浏览器发送请求，会先由controlller处理，接着调用service，再调用mapper。mapper底层会基于druid连接池访问到数据库，进行数据操作

#### mybatis-spring-boot-starter的高级使用
mybatis的各种高阶功能，原来都是在xml mapper文件中完成的，但是现在都是倾向于无xml化，全部基于java类和注解来完成

mybatis之前都是有一个mybatis-config.xml之类的文件，可以在里面对mybatis本身进行配置的，比如二级缓存之类的
但是在这里，都是在spring boot的application.properties文件中进行配置了。具体要设置什么参数，可以关注一下mybatis的参数配置信息
```properties
mybatis.type-aliases-package=com.example.domain.model
mybatis.type-handlers-package=com.example.typehandler
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.configuration.default-fetch-size=100
mybatis.configuration.default-statement-timeout=30
```
#### 目前为止发现的spring boot几大特点总结
+ **对常用的依赖进行统一的版本约束**，让各依赖的版本都可以兼容，通过spring-boot-starter-parent中的dependencyManagement实现

+ **简化配置，内置web容器、Auto Configuration、内置打包插件**，都是让你写了代码就能立即运行起来

    比如mybatis-spring-boot-starter，直接自己按照约定，找到一个数据源就可以完成实现所有的事情，不需要再进行繁琐的xml配置
    
    比如spring-boot-starter-web，也是按照约定，直接完成默认的web程序相关的配置，比如内置web容器的接口、spring mvc的配置，等等
    
    最后发现，整合常用的框架，除了在外部文件里，配置了Druid数据库连接池的一些东西，其他框架几乎没有配置，全部都是基于默认的约定完成
    
    内置的打包插件可以让我们不用做任何配置，直接就完成一个fat jar的打包，可以执行的jar包了就是
    
    然后内置的web容器，直接java -jar就可以启动web容器，并且运行web程序，接着就可以本地调试和测试了

+ **spring boot，核心目的就是要简化我们的系统开发**

    简化再简化，开发非常简单，尽量不要配置，基于约定，记住，这是核心思想
    
    同时为了简化系统开发整个流程中的方方面面，后面spring boot还提供了其他很多的东西，到后面我们会再讲解
***


## 9. Spring Web Mvc 开发基础
#### spring-boot-starter-web介绍
spring boot崇尚的就是尽可能减少手动配置，尽量基于约定规则来完成所有的配置，同时尽量基于注解来完成配置。
只要在依赖中引入spring-boot-starter-web，其实spring boot就会基于自己的Auto Configuration功能，完成web服务器和spring mvc的自动配置，然后我们上手就可以开发web程序，直接运行main类就可以启动内置的web服务器了。这能让我们快速启动web程序的开发、调试和验证。

#### Spring MVC介绍
spring mvc是一个mvc层的框架，可以接受http请求，将请求转发路由到对应的类方法中来处理，接着将响应映射到视图文件，或者直接返回给浏览器
```java
@RestController
@RequestMapping(value="/users")
public class MyRestController {
    @RequestMapping(value="/{user}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long user) {
        // ...
    }
    @RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
    List<Customer> getUserCustomers(@PathVariable Long user) {
        // ...
    }
    @RequestMapping(value="/{user}", method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long user) {
        // ...
    }
}

```

#### spring boot为spring mvc做的auto configuration
+ 自动注册了ContentNegotiatingViewResolver和BeanNameViewResolver两个bean
+ 支持处理静态资源
+ 自动注册了Converter、GenericConverter、Formatter几个bean
+ 支持HttpMessageConverters
+ 自动注册了MessageCodesResolver
+ 静态index.html支持
+ 自定义Favicon图标支持
+ 自动使用了ConfigurableWebBindingInitializer bean

只要知道这个auto configuration，会自动给我们完成一些spring mvc的配置，不需要我们手动去搞一个mvc-servlet.xml配置

#### RESTful风格的接口
**在接口中增加api字样表明这是一个api接口**

http://localhost:8080/api

**需要在接口中增加版本标识**

http://localhost:8080/api/v1.0

**按照一定风格写清楚标识的资源**

http://localhost:8080/api/v1.0/system/employee

这里表示的就是系统管理模块中的员工管理

**RESTful中的HTTP method**
+ POST：代表的是新增
+ PUT：代表的是修改
+ GET：代表的是查询
+ PATCH：代表的是更新部分属性
+ DELETE：代表的是删除
+ HEAD：获取头信息，要查找的信息在响应头中
+ OPTIONS：获取URI支持的方法，在响应头中会有Allow，包含了支持的方法
+ 新增员工：POST http://localhost:8080/api/v1.0/system/employee
+ 修改员工：PUT http://localhost:8080/api/v1.0/system/employee/1
+ 查询员工：GET http://localhost:8080/api/v1.0/system/employee/1
+ 查询所有员工：GET http://localhost:8080/api/v1.0/system/employee
+ 删除员工：DELETE http://localhost:8080/api/v1.0/system/employee/1

**RESTful中的HTTP status**
+ 200，成功
+ 400，错误的请求，比如请求参数匹配错误
+ 404，没找到这个资源
+ 405，使用的HTTP method不被允许
+ 500，服务器内部错误


#### spring boot支持RESTful接口
只要依赖了spring-boot-starter-web，就自动支持RESTful接口
```java
@RestController
@RequestMapping("/api/v1.0/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")  
	public List<User> listUsers() {
		return userService.listUsers();
	}
	
	@GetMapping("/{id}")  
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	

	@PostMapping("/")   
	public String saveUser(
			@RequestBody @Validated({User.Save.class}) User user,
			BindingResult bindingResult) {
		userService.saveUser(user); 
		
		return "{'status': 'success', 'message': '新增用户ID为" + user.getId() + "'}"; 
	}
}
```


#### 系统中调用RESTful接口
spring boot提供了一个RestTemplate来辅助发起REST请求，底层通过HttpURLConnection来发送HTTP小覅西，使用Jackson来进行JSON序列化
```java
@Controller
@RequestMapping("/test")
public class TestController {
    
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    
    @GetMapping("/user/{id}")
    public User testGetUserById(@PathVariable("id") Long id) {
        RestTemplate client = restTemplateBuilder.build();
        String uri = "http://localhost:8080/api/v1.0/user/{id}";  
        return client.getForObject(uri, User.class, id);
    }
    
}

```
#### @RestController注解
RESTful风格的Controller中，直接用这个注解即可，对每个方法的返回值默认采用@ResponseBody的方式来处理

不会去找某个视图资源文件来渲染后发回浏览器，因为@RestController就代表了这是一个负责提供RESTful接口的Controller

#### @RequestMapping注解
+ 一般在Controller类级别加一个@RequestMapping注解，代表对一类资源的映射
+ 在Controller中每个方法级别加一个@RequestMapping，支持某一类请求

#### @PathVariable注解
就是在请求中附带一个id或者别的什么参数，代表了对一个资源的标识和定位
然后在方法入参中使用@PathVariable注解配置请求中参数和方法入参的映射关系
```java
public class UserController {
    @RequestMapping(value = "/{userId}", method = HttpMethod.GET)
    public User getUserById(@PathVariable("userId") Long userId) { }
}
```
#### @XMapping系列注解
如果是做Restful风格的Controller，其实一般就更加简化，使用@GetMapping，@PutMapping，@PostMapping，@DeleteMapping。来代表了增删改查等一些操作和请求即可。
```java
public class UserController {
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
    }
    @PostMapping("/")
    public String saveUser(User user) {
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") Long userId, 
        @ModelAttribute User user) {
        
    }
    @DeleteMapping("/{userId}")
    public String removeUser(@PathVariable("userId") Long userId) {
        
    }
}
```

#### ModelAndView
这个其实一般用于传统的MVC模式中，就是Controller接收请求，调用Service获取结果后，再将结果封装到ModelAndView中去，同时在里面指明请求要转发到哪个视图资源文件上去。接着JSP、FreeMarker、Thymeleaf等模板引擎技术，可以从ModelAndView中提取之前封装进去的数据，然后将数据渲染到网页上去
但是在现在的大趋势下，这种技术已经很少使用了，除非是一些一个人开发的极其极其小的小项目，才会用MVC模式
```java
public class UserController {
    @GetMapping("/{userId}")
    public ModelAndView getUserById(@PathVariable("userId") Long userId, ModelAndView mav) {
        User user = userSerivce.getUserById(userId);
        mav.addObject("user", user);
        mav.setViewName("/userInfo.jsp");
        return mav;
    }
}
```

#### 将请求参数映射到方法入参
使用@RequestParam可以将某个请求参数，映射到方法入参上

```java
public class UserController {
  @GetMapping("/{userId}")
  public User getUserById(@PathVariable("userId") Long userId, 
                          @RequestParam("user_status") Integer userStatus) {
      
  }  
}
```
#### @ResponseBody
就是将方法的返回值直接用json等格式返回到浏览器，一般我们现在都直接用@RestController了，自带这个功能
***


## 10. web开发中对请求参数的校验
#### Spring Boot对请求校验的支持
Spring Boot支持JSR-303验证框架，默认实现是Hibernate Validator，只要在Java Bean上放一些校验注解，就可以实现校验支持

常用的校验注解包括下面这些：

+ 空检查：@Null，@NotNull，@NotBlank，@NotEmpty
+ 长度检查：@Size(min=20, max=50)，@Length
+ 数值检查：@Min，@Max，@Range(min=1, max=99)
+ 其他检查：@Email，@Pattern

而且这个校验是支持group的概念的，对于不同的group生效的校验不一样。这个很有用，因为对于增删改查等不同的操作，需要执行的校验本来就是不一样的

#### 基本的校验案例
```java
public class User {
    public interface Update{}
    public interface Add{}
    
    // 这就是一个典型的group分组
    // 更新操作的时候，要求userId必须不为空
    // 新增操作的时候，要求userId必须为空
    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    private Long userId;
    @Size(min=3, max=20)
    private String name;
    @Range(min=1, max=120)
    private Integer age;    
}

```
```java
public class UserController {
    // 这里就声明了要激活Add group对应的校验注解
    // 那么就会校验user的userId不能为空
    @PostMapping("/")
    public String saveUser(@Validated({User.Add.class}) User user, 
                          BindingResult result) {
        if(result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            FieldError error = (FieldError)errors.get(0);
            System.out.println(error.getObjectName() + "," 
                               + error.getField() + "," 
                               + error.getDefaultMessage());
            return "error";
        }
        return "success";
    }
}
```
#### 自定义校验注解
```java
public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private Age age;
    private Integer max;
    
    public void initialize(Age age) {
        this.age = age;
        this.max = age.max();
    }
    
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value < max;
    }
    
}

 
@Constraint(validatedBy = {AgeValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicty.RUNTIME)
public @interface Age {
    
    String message() default "年龄是非法的，不能超过{max}岁";
    int max() default 100;
    Class<?>[] groups default {};
    Class<? extends Payload>[] payload() default {};
    
}
```
***

 

## 11. spring Mvc 中常用的一些全局配置
#### WebMvcConfigurer
```java
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    
    // 拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/user/**");
    }
    
    // 跨域访问配置
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**")
            .allowedOrigins("http://www.zhss.com")
            .allowedMethods("POST", "GET")
    }
    
    // 格式化
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
    
    // URI到视图的映射
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addUserUI").setViewName("/addUser.jsp");
    }    
}

public class UserLoginInterceptor implements HandlerInterceptor { }
```
#### spring监听器的使用
```java
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
    }    
}
```
#### 全局异常处理
Controller中抛出的异常全部交给/error来处理，Spring Boot是有一个默认实现的，但是也可以我们自己覆盖掉
```java
@ControllerAdvice
class GlobalErrorHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<String>();  
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("自定义的全局异常处理");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;
    private Integer code;
    private String message;
    private String url;
    private T data;
}
```
#### 整合 mybatis
```java
@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user")  
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age")  
	})
	List<User> listUsers();
	
	@Select("SELECT * FROM user WHERE id=#{id}")
	@Results({
		@Result(property = "id", column = "id", id = true),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age")  
	})
	User getUserById(@Param("id") Long id);
	
	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")  
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void saveUser(User user);
	
	@Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")  
	void updateUser(User user);

	@Delete("DELETE FROM user WHERE id=#{id}")
	void removeUser(@Param("id") Long id);
	
}
```
***


## 12. Spring Boot 常用配置
#### Spring Boot的基础配置
**端口配置**

在application.properties中即可完成spring boot的配置
默认的监听端口是8080，但是可以用如下三种方式来修改监听的端口

在application.propertie
```properties
server.port=9090
```
启动系统的时候：java -jar target\springboot-demo-1.0.0.jar --server.port=9090
启动系统的时候：java -Dserver.port=9090 -jar target\springboot-demo-1.0.0.jar

**web上下文配置**

默认的web上下文是：/，可以通过属性来修改web上下文
```properties
server.context-path=/springboot-demo
```

**使用其他web服务器**

默认的web服务器是用的内嵌的tomcat，可以使用jetty或者是undertow
比如使用jetty作为web服务器

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>    
```

**tomcat 配置** 
```properties
# 打开tomcat访问日志
server.tomcat.accesslog.enabled=true
# 访问日志所在的目录
server.tomcat.accesslog.directory=logs
# 允许HTTP请求缓存到请求队列的最大个数，默认是不限制的
server.tomcat.accept-count=
# 最大连接数，默认是不限制的，如果连接数达到了上限，那么剩下的连接就会保存到请求缓存队列里，也就是上面参数指定的个数
server.tomcat.max-connections=
# 最大工作线程数
server.tomcat.max-threads=
# HTTP POST内容最大长度，默认不限制
server.tomcat.max-http-post-size=

```

#### spring组件加载外部配置文件
在实际开发中，将核心配置放在外部配置文件，是很重要的。因为通常我们都是对不同的环境使用一套完全不同的配置，但是保证我们的代码必须是相同的。
比如我们有一个类，其中要从外部配置文件中注入一个name属性
```java
import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
// 无论用什么spring组件都可以被注入外部配置
@Component
public class MyBean {
    @Value("${name}")
    private String name;
    // ...
}
```

然后通常，我们会在src/main/resources中，放置一个application.properties，其中可以给name属性一个值。
也可以在命令行中传递这个参数值来替代：java -jar app.jar --name="Spring"。

#### spring boot多环境支持
spring boot支持使用@Profile注解来标志，在哪个环境profile下，可以激活使用某个@Configuration类
接着可以在启动的时候，命令行中，使用如下参数来指定某个环境profile：--spring.profiles.active=dev,hsqldb
```java
@Configuration
@Profile("production")
public class ProductionConfiguration {
}
```

#### 系统读取应用的配置
**Environment类**
spring boot提供了一个Environment类，可以读取applicaiton.properties、命令行参数、系统参数、操作系统环境变量，等等，各种参数和配置。可以通过spring bean注入的方式获取到这个Environment，很多时候，可能你并不想直接使用@Value将某些参数读取到系统里面来，但是你可以注入一个Environment，从这个里面去获取需要的一些参数
```java
@Configuration
public class EnvironmentConfig {
    @Autowired
    private Environment env;    
    public int getServerPort() {
        return env.getProperty("server.port", Integer.class);
    }
}

```
***

## 13. Spring 测试
我们正好基于之前快速写好的一个所谓“用户管理”的模块，完整的模块，我们来做所有代码组件的一个单元测试

+ JUnit
+ Mockito做测试替身，隔离各个代码组件
+ Hamcrest去做复杂的断言
+ spring test等框架去在spring boot、spring等框架的环境下，去进行相关的测试

#### JUnit的介绍
JUnit的使用非常容易上手，测试类放在src/main/test下，然后类名一般用Test结尾

通常来说，一个测试类对应一个系统类，类中的每个方法，用于测试一个方法，方法一般以test开头，每个方法用@Test标注

如果有测试开始前要执行的操作，用@Before标注一个方法来执行；如果有测试结束之后要执行的操作，用@After标注一个方法来执行，一般会将多个测试方法中的初始化和资源清理代码放在这些方法中

每次运行一个方法，都会创建一个类的实例，将各个测试方法互相之间隔离开来，避免互相影响，导致测试失败

在每个测试方法中，最后都会用Assert类来进行断言，判断测试是否通过，就是看一下测试得到的结果，是不是我们期望的，如果不是会报错，表示测试不通过

JUnit还有一个Suite的概念，一次性运行多个测试用例，算是一个测试套件，比如下面这样子

```java
@RunWith(Suite.class)
@SuiteClasses({TestSuite1.class, TestSuite2.class})
public class TestSuitMain {
}
```

我们一般都是，写好一些代码组件，然后就针对这些代码组件，去立即写对应的单元测试，单元测试是一个类一个类的执行
到了最后，你都要集成测试，mvn test，将所有的单元测试全部跑一遍

#### spring-boot-starter-test
spring boot对单元测试提供了很好的支持，只要依赖spring-boot-starter-test即可，这个依赖会自动导入单元测试需要的所有依赖
包括了JUnit、AssertJ、Hamcrest以及其他的一些包，而且这个spring-boot-starter-test一般是设置为test scope即可
具体来说，spring-boot-starter-test导入之后，会包含下面这些东西：

+ JUnit：最经典的单元测试框架
+ Spring Test、Spring Boot Test：是spring和spring boot环境下，对测试的一个支持
+ AssertJ：是用来进行断言的
+ Hamcrest：是用来进行复杂断言，复杂的表达式
+ Mockito：测试替身的模拟
+ JSONassert：都是对json数据进行操作的
+ JsonPath

#### 测试spring boot应用程序
**spring boot单元测试脚手架**

+ @RunWith的意思，是不要使用默认方式进行单元测试，而是使用指定的类来提供单元测试
+ 所有的spring测试都是找SpringRunner.class
+ 这个是spring boot提供的，会一直找到一个Application类，只要包含了@SpringBootApplication的就算，然后会先启动这个类，来给单元测试提供环境

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    
    @Test
    public void testFindById() {    }
}
```
**MockMvc 测试controller组件**

```java
//模拟GET请求
mvc.perform(get("/employee/{id}", 1))

//模拟POST请求
mvc.perform(post("/employee/{id}",1)).contentType(MediaType.APPLICATION_JSON_UTF8).content(JSONObject.toJSONString(user)
                                                                                           
// 模拟文件上传                                                                                    
mvc.perform(multipart("/upload").file("file", "文件内容".getBytes("UTF-8")))
                                                                                           //模拟表单请求
mvc.perform(post("/employee").param("name", "张三").param("age", 20))
                                                                                           //模拟session                                                                                           
mvc.perform(get("/employee").sessionAttr(name, value)
            
//模拟cookiei
mvc.perform(get("/employee").cookie(new Cookie(name ,value)))

//模拟HTTP body内容，比如json
mvc.perform(get("/employee").content(json))

//返回值比较status: 
andExpect(status().isOk())

//返回值比较json: 
andExpect(content().json(JSONArray.toJSONString(users)))

//返回值比较striong
andExpect(content().string("success"));
```

```java
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    public static final String BASE_USER_API = "/api/v1.0/user/";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testListUsers() throws Exception {

        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setName("test user");
        user.setAge(20);
        users.add(user);
        when(userService.listUsers()).thenReturn(users);
  mockMvc.perform(get(BASE_USER_API)).andExpect(content().json(JSONArray.toJSONString(users)));
    }

    @Test
    public void testSaveUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setName("test user");
        user.setAge(20);
        when(userService.saveUser(user)).thenReturn(userId);
        mockMvc.perform(post(BASE_USER_API).contentType(MediaType.APPLICATION_JSON_UTF8).content(JSONObject.toJSONString(user))).andExpect(content().json("{'status': 'success', 'message': '新增用户ID为" + user.getId() + "'}"));
    }
}
```

**测试service组件**

+ 测试之前自动构造好数据，测试结束之后自动回滚数据构造
+ 将service依赖的service进行模拟打桩进来
+ 接住@MockBean模拟替身

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDAO userDAO;

    @Test
    public void testListUsers() throws Exception {

        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setName("test user");
        user.setAge(20);
        users.add(user);

        when(userDAO.listUsers()).thenReturn(users);
        assertEquals(users, userService.listUsers());
    }

    @Test
    public void testGetUserById() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("test user");
        user.setAge(20);

        when(userDAO.getUserById(userId)).thenReturn(user);
        assertEquals(user, userService.getUserById(userId));
    }


    @Test
    public void testSaveUser() throws Exception {

        Long userId = 1L;
        User user = new User();
        user.setName("test user");
        user.setAge(20);

        when(userDAO.saveUser(user)).thenReturn(userId);
        assertEquals(userId, userService.saveUser(user));
    }
}
```
**DAO层单元测试**

+ 可以使用@Sql先构造好需要的数据
+ 或者用setup 设置好数据
+ 设置事物@Transactional
+ 设置回滚@Rollback(true) 
```java
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class UserDAOTest {

    ThreadLocal<User> theadLocalUsers = new ThreadLocal<>();
    @Autowired
    private UserDAO userDAO;

    @Before
    public void init() {
        User user = new User();
        user.setName("test user");
        user.setAge(20);
        userDAO.saveUser(user);
        theadLocalUsers.set(user);
    }

    @Test
    public void testListUsers() throws Exception {

        assertThat(userDAO.listUsers().size(), is(greaterThan(0)));
    }

    @Test
    public void testGetUserById() throws Exception {
        User resultData = theadLocalUsers.get();
        assertEquals(userDAO.getUserById(resultData.getId()).toString(), resultData.toString());
    }


    @Test
    public void testSaveUser() throws Exception {
        User resultData = theadLocalUsers.get();
        assertThat(resultData.getId(), is(greaterThan(0L)));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User resultData = theadLocalUsers.get();
        Integer age = resultData.getAge() + 10;
        User user = new User();
        user.setId(resultData.getId());
        user.setName("test user");
        user.setAge(age);

        userDAO.updateUser(user);
        User updatedUser = userDAO.getUserById(user.getId());
        assertEquals(updatedUser.getAge(), age);
    }

    @Test
    public void testRemoveUser() throws Exception {
        User resultData = theadLocalUsers.get();
        assertTrue(userDAO.removeUser(resultData.getId()));
    }
}
```
**assertThat和Hamcrest**
+ 单元测试结构
    + @Before
    + @Test
    + @After
+ 断言
    + assertEquals
    + assertTrue / assertFalse
    + assertNull / assertNotNull
    + assertSame / assertNotSame
    + assertArrayEquals
    + assertThat
+ 测试异常
    + @Test(expected = NullPointException.class)
+ 主动失败
    + fail
+ JUnit + Hamcrest
    + assertThat(str.indexOf("hello"), is(not(-1)))
    + assertThat(str.contains("hello"), equals(true))
    + assertThat(str, containsString("hello"))
    + is、not
    + equalTo / sameInstance、nullValue / notNullValue、instanceOf
    + hasProperty
    + hasEntry、hasKey、hasValue、hasItem / hasItems、hasItemInArray、in
    + greaterThan、greaterThanOrEqualTo、lessThan、lessThanOrEqualTo
    + containsString、endsWith、startsWith
+ JUnit + Mockito
    + when().thenReturn()
***

## 14. 日志打印
#### 默认日志打印
默认情况下，spring boot使用apache commons logging作为日志接口
但是使用logback作为日志框架实现，所以打印日志的代码一般是下面这样的：
```java
public class HelloworldController {
    private Log log = LogFactory.getLog(HelloworldController.class);    
}
```
日志格式

+ 日期和时间
+ 日志级别：ERROR，WARN，INFO，DEBUG，TRACE
+ 进程ID
+ ---，这是个分隔符
+ 线程名称
+ 日志内容
默认是INFO以上的日志才会打印，可以在application.properties中配置一下
```text
2014-03-05 10:57:51.112  INFO 45469 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/7.0.52
2014-03-05 10:57:51.253  INFO 45469 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2014-03-05 10:57:51.253  INFO 45469 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1358 ms
2014-03-05 10:57:51.698  INFO 45469 --- [ost-startStop-1] o.s.b.c.e.ServletRegistrationBean        : Mapping servlet: 'dispatcherServlet' to [/]
2014-03-05 10:57:51.702  INFO 45469 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
```

#### 自定义日志格式
可以对控制台和文件两个地方的日志分别定义格式

•	%level，日志级别
•	%date，日期时间，HH:mm:ss是输出时分秒，ISO8601是标准日期输出，yyyy-MM-dd HH:mm:ss.SSS
•	%logger，输出Logger的名字，包名+类名，{n}限制了输出的长度，如果太长的话，会尽可能压缩包名和类名，但是建议一般保持的长一些
•	%thread，线程名称
•	%M，日志打印的方法名
•	%L，打印日志所在的行，性能消耗较大
•	%m，日志消息
•	%n，换行
可以在src/main/resources目录下放一个logback-spring.xml来对logback进行更加细致的配置
**logging.file 和 logging.path 只会有一个配置起作用**
```properties
# 配置打印日志的默认最小级别
logging.level.root=info
# 配置org包下打印日志的最小级别是WARN
# org包下的一般都是第三方的组件，不需要打印info级别的日志
logging.level.org=warn
# 自己包下的日志，从debug级别就开始打印
logging.level.com.zhss=debug

# 这是相对路径，放在应用的目录下
logging.file=my.log
# 当然一般其实是将日志文件放在指定的某个日志目录中的
# 这就会在/var/logs/com.zhss.springboot.demo目录下生成一个spring.log日志文件
logging.path=/var/logs/com.zhss.springboot.demo

logging.pattern.console=%level %date{HH:mm:ss} %logger{20}.%M %L :%m%n
logging.pattern.file=%level %date{ISO8601} [%thread] %logger{2000}.%M %L :%m%n
```
#### 切换日志实现
默认情况下，spring boot会使用logback作为日志框架，但是如果我们在依赖中引入比如log4j、java util loggins，那么spring boot会使用别的日志框架
logback的配置文件是：logback-spring.xml
log4j的配置文件是：log4j2-spring.xml
java util logging的配置文件是：logging.properties
***

## Spring Boot 部署
#### 以jar方式来部署
如果要以jar方式来部署spring boot应用，只需要加入下面的插件即可
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <executable>true</executable>
            </configuration>
        </plugin>
    </plugins>
</build>
```
接着只要执行：mvn package，即可完成打包，这是一个fatjar包，包含了所有依赖，可以执行的一个jar包
执行jar包启动系统：java -jar target\springboot-demo-1.0.0.jar

#### 以war包方式来部署
实际去部署的时候，都不会是以jar包方式部署的，因为那是用的spring boot内嵌的tomcat服务器来部署的，一般还是以war包方式，部署到线上已有的tomcat容器中的
但是到了阶段二，就是已经开始有一定的访问量了，那么那个时候开始，我们就会正经使用tomcat去部署，而且会深入的学习tomcat，内核
```xml
<groupId>com.zhss.springboot</groupId>
<artifactId>springboot-demo</artifactId>
<packaging>war</packaging>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <scope>provided</scope>
</dependency>

```
接着要再次修改Application类 继承SpringBootServletInitializer基类
```java
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringAppliciationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

```
#### 多环境部署
可以在src/main/resources目录下，放多个application-{profile}.properties文件

然后在启动的时候，使用java -jar -Dspring.profiles.active=prod target\springboot-demo-1.0.0.jar来指定要激活哪个环境的profile
很多大公司里，自己研发的设施，是要求你不同的环境必须放不同的一个文件，让他们去读取的，跟spring boot是不兼容的。META-INF/conf.properties
我们用的是maven profile，我们在不同profile的路径下，放一个application.properites，以及也许需要放置的其他的一些配置文件，为了以防万一
也可以在tomcat的catalina.sh中，编辑系统属性来激活对应的profile，比如JAVA_OPTS="-Dspring.profiles.active=prod"
还可以使用@Profile来标准@Configuration，来决定不同的环境下，可以让不同的类生效
但是实际项目中，还是建议使用maven的profile支持多环境吧，更加灵活。
***

## 15.  监控
到了后面业务量上来，非常专业的系统监控的，分布式的系统监控
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
```http
// 查看系统的基本健康信息：系统是否正常，磁盘空间，数据库
http://localhost:8080/springboot-demo/health
// 查看最近的一些http请求
http://localhost:8080/springboot-demo/trace
// 在线查看日志
http://localhost:8080/springboot-demo/logfile
// 在线查看线程栈信息
http://localhost:8080/springboot-demo/dump
// 在线查看内存快照
http://localhost:8080/springboot-demo/heapdump
// 查看系统的性能指标：内存占用、垃圾回收次数
http://localhost:8080/springboot-demo/metrics
// 查看系统的一些额外信息
http://localhost:8080/springboot-demo/info
// 在线查看日志配置
http://localhost:8080/springboot-demo/loggers
// 查看URL映射
http://localhost:8080/springboot-demo/mappings
// 查看所有的spring bean
http://localhost:8080/springboot-demo/beans
// 查看环境变量
http://localhost:8080/springboot-demo/env
// 查看configpropss环境变量
http://localhost:8080/springboot-demo/configprops
// 查看auto config的一些信息
http://localhost:8080/springboot-demo/autoconfig
```
***
