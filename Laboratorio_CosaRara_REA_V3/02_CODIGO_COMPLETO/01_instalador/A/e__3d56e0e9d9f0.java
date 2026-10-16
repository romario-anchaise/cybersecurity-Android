// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import H.ThreadFactoryC0026a;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k1.InterfaceC0195k;
import m1.InterfaceC0209m;
import p013i.C0133g;
import p013i.RunnableC0132f;
import p015j.C0154k;
import p015j.InterfaceC0139c0;
import p015j.InterfaceC0160n;
import p015j.J0;
import p015j.k1;
import p015j.o1;

/* JADX INFO: renamed from: A.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0005e implements InterfaceC0006f, InterfaceC0008h, H.k, O.e, d0.g, J0, p013i.z, p013i.l, InterfaceC0139c0, p022m0.o, InterfaceC0209m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f33a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f34b;

    public /* synthetic */ C0005e(int i2, Object obj) {
        this.f33a = i2;
        this.f34b = obj;
    }

    public static p010f0.q F(p001a0.j jVar, p010f0.i iVar, d0.a aVar, d0.b bVar) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(iVar.f2639a.getResources(), bVar.f2198a);
        W.g gVar = W.g.f749a;
        Map map = bVar.f2199b;
        Object obj = map.get("coil#disk_cache_key");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("coil#is_sampled");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Bitmap.Config config = p016j0.f.f3375a;
        return new p010f0.q(bitmapDrawable, iVar, gVar, aVar, str, zBooleanValue, jVar != null && jVar.g);
    }

    public void A(String str, String str2) {
        F0.i.e(str, "name");
        F0.i.e(str2, "value");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(Y0.b.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), str).toString());
            }
        }
        z(str, str2);
    }

    public X0.n B() {
        return new X0.n((String[]) ((ArrayList) this.f34b).toArray(new String[0]));
    }

    public X.i C() {
        X.d dVarJ;
        X.b bVar = (X.b) this.f34b;
        X.g gVar = bVar.f853d;
        synchronized (gVar) {
            bVar.a(true);
            dVarJ = gVar.j(bVar.f850a.f854a);
        }
        if (dVarJ != null) {
            return new X.i(dVarJ);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    /* JADX WARN: Code duplicated, block: B:88:0x0137  */
    public d0.b D(p010f0.i iVar, d0.a aVar, g0.h hVar, g0.g gVar) {
        d0.b bVarI;
        boolean zEquals;
        d0.b bVar;
        if (!iVar.f2651n.f2602a) {
            return null;
        }
        d0.c cVarC = ((V.k) this.f34b).c();
        if (cVarC != null) {
            bVarI = cVarC.f2200a.i(aVar);
            if (bVarI == null) {
                b1.p pVar = cVarC.f2201b;
                synchronized (pVar) {
                    try {
                        ArrayList arrayList = (ArrayList) ((LinkedHashMap) pVar.f2171b).get(aVar);
                        bVar = null;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                d0.f fVar = (d0.f) arrayList.get(i2);
                                Bitmap bitmap = (Bitmap) fVar.f2207b.get();
                                d0.b bVar2 = bitmap != null ? new d0.b(bitmap, fVar.f2208c) : null;
                                if (bVar2 != null) {
                                    bVar = bVar2;
                                    break;
                                }
                            }
                            int i3 = pVar.f2170a;
                            pVar.f2170a = i3 + 1;
                            if (i3 >= 10) {
                                pVar.b();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                bVarI = bVar;
            }
        } else {
            bVarI = null;
        }
        if (bVarI != null) {
            Bitmap bitmap2 = bVarI.f2198a;
            Bitmap.Config config = bitmap2.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            if (C.h.o(iVar, config)) {
                Object obj = bVarI.f2199b.get("coil#is_sampled");
                Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                if (!F0.i.a(hVar, g0.h.f2748c)) {
                    String str = (String) aVar.f2197b.get("coil#transformation_size");
                    if (str != null) {
                        zEquals = str.equals(hVar.toString());
                    } else {
                        int width = bitmap2.getWidth();
                        int height = bitmap2.getHeight();
                        f1.d dVar = hVar.f2749a;
                        int i4 = dVar instanceof g0.a ? ((g0.a) dVar).f2738m : Integer.MAX_VALUE;
                        f1.d dVar2 = hVar.f2750b;
                        int i5 = dVar2 instanceof g0.a ? ((g0.a) dVar2).f2738m : Integer.MAX_VALUE;
                        double dJ = f1.d.j(width, height, i4, i5, gVar);
                        boolean zA = p016j0.d.a(iVar);
                        if (zA) {
                            double d2 = dJ > 1.0d ? 1.0d : dJ;
                            if (Math.abs(((double) i4) - (((double) width) * d2)) > 1.0d && Math.abs(((double) i5) - (d2 * ((double) height))) > 1.0d) {
                                if ((dJ == 1.0d && !zA) || (dJ > 1.0d && zBooleanValue)) {
                                    zEquals = false;
                                }
                            }
                        } else if ((i4 != Integer.MIN_VALUE && i4 != Integer.MAX_VALUE && Math.abs(i4 - width) > 1) || (i5 != Integer.MIN_VALUE && i5 != Integer.MAX_VALUE && Math.abs(i5 - height) > 1)) {
                            if (dJ == 1.0d) {
                                zEquals = false;
                            } else {
                                zEquals = false;
                            }
                        }
                        zEquals = true;
                    }
                } else if (zBooleanValue) {
                    zEquals = false;
                } else {
                    zEquals = true;
                }
            } else {
                zEquals = false;
            }
            if (zEquals) {
                return bVarI;
            }
        }
        return null;
    }

    public d0.a E(p010f0.i iVar, Object obj, p010f0.m mVar, V.c cVar) {
        String strA;
        Map linkedHashMap;
        iVar.getClass();
        List list = ((V.k) this.f34b).f685h.f657c;
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                strA = null;
                break;
            }
            p034t0.d dVar = (p034t0.d) list.get(i2);
            p003b0.b bVar = (p003b0.b) dVar.f4126a;
            if (((Class) dVar.f4127b).isAssignableFrom(obj.getClass())) {
                F0.i.c(bVar, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                strA = bVar.a(obj, mVar);
                if (strA != null) {
                    break;
                }
            }
            i2++;
        }
        if (strA == null) {
            return null;
        }
        Map map = iVar.f2661x.f2682a;
        boolean zIsEmpty = map.isEmpty();
        p036u0.o oVar = p036u0.o.f4147a;
        if (zIsEmpty) {
            linkedHashMap = oVar;
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = map.entrySet().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getValue().getClass();
                throw new ClassCastException();
            }
        }
        iVar.f2644f.getClass();
        return linkedHashMap.isEmpty() ? new d0.a(strA, oVar) : new d0.a(strA, p036u0.q.s(linkedHashMap));
    }

    public void G(String str) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) this.f34b;
            if (i2 >= arrayList.size()) {
                return;
            }
            if (str.equalsIgnoreCase((String) arrayList.get(i2))) {
                arrayList.remove(i2);
                arrayList.remove(i2);
                i2 -= 2;
            }
            i2 += 2;
        }
    }

    @Override // p013i.z
    public void a(p013i.n nVar, boolean z2) {
        if (nVar instanceof p013i.G) {
            ((p013i.G) nVar).f2863z.k().c(false);
        }
        p013i.z zVar = ((C0154k) this.f34b).f3210e;
        if (zVar != null) {
            zVar.a(nVar, z2);
        }
    }

    @Override // A.InterfaceC0006f
    public void b(Bundle bundle) {
        ((ContentInfo.Builder) this.f34b).setExtras(bundle);
    }

    @Override // A.InterfaceC0006f
    public void d(Uri uri) {
        ((ContentInfo.Builder) this.f34b).setLinkUri(uri);
    }

    @Override // A.InterfaceC0008h
    public int e() {
        return ((ContentInfo) this.f34b).getSource();
    }

    @Override // p013i.l
    public void f(p013i.n nVar) {
        p013i.l lVar = ((ActionMenuView) this.f34b).f1358v;
        if (lVar != null) {
            lVar.f(nVar);
        }
    }

    @Override // A.InterfaceC0008h
    public ClipData g() {
        return ((ContentInfo) this.f34b).getClip();
    }

    @Override // p015j.J0
    public void h(p013i.n nVar, p013i.p pVar) {
        p013i.h hVar = (p013i.h) this.f34b;
        hVar.f2896f.removeCallbacksAndMessages(null);
        ArrayList arrayList = hVar.f2897h;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (nVar == ((C0133g) arrayList.get(i2)).f2890b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1) {
            return;
        }
        int i3 = i2 + 1;
        hVar.f2896f.postAtTime(new RunnableC0132f(this, i3 < arrayList.size() ? (C0133g) arrayList.get(i3) : null, pVar, nVar), nVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // d0.g
    public d0.b i(d0.a aVar) {
        return null;
    }

    @Override // p013i.z
    public boolean j(p013i.n nVar) {
        C0154k c0154k = (C0154k) this.f34b;
        if (nVar == c0154k.f3208c) {
            return false;
        }
        ((p013i.G) nVar).f2862A.getClass();
        c0154k.getClass();
        p013i.z zVar = c0154k.f3210e;
        if (zVar != null) {
            return zVar.j(nVar);
        }
        return false;
    }

    @Override // A.InterfaceC0006f
    public C0009i k() {
        return new C0009i(new C0005e(((ContentInfo.Builder) this.f34b).build()));
    }

    @Override // O.e
    public void l(int i2, Serializable serializable) {
        String str;
        switch (i2) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i2 == 6 || i2 == 7 || i2 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f34b).setResultCode(i2);
    }

    @Override // p013i.l
    public boolean m(p013i.n nVar, MenuItem menuItem) {
        InterfaceC0160n interfaceC0160n = ((ActionMenuView) this.f34b).f1351A;
        if (interfaceC0160n == null) {
            return false;
        }
        Toolbar toolbar = ((k1) interfaceC0160n).f3228a;
        Iterator it = toolbar.f1423G.f65b.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        o1 o1Var = toolbar.f1425I;
        return o1Var != null ? ((p009f.I) o1Var).f2414a.f2418b.f2517a.onMenuItemSelected(0, menuItem) : false;
    }

    @Override // p015j.J0
    public void n(p013i.n nVar, p013i.p pVar) {
        ((p013i.h) this.f34b).f2896f.removeCallbacksAndMessages(nVar);
    }

    @Override // p022m0.o
    public Object o() {
        Constructor constructor = (Constructor) this.f34b;
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e2) {
            p028p0.a aVar = p028p0.d.f4001a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Failed to invoke constructor '" + p028p0.d.b(constructor) + "' with no args", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Failed to invoke constructor '" + p028p0.d.b(constructor) + "' with no args", e4.getCause());
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0044  */
    @Override // m1.InterfaceC0209m
    public Object p(Object obj) {
        Charset charsetForName;
        String str;
        switch (this.f33a) {
            case 23:
                return Optional.ofNullable(((InterfaceC0209m) this.f34b).p((X0.G) obj));
            default:
                X0.G g = (X0.G) obj;
                X0.E e2 = g.f925a;
                if (e2 == null) {
                    InterfaceC0195k interfaceC0195kJ = g.j();
                    X0.s sVarF = g.f();
                    if (sVarF != null) {
                        charsetForName = M0.a.f360a;
                        String[] strArr = sVarF.f1034c;
                        int i2 = 0;
                        int iK = p029q.j.k(0, strArr.length - 1, 2);
                        if (iK >= 0) {
                            while (true) {
                                if (M0.m.M(strArr[i2], "charset")) {
                                    str = strArr[i2 + 1];
                                } else if (i2 != iK) {
                                    i2 += 2;
                                } else {
                                    str = null;
                                }
                            }
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            try {
                                charsetForName = Charset.forName(str);
                                break;
                            } catch (IllegalArgumentException unused) {
                            }
                        }
                        if (charsetForName == null) {
                            charsetForName = M0.a.f360a;
                        }
                    } else {
                        charsetForName = M0.a.f360a;
                    }
                    e2 = new X0.E(interfaceC0195kJ, charsetForName);
                    g.f925a = e2;
                }
                s0.a aVar = new s0.a(e2);
                aVar.f4087o = 2;
                try {
                    Object objA = ((p018k0.y) this.f34b).a(aVar);
                    if (aVar.J() != 10) {
                        throw new p018k0.p("JSON document was not fully consumed.");
                    }
                    g.close();
                    return objA;
                } catch (Throwable th) {
                    g.close();
                    throw th;
                }
        }
    }

    @Override // A.InterfaceC0008h
    public int q() {
        return ((ContentInfo) this.f34b).getFlags();
    }

    @Override // O.e
    public void r() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // d0.g
    public void s(d0.a aVar, Bitmap bitmap, Map map) {
        ((b1.p) this.f34b).f(aVar, bitmap, map, f1.l.x(bitmap));
    }

    @Override // A.InterfaceC0008h
    public ContentInfo t() {
        return (ContentInfo) this.f34b;
    }

    public String toString() {
        switch (this.f33a) {
            case 1:
                return "ContentInfoCompat{" + ((ContentInfo) this.f34b) + "}";
            default:
                return super.toString();
        }
    }

    @Override // H.k
    public void v(f1.l lVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0026a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new H.n(this, lVar, threadPoolExecutor, 0));
    }

    @Override // A.InterfaceC0006f
    public void x(int i2) {
        ((ContentInfo.Builder) this.f34b).setFlags(i2);
    }

    public void y(String str, String str2) {
        F0.i.e(str, "name");
        F0.i.e(str2, "value");
        f1.l.j(str);
        f1.l.l(str2, str);
        z(str, str2);
    }

    public void z(String str, String str2) {
        F0.i.e(str, "name");
        F0.i.e(str2, "value");
        ArrayList arrayList = (ArrayList) this.f34b;
        arrayList.add(str);
        arrayList.add(M0.e.j0(str2).toString());
    }

    public C0005e(V.k kVar, C.h hVar) {
        this.f33a = 15;
        this.f34b = kVar;
    }

    public C0005e(p018k0.m mVar, p018k0.y yVar) {
        this.f33a = 24;
        this.f34b = yVar;
    }

    public C0005e(int i2) {
        this.f33a = i2;
        switch (i2) {
            case 10:
                this.f34b = new ArrayList(20);
                break;
            case 13:
                this.f34b = new LinkedHashSet();
                break;
            case 25:
                break;
            default:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                F0.i.e(timeUnit, "timeUnit");
                this.f34b = new b1.n(a1.d.f1235h, timeUnit);
                break;
        }
    }

    public C0005e(TextView textView) {
        this.f33a = 6;
        this.f34b = new J.g(textView);
    }

    public C0005e(EditText editText) {
        this.f33a = 5;
        this.f34b = new H.s(editText);
    }

    public C0005e(Context context) {
        this.f33a = 4;
        this.f34b = context.getApplicationContext();
    }

    public C0005e(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f33a = 3;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f34b = new C.g(uri, clipDescription, uri2);
        } else {
            this.f34b = new C.h(uri, clipDescription, uri2);
        }
    }

    public C0005e(Y0.a aVar) {
        this.f33a = 11;
        this.f34b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), aVar);
    }

    public C0005e(ContentInfo contentInfo) {
        this.f33a = 1;
        contentInfo.getClass();
        this.f34b = AbstractC0004d.e(contentInfo);
    }

    public C0005e(ClipData clipData, int i2) {
        this.f33a = 0;
        this.f34b = AbstractC0004d.c(clipData, i2);
    }

    @Override // p015j.InterfaceC0139c0
    public void c(int i2) {
    }

    @Override // d0.g
    public void u(int i2) {
    }

    @Override // p015j.InterfaceC0139c0
    public void w(int i2) {
    }
}
