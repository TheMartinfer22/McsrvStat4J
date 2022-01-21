package dev.nanosync.mcsrvstat4j.service;

import dev.nanosync.mcsrvstat4j.entities.ServerEntity;
import dev.nanosync.mcsrvstat4j.enums.DebugEnum;
import dev.nanosync.mcsrvstat4j.enums.MotdEnum;
import dev.nanosync.mcsrvstat4j.enums.PlayersEnum;
import dev.nanosync.mcsrvstat4j.repositories.ServerRepository;
import dev.nanosync.mcsrvstat4j.enums.ServerStats;
import feign.Feign;
import feign.gson.GsonDecoder;

public class ServerService extends ServerEntity {

    private final ServerEntity serverEntity;

    public ServerService(String host){
        this.serverEntity = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ServerRepository.class, "https://api.mcsrvstat.us")
                .search(host);
        if (getServerStats().equals(ServerStats.OFFLINE)) throw new NullPointerException("The server is offline");
    }

    public ServerStats getServerStats() {
        if (serverEntity.getIp().equals("127.0.0.1")) return ServerStats.OFFLINE;
        return ServerStats.ONLINE;
    }

    public String getIp() {
        return serverEntity.getIp();
    }

    public String getPort() {
        return serverEntity.getPort();
    }

    public Object getDebug(DebugEnum debugEnum) {
        return serverEntity.getDebug().get(debugEnum.toString());
    }

    public Object getMotd(MotdEnum motdEnum) {
        return serverEntity.getMotd().get(motdEnum.toString());
    }

    public Object getPlayers(PlayersEnum playersEnum) {
        return serverEntity.getPlayers().get(playersEnum.toString());
    }

    public String getVersion() {
        return serverEntity.getVersion();
    }

    public String getOnline() {
        return serverEntity.getOnline();
    }

    public String getProtocol() {
        return serverEntity.getProtocol();
    }

    public String getHostname() {
        return serverEntity.getHostname();
    }

    public String getIcon() {
        return serverEntity.getIcon();
    }

}
