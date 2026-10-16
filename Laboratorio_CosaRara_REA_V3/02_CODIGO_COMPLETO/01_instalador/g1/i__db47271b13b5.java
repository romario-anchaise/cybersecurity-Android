// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f2770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f2771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f2772c;

    public /* synthetic */ i(Method method, Method method2, Method method3) {
        this.f2770a = method;
        this.f2771b = method2;
        this.f2772c = method3;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
