// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lyr.stable.wrapper.wallpaper.BingWallpaperApi;

/* JADX INFO: renamed from: m1.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0214s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f3855c;

    public C0214s(Object obj, Method method, ArrayList arrayList) {
        this.f3853a = obj;
        this.f3854b = method;
        this.f3855c = Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        return String.format("%s.%s() %s", BingWallpaperApi.class.getName(), this.f3854b.getName(), this.f3855c);
    }
}
