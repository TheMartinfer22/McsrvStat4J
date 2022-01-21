package dev.nanosync.mcsrvstat4j.enums;

import java.util.Locale;

public enum DebugEnum {
    PING,
    QUERY,
    SRV,
    QUERYMISMATCH,
    IPINSRV,
    CNAMEINSRV,
    ANIMATEDMOTD,
    CACHETIME,
    APIVERSION;

    @Override
    public String toString() {
        return super.toString().toLowerCase(Locale.ROOT);
    }
}
