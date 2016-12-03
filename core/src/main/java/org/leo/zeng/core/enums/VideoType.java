package org.leo.zeng.core.enums;

/**
 * 视频类型
 */
public enum VideoType {
    MP4(".mp4");
    private String value;

    private VideoType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean has(String extension) {
        if (VideoType.MP4.getValue().equalsIgnoreCase(extension)) {
            return true;
        }
        return false;
    }
}
