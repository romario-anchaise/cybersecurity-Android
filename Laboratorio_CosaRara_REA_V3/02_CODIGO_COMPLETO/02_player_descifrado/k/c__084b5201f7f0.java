// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f2371e = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f2372f = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SQLiteDatabase f2373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2374d;

    public c(SQLiteDatabase sQLiteDatabase) {
        this.f2373c = sQLiteDatabase;
        this.f2374d = sQLiteDatabase.getAttachedDbs();
    }

    public final void A(String str) {
        this.f2373c.execSQL(str);
    }

    public final void B(Object[] objArr) {
        this.f2373c.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", objArr);
    }

    public final boolean C() {
        return this.f2373c.inTransaction();
    }

    public final boolean D() {
        return this.f2373c.isWriteAheadLoggingEnabled();
    }

    public final Cursor E(j.f fVar) {
        final b bVar = new b(0, fVar);
        Cursor cursorRawQueryWithFactory = this.f2373c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: k.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                j.f fVar2 = (j.f) bVar.f2370d;
                sQLiteQuery.getClass();
                fVar2.w(new h(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, fVar.d(), f2372f, null);
        cursorRawQueryWithFactory.getClass();
        return cursorRawQueryWithFactory;
    }

    public final void F() {
        this.f2373c.setTransactionSuccessful();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2373c.close();
    }

    public final void d() {
        this.f2373c.beginTransaction();
    }

    public final void w() {
        this.f2373c.beginTransactionNonExclusive();
    }

    public final i y(String str) {
        SQLiteStatement sQLiteStatementCompileStatement = this.f2373c.compileStatement(str);
        sQLiteStatementCompileStatement.getClass();
        return new i(sQLiteStatementCompileStatement);
    }

    public final void z() {
        this.f2373c.endTransaction();
    }
}
