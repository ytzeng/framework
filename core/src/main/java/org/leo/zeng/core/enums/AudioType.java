package org.leo.zeng.core.enums;

/**
 * 音频类型
 */
public enum AudioType {
    MP3(".mp3");
    private String value;

    private AudioType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean has(String extension) {
        if (AudioType.MP3.getValue().equalsIgnoreCase(extension)) {
            return true;
        }
        return false;
    }
}
