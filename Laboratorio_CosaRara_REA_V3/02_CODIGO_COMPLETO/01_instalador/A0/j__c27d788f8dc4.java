// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p001a0;

import V.c;
import android.content.Context;
import g0.h;
import java.util.ArrayList;
import p010f0.i;
import p010f0.k;
import p042x0.a;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f1217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f1220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f1221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f1222f;
    public final boolean g;

    public j(i iVar, ArrayList arrayList, int i2, i iVar2, h hVar, c cVar, boolean z2) {
        this.f1217a = iVar;
        this.f1218b = arrayList;
        this.f1219c = i2;
        this.f1220d = iVar2;
        this.f1221e = hVar;
        this.f1222f = cVar;
        this.g = z2;
    }

    public final void a(i iVar, h hVar) {
        Context context = iVar.f2639a;
        i iVar2 = this.f1217a;
        if (context != iVar2.f2639a) {
            throw new IllegalStateException(("Interceptor '" + hVar + "' cannot modify the request's context.").toString());
        }
        if (iVar.f2640b == k.f2664b) {
            throw new IllegalStateException(("Interceptor '" + hVar + "' cannot set the request's data to null.").toString());
        }
        if (iVar.f2641c != iVar2.f2641c) {
            throw new IllegalStateException(("Interceptor '" + hVar + "' cannot modify the request's target.").toString());
        }
        if (iVar.f2658u != iVar2.f2658u) {
            throw new IllegalStateException(("Interceptor '" + hVar + "' cannot modify the request's lifecycle.").toString());
        }
        if (iVar.f2659v == iVar2.f2659v) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + hVar + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(i iVar, p044y0.c cVar) {
        i iVar2;
        j jVar;
        h hVar;
        if (cVar instanceof i) {
            iVar2 = (i) cVar;
            int i2 = iVar2.f1216h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                iVar2.f1216h = i2 - Integer.MIN_VALUE;
            } else {
                iVar2 = new i(this, cVar);
            }
        } else {
            iVar2 = new i(this, cVar);
        }
        Object objD = iVar2.f1215f;
        a aVar = a.f4189a;
        int i3 = iVar2.f1216h;
        if (i3 == 0) {
            p029q.j.o(objD);
            ArrayList arrayList = this.f1218b;
            int i4 = this.f1219c;
            if (i4 > 0) {
                a(iVar, (h) arrayList.get(i4 - 1));
            }
            h hVar2 = (h) arrayList.get(i4);
            j jVar2 = new j(this.f1217a, arrayList, i4 + 1, iVar, this.f1221e, this.f1222f, this.g);
            iVar2.f1213d = this;
            iVar2.f1214e = hVar2;
            iVar2.f1216h = 1;
            objD = hVar2.d(jVar2, iVar2);
            if (objD == aVar) {
                return aVar;
            }
            jVar = this;
            hVar = hVar2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = iVar2.f1214e;
            jVar = iVar2.f1213d;
            p029q.j.o(objD);
        }
        p010f0.j jVar3 = (p010f0.j) objD;
        jVar.a(jVar3.b(), hVar);
        return jVar3;
    }
}
