package com.lloydsbank.cassandra.cqlmigrate;


/**
 * Created by askehi on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {
        String[] hosts = {"10.112.159.86", "10.112.159.89", "10.112.159.93"};

        CassandraMigrator cassandraMigrator = new CassandraMigrator(hosts);
        cassandraMigrator.run();
    }
}
