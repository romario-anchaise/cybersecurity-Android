// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import V0.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WallpaperMapper {
    public static final String BING_HOST = p.a(new int[]{155, 50, 70, 35, 84, 79, 205, 191, 75, 52, 59, 246, 0, 255, 113, 219, 221, 37, 93, 62});

    private WallpaperMapper() {
    }

    public static String absoluteUrl(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        if (str.charAt(0) == '/') {
            return BING_HOST + str;
        }
        return BING_HOST + "/" + str;
    }

    public static List<WallpaperItem> fromArchive(BingHpImageArchive bingHpImageArchive) {
        ArrayList arrayList = new ArrayList();
        if (bingHpImageArchive == null) {
            return arrayList;
        }
        for (BingHpImageArchive.Image image : bingHpImageArchive.images()) {
            String strAbsoluteUrl = absoluteUrl(image.url);
            if (!strAbsoluteUrl.isEmpty()) {
                String str = image.title;
                String strTrim = str == null ? "" : str.trim();
                String str2 = image.copyright;
                String strTrim2 = str2 != null ? str2.trim() : "";
                String str3 = image.startDate;
                arrayList.add(new WallpaperItem((str3 == null || str3.isEmpty()) ? strAbsoluteUrl : image.startDate, strTrim.isEmpty() ? strTrim2 : strTrim, strTrim2, strAbsoluteUrl, thumbUrl(strAbsoluteUrl)));
            }
        }
        return arrayList;
    }

    public static String thumbUrl(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.contains("?") ? "&" : "?");
        sb.append("w=480");
        return sb.toString();
    }
}
