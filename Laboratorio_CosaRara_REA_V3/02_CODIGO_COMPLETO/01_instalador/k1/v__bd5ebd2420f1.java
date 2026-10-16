// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class v extends o {
    @Override // k1.o
    public final void a(z zVar) throws IOException {
        F0.i.e(zVar, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File fileE = zVar.e();
        if (fileE.delete() || !fileE.exists()) {
            return;
        }
        throw new IOException("failed to delete " + zVar);
    }

    @Override // k1.o
    public final List d(z zVar) throws IOException {
        F0.i.e(zVar, "dir");
        File fileE = zVar.e();
        String[] list = fileE.list();
        if (list == null) {
            if (fileE.exists()) {
                throw new IOException("failed to list " + zVar);
            }
            throw new FileNotFoundException("no such file: " + zVar);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            F0.i.b(str);
            arrayList.add(zVar.d(str));
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    @Override // k1.o
    public n f(z zVar) {
        F0.i.e(zVar, "path");
        File fileE = zVar.e();
        boolean zIsFile = fileE.isFile();
        boolean zIsDirectory = fileE.isDirectory();
        long jLastModified = fileE.lastModified();
        long length = fileE.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !fileE.exists()) {
            return null;
        }
        return new n(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
    }

    @Override // k1.o
    public final u g(z zVar) {
        return new u(new RandomAccessFile(zVar.e(), "r"));
    }

    @Override // k1.o
    public final G h(z zVar) {
        F0.i.e(zVar, "file");
        File fileE = zVar.e();
        Logger logger = x.f3514a;
        return new C0187c(new FileOutputStream(fileE, false), 1, new K());
    }

    @Override // k1.o
    public final I i(z zVar) {
        F0.i.e(zVar, "file");
        File fileE = zVar.e();
        Logger logger = x.f3514a;
        return new C0188d(new FileInputStream(fileE), K.f3456d);
    }

    public void j(z zVar, z zVar2) throws IOException {
        F0.i.e(zVar, "source");
        F0.i.e(zVar2, "target");
        if (zVar.e().renameTo(zVar2.e())) {
            return;
        }
        throw new IOException("failed to move " + zVar + " to " + zVar2);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
