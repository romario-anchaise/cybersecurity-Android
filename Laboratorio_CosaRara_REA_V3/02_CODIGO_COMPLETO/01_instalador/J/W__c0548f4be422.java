// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.graphics.Typeface;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class W implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f3130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Typeface f3131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3132c;

    public W(TextView textView, Typeface typeface, int i2) {
        this.f3130a = textView;
        this.f3131b = typeface;
        this.f3132c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3130a.setTypeface(this.f3131b, this.f3132c);
    }
}
