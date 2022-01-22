package dev.nanosync.mcsrvstat4j.service;

import dev.nanosync.mcsrvstat4j.entities.ServerEntity;
import dev.nanosync.mcsrvstat4j.enums.DebugEnum;
import dev.nanosync.mcsrvstat4j.enums.MotdEnum;
import dev.nanosync.mcsrvstat4j.enums.PlayersEnum;
import dev.nanosync.mcsrvstat4j.repositories.ServerRepository;
import dev.nanosync.mcsrvstat4j.enums.ServerStats;
import feign.Feign;
import feign.gson.GsonDecoder;

import javax.management.AttributeNotFoundException;

public class ServerService {

    private final ServerEntity serverEntity;

    /**
     * It will build the entity with the server's IP address and pass the responsibility
     * to the repository to deliver the entity's data.
     *
     * @param host : String param
     * @throws AttributeNotFoundException <strong>if server is invalid or offline throw a Exception</strong>
     */
    public ServerService(String host) throws AttributeNotFoundException {
        this.serverEntity = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ServerRepository.class, "https://api.mcsrvstat.us")
                .search(host);
        if (getServerStats().equals(ServerStats.OFFLINE)) throw new AttributeNotFoundException("The server is offline");
    }

    public ServerStats getServerStats() {
        if (serverEntity.getIp().equals("127.0.0.1")) return ServerStats.OFFLINE;
        return ServerStats.ONLINE;
    }

    /**
     * Get numeric IP.
     * @return String
     */
    public String getIp() {
        return serverEntity.getIp();
    }

    /**
     * Get port of server.
     * @return String
     */
    public String getPort() {
        return serverEntity.getPort();
    }

    /**
     * Get a debug attribute, check <strong>DebugEnum</strong>
     * @param debugEnum Require a enum to access Map.
     * @return Object
     */
    public Object getDebug(DebugEnum debugEnum) {
        return serverEntity.getDebug().get(debugEnum.toString());
    }

    /**
     * Get a debug attribute, check <strong>MotdEnum</strong>
     * @param motdEnum Require a enum to access Map.
     * @return Object
     */
    public Object getMotd(MotdEnum motdEnum) {
        return serverEntity.getMotd().get(motdEnum.toString());
    }

    /**
     * Get a debug attribute, check <strong>PlayersEnum</strong>
     * @param playersEnum Require a enum to access Map.
     * @return Object
     */
    public Object getPlayers(PlayersEnum playersEnum) {
        return serverEntity.getPlayers().get(playersEnum.toString());
    }

    /**
     * Get version of server
     * @return String
     */
    public String getVersion() {
        return serverEntity.getVersion();
    }

    /**
     * Get a online mode for server.
     * @return String
     */
    public String getOnline() {
        return serverEntity.getOnline();
    }

    /**
     * Get a protocol of server.
     * @return String
     */
    public String getProtocol() {
        return serverEntity.getProtocol();
    }

    /**
     * Get a complete hostname of server.
     * @return String
     */
    public String getHostname() {
        return serverEntity.getHostname();
    }

    /**
     * Get icon 64x64 of server.
     * @return String
     */
    public String getIcon() {
        return serverEntity.getIcon();
    }

}
