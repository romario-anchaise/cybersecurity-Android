// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import F0.i;
import H.x;
import V.k;
import X0.D;
import X0.G;
import X0.o;
import X0.p;
import X0.q;
import X0.v;
import X0.w;
import X0.y;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import m1.C0198b;
import m1.C0199c;
import m1.ExecutorC0197a;
import m1.J;
import m1.P;
import p016j0.j;
import p018k0.m;
import p034t0.g;
import p036u0.n;

/* JADX INFO: loaded from: classes.dex */
public final class WallpaperClient {
    private static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 13; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36";
    private static volatile WallpaperClient instance;
    private final BingWallpaperApi api;
    private final V.f imageLoader;
    private final w okHttp;

    private WallpaperClient(Context context) {
        v vVar = new v();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        i.e(timeUnit, "unit");
        vVar.f1061r = Y0.b.b(15L, timeUnit);
        vVar.f1062s = Y0.b.b(20L, timeUnit);
        vVar.f1047c.add(new c());
        w wVar = new w(vVar);
        this.okHttp = wVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str = WallpaperMapper.BING_HOST + "/";
        Objects.requireNonNull(str, "baseUrl == null");
        o oVar = new o();
        oVar.c(null, str);
        p pVarA = oVar.a();
        ArrayList arrayList3 = pVarA.f1026f;
        if (!"".equals(arrayList3.get(arrayList3.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + pVarA);
        }
        arrayList.add(new n1.a(new m()));
        ExecutorC0197a executorC0197a = J.f3768a;
        C0198b c0198b = J.f3770c;
        ArrayList arrayList4 = new ArrayList(arrayList2);
        List listA = c0198b.a(executorC0197a);
        arrayList4.addAll(listA);
        List listB = c0198b.b();
        ArrayList arrayList5 = new ArrayList(arrayList.size() + 1 + listB.size());
        arrayList5.add(new C0199c(0));
        arrayList5.addAll(arrayList);
        arrayList5.addAll(listB);
        List listUnmodifiableList = Collections.unmodifiableList(arrayList5);
        List listUnmodifiableList2 = Collections.unmodifiableList(arrayList4);
        listA.size();
        V.a aVar = new V.a(wVar, pVarA, listUnmodifiableList, listUnmodifiableList2);
        if (!BingWallpaperApi.class.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(BingWallpaperApi.class);
        while (!arrayDeque.isEmpty()) {
            Class cls = (Class) arrayDeque.removeFirst();
            if (cls.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls.getName());
                if (cls != BingWallpaperApi.class) {
                    sb.append(" which is an interface of ");
                    sb.append(BingWallpaperApi.class.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls.getInterfaces());
        }
        this.api = (BingWallpaperApi) Proxy.newProxyInstance(BingWallpaperApi.class.getClassLoader(), new Class[]{BingWallpaperApi.class}, new P(aVar));
        x xVar = new x(context);
        xVar.f248c = new M0.d(this.okHttp);
        p014i0.a aVar2 = new p014i0.a(100);
        p010f0.c cVar = (p010f0.c) xVar.f247b;
        p010f0.c cVar2 = new p010f0.c(cVar.f2604a, cVar.f2605b, cVar.f2606c, cVar.f2607d, aVar2, cVar.f2609f, cVar.g, cVar.f2610h, cVar.f2611i, cVar.f2612j, cVar.f2613k, cVar.f2614l, cVar.f2615m, cVar.f2616n, cVar.f2617o);
        xVar.f247b = cVar2;
        g gVar = new g(new V.d(xVar, 0));
        g gVar2 = new g(new V.d(xVar, 1));
        M0.d dVar = (M0.d) xVar.f248c;
        p034t0.b gVar3 = dVar == null ? new g(V.e.f663b) : dVar;
        n nVar = n.f4146a;
        this.imageLoader = new k((Context) xVar.f246a, cVar2, gVar, gVar2, gVar3, new V.b(nVar, nVar, nVar, nVar, nVar), (j) xVar.f249d);
    }

    public static WallpaperClient get(Context context) {
        WallpaperClient wallpaperClient = instance;
        if (wallpaperClient == null) {
            synchronized (WallpaperClient.class) {
                try {
                    wallpaperClient = instance;
                    if (wallpaperClient == null) {
                        wallpaperClient = new WallpaperClient(context.getApplicationContext());
                        instance = wallpaperClient;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return wallpaperClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static D lambda$new$0(q qVar) throws IOException {
        c1.f fVar = (c1.f) qVar;
        V.a aVarF = fVar.f2188e.f();
        aVarF.f("User-Agent", USER_AGENT);
        aVarF.f("Accept", "application/json,image/*,*/*");
        return fVar.b(aVarF.c());
    }

    public BingWallpaperApi api() {
        return this.api;
    }

    public Bitmap downloadBitmap(String str) throws IOException {
        G g;
        V.a aVar = new V.a();
        aVar.l(str);
        y yVarC = aVar.c();
        w wVar = this.okHttp;
        wVar.getClass();
        D dG = new b1.j(wVar, yVarC).g();
        try {
            if (!dG.f() || (g = dG.g) == null) {
                throw new IOException("HTTP " + dG.f907d);
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(g.j().s());
            if (bitmapDecodeStream == null) {
                throw new IOException("decode failed");
            }
            dG.close();
            return bitmapDecodeStream;
        } catch (Throwable th) {
            try {
                dG.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public V.f imageLoader() {
        return this.imageLoader;
    }
}
