package dev.nanosync.mcsrvstat4j.enums;

import java.util.Locale;

public enum MotdEnum {
    RAW, CLEAN, HTML;

    @Override
    public String toString() {
        return super.toString().toLowerCase(Locale.ROOT);
    }
}
