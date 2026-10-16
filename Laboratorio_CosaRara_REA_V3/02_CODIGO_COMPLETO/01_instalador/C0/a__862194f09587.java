// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p005c0;

import F0.i;
import X0.p;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import f1.l;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import p010f0.m;
import p016j0.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2178a;

    public /* synthetic */ a(int i2) {
        this.f2178a = i2;
    }

    public final Object a(Object obj, m mVar) throws PackageManager.NameNotFoundException {
        String authority;
        switch (this.f2178a) {
            case 0:
                return ByteBuffer.wrap((byte[]) obj);
            case 1:
                Uri uri = (Uri) obj;
                if (f.d(uri)) {
                    return null;
                }
                String scheme = uri.getScheme();
                if (scheme != null && !scheme.equals("file")) {
                    return null;
                }
                String path = uri.getPath();
                if (path == null) {
                    path = "";
                }
                if (path.length() <= 0 || !l.v(path.charAt(0), '/', false) || ((String) p036u0.f.u(uri.getPathSegments())) == null) {
                    return null;
                }
                if (!i.a(uri.getScheme(), "file")) {
                    return new File(uri.toString());
                }
                String path2 = uri.getPath();
                if (path2 != null) {
                    return new File(path2);
                }
                return null;
            case 2:
                return ((p) obj).f1028i;
            case 3:
                Context context = mVar.f2666a;
                int iIntValue = ((Number) obj).intValue();
                try {
                    if (context.getResources().getResourceEntryName(iIntValue) != null) {
                        return Uri.parse("android.resource://" + context.getPackageName() + '/' + iIntValue);
                    }
                } catch (Resources.NotFoundException unused) {
                }
                return null;
            case 4:
                Uri uri2 = (Uri) obj;
                if (!i.a(uri2.getScheme(), "android.resource") || (authority = uri2.getAuthority()) == null || M0.m.N(authority) || uri2.getPathSegments().size() != 2) {
                    return null;
                }
                String authority2 = uri2.getAuthority();
                if (authority2 == null) {
                    authority2 = "";
                }
                Resources resourcesForApplication = mVar.f2666a.getPackageManager().getResourcesForApplication(authority2);
                List<String> pathSegments = uri2.getPathSegments();
                int identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority2);
                if (identifier == 0) {
                    throw new IllegalStateException(("Invalid android.resource URI: " + uri2).toString());
                }
                return Uri.parse("android.resource://" + authority2 + '/' + identifier);
            default:
                return Uri.parse((String) obj);
        }
    }
}
