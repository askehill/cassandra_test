package com.lloydsbank.cassandra.cqlmigrate;


import org.junit.Before;
import org.junit.Test;

public class CassandraMigratorTest {

    String[] hosts =  {"10.112.159.86", "10.112.159.89", "10.112.159.93"};

    @Before
    public void before () {

    }
    @Test
    public void testInstantiation() {
        CassandraMigrator cassandraMigrator = new CassandraMigrator(hosts);
        cassandraMigrator.run();
    }
}
