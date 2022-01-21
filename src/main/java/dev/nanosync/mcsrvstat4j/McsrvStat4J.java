package dev.nanosync.mcsrvstat4j;

import dev.nanosync.mcsrvstat4j.service.ServerService;

public class McsrvStat4J {
    public ServerService getStatus(String host){
        return new ServerService(host);
    }
}
