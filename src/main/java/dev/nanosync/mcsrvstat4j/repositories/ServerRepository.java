package dev.nanosync.mcsrvstat4j.repositories;


import dev.nanosync.mcsrvstat4j.entities.ServerEntity;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface ServerRepository {
    @RequestLine("GET /2/{host}")
    ServerEntity search(@Param("host") String host);
}
