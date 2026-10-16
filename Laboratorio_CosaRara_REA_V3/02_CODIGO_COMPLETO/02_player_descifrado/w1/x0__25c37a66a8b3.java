// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f5481a = Collections.unmodifiableList(Arrays.asList("debugger", "xposed", "frida-file", "qemu", "emulator", "frida-maps", "traced"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f5482b = Collections.unmodifiableList(Arrays.asList("terminate", "report_only", "off"));

    public static String a(String str, int i3) {
        if (str == null) {
            return "";
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        if (lowerCase.length() > i3) {
            return "";
        }
        for (int i4 = 0; i4 < lowerCase.length(); i4++) {
            if (Character.isISOControl(lowerCase.charAt(i4))) {
                return "";
            }
        }
        return lowerCase;
    }

    public static void b(File file, long j3) {
        File[] fileArrListFiles = file.listFiles(new v0(0));
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        Arrays.sort(fileArrListFiles, Comparator.comparingLong(new u0(0)).reversed());
        for (int i3 = 0; i3 < fileArrListFiles.length; i3++) {
            File file2 = fileArrListFiles[i3];
            long jLastModified = file2.lastModified();
            if (jLastModified <= 0 || ((j3 >= jLastModified && j3 - jLastModified > 604800000) || i3 >= 32)) {
                try {
                    file2.delete();
                } catch (Throwable unused) {
                }
            }
        }
    }
}
