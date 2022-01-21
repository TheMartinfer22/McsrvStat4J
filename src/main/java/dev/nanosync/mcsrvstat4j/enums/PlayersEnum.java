package dev.nanosync.mcsrvstat4j.enums;

import java.util.Locale;

public enum PlayersEnum {
    ONLINE, MAX;

    @Override
    public String toString() {
        return super.toString().toLowerCase(Locale.ROOT);
    }
}
