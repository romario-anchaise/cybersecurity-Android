// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p017k;

import f1.l;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class a extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f3402d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3403c;

    public a(int i2) {
        switch (i2) {
            case 1:
                this.f3403c = new Object();
                Executors.newFixedThreadPool(4, new b());
                break;
            default:
                this.f3403c = new a(1);
                break;
        }
    }
}
