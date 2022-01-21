package dev.nanosync.mcsrvstat4j.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class ServerEntity {
    private String ip;
    private String port;
    private Map<String, Object> debug;
    private Map<String, Object> motd;
    private Map<String, Object> players;
    private String version;
    private String online;
    private String protocol;
    private String hostname;
    private String icon;
}
