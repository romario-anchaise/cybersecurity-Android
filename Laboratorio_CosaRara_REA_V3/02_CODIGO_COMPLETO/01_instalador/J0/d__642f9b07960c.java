// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p016j0;

import F0.h;
import N0.C;
import N0.C0041m;
import R0.o;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import f1.l;
import g0.f;
import p010f0.b;
import p010f0.c;
import p010f0.i;
import p012h0.a;
import p014i0.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3373a;

    static {
        T0.d dVar = C.f385a;
        O0.c cVar = o.f569a.f512f;
        T0.c cVar2 = C.f386b;
        p014i0.c cVar3 = e.f3015a;
        g0.d dVar2 = g0.d.f2741a;
        Bitmap.Config config = f.f3375a;
        b bVar = b.ENABLED;
        f3373a = new c(cVar, cVar2, cVar2, cVar2, cVar3, dVar2, config, true, false, null, null, null, bVar, bVar, bVar);
    }

    public static final boolean a(i iVar) {
        a aVar;
        ImageView imageView;
        int iOrdinal = iVar.f2643e.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new C0041m();
            }
            g0.i iVar2 = iVar.f2659v;
            if (!(iVar2 instanceof g0.c) && ((aVar = iVar.f2641c) == null || !(iVar2 instanceof f) || (imageView = aVar.f2841b) == null || imageView != ((f) iVar2).f2743a)) {
                return false;
            }
        }
        return true;
    }

    public static final Drawable b(i iVar, Integer num, Drawable drawable) {
        if (num == null) {
            return drawable;
        }
        if (num.intValue() == 0) {
            return null;
        }
        Context context = iVar.f2639a;
        int iIntValue = num.intValue();
        Drawable drawableA = l.A(context, iIntValue);
        if (drawableA != null) {
            return drawableA;
        }
        throw new IllegalStateException(h.b(iIntValue, "Invalid resource ID: ").toString());
    }
}
