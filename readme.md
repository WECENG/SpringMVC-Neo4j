SpringMVC集成嵌入式neo4j服务器
    1.导入相关jar包
         <dependency>
              <groupId>org.springframework.data</groupId>
              <artifactId>spring-data-neo4j</artifactId>
              <version>5.0.4.RELEASE</version>
          </dependency>
          <dependency>
                <groupId>org.neo4j</groupId>
                <artifactId>neo4j</artifactId>
                <version>3.3.5</version>
          </dependency>
              <!-- https://mvnrepository.com/artifact/org.neo4j/neo4j-ogm-embedded-driver -->
          <dependency>
                <groupId>org.neo4j</groupId>
                <artifactId>neo4j-ogm-embedded-driver</artifactId>
                <version>3.0.3</version>
          </dependency>
          （jar包倒错，各种bug）
    如果要发布项目还要导入以下的jar包
         <dependency>
                <groupId>com.fasterxml.jackson.core</groupId>
                <artifactId>jackson-databind</artifactId>
                <version>2.9.4</version>
         </dependency> 
         
         
    2.配置嵌入式服务器
            a.配置了一个嵌入式neo4j数据库
                @Bean
                public GraphDatabaseService graphDatabaseService(){
                    return new GraphDatabaseFactory().newEmbeddedDatabaseBuilder(file)
                            .setConfig( GraphDatabaseSettings.pagecache_memory, "512M" )
                            .setConfig( GraphDatabaseSettings.string_block_size, "60" )
                            .setConfig( GraphDatabaseSettings.array_block_size, "300" )
                            .newGraphDatabase();
                
            b.创建工厂对象，该对象会自动创建Repository
                @Bean
                public SessionFactory sessionFactory(){
                    return new SessionFactory("cn.gdou.DAO.domain");
                }
                
            c.创建事物管理bean
               @Bean
                public Neo4jTransactionManager transactionManager(){
                   return new Neo4jTransactionManager(this.sessionFactory());
                }
                
    3.创建Repository类
            创建一个接口继承Neo4jRepository<Object,Long>
            如同其它spring data Repository
            
    4.创建Services类
            业务逻辑
            
    5.创建测试类
            通过spring-test进行测试
            
        如果要发布项目的话，项目发布完之后要关闭tomcat,不然会报错
        neo4j服务器和tomcat不能同时运行
        
        所以说嵌入式neo4j服务器主要用来测试的
            