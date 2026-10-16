// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2733a;

    static {
        int[] iArr = new int[Proxy.Type.values().length];
        try {
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f2733a = iArr;
    }
}
