// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p016j0;

import F0.i;
import M0.e;
import M0.m;
import N0.C0041m;
import X0.n;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.d;
import g0.a;
import g0.g;
import java.io.Closeable;
import java.util.ArrayList;
import p010f0.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f3375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f3376b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap.Config unused = Bitmap.Config.RGBA_F16;
        } else {
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        }
        f3375a = i2 >= 26 ? Bitmap.Config.HARDWARE : Bitmap.Config.ARGB_8888;
        f3376b = new n((String[]) new ArrayList(20).toArray(new String[0]));
    }

    public static final void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final String b(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || m.N(str)) {
            return null;
        }
        String strH0 = e.h0(e.h0(str, '#'), '?');
        return mimeTypeMap.getMimeTypeFromExtension(e.g0(e.g0(strH0, '/', strH0), '.', ""));
    }

    public static final u c(ImageView imageView) {
        Object tag = imageView.getTag(R.id.coil_request_manager);
        u uVar = tag instanceof u ? (u) tag : null;
        if (uVar == null) {
            synchronized (imageView) {
                try {
                    Object tag2 = imageView.getTag(R.id.coil_request_manager);
                    u uVar2 = tag2 instanceof u ? (u) tag2 : null;
                    if (uVar2 != null) {
                        uVar = uVar2;
                    } else {
                        uVar = new u();
                        imageView.addOnAttachStateChangeListener(uVar);
                        imageView.setTag(R.id.coil_request_manager, uVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return uVar;
    }

    public static final boolean d(Uri uri) {
        return i.a(uri.getScheme(), "file") && i.a((String) p036u0.f.u(uri.getPathSegments()), "android_asset");
    }

    public static final int e(d dVar, g gVar) {
        if (dVar instanceof a) {
            return ((a) dVar).f2738m;
        }
        int iOrdinal = gVar.ordinal();
        if (iOrdinal == 0) {
            return Integer.MIN_VALUE;
        }
        if (iOrdinal == 1) {
            return Integer.MAX_VALUE;
        }
        throw new C0041m();
    }
}
