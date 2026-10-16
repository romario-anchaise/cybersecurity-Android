// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import X0.C0062i;
import X0.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;

/* JADX INFO: renamed from: j.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0171t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f3300b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0171t f3301c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Q0 f3302a;

    public static synchronized C0171t a() {
        try {
            if (f3301c == null) {
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3301c;
    }

    public static synchronized void c() {
        if (f3301c == null) {
            C0171t c0171t = new C0171t();
            f3301c = c0171t;
            c0171t.f3302a = Q0.b();
            Q0 q1 = f3301c.f3302a;
            y yVar = new y();
            synchronized (q1) {
                q1.f3107e = yVar;
            }
        }
    }

    public static void d(Drawable drawable, C0062i c0062i, int[] iArr) {
        PorterDuff.Mode mode = Q0.f3101f;
        int[] state = drawable.getState();
        int[] iArr2 = AbstractC0167q0.f3268a;
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z2 = c0062i.f984b;
        if (!z2 && !c0062i.f983a) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterE = null;
        ColorStateList colorStateList = z2 ? (ColorStateList) c0062i.f985c : null;
        PorterDuff.Mode mode2 = c0062i.f983a ? (PorterDuff.Mode) c0062i.f986d : Q0.f3101f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterE = Q0.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterE);
    }

    public final synchronized Drawable b(Context context, int i2) {
        return this.f3302a.c(context, i2);
    }
}
