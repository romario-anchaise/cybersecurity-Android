// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import R0.v;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f616f;
    public static final i g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f617h;

    static {
        String property;
        int i2 = v.f576a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f611a = property;
        f612b = R0.a.g("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i3 = v.f576a;
        if (i3 < 2) {
            i3 = 2;
        }
        f613c = R0.a.h("kotlinx.coroutines.scheduler.core.pool.size", i3, 1, 0, 8);
        f614d = R0.a.h("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        f615e = TimeUnit.SECONDS.toNanos(R0.a.g("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f616f = f.f605a;
        g = new i(0);
        f617h = new i(1);
    }
}
