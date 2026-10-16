// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p003b0;

import F0.i;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import p010f0.m;
import p016j0.f;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    @Override // p003b0.b
    public final String a(Object obj, m mVar) {
        Uri uri = (Uri) obj;
        if (!i.a(uri.getScheme(), "android.resource")) {
            return uri.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append('-');
        Configuration configuration = mVar.f2666a.getResources().getConfiguration();
        Bitmap.Config config = f.f3375a;
        sb.append(configuration.uiMode & 48);
        return sb.toString();
    }
}
