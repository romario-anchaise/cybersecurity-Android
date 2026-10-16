// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package C0;

import F0.i;
import M0.e;
import f1.d;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d {
    public static File I(File file) {
        int length;
        File file2;
        int iX;
        File file3 = new File("image_cache");
        String path = file3.getPath();
        i.d(path, "getPath(...)");
        char c2 = File.separatorChar;
        int iX2 = e.X(path, c2, 0, false, 4);
        if (iX2 == 0) {
            if (path.length() <= 1 || path.charAt(1) != c2 || (iX = e.X(path, c2, 2, false, 4)) < 0) {
                length = 1;
            } else {
                int iX3 = e.X(path, c2, iX + 1, false, 4);
                length = iX3 >= 0 ? iX3 + 1 : path.length();
            }
        } else if (iX2 <= 0 || path.charAt(iX2 - 1) != ':') {
            length = (iX2 == -1 && e.U(path, ':')) ? path.length() : 0;
        } else {
            length = iX2 + 1;
        }
        if (length > 0) {
            return file3;
        }
        String string = file.toString();
        i.d(string, "toString(...)");
        if ((string.length() == 0) || e.U(string, c2)) {
            file2 = new File(string + file3);
        } else {
            file2 = new File(string + c2 + file3);
        }
        return file2;
    }
}
