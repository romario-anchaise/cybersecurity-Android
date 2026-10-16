// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import p011h.b;
import p021m.a;
import p021m.f;
import p039w.g;

/* JADX INFO: renamed from: f.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0125o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f2503a = new F(new G());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2504b = -100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static g f2505c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static g f2506d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f2507e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f2508f = false;
    public static final f g = new f();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f2509h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f2510i = new Object();

    public static boolean c(Context context) {
        if (f2507e == null) {
            try {
                int i2 = E.f2409a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) E.class), D.a() | 128).metaData;
                if (bundle != null) {
                    f2507e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f2507e = Boolean.FALSE;
            }
        }
        return f2507e.booleanValue();
    }

    public static void g(z zVar) {
        synchronized (f2509h) {
            try {
                f fVar = g;
                fVar.getClass();
                a aVar = new a(fVar);
                while (aVar.hasNext()) {
                    AbstractC0125o abstractC0125o = (AbstractC0125o) ((WeakReference) aVar.next()).get();
                    if (abstractC0125o == zVar || abstractC0125o == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void d();

    public abstract void e();

    public abstract boolean h(int i2);

    public abstract void i(int i2);

    public abstract void j(View view);

    public abstract void k(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void l(CharSequence charSequence);

    public abstract b n(p011h.a aVar);
}
