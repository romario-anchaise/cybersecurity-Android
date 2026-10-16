// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import android.os.Bundle;
import androidx.lifecycle.F;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Q.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1244b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f1243a = i2;
        this.f1244b = obj;
    }

    @Override // Q.d
    public final Bundle a() {
        switch (this.f1243a) {
            case 0:
                return i.b((androidx.fragment.app.h) this.f1244b);
            default:
                return F.a((F) this.f1244b);
        }
    }
}
