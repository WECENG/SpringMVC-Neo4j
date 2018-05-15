package cn.gdou.DAO.neo4j.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;

@Configuration
@EnableNeo4jRepositories(basePackages = {"cn.gdou.DAO.repository"})
@EnableTransactionManagement
public class Neo4jConfig{
    File file=new File("F://temp//graph.db");

    //创建工厂对象，该对象会自动创建Repository
    @Bean
    public SessionFactory sessionFactory(){
        return new SessionFactory("cn.gdou.DAO.domain");
    }

    //创建事物管理bean
    @Bean
    public Neo4jTransactionManager transactionManager(){
        return new Neo4jTransactionManager(this.sessionFactory());
    }

    //配置了一个嵌入式neo4j数据库
    @Bean
    public GraphDatabaseService graphDatabaseService(){
        return new GraphDatabaseFactory().newEmbeddedDatabaseBuilder(file)
                .setConfig( GraphDatabaseSettings.pagecache_memory, "512M" )
                .setConfig( GraphDatabaseSettings.string_block_size, "60" )
                .setConfig( GraphDatabaseSettings.array_block_size, "300" )
                .newGraphDatabase();

    }
}
