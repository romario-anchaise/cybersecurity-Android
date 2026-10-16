// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import W.p;
import W.q;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.xmlpull.v1.XmlPullParserException;
import p036u0.n;

/* JADX INFO: loaded from: classes.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f1127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p010f0.m f1128c;

    public /* synthetic */ b(Uri uri, p010f0.m mVar, int i2) {
        this.f1126a = i2;
        this.f1127b = uri;
        this.f1128c = mVar;
    }

    /* JADX WARN: Code duplicated, block: B:92:0x0207  */
    @Override // Z.g
    public final Object a(p040w0.d dVar) throws XmlPullParserException, IOException {
        Collection collection;
        Collection collectionM;
        InputStream inputStreamOpenInputStream;
        List<String> pathSegments;
        int size;
        Bundle bundle;
        Integer numJ;
        Drawable drawableA;
        W.g gVar = W.g.f751c;
        p010f0.m mVar = this.f1128c;
        Uri uri = this.f1127b;
        boolean z2 = true;
        switch (this.f1126a) {
            case 0:
                List<String> pathSegments2 = uri.getPathSegments();
                F0.i.e(pathSegments2, "<this>");
                int size2 = pathSegments2.size() - 1;
                if (size2 > 0) {
                    if (size2 == 1) {
                        collectionM = p029q.j.m(p036u0.f.x(pathSegments2));
                    } else {
                        ArrayList arrayList = new ArrayList(size2);
                        if (pathSegments2 instanceof RandomAccess) {
                            int size3 = pathSegments2.size();
                            for (int i2 = 1; i2 < size3; i2++) {
                                arrayList.add(pathSegments2.get(i2));
                            }
                        } else {
                            ListIterator<String> listIterator = pathSegments2.listIterator(1);
                            while (listIterator.hasNext()) {
                                arrayList.add(listIterator.next());
                            }
                        }
                        collection = arrayList;
                    }
                    String strW = p036u0.f.w(collection, "/", null, null, null, 62);
                    return new m(new q(f1.l.f(f1.l.W(mVar.f2666a.getAssets().open(strW))), new W.a()), p016j0.f.b(MimeTypeMap.getSingleton(), strW), gVar);
                }
                collectionM = n.f4146a;
                collection = collectionM;
                String strW2 = p036u0.f.w(collection, "/", null, null, null, 62);
                return new m(new q(f1.l.f(f1.l.W(mVar.f2666a.getAssets().open(strW2))), new W.a()), p016j0.f.b(MimeTypeMap.getSingleton(), strW2), gVar);
            case 1:
                ContentResolver contentResolver = mVar.f2666a.getContentResolver();
                if (F0.i.a(uri.getAuthority(), "com.android.contacts") && F0.i.a(uri.getLastPathSegment(), "display_photo")) {
                    AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                    inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to find a contact photo associated with '" + uri + "'.").toString());
                    }
                } else if (Build.VERSION.SDK_INT >= 29 && F0.i.a(uri.getAuthority(), "media") && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && F0.i.a(pathSegments.get(size - 3), "audio") && F0.i.a(pathSegments.get(size - 2), "albums")) {
                    g0.h hVar = mVar.f2669d;
                    f1.d dVar2 = hVar.f2749a;
                    g0.a aVar = dVar2 instanceof g0.a ? (g0.a) dVar2 : null;
                    if (aVar != null) {
                        f1.d dVar3 = hVar.f2750b;
                        g0.a aVar2 = dVar3 instanceof g0.a ? (g0.a) dVar3 : null;
                        if (aVar2 != null) {
                            bundle = new Bundle(1);
                            bundle.putParcelable("android.content.extra.SIZE", new Point(aVar.f2738m, aVar2.f2738m));
                        } else {
                            bundle = null;
                        }
                    } else {
                        bundle = null;
                    }
                    AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(uri, "image/*", bundle, null);
                    inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + uri + "'.").toString());
                    }
                } else {
                    inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to open '" + uri + "'.").toString());
                    }
                }
                return new m(new q(f1.l.f(f1.l.W(inputStreamOpenInputStream)), new W.a()), contentResolver.getType(uri), gVar);
            default:
                String authority = uri.getAuthority();
                if (authority != null) {
                    if (M0.m.N(authority)) {
                        authority = null;
                    }
                    if (authority != null) {
                        List<String> pathSegments3 = uri.getPathSegments();
                        F0.i.e(pathSegments3, "<this>");
                        String str = pathSegments3.isEmpty() ? null : pathSegments3.get(pathSegments3.size() - 1);
                        if (str == null || (numJ = M0.l.J(str)) == null) {
                            throw new IllegalStateException("Invalid android.resource URI: " + uri);
                        }
                        int iIntValue = numJ.intValue();
                        Context context = mVar.f2666a;
                        Resources resources = authority.equals(context.getPackageName()) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
                        TypedValue typedValue = new TypedValue();
                        resources.getValue(iIntValue, typedValue, true);
                        CharSequence charSequence = typedValue.string;
                        String strB = p016j0.f.b(MimeTypeMap.getSingleton(), charSequence.subSequence(M0.e.a0(charSequence, '/', 0, 6), charSequence.length()).toString());
                        if (!F0.i.a(strB, "text/xml")) {
                            TypedValue typedValue2 = new TypedValue();
                            return new m(new q(f1.l.f(f1.l.W(resources.openRawResource(iIntValue, typedValue2))), new p(typedValue2.density)), strB, gVar);
                        }
                        if (authority.equals(context.getPackageName())) {
                            drawableA = f1.l.A(context, iIntValue);
                            if (drawableA == null) {
                                throw new IllegalStateException(F0.h.b(iIntValue, "Invalid resource ID: ").toString());
                            }
                        } else {
                            XmlResourceParser xml = resources.getXml(iIntValue);
                            int next = xml.next();
                            while (next != 2 && next != 1) {
                                next = xml.next();
                            }
                            if (next != 2) {
                                throw new XmlPullParserException("No start tag found.");
                            }
                            Resources.Theme theme = context.getTheme();
                            ThreadLocal threadLocal = s.n.f4061a;
                            drawableA = s.i.a(resources, iIntValue, theme);
                            if (drawableA == null) {
                                throw new IllegalStateException(F0.h.b(iIntValue, "Invalid resource ID: ").toString());
                            }
                        }
                        if (!(drawableA instanceof VectorDrawable) && !(drawableA instanceof T.a)) {
                            z2 = false;
                        }
                        if (z2) {
                            drawableA = new BitmapDrawable(context.getResources(), f1.l.q(drawableA, mVar.f2667b, mVar.f2669d, mVar.f2670e, mVar.f2671f));
                        }
                        return new d(drawableA, z2, gVar);
                    }
                }
                throw new IllegalStateException("Invalid android.resource URI: " + uri);
        }
    }
}
