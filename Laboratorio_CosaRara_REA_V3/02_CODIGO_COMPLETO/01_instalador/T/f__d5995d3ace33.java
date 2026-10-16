// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import A.C0005e;
import D.b;
import H.s;
import O.g;
import V.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.j0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p015j.V;
import p021m.i;
import p029q.j;
import p041x.d;
import p041x.k;
import s.e;
import s.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0 f4109b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f4108a = new k();
        } else if (i2 >= 28) {
            f4108a = new j();
        } else if (i2 >= 26) {
            f4108a = new i();
        } else {
            Method method = h.f4117c;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                f4108a = new h();
            } else {
                f4108a = new g();
            }
        }
        f4109b = new j0(16);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    public static Typeface a(Context context, e eVar, Resources resources, int i2, String str, int i3, int i4, V v2) {
        Typeface typefaceC;
        Typeface typefaceCreate;
        Typeface typeface;
        int i5 = 5;
        int i6 = 1;
        int i7 = 3;
        int i8 = 0;
        if (eVar instanceof h) {
            h hVar = (h) eVar;
            String str2 = hVar.f4055d;
            typefaceC = null;
            if (str2 == null || str2.isEmpty()) {
                typefaceCreate = null;
            } else {
                typefaceCreate = Typeface.create(str2, 0);
                Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
                if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
                    typefaceCreate = null;
                }
            }
            if (typefaceCreate != null) {
                new Handler(Looper.getMainLooper()).post(new g(v2, i7, typefaceCreate));
                return typefaceCreate;
            }
            boolean z2 = hVar.f4054c == 0;
            int i9 = hVar.f4053b;
            Handler handler = new Handler(Looper.getMainLooper());
            C0005e c0005e = new C0005e(25);
            c0005e.f34b = v2;
            a aVar = hVar.f4052a;
            s sVar = new s(c0005e, 16, handler);
            if (z2) {
                j0 j0Var = p041x.g.f4176a;
                String str3 = ((String) aVar.f654f) + "-" + i4;
                typeface = (Typeface) p041x.g.f4176a.g(str3);
                if (typeface != null) {
                    handler.post(new R0.h(c0005e, i5, typeface));
                    typefaceC = typeface;
                } else if (i9 == -1) {
                    p041x.f fVarA = p041x.g.a(str3, context, aVar, i4);
                    sVar.D(fVarA);
                    typefaceC = fVarA.f4174a;
                } else {
                    try {
                        try {
                            try {
                                p041x.f fVar = (p041x.f) p041x.g.f4177b.submit(new d(str3, context, aVar, i4, 0)).get(i9, TimeUnit.MILLISECONDS);
                                sVar.D(fVar);
                                typefaceC = fVar.f4174a;
                            } catch (InterruptedException e2) {
                                throw e2;
                            }
                        } catch (ExecutionException e3) {
                            throw new RuntimeException(e3);
                        } catch (TimeoutException unused) {
                            throw new InterruptedException("timeout");
                        }
                    } catch (InterruptedException unused2) {
                        ((Handler) sVar.f233c).post(new b((C0005e) sVar.f232b, -3));
                    }
                }
            } else {
                j0 j0Var2 = p041x.g.f4176a;
                String str4 = ((String) aVar.f654f) + "-" + i4;
                typeface = (Typeface) p041x.g.f4176a.g(str4);
                if (typeface != null) {
                    handler.post(new R0.h(c0005e, i5, typeface));
                    typefaceC = typeface;
                } else {
                    p041x.e eVar2 = new p041x.e(i8, sVar);
                    synchronized (p041x.g.f4178c) {
                        try {
                            i iVar = p041x.g.f4179d;
                            ArrayList arrayList = (ArrayList) iVar.get(str4);
                            if (arrayList != null) {
                                arrayList.add(eVar2);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(eVar2);
                                iVar.put(str4, arrayList2);
                                d dVar = new d(str4, context, aVar, i4, 1);
                                ThreadPoolExecutor threadPoolExecutor = p041x.g.f4177b;
                                p041x.e eVar3 = new p041x.e(i6, str4);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                k kVar = new k();
                                kVar.f4186a = dVar;
                                kVar.f4187b = eVar3;
                                kVar.f4188c = handler2;
                                threadPoolExecutor.execute(kVar);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        } else {
            typefaceC = f4108a.c(context, (s.f) eVar, resources, i4);
            if (typefaceC != null) {
                new Handler(Looper.getMainLooper()).post(new g(v2, i7, typefaceC));
            } else {
                v2.a();
            }
        }
        if (typefaceC != null) {
            f4109b.k(b(resources, i2, str, i3, i4), typefaceC);
        }
        return typefaceC;
    }

    public static String b(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + '-' + str + '-' + i3 + '-' + i2 + '-' + i4;
    }
}
