package dev.nanosync.mcsrvstat4j;

import dev.nanosync.mcsrvstat4j.entities.ServerEntity;
import dev.nanosync.mcsrvstat4j.repositories.ServerRepository;
import feign.Feign;
import feign.gson.GsonDecoder;

public class McsrvStat4J {
    public ServerEntity getStatus(String host){
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(ServerRepository.class, "https://api.mcsrvstat.us")
                .search(host);
    }
}
