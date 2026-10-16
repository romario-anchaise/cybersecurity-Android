// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class C extends E {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f0e;

    public C(int i2, Class cls, int i3, int i4, int i5) {
        this.f0e = i5;
        this.f2a = i2;
        this.f5d = cls;
        this.f4c = i3;
        this.f3b = i4;
    }

    @Override // A.E
    public final Object b(View view) {
        switch (this.f0e) {
            case 0:
                return Boolean.valueOf(P.d(view));
            case 1:
                return P.b(view);
            default:
                return Boolean.valueOf(P.c(view));
        }
    }

    @Override // A.E
    public final void c(View view, Object obj) {
        switch (this.f0e) {
            case 0:
                P.j(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                P.h(view, (CharSequence) obj);
                break;
            default:
                P.g(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // A.E
    public final boolean e(Object obj, Object obj2) {
        switch (this.f0e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
    }
}
