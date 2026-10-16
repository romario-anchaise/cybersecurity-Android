// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import W.q;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import java.nio.ByteBuffer;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p010f0.m f1130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1131c;

    public /* synthetic */ c(Object obj, p010f0.m mVar, int i2) {
        this.f1129a = i2;
        this.f1131c = obj;
        this.f1130b = mVar;
    }

    @Override // Z.g
    public final Object a(p040w0.d dVar) {
        W.g gVar = W.g.f750b;
        p010f0.m mVar = this.f1130b;
        Object obj = this.f1131c;
        switch (this.f1129a) {
            case 0:
                return new d(new BitmapDrawable(mVar.f2666a.getResources(), (Bitmap) obj), false, gVar);
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                try {
                    C0193i c0193i = new C0193i();
                    c0193i.write(byteBuffer);
                    byteBuffer.position(0);
                    Context context = mVar.f2666a;
                    return new m(new q(c0193i, null), null, gVar);
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    throw th;
                }
            default:
                Drawable bitmapDrawable = (Drawable) obj;
                Bitmap.Config config = p016j0.f.f3375a;
                boolean z2 = (bitmapDrawable instanceof VectorDrawable) || (bitmapDrawable instanceof T.a);
                if (z2) {
                    bitmapDrawable = new BitmapDrawable(mVar.f2666a.getResources(), f1.l.q(bitmapDrawable, mVar.f2667b, mVar.f2669d, mVar.f2670e, mVar.f2671f));
                }
                return new d(bitmapDrawable, z2, gVar);
        }
    }
}
