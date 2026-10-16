// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f502d;

    public m(int i2, int i3, long j2, long j3) {
        this.f499a = i2;
        this.f500b = i3;
        this.f501c = j2;
        this.f502d = j3;
    }

    public static m a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            m mVar = new m(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return mVar;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f499a);
            dataOutputStream.writeInt(this.f500b);
            dataOutputStream.writeLong(this.f501c);
            dataOutputStream.writeLong(this.f502d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f500b == mVar.f500b && this.f501c == mVar.f501c && this.f499a == mVar.f499a && this.f502d == mVar.f502d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f500b), Long.valueOf(this.f501c), Integer.valueOf(this.f499a), Long.valueOf(this.f502d));
    }
}
