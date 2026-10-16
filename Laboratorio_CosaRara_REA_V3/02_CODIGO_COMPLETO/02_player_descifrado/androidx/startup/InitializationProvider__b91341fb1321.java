// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import androidx.work.WorkManagerInitializer;
import com.os9sp.yfwkcq0dwfxaf.R;
import h1.a;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class InitializationProvider extends ContentProvider {
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
            throw new a("Context cannot be null");
        }
        if (m.a.f2673d == null) {
            synchronized (m.a.f2674e) {
                try {
                    if (m.a.f2673d == null) {
                        m.a.f2673d = new m.a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        m.a aVar = m.a.f2673d;
        Context context2 = aVar.f2677c;
        try {
            try {
                Trace.beginSection("Startup");
                Bundle bundle = context2.getPackageManager().getProviderInfo(new ComponentName(context2.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                String string = context2.getString(R.string.androidx_startup);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (WorkManagerInitializer.class.isAssignableFrom(cls)) {
                                aVar.f2676b.add(cls);
                                aVar.a(cls, hashSet);
                            } else {
                                continue;
                            }
                        }
                    }
                }
                Trace.endSection();
                return true;
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e3) {
            throw new a(e3);
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
