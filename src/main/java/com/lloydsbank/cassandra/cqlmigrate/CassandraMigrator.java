package com.lloydsbank.cassandra.cqlmigrate;

import uk.sky.cqlmigrate.CassandraLockConfig;
import uk.sky.cqlmigrate.CqlMigrator;
import uk.sky.cqlmigrate.CqlMigratorFactory;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static java.util.Arrays.asList;


public class CassandraMigrator {

    String hosts[] = {};

    public CassandraMigrator(String[] hosts) {
        this.hosts = hosts;
    }

    public int run() {
        CassandraLockConfig lockConfig = CassandraLockConfig.builder()
                .withTimeout(Duration.ofSeconds(3))
                .withPollingInterval(Duration.ofMillis(500))
                .build();

        CqlMigrator migrator = CqlMigratorFactory.create(lockConfig);
        Path schemas = null;
        try {
            System.out.println(ClassLoader.getSystemClassLoader().getResources("cql").nextElement());
            schemas = Paths.get(ClassLoader.getSystemClassLoader().getResources("cql").nextElement().toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(hosts[0]);
        migrator.migrate(hosts, 9042, "", "", "my_keyspace", asList(schemas));
        return 0;
    }
}
