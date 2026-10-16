// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import e2.n1;
import g.j;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f2379j = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n1 f2381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f2382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l.a f2385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2386i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String str, final n1 n1Var, final j jVar, boolean z2) {
        String string;
        super(context, str, null, jVar.f1413b, new DatabaseErrorHandler() { // from class: k.d
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                jVar.getClass();
                int i3 = f.f2379j;
                sQLiteDatabase.getClass();
                n1 n1Var2 = n1Var;
                c cVar = (c) n1Var2.f905c;
                if (cVar == null || !cVar.f2373c.equals(sQLiteDatabase)) {
                    cVar = new c(sQLiteDatabase);
                    n1Var2.f905c = cVar;
                }
                SQLiteDatabase sQLiteDatabase2 = cVar.f2373c;
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + cVar + ".path");
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        j.c(path);
                        return;
                    }
                    return;
                }
                List list = null;
                try {
                    try {
                        list = cVar.f2374d;
                    } catch (SQLiteException unused) {
                    }
                    try {
                        cVar.close();
                    } catch (IOException unused2) {
                    }
                    if (list != null) {
                        return;
                    }
                } finally {
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            Object obj = ((Pair) it.next()).second;
                            obj.getClass();
                            j.c((String) obj);
                        }
                    } else {
                        String path2 = sQLiteDatabase2.getPath();
                        if (path2 != null) {
                            j.c(path2);
                        }
                    }
                }
            }
        });
        jVar.getClass();
        this.f2380c = context;
        this.f2381d = n1Var;
        this.f2382e = jVar;
        this.f2383f = z2;
        if (str == null) {
            string = UUID.randomUUID().toString();
            string.getClass();
        } else {
            string = str;
        }
        File cacheDir = context.getCacheDir();
        cacheDir.getClass();
        this.f2385h = new l.a(cacheDir, string, false);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        l.a aVar = this.f2385h;
        try {
            aVar.a(aVar.f2403a);
            super.close();
            this.f2381d.f905c = null;
            this.f2386i = false;
        } finally {
            aVar.b();
        }
    }

    public final c d(boolean z2) {
        l.a aVar = this.f2385h;
        try {
            aVar.a((this.f2386i || getDatabaseName() == null) ? false : true);
            this.f2384g = false;
            SQLiteDatabase sQLiteDatabaseY = y(z2);
            if (!this.f2384g) {
                return w(sQLiteDatabaseY);
            }
            close();
            return d(z2);
        } finally {
            aVar.b();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        try {
            j jVar = this.f2382e;
            w(sQLiteDatabase);
            jVar.getClass();
        } catch (Throwable th) {
            throw new e(1, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        try {
            this.f2382e.e(w(sQLiteDatabase));
        } catch (Throwable th) {
            throw new e(2, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        sQLiteDatabase.getClass();
        this.f2384g = true;
        try {
            this.f2382e.i(w(sQLiteDatabase), i3, i4);
        } catch (Throwable th) {
            throw new e(4, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        if (!this.f2384g) {
            try {
                this.f2382e.h(w(sQLiteDatabase));
            } catch (Throwable th) {
                throw new e(5, th);
            }
        }
        this.f2386i = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        sQLiteDatabase.getClass();
        this.f2384g = true;
        try {
            this.f2382e.i(w(sQLiteDatabase), i3, i4);
        } catch (Throwable th) {
            throw new e(3, th);
        }
    }

    public final c w(SQLiteDatabase sQLiteDatabase) {
        n1 n1Var = this.f2381d;
        n1Var.getClass();
        c cVar = (c) n1Var.f905c;
        if (cVar != null && cVar.f2373c.equals(sQLiteDatabase)) {
            return cVar;
        }
        c cVar2 = new c(sQLiteDatabase);
        n1Var.f905c = cVar2;
        return cVar2;
    }

    public final SQLiteDatabase y(boolean z2) throws Throwable {
        SQLiteDatabase readableDatabase;
        SQLiteDatabase readableDatabase2;
        File parentFile;
        String databaseName = getDatabaseName();
        Context context = this.f2380c;
        if (databaseName != null && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            if (z2) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.getClass();
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase3 = getReadableDatabase();
            readableDatabase3.getClass();
            return readableDatabase3;
        } catch (Throwable unused) {
            super.close();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                if (z2) {
                    readableDatabase2 = getWritableDatabase();
                    readableDatabase2.getClass();
                } else {
                    readableDatabase2 = getReadableDatabase();
                    readableDatabase2.getClass();
                }
                return readableDatabase2;
            } catch (Throwable th) {
                super.close();
                if (th instanceof e) {
                    e eVar = th;
                    int iA = g.d.a(eVar.f2377c);
                    Throwable th2 = eVar.f2378d;
                    if (iA == 0 || iA == 1 || iA == 2 || iA == 3 || !(th2 instanceof SQLiteException)) {
                        throw th2;
                    }
                } else if (!(th instanceof SQLiteException) || databaseName == null || !this.f2383f) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    if (z2) {
                        readableDatabase = getWritableDatabase();
                        readableDatabase.getClass();
                    } else {
                        readableDatabase = getReadableDatabase();
                        readableDatabase.getClass();
                    }
                    return readableDatabase;
                } catch (e e3) {
                    throw e3.f2378d;
                }
            }
        }
    }
}
