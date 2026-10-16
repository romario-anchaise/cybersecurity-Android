// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import H.C0028c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/* JADX INFO: loaded from: classes.dex */
public final class w extends v {
    public static Long k(FileTime fileTime) {
        long millis = fileTime.toMillis();
        Long lValueOf = Long.valueOf(millis);
        if (millis != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // k1.v, k1.o
    public final n f(z zVar) {
        z zVarQ;
        F0.i.e(zVar, "path");
        Path pathF = zVar.f();
        try {
            BasicFileAttributes attributes = Files.readAttributes(pathF, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(pathF) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            if (symbolicLink != null) {
                String str = z.f3517b;
                zVarQ = C0028c.q(symbolicLink.toString(), false);
            } else {
                zVarQ = null;
            }
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lK = fileTimeCreationTime != null ? k(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lK2 = fileTimeLastModifiedTime != null ? k(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new n(zIsRegularFile, zIsDirectory, zVarQ, lValueOf, lK, lK2, fileTimeLastAccessTime != null ? k(fileTimeLastAccessTime) : null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    @Override // k1.v
    public final void j(z zVar, z zVar2) throws IOException {
        F0.i.e(zVar, "source");
        F0.i.e(zVar2, "target");
        try {
            Files.move(zVar.f(), zVar2.f(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e2) {
            throw new FileNotFoundException(e2.getMessage());
        }
    }

    @Override // k1.v
    public final String toString() {
        return "NioSystemFileSystem";
    }
}
