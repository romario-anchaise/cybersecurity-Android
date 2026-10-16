// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import V.a;
import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f4169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f4170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4171e;

    public /* synthetic */ d(String str, Context context, a aVar, int i2, int i3) {
        this.f4167a = i3;
        this.f4168b = str;
        this.f4169c = context;
        this.f4170d = aVar;
        this.f4171e = i2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4167a) {
            case 0:
                return g.a(this.f4168b, this.f4169c, this.f4170d, this.f4171e);
            default:
                try {
                    return g.a(this.f4168b, this.f4169c, this.f4170d, this.f4171e);
                } catch (Throwable unused) {
                    return new f(-3);
                }
        }
    }
}
