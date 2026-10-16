// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V;

import N0.AbstractC0029a;
import N0.AbstractC0045q;
import N0.AbstractC0049v;
import N0.C;
import N0.C0052y;
import N0.S;
import N0.V;
import N0.f0;
import N0.r;
import R0.o;
import X0.p;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import androidx.lifecycle.AbstractC0078p;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p010f0.l;
import p010f0.q;
import p010f0.s;
import p010f0.u;
import p016j0.m;

/* JADX INFO: loaded from: classes.dex */
public final class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p010f0.c f680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p034t0.g f681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p016j0.j f683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final R0.d f684f;
    public final C.h g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f685h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f686i;

    public k(Context context, p010f0.c cVar, p034t0.g gVar, p034t0.g gVar2, p034t0.b bVar, b bVar2, p016j0.j jVar) {
        int i2 = 3;
        int i3 = 4;
        int i4 = 1;
        int i5 = 5;
        int i6 = 2;
        int i7 = 0;
        this.f679a = context;
        this.f680b = cVar;
        this.f681c = gVar;
        this.f683e = jVar;
        f0 f0Var = new f0(null);
        T0.d dVar = C.f385a;
        O0.c cVar2 = o.f569a.f512f;
        F0.i.e(cVar2, "context");
        p040w0.i iVarT = p029q.j.n(f0Var, cVar2).t(new j(this));
        this.f684f = new R0.d(iVarT.j(r.f453b) == null ? iVarT.t(new V(null)) : iVarT);
        m mVar = new m(this);
        C.h hVar = new C.h(this, mVar);
        this.g = hVar;
        a aVar = new a(bVar2);
        aVar.b(new p005c0.a(i6), p.class);
        aVar.b(new p005c0.a(i5), String.class);
        aVar.b(new p005c0.a(i4), Uri.class);
        aVar.b(new p005c0.a(i3), Uri.class);
        aVar.b(new p005c0.a(i2), Integer.class);
        aVar.b(new p005c0.a(i7), byte[].class);
        p003b0.c cVar3 = new p003b0.c();
        ArrayList arrayList = (ArrayList) aVar.f652d;
        arrayList.add(new p034t0.d(cVar3, Uri.class));
        arrayList.add(new p034t0.d(new p003b0.a(jVar.f3384a), File.class));
        aVar.a(new Z.i(bVar, gVar2, jVar.f3386c), Uri.class);
        aVar.a(new Z.a(i5), File.class);
        aVar.a(new Z.a(i7), Uri.class);
        aVar.a(new Z.a(i2), Uri.class);
        aVar.a(new Z.a(6), Uri.class);
        aVar.a(new Z.a(i3), Drawable.class);
        aVar.a(new Z.a(1), Bitmap.class);
        aVar.a(new Z.a(2), ByteBuffer.class);
        W.c cVar4 = new W.c(jVar.f3387d, jVar.f3388e);
        ArrayList arrayList2 = (ArrayList) aVar.f654f;
        arrayList2.add(cVar4);
        List listD = f1.d.D((ArrayList) aVar.f650b);
        this.f685h = new b(listD, f1.d.D((ArrayList) aVar.f651c), f1.d.D(arrayList), f1.d.D((ArrayList) aVar.f653e), f1.d.D(arrayList2));
        this.f686i = p036u0.f.z(listD, new p001a0.h(this, mVar, hVar));
        new AtomicBoolean(false);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00d9 A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ea A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0104  */
    /* JADX WARN: Code duplicated, block: B:46:0x0106  */
    /* JADX WARN: Code duplicated, block: B:49:0x0130  */
    /* JADX WARN: Code duplicated, block: B:52:0x0138 A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0146 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x0148 A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x014c A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0156 A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x015a A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0169 A[Catch: all -> 0x0167, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x016d A[Catch: all -> 0x0167, TRY_LEAVE, TryCatch #1 {all -> 0x0167, blocks: (B:50:0x0131, B:52:0x0138, B:55:0x0148, B:60:0x0160, B:56:0x014c, B:58:0x0156, B:59:0x015a, B:63:0x0169, B:65:0x016d, B:47:0x0108, B:37:0x00d3, B:39:0x00d9, B:40:0x00dc, B:42:0x00ea, B:43:0x00ed, B:32:0x00b6, B:34:0x00bc, B:67:0x017c, B:68:0x0183), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0188 A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:69:0x0184, B:71:0x0188, B:75:0x019a, B:76:0x01a3), top: B:81:0x0184 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x019a A[Catch: all -> 0x0198, TryCatch #2 {all -> 0x0198, blocks: (B:69:0x0184, B:71:0x0188, B:75:0x019a, B:76:0x01a3), top: B:81:0x0184 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v9, types: [V.k, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v6, types: [V.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v7, types: [f0.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v5, types: [f0.p] */
    /* JADX WARN: Type inference failed for: r4v6, types: [f0.p] */
    public static final Object a(k kVar, p010f0.i iVar, p044y0.c cVar) {
        h hVar;
        int i2;
        ?? r2;
        ?? r1;
        c cVar2;
        k kVar2;
        Bitmap bitmap;
        Object objA;
        c cVar3;
        k kVar3;
        Object objN;
        c cVar4;
        k kVar4;
        ?? r4;
        ?? r3;
        p010f0.j jVar;
        ?? r5;
        p010f0.p pVar;
        p010f0.i iVar2;
        p010f0.j jVar2;
        q qVar;
        p012h0.a aVar;
        p010f0.i iVar3;
        Drawable drawable;
        p014i0.f fVarA;
        p010f0.p pVar2;
        p010f0.i iVar4;
        p010f0.p pVar3;
        p010f0.i iVar5;
        Drawable drawableB;
        p012h0.a aVar2;
        Object obj;
        p010f0.p sVar;
        p010f0.i iVarA;
        c cVar5;
        int i3;
        k kVar5 = kVar;
        kVar.getClass();
        if (cVar instanceof h) {
            hVar = (h) cVar;
            i3 = hVar.f672k;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                int i4 = i3 - Integer.MIN_VALUE;
                hVar.f672k = i4;
                i2 = i4;
            } else {
                hVar = new h(kVar5, cVar);
                i2 = i3;
            }
        } else {
            hVar = new h(kVar5, cVar);
            i2 = i3;
        }
        h hVar2 = hVar;
        Object obj2 = hVar2.f670i;
        p042x0.a aVar3 = p042x0.a.f4189a;
        int i5 = hVar2.f672k;
        if (i5 != 0) {
            try {
                if (i5 == 1) {
                    c cVar6 = hVar2.g;
                    p010f0.i iVar6 = hVar2.f668f;
                    p010f0.p pVar4 = hVar2.f667e;
                    k kVar6 = hVar2.f666d;
                    p029q.j.o(obj2);
                    cVar2 = cVar6;
                    kVar2 = kVar6;
                    iVar5 = iVar6;
                    pVar3 = pVar4;
                    kVar2 = kVar5;
                    cVar2 = cVar5;
                    iVar5 = iVarA;
                    pVar3 = sVar;
                    if (kVar2.c() != null) {
                        iVar5.getClass();
                    }
                    drawableB = p016j0.d.b(iVar5, iVar5.f2662y, iVar5.f2638B.f2612j);
                    aVar2 = iVar5.f2641c;
                    if (aVar2 != null) {
                        aVar2.i(drawableB);
                    }
                    cVar2.getClass();
                    g0.i iVar7 = iVar5.f2659v;
                    hVar2.f666d = kVar2;
                    hVar2.f667e = pVar3;
                    hVar2.f668f = iVar5;
                    hVar2.g = cVar2;
                    hVar2.f669h = null;
                    hVar2.f672k = 2;
                    objA = iVar7.a(hVar2);
                    if (objA == aVar3) {
                        obj = aVar3;
                    } else {
                        bitmap = null;
                        kVar3 = kVar2;
                        cVar3 = cVar2;
                        iVar4 = iVar5;
                        pVar2 = pVar3;
                        g0.h hVar3 = (g0.h) objA;
                        cVar3.getClass();
                        AbstractC0045q abstractC0045q = iVar4.f2654q;
                        i iVar8 = new i(iVar4, kVar3, hVar3, cVar3, bitmap, null);
                        hVar2.f666d = kVar3;
                        hVar2.f667e = pVar2;
                        hVar2.f668f = iVar4;
                        hVar2.g = cVar3;
                        hVar2.f669h = null;
                        hVar2.f672k = 3;
                        objN = AbstractC0049v.n(abstractC0045q, iVar8, hVar2);
                        kVar4 = kVar3;
                        cVar4 = cVar3;
                        iVar2 = iVar4;
                        pVar = pVar2;
                        if (objN == aVar3) {
                            obj = aVar3;
                        }
                    }
                } else if (i5 == 2) {
                    Bitmap bitmap2 = hVar2.f669h;
                    c cVar7 = hVar2.g;
                    p010f0.i iVar9 = hVar2.f668f;
                    p010f0.p pVar5 = hVar2.f667e;
                    k kVar7 = hVar2.f666d;
                    p029q.j.o(obj2);
                    bitmap = bitmap2;
                    objA = obj2;
                    cVar3 = cVar7;
                    kVar3 = kVar7;
                    iVar4 = iVar9;
                    pVar2 = pVar5;
                    g0.h hVar4 = (g0.h) objA;
                    cVar3.getClass();
                    AbstractC0045q abstractC0045q2 = iVar4.f2654q;
                    i iVar10 = new i(iVar4, kVar3, hVar4, cVar3, bitmap, null);
                    hVar2.f666d = kVar3;
                    hVar2.f667e = pVar2;
                    hVar2.f668f = iVar4;
                    hVar2.g = cVar3;
                    hVar2.f669h = null;
                    hVar2.f672k = 3;
                    objN = AbstractC0049v.n(abstractC0045q2, iVar10, hVar2);
                    kVar4 = kVar3;
                    cVar4 = cVar3;
                    iVar2 = iVar4;
                    pVar = pVar2;
                    if (objN == aVar3) {
                        obj = aVar3;
                    }
                } else {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c cVar8 = hVar2.g;
                    p010f0.i iVar11 = hVar2.f668f;
                    p010f0.p pVar6 = hVar2.f667e;
                    k kVar8 = hVar2.f666d;
                    p029q.j.o(obj2);
                    objN = obj2;
                    cVar4 = cVar8;
                    kVar4 = kVar8;
                    iVar2 = iVar11;
                    pVar = pVar6;
                }
                jVar2 = (p010f0.j) objN;
                if (jVar2 instanceof q) {
                    qVar = (q) jVar2;
                    aVar = iVar2.f2641c;
                    kVar4.getClass();
                    iVar3 = qVar.f2684b;
                    drawable = qVar.f2683a;
                    if (aVar == null) {
                        fVarA = iVar3.g.a(aVar, qVar);
                        if (fVarA instanceof p014i0.d) {
                            aVar.i(drawable);
                        } else {
                            cVar4.getClass();
                            fVarA.a();
                        }
                    } else if (aVar != null) {
                        aVar.i(drawable);
                    }
                    cVar4.getClass();
                    iVar3.getClass();
                    r5 = pVar;
                    jVar = jVar2;
                } else if (jVar2 instanceof p010f0.e) {
                    r5 = pVar;
                    jVar = jVar2;
                    p012h0.a aVar4 = iVar2.f2641c;
                    kVar4.getClass();
                    d((p010f0.e) jVar2, aVar4, cVar4);
                    r5 = pVar;
                    jVar = jVar2;
                }
            } catch (Throwable th) {
                th = th;
                r2 = kVar5;
                r1 = -2147483648;
                r3 = i5;
                r4 = i2;
                try {
                    if (!(th instanceof CancellationException)) {
                        r1.getClass();
                        r2.getClass();
                        r3.getClass();
                        throw th;
                    }
                    r1.g.getClass();
                    p010f0.e eVarI = C.h.i(r3, th);
                    d(eVarI, r3.f2641c, r2);
                    r5 = r4;
                    jVar = eVarI;
                } catch (Throwable th2) {
                    r4.a();
                    throw th2;
                }
            }
            r5 = pVar;
            jVar = jVar2;
            r5.a();
            obj = jVar;
        } else {
            p029q.j.o(obj2);
            p040w0.i iVar12 = hVar2.f4197b;
            F0.i.b(iVar12);
            S sE = AbstractC0049v.e(iVar12);
            C.h hVar5 = kVar5.g;
            hVar5.getClass();
            AbstractC0078p abstractC0078p = iVar.f2658u;
            p012h0.a aVar5 = iVar.f2641c;
            sVar = aVar5 != null ? new s((k) hVar5.f111a, iVar, aVar5, abstractC0078p, sE) : new p010f0.a(abstractC0078p, sE);
            sVar.d();
            p010f0.h hVar6 = new p010f0.h(iVar, iVar.f2639a);
            hVar6.f2624b = kVar5.f680b;
            hVar6.f2636o = null;
            iVarA = hVar6.a();
            cVar5 = c.f660a;
            try {
                if (iVarA.f2640b == p010f0.k.f2664b) {
                    throw new l("The request's data is null.");
                }
                sVar.start();
                AbstractC0078p abstractC0078p2 = iVarA.f2658u;
                hVar2.f666d = kVar5;
                hVar2.f667e = sVar;
                hVar2.f668f = iVarA;
                hVar2.g = cVar5;
                hVar2.f672k = 1;
                if (f1.d.d(abstractC0078p2, hVar2) == aVar3) {
                    kVar2 = kVar5;
                    cVar2 = cVar5;
                    iVar5 = iVarA;
                    pVar3 = sVar;
                    obj = aVar3;
                } else {
                    kVar2 = kVar5;
                    cVar2 = cVar5;
                    iVar5 = iVarA;
                    pVar3 = sVar;
                    if (kVar2.c() != null) {
                        iVar5.getClass();
                    }
                    drawableB = p016j0.d.b(iVar5, iVar5.f2662y, iVar5.f2638B.f2612j);
                    aVar2 = iVar5.f2641c;
                    if (aVar2 != null) {
                        aVar2.i(drawableB);
                    }
                    cVar2.getClass();
                    g0.i iVar13 = iVar5.f2659v;
                    hVar2.f666d = kVar2;
                    hVar2.f667e = pVar3;
                    hVar2.f668f = iVar5;
                    hVar2.g = cVar2;
                    hVar2.f669h = null;
                    hVar2.f672k = 2;
                    objA = iVar13.a(hVar2);
                    if (objA == aVar3) {
                        obj = aVar3;
                    } else {
                        bitmap = null;
                        kVar3 = kVar2;
                        cVar3 = cVar2;
                        iVar4 = iVar5;
                        pVar2 = pVar3;
                        g0.h hVar7 = (g0.h) objA;
                        cVar3.getClass();
                        AbstractC0045q abstractC0045q3 = iVar4.f2654q;
                        i iVar14 = new i(iVar4, kVar3, hVar7, cVar3, bitmap, null);
                        hVar2.f666d = kVar3;
                        hVar2.f667e = pVar2;
                        hVar2.f668f = iVar4;
                        hVar2.g = cVar3;
                        hVar2.f669h = null;
                        hVar2.f672k = 3;
                        objN = AbstractC0049v.n(abstractC0045q3, iVar14, hVar2);
                        kVar4 = kVar3;
                        cVar4 = cVar3;
                        iVar2 = iVar4;
                        pVar = pVar2;
                        if (objN == aVar3) {
                            obj = aVar3;
                        } else {
                            jVar2 = (p010f0.j) objN;
                            if (jVar2 instanceof q) {
                                qVar = (q) jVar2;
                                aVar = iVar2.f2641c;
                                kVar4.getClass();
                                iVar3 = qVar.f2684b;
                                drawable = qVar.f2683a;
                                if (aVar == null) {
                                    fVarA = iVar3.g.a(aVar, qVar);
                                    if (fVarA instanceof p014i0.d) {
                                        aVar.i(drawable);
                                    } else {
                                        cVar4.getClass();
                                        fVarA.a();
                                    }
                                } else if (aVar != null) {
                                    aVar.i(drawable);
                                }
                                cVar4.getClass();
                                iVar3.getClass();
                                r5 = pVar;
                                jVar = jVar2;
                            } else if (jVar2 instanceof p010f0.e) {
                                r5 = pVar;
                                jVar = jVar2;
                                p012h0.a aVar6 = iVar2.f2641c;
                                kVar4.getClass();
                                d((p010f0.e) jVar2, aVar6, cVar4);
                                r5 = pVar;
                                jVar = jVar2;
                            }
                            r5 = pVar;
                            jVar = jVar2;
                            r5.a();
                            obj = jVar;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                r1 = kVar5;
                r2 = cVar5;
                r3 = iVarA;
                r4 = sVar;
                if (!(th instanceof CancellationException)) {
                    r1.getClass();
                    r2.getClass();
                    r3.getClass();
                    throw th;
                }
                r1.g.getClass();
                p010f0.e eVarI2 = C.h.i(r3, th);
                d(eVarI2, r3.f2641c, r2);
                r5 = r4;
                jVar = eVarI2;
            }
        }
        return obj;
    }

    public static void d(p010f0.e eVar, p012h0.a aVar, c cVar) {
        p010f0.i iVar = eVar.f2619b;
        Drawable drawable = eVar.f2618a;
        if (aVar != null) {
            p014i0.f fVarA = eVar.f2619b.g.a(aVar, eVar);
            if (fVarA instanceof p014i0.d) {
                aVar.i(drawable);
            } else {
                cVar.getClass();
                fVarA.a();
            }
        } else if (aVar != null) {
            aVar.i(drawable);
        }
        cVar.getClass();
        iVar.getClass();
    }

    public final p010f0.k b(p010f0.i iVar) {
        R0.d dVar = this.f684f;
        g gVar = new g(this, iVar, null);
        boolean z2 = true;
        p040w0.i iVarC = AbstractC0049v.c(dVar.c(), p040w0.j.f4165a, true);
        T0.d dVar2 = C.f385a;
        if (iVarC != dVar2 && iVarC.j(p040w0.e.f4164a) == null) {
            iVarC = iVarC.t(dVar2);
        }
        AbstractC0029a c0052y = new C0052y(iVarC, z2, 0);
        c0052y.M(1, c0052y, gVar);
        p012h0.a aVar = iVar.f2641c;
        if (aVar == null) {
            return new p010f0.k(1);
        }
        u uVarC = p016j0.f.c(aVar.f2841b);
        synchronized (uVarC) {
            p010f0.k kVar = uVarC.f2697a;
            if (kVar != null && F0.i.a(Looper.myLooper(), Looper.getMainLooper()) && uVarC.f2700d) {
                uVarC.f2700d = false;
                return kVar;
            }
            C0052y c0052y2 = uVarC.f2698b;
            if (c0052y2 != null) {
                AbstractC0049v.a(c0052y2);
            }
            uVarC.f2698b = null;
            p010f0.k kVar2 = new p010f0.k(2);
            uVarC.f2697a = kVar2;
            return kVar2;
        }
    }

    public final d0.c c() {
        return (d0.c) this.f681c.getValue();
    }
}
