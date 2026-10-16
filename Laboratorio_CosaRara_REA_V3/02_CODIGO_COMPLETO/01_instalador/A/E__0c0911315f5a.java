// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import H.C0028c;
import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f5d;

    public E() {
        if (C0028c.f191b == null) {
            C0028c.f191b = new C0028c(4);
        }
    }

    public int a(int i2) {
        if (i2 < this.f4c) {
            return ((ByteBuffer) this.f5d).getShort(this.f3b + i2);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public void d(View view, Object obj) {
        Object tag;
        C0003c c0003c;
        if (Build.VERSION.SDK_INT >= this.f3b) {
            c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f3b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.f2a);
            if (!((Class) this.f5d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateC = X.c(view);
            if (accessibilityDelegateC == null) {
                c0003c = null;
            } else {
                c0003c = accessibilityDelegateC instanceof C0001a ? ((C0001a) accessibilityDelegateC).f19a : new C0003c(accessibilityDelegateC);
            }
            if (c0003c == null) {
                c0003c = new C0003c();
            }
            X.h(view, c0003c);
            view.setTag(this.f2a, obj);
            X.e(view, this.f4c);
        }
    }

    public abstract boolean e(Object obj, Object obj2);
}
