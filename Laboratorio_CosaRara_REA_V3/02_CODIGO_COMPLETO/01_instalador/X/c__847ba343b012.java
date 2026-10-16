// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import V.a;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import b1.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import s.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4166a = new a();

    public static p a(Context context, a aVar) {
        Cursor cursorA;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = (String) aVar.f650b;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
        }
        String str2 = providerInfoResolveContentProvider.packageName;
        String str3 = (String) aVar.f651c;
        if (!str2.equals(str3)) {
            throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str3);
        }
        Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        a aVar2 = f4166a;
        Collections.sort(arrayList, aVar2);
        List listD = (List) aVar.f653e;
        if (listD == null) {
            listD = b.d(resources, 0);
        }
        int i2 = 0;
        loop1: while (true) {
            cursorA = null;
            if (i2 >= listD.size()) {
                providerInfoResolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList((Collection) listD.get(i2));
            Collections.sort(arrayList2, aVar2);
            if (arrayList.size() == arrayList2.size()) {
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        break loop1;
                    }
                    if (!Arrays.equals((byte[]) arrayList.get(i3), (byte[]) arrayList2.get(i3))) {
                        break;
                    }
                    i3++;
                }
            }
            i2++;
        }
        if (providerInfoResolveContentProvider == null) {
            return new p(1, null);
        }
        String str4 = providerInfoResolveContentProvider.authority;
        ArrayList arrayList3 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str4).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str4).appendPath("file").build();
        try {
            cursorA = b.a(context.getContentResolver(), uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{(String) aVar.f652d}, null, null);
            if (cursorA != null && cursorA.getCount() > 0) {
                int columnIndex = cursorA.getColumnIndex("result_code");
                arrayList3 = new ArrayList();
                int columnIndex2 = cursorA.getColumnIndex("_id");
                int columnIndex3 = cursorA.getColumnIndex("file_id");
                int columnIndex4 = cursorA.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorA.getColumnIndex("font_weight");
                int columnIndex6 = cursorA.getColumnIndex("font_italic");
                while (cursorA.moveToNext()) {
                    arrayList3.add(new h(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorA.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorA.getLong(columnIndex3)), columnIndex4 != -1 ? cursorA.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorA.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorA.getInt(columnIndex6) == 1, columnIndex != -1 ? cursorA.getInt(columnIndex) : 0));
                }
            }
            return new p(0, (h[]) arrayList3.toArray(new h[0]));
        } finally {
            if (cursorA != null) {
                cursorA.close();
            }
        }
    }
}
