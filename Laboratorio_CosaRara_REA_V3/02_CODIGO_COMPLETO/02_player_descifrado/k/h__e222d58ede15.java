// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k;

import android.database.sqlite.SQLiteProgram;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class h implements j.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SQLiteProgram f2394c;

    public h(SQLiteProgram sQLiteProgram) {
        sQLiteProgram.getClass();
        this.f2394c = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2394c.close();
    }

    @Override // j.e
    public final void h(int i3, long j3) {
        this.f2394c.bindLong(i3, j3);
    }

    @Override // j.e
    public final void j(int i3, byte[] bArr) {
        this.f2394c.bindBlob(i3, bArr);
    }

    @Override // j.e
    public final void l(int i3) {
        this.f2394c.bindNull(i3);
    }

    @Override // j.e
    public final void m(String str, int i3) {
        str.getClass();
        this.f2394c.bindString(i3, str);
    }

    @Override // j.e
    public final void o(int i3, double d3) {
        this.f2394c.bindDouble(i3, d3);
    }
}
