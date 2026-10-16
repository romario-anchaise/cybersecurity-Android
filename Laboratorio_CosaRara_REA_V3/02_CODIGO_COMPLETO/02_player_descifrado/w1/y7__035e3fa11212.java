// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f5609a = Collections.unmodifiableList(Arrays.asList("black", "update", "fingerprint", "face"));

    public static boolean a(String str) {
        return "black".equals(str) || "update".equals(str) || "fingerprint".equals(str) || "face".equals(str);
    }

    public static ArrayList b(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (a(str) && !arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        for (String str2 : f5609a) {
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static String c(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(arrayList.size() - 1);
    }
}
