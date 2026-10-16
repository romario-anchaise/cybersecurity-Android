// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.I;
import A.X;
import H.t;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WeakReference f3126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0137b0 f3127d;

    public V(C0137b0 c0137b0, int i2, int i3, WeakReference weakReference) {
        this.f3127d = c0137b0;
        this.f3124a = i2;
        this.f3125b = i3;
        this.f3126c = weakReference;
    }

    public final void a() {
        new Handler(Looper.getMainLooper()).post(new t(7, this));
    }

    public final void b(Typeface typeface) {
        int i2;
        if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f3124a) != -1) {
            typeface = AbstractC0135a0.a(typeface, i2, (this.f3125b & 2) != 0);
        }
        C0137b0 c0137b0 = this.f3127d;
        if (c0137b0.f3151m) {
            c0137b0.f3150l = typeface;
            TextView textView = (TextView) this.f3126c.get();
            if (textView != null) {
                WeakHashMap weakHashMap = X.f14a;
                if (I.b(textView)) {
                    textView.post(new W(textView, typeface, c0137b0.f3148j));
                } else {
                    textView.setTypeface(typeface, c0137b0.f3148j);
                }
            }
        }
    }
}
