// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p001a0;

import A.C0005e;
import F0.n;
import N0.AbstractC0045q;
import N0.AbstractC0049v;
import N0.C0041m;
import V.b;
import V.c;
import V.k;
import Z.d;
import Z.e;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import g0.g;
import java.util.List;
import java.util.concurrent.CancellationException;
import p010f0.i;
import p016j0.f;
import p016j0.m;
import p029q.j;
import p042x0.a;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f1210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C.h f1211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0005e f1212d;

    public h(k kVar, m mVar, C.h hVar) {
        this.f1209a = kVar;
        this.f1210b = mVar;
        this.f1211c = hVar;
        this.f1212d = new C0005e(kVar, hVar);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0077  */
    /* JADX WARN: Code duplicated, block: B:18:0x0095  */
    /* JADX WARN: Code duplicated, block: B:20:0x0098  */
    /* JADX WARN: Code duplicated, block: B:23:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:26:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:29:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:31:0x00df  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c1 -> B:24:0x00c8). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static final java.lang.Object a(p001a0.h r19, Z.m r20, V.b r21, p010f0.i r22, java.lang.Object r23, p010f0.m r24, V.c r25, p044y0.c r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a0.h.a(a0.h, Z.m, V.b, f0.i, java.lang.Object, f0.m, V.c, y0.c):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:42:0x013b  */
    /* JADX WARN: Code duplicated, block: B:43:0x013e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0141  */
    /* JADX WARN: Code duplicated, block: B:49:0x0167 A[PHI: r1
  0x0167: PHI (r1v23 java.lang.Object) = (r1v20 java.lang.Object), (r1v1 java.lang.Object) binds: [B:47:0x0164, B:14:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x0170  */
    /* JADX WARN: Code duplicated, block: B:53:0x0175  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [x0.a] */
    /* JADX WARN: Type inference failed for: r9v3, types: [a0.a] */
    public static final Object b(h hVar, i iVar, Object obj, p010f0.m mVar, c cVar, p044y0.c cVar2) throws Throwable {
        c cVar3;
        i iVar2;
        Object obj2;
        c cVar4;
        n nVar;
        n nVar2;
        n nVar3;
        h hVar2;
        n nVar4;
        n nVar5;
        i iVar3;
        h hVar3;
        Object obj3;
        Z.m mVar2;
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        hVar.getClass();
        if (cVar2 instanceof c) {
            cVar3 = (c) cVar2;
            int i2 = cVar3.f1181n;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar3.f1181n = i2 - Integer.MIN_VALUE;
            } else {
                cVar3 = new c(hVar, cVar2);
            }
        } else {
            cVar3 = new c(hVar, cVar2);
        }
        c cVar5 = cVar3;
        Object objC = cVar5.f1179l;
        Object obj4 = a.f4189a;
        n nVar6 = cVar5.f1181n;
        try {
            if (nVar6 == 0) {
                j.o(objC);
                n nVar7 = new n();
                nVar7.f180a = mVar;
                n nVar8 = new n();
                nVar8.f180a = hVar.f1209a.f685h;
                n nVar9 = new n();
                try {
                    nVar7.f180a = hVar.f1211c.s((p010f0.m) nVar7.f180a);
                    iVar.getClass();
                    b bVar = (b) nVar8.f180a;
                    p010f0.m mVar3 = (p010f0.m) nVar7.f180a;
                    cVar5.f1172d = hVar;
                    cVar5.f1173e = iVar;
                    cVar5.f1174f = obj;
                    cVar5.g = cVar;
                    cVar5.f1175h = nVar7;
                    cVar5.f1176i = nVar8;
                    cVar5.f1177j = nVar9;
                    cVar5.f1178k = nVar9;
                    cVar5.f1181n = 1;
                    objC = hVar.c(bVar, iVar, obj, mVar3, cVar, cVar5);
                    if (objC != obj4) {
                        iVar2 = iVar;
                        obj2 = obj;
                        cVar4 = cVar;
                        nVar = nVar7;
                        nVar2 = nVar8;
                        nVar3 = nVar9;
                        hVar2 = hVar;
                        nVar4 = nVar3;
                    }
                    return obj4;
                } catch (Throwable th) {
                    th = th;
                    nVar6 = nVar9;
                    Object obj5 = nVar6.f180a;
                    Z.m mVar4 = obj5 instanceof Z.m ? (Z.m) obj5 : null;
                    if (mVar4 != null) {
                        f.a(mVar4.f1153a);
                    }
                    throw th;
                }
            }
            if (nVar6 == 1) {
                nVar4 = cVar5.f1178k;
                nVar3 = cVar5.f1177j;
                n nVar10 = cVar5.f1176i;
                nVar = cVar5.f1175h;
                cVar4 = (c) cVar5.g;
                Object obj6 = cVar5.f1174f;
                iVar2 = cVar5.f1173e;
                hVar2 = cVar5.f1172d;
                j.o(objC);
                nVar2 = nVar10;
                obj2 = obj6;
            } else {
                if (nVar6 == 2) {
                    nVar3 = cVar5.f1175h;
                    nVar5 = (n) cVar5.g;
                    iVar3 = cVar5.f1173e;
                    hVar3 = cVar5.f1172d;
                    j.o(objC);
                    objC = (a) objC;
                    iVar2 = iVar3;
                    hVar2 = hVar3;
                    nVar = nVar5;
                    obj3 = nVar3.f180a;
                    if (obj3 instanceof Z.m) {
                        mVar2 = (Z.m) obj3;
                    } else {
                        mVar2 = null;
                    }
                    if (mVar2 != null) {
                        f.a(mVar2.f1153a);
                    }
                    cVar5.f1172d = null;
                    cVar5.f1173e = null;
                    cVar5.f1174f = null;
                    cVar5.g = null;
                    cVar5.f1175h = null;
                    cVar5.f1176i = null;
                    cVar5.f1177j = null;
                    cVar5.f1178k = null;
                    cVar5.f1181n = 3;
                    hVar2.getClass();
                    iVar2.f2644f.getClass();
                    if (objC != obj4) {
                    }
                    return obj4;
                }
                if (nVar6 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j.o(objC);
            }
            obj4 = (a) objC;
            Drawable drawable = obj4.f1158a;
            bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                bitmap.prepareToDraw();
            }
            return obj4;
            nVar4.f180a = objC;
            Object obj7 = nVar3.f180a;
            e eVar = (e) obj7;
            if (eVar instanceof Z.m) {
                AbstractC0045q abstractC0045q = iVar2.f2656s;
                d dVar = new d(hVar2, nVar3, nVar2, iVar2, obj2, nVar, cVar4, null);
                cVar5.f1172d = hVar2;
                cVar5.f1173e = iVar2;
                cVar5.f1174f = cVar4;
                cVar5.g = nVar;
                cVar5.f1175h = nVar3;
                cVar5.f1176i = null;
                cVar5.f1177j = null;
                cVar5.f1178k = null;
                cVar5.f1181n = 2;
                objC = AbstractC0049v.n(abstractC0045q, dVar, cVar5);
                if (objC != obj4) {
                    nVar5 = nVar;
                    iVar3 = iVar2;
                    hVar3 = hVar2;
                    objC = (a) objC;
                    iVar2 = iVar3;
                    hVar2 = hVar3;
                    nVar = nVar5;
                    obj3 = nVar3.f180a;
                    if (obj3 instanceof Z.m) {
                        mVar2 = (Z.m) obj3;
                    } else {
                        mVar2 = null;
                    }
                    if (mVar2 != null) {
                        f.a(mVar2.f1153a);
                    }
                    cVar5.f1172d = null;
                    cVar5.f1173e = null;
                    cVar5.f1174f = null;
                    cVar5.g = null;
                    cVar5.f1175h = null;
                    cVar5.f1176i = null;
                    cVar5.f1177j = null;
                    cVar5.f1178k = null;
                    cVar5.f1181n = 3;
                    hVar2.getClass();
                    iVar2.f2644f.getClass();
                    if (objC != obj4) {
                        obj4 = (a) objC;
                        Drawable drawable2 = obj4.f1158a;
                        if (drawable2 instanceof BitmapDrawable) {
                        }
                        if (bitmapDrawable != null) {
                            bitmap.prepareToDraw();
                        }
                    }
                }
            } else {
                if (!(eVar instanceof d)) {
                    throw new C0041m();
                }
                objC = new a(((d) obj7).f1132a, ((d) obj7).f1133b, ((d) obj7).f1134c, null);
                obj3 = nVar3.f180a;
                if (obj3 instanceof Z.m) {
                    mVar2 = (Z.m) obj3;
                } else {
                    mVar2 = null;
                }
                if (mVar2 != null) {
                    f.a(mVar2.f1153a);
                }
                cVar5.f1172d = null;
                cVar5.f1173e = null;
                cVar5.f1174f = null;
                cVar5.g = null;
                cVar5.f1175h = null;
                cVar5.f1176i = null;
                cVar5.f1177j = null;
                cVar5.f1178k = null;
                cVar5.f1181n = 3;
                hVar2.getClass();
                iVar2.f2644f.getClass();
                if (objC != obj4) {
                    obj4 = (a) objC;
                    Drawable drawable3 = obj4.f1158a;
                    if (drawable3 instanceof BitmapDrawable) {
                    }
                    if (bitmapDrawable != null) {
                        bitmap.prepareToDraw();
                    }
                }
            }
            return obj4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0086  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:46:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c8 -> B:29:0x00ca). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object c(V.b r20, p010f0.i r21, java.lang.Object r22, p010f0.m r23, V.c r24, p044y0.c r25) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p001a0.h.c(V.b, f0.i, java.lang.Object, f0.m, V.c, y0.c):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    public final Object d(j jVar, p044y0.c cVar) {
        f fVar;
        h hVar;
        j jVar2 = jVar;
        C0005e c0005e = this.f1212d;
        if (cVar instanceof f) {
            fVar = (f) cVar;
            int i2 = fVar.f1201h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                fVar.f1201h = i2 - Integer.MIN_VALUE;
            } else {
                fVar = new f(this, cVar);
            }
        } else {
            fVar = new f(this, cVar);
        }
        f fVar2 = fVar;
        Object objN = fVar2.f1200f;
        a aVar = a.f4189a;
        int i3 = fVar2.f1201h;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j jVar3 = fVar2.f1199e;
            hVar = fVar2.f1198d;
            try {
                j.o(objN);
            } catch (Throwable th) {
                th = th;
                jVar2 = jVar3;
                if (!(th instanceof CancellationException)) {
                    throw th;
                }
                C.h hVar2 = hVar.f1211c;
                return C.h.i(jVar2.f1220d, th);
            }
        }
        j.o(objN);
        try {
            i iVar = jVar2.f1220d;
            Object obj = iVar.f2640b;
            g0.h hVar3 = jVar2.f1221e;
            Bitmap.Config config = f.f3375a;
            c cVar2 = jVar2.f1222f;
            p010f0.m mVarQ = this.f1211c.q(iVar, hVar3);
            g gVar = mVarQ.f2670e;
            List list = this.f1209a.f685h.f656b;
            int size = list.size();
            Object obj2 = obj;
            int i4 = 0;
            while (i4 < size) {
                p034t0.d dVar = (p034t0.d) list.get(i4);
                p005c0.a aVar2 = (p005c0.a) dVar.f4126a;
                List list2 = list;
                if (((Class) dVar.f4127b).isAssignableFrom(obj2.getClass())) {
                    F0.i.c(aVar2, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                    Object objA = aVar2.a(obj2, mVarQ);
                    if (objA != null) {
                        obj2 = objA;
                    }
                }
                i4++;
                list = list2;
            }
            d0.a aVarE = c0005e.E(iVar, obj2, mVarQ, cVar2);
            d0.b bVarD = aVarE != null ? c0005e.D(iVar, aVarE, hVar3, gVar) : null;
            if (bVarD != null) {
                return C0005e.F(jVar2, iVar, aVarE, bVarD);
            }
            AbstractC0045q abstractC0045q = iVar.f2655r;
            g gVar2 = new g(this, iVar, obj2, mVarQ, cVar2, aVarE, jVar, null);
            fVar2.f1198d = this;
            fVar2.f1199e = jVar2;
            fVar2.f1201h = 1;
            objN = AbstractC0049v.n(abstractC0045q, gVar2, fVar2);
            return objN == aVar ? aVar : objN;
        } catch (Throwable th2) {
            th = th2;
            hVar = this;
            if (!(th instanceof CancellationException)) {
                throw th;
            }
            C.h hVar4 = hVar.f1211c;
            return C.h.i(jVar2.f1220d, th);
        }
    }
}
