// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.File;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1125a;

    public /* synthetic */ a(int i2) {
        this.f1125a = i2;
    }

    @Override // Z.f
    public final g a(Object obj, p010f0.m mVar) {
        switch (this.f1125a) {
            case 0:
                Uri uri = (Uri) obj;
                if (p016j0.f.d(uri)) {
                    return new b(uri, mVar, 0);
                }
                return null;
            case 1:
                return new c((Bitmap) obj, mVar, 0);
            case 2:
                return new c((ByteBuffer) obj, mVar, 1);
            case 3:
                Uri uri2 = (Uri) obj;
                if (F0.i.a(uri2.getScheme(), "content")) {
                    return new b(uri2, mVar, 1);
                }
                return null;
            case 4:
                return new c((Drawable) obj, mVar, 2);
            case 5:
                return new h((File) obj);
            default:
                Uri uri3 = (Uri) obj;
                if (F0.i.a(uri3.getScheme(), "android.resource")) {
                    return new b(uri3, mVar, 2);
                }
                return null;
        }
    }
}
