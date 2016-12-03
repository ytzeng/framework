package org.leo.zeng.core.enums;

/**
 * 图片类型
 */
public enum ImageType {
    /** JPEG文件格式 */
    JPG(".jpg"),
    /** BMP图像文件格式 */
    BMP(".bmp"),
    /** GIF文件格式 */
    GIF(".gif"),
    /** PNG图像文件格式 */
    PNG(".png");
    private String value;

    private ImageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean has(String extension) {
        if (ImageType.JPG.getValue().equalsIgnoreCase(extension)) {
            return true;
        } else if (ImageType.BMP.getValue().equalsIgnoreCase(extension)) {
            return true;
        } else if (ImageType.GIF.getValue().equalsIgnoreCase(extension)) {
            return true;
        } else if (ImageType.PNG.getValue().equalsIgnoreCase(extension)) {
            return true;
        }
        return false;
    }
}
