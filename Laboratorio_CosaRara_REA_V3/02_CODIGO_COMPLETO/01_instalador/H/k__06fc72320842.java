// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import android.view.View;
import f1.l;
import p015j.r1;

/* JADX INFO: loaded from: classes.dex */
public final class k extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2833f;

    public k(l lVar) {
        this.f2830c = 0;
        this.f2833f = lVar;
        this.f2831d = false;
        this.f2832e = 0;
    }

    @Override // A.i0
    public final void a() {
        switch (this.f2830c) {
            case 0:
                int i2 = this.f2832e + 1;
                this.f2832e = i2;
                l lVar = (l) this.f2833f;
                if (i2 == lVar.f2834a.size()) {
                    l lVar2 = lVar.f2837d;
                    if (lVar2 != null) {
                        lVar2.a();
                    }
                    this.f2832e = 0;
                    this.f2831d = false;
                    lVar.f2838e = false;
                }
                break;
            default:
                if (!this.f2831d) {
                    ((r1) this.f2833f).f3276a.setVisibility(this.f2832e);
                }
                break;
        }
    }

    @Override // f1.l, A.i0
    public void b(View view) {
        switch (this.f2830c) {
            case 1:
                this.f2831d = true;
                break;
        }
    }

    @Override // f1.l, A.i0
    public final void c() {
        switch (this.f2830c) {
            case 0:
                if (!this.f2831d) {
                    this.f2831d = true;
                    l lVar = ((l) this.f2833f).f2837d;
                    if (lVar != null) {
                        lVar.c();
                    }
                    break;
                }
                break;
            default:
                ((r1) this.f2833f).f3276a.setVisibility(0);
                break;
        }
    }

    public k(r1 r1Var, int i2) {
        this.f2830c = 1;
        this.f2833f = r1Var;
        this.f2832e = i2;
        this.f2831d = false;
    }
}
