package me.pr3.packetdump.persistence.jpa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.postgresql.ds.PGSimpleDataSource;

public class JpaEntityManagerFactory {

    private final String DB_URL = "jdbc:mysql://databaseurl";
    private final String DB_USER_NAME = "username";
    private final String DB_PASSWORD = "password";
    private final Class[] entityClasses;

    public JpaEntityManagerFactory(Class[] entityClasses) {
        this.entityClasses = entityClasses;
    }

    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    protected EntityManagerFactory getEntityManagerFactory() {
        PersistenceUnitInfo persistenceUnitInfo = getPersistenceUnitInfo(getClass().getSimpleName());
        Map<String, Object> configuration = new HashMap<>();
        return new EntityManagerFactoryBuilderImpl(new PersistenceUnitInfoDescriptor(persistenceUnitInfo), configuration)
                .build();
    }

    protected HibernatePersistenceUnitInfo getPersistenceUnitInfo(String name) {
        return new HibernatePersistenceUnitInfo(name, getEntityClassNames(), getProperties());
    }

    protected List<String> getEntityClassNames() {
        return Arrays.asList(getEntities())
                .stream()
                .map(Class::getName)
                .collect(Collectors.toList());
    }

    protected Properties getProperties() {
        Properties properties = new Properties();
        properties.put("jakarta.persistence.jdbc.driver", "org.postgresql.Driver");
        //        <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/postgres?currentSchema=abiwebsite"/>
        properties.put("jakarta.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/postgres");
        //        <property name="jakarta.persistence.jdbc.user" value="service_user"/>
        properties.put("jakarta.persistence.jdbc.user", "service_user");
        //        <property name="jakarta.persistence.jdbc.password" value="password"/>
        properties.put("jakarta.persistence.jdbc.password", "password");
        //        <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        //        <property name="hibernate.hbm2ddl.auto" value="update"/>
        properties.put("hibernate.hbm2ddl.auto", "update");
        //        <property name="jakarta.persistence.schema-generation.database.action" value="create"/>
        properties.put("jakarta.persistence.schema-generation.database.action", "create");
        //        <property name="hibernate.default_schema" value="abiwebsite"<property>
        properties.put("hibernate.default_schema", "packetdump");
        //properties.put("hibernate.connection.datasource", getPgSqlDataSource());
        return properties;
    }

    protected Class[] getEntities() {
        return entityClasses;
    }

    //protected DataSource getPgSqlDataSource() {
    //    PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
    //    pgSimpleDataSource.setURL(DB_URL);
    //    pgSimpleDataSource.setUser(DB_USER_NAME);
    //    pgSimpleDataSource.setPassword(DB_PASSWORD);
    //    return pgSimpleDataSource;
    //}
}