// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k;

import android.database.sqlite.SQLiteStatement;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends h implements j.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SQLiteStatement f2395d;

    public i(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f2395d = sQLiteStatement;
    }

    public final int d() {
        return this.f2395d.executeUpdateDelete();
    }
}
