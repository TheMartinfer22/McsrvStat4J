package dev.nanosync.mcsrvstat4j;

import dev.nanosync.mcsrvstat4j.service.ServerService;

import javax.management.AttributeNotFoundException;

public class McsrvStat4J {
    public ServerService getStatus(String host) throws AttributeNotFoundException {
        return new ServerService(host);
    }
}
