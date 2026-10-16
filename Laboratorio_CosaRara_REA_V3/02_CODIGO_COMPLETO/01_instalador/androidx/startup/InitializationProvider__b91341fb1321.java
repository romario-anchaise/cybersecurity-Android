// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.startup;

import N0.C0041m;
import R.a;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            throw new C0041m("Context cannot be null");
        }
        if (context.getApplicationContext() == null) {
            return true;
        }
        a aVarC = a.c(context);
        Context context2 = aVarC.f534c;
        try {
            try {
                Trace.beginSection("Startup");
                aVarC.a(context2.getPackageManager().getProviderInfo(new ComponentName(context2.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                Trace.endSection();
                return true;
            } catch (PackageManager.NameNotFoundException e2) {
                throw new C0041m(e2);
            }
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
