// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f734a = p.a(new int[]{172, 25, 124, 50, 68, 20, 212, 164, 5, 32, 124, 224, 90});

    public static int a(View view, int i2) {
        Object tag = view.getTag(i2);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return 0;
    }
}
