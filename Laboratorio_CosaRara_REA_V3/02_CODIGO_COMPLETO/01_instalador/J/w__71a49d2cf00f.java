// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import f1.l;
import p007e.a;

/* JADX INFO: renamed from: j.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0177w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f3332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0005e f3333b;

    public C0177w(TextView textView) {
        this.f3332a = textView;
        this.f3333b = new C0005e(textView);
    }

    public final void a(AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = this.f3332a.getContext().obtainStyledAttributes(attributeSet, a.f2233i, i2, 0);
        try {
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            c(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b(boolean z2) {
        ((l) this.f3333b.f34b).T(z2);
    }

    public final void c(boolean z2) {
        ((l) this.f3333b.f34b).U(z2);
    }
}
