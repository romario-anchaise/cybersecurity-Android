// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package C;

import A.C0005e;
import A.C0007g;
import A.InterfaceC0006f;
import A.InterfaceC0024y;
import A.X;
import A.x0;
import A.z0;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import com.o2s2m.gae1fc3b2uc0u.R;
import p015j.C0175v;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements InterfaceC0024y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f106a;

    public /* synthetic */ d(Object obj) {
        this.f106a = obj;
    }

    public boolean a(C0005e c0005e, int i2, Bundle bundle) {
        InterfaceC0006f c0005e2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 25 && (i2 & 1) != 0) {
            try {
                ((i) c0005e.f34b).b();
                Parcelable parcelable = (Parcelable) ((i) c0005e.f34b).e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e2) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e2);
                return false;
            }
        }
        ClipDescription clipDescriptionA = ((i) c0005e.f34b).a();
        i iVar = (i) c0005e.f34b;
        ClipData clipData = new ClipData(clipDescriptionA, new ClipData.Item(iVar.g()));
        if (i3 >= 31) {
            c0005e2 = new C0005e(clipData, 2);
        } else {
            C0007g c0007g = new C0007g();
            c0007g.f39b = clipData;
            c0007g.f40c = 2;
            c0005e2 = c0007g;
        }
        c0005e2.d(iVar.c());
        c0005e2.b(bundle);
        return X.f((C0175v) this.f106a, c0005e2.k()) == null;
    }

    @Override // A.InterfaceC0024y
    public z0 b(View view, z0 z0Var) {
        x0 x0Var = z0Var.f91a;
        p033t.c cVarF = x0Var.f(7);
        p033t.c cVarF2 = x0Var.f(128);
        int iMax = Math.max(cVarF.f4104b, cVarF2.f4104b);
        int iMax2 = Math.max(cVarF.f4106d, cVarF2.f4106d);
        int iMax3 = Math.max(cVarF.f4103a, cVarF2.f4103a);
        int iMax4 = Math.max(cVarF.f4105c, cVarF2.f4105c);
        view.setTag(R.id.viewport_insets_top, Integer.valueOf(iMax));
        view.setTag(R.id.viewport_insets_bottom, Integer.valueOf(iMax2));
        view.setTag(R.id.viewport_insets_left, Integer.valueOf(iMax3));
        view.setTag(R.id.viewport_insets_right, Integer.valueOf(iMax4));
        ((V0.a) this.f106a).run();
        return z0Var;
    }
}
