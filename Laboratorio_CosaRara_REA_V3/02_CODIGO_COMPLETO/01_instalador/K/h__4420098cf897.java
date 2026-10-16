// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

import android.system.ErrnoException;
import android.system.Os;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static void a(FileDescriptor fileDescriptor) throws ErrnoException {
        Os.close(fileDescriptor);
    }

    public static FileDescriptor b(FileDescriptor fileDescriptor) throws ErrnoException {
        return Os.dup(fileDescriptor);
    }

    public static long c(FileDescriptor fileDescriptor, long j2, int i2) throws ErrnoException {
        return Os.lseek(fileDescriptor, j2, i2);
    }
}
