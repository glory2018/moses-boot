# moses-boot
springboot2.2.6+thymeleaf+mybatis plus

https://github.com/glory2018/moses-boot.git


#由于Oracle授权问题，Maven3不提供oracle JDBC driver
mvn install:install-file -Dfile=D:\program\lib\ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar

<!-- 添加oracle驱动依赖 -->
<dependency>
<groupId>com.oracle</groupId>
<artifactId>ojdbc6</artifactId>
<version>11.2.0.1.0</version>
</dependency>
