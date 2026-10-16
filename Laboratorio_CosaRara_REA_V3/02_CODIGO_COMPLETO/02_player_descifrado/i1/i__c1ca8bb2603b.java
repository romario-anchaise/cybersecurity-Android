// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends o {
    public static final void C(Collection collection, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, p1.l lVar) {
        sb.append(charSequence2);
        int i3 = 0;
        for (Object obj : collection) {
            i3++;
            if (i3 > 1) {
                sb.append(charSequence);
            }
            q2.k.a(sb, obj, lVar);
        }
        sb.append(charSequence3);
    }

    public static String D(Collection collection, String str, d2.o oVar, int i3) {
        CharSequence charSequence = (i3 & 2) != 0 ? "" : "[";
        String str2 = (i3 & 4) == 0 ? "]" : "";
        if ((i3 & 32) != 0) {
            oVar = null;
        }
        StringBuilder sb = new StringBuilder();
        C(collection, sb, str, charSequence, str2, "...", oVar);
        return sb.toString();
    }

    public static List E(Collection collection) {
        collection.getClass();
        int size = collection.size();
        if (size == 0) {
            return q.f2104c;
        }
        if (size != 1) {
            return new ArrayList(collection);
        }
        return m0.a.k(collection instanceof List ? ((List) collection).get(0) : collection.iterator().next());
    }
}
