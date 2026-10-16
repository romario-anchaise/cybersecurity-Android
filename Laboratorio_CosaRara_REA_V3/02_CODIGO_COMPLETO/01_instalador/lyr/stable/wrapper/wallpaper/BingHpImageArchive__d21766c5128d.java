// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BingHpImageArchive {

    @p020l0.b("images")
    public List<Image> images;

    public static final class Image {

        @p020l0.b("copyright")
        public String copyright;

        @p020l0.b("startdate")
        public String startDate;

        @p020l0.b("title")
        public String title;

        @p020l0.b("url")
        public String url;

        @p020l0.b("urlbase")
        public String urlBase;
    }

    public List<Image> images() {
        List<Image> list = this.images;
        return list == null ? Collections.emptyList() : list;
    }
}
