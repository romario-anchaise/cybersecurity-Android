// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import E0.l;
import F0.i;
import M0.o;
import f1.d;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p029q.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends l {
    public static final void A(Iterable iterable, AbstractCollection abstractCollection) {
        i.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List B(Iterable iterable) {
        ArrayList arrayListC;
        i.e(iterable, "<this>");
        boolean z2 = iterable instanceof Collection;
        n nVar = n.f4146a;
        if (z2) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return nVar;
            }
            if (size != 1) {
                return C(collection);
            }
            return j.m(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        if (z2) {
            arrayListC = C((Collection) iterable);
        } else {
            ArrayList arrayList = new ArrayList();
            A(iterable, arrayList);
            arrayListC = arrayList;
        }
        int size2 = arrayListC.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayListC : j.m(arrayListC.get(0));
        }
        return nVar;
    }

    public static ArrayList C(Collection collection) {
        i.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Object s(Collection collection) {
        i.e(collection, "<this>");
        if (collection instanceof List) {
            return t((List) collection);
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object t(List list) {
        i.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object u(List list) {
        i.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final void v(Collection collection, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, l lVar) {
        i.e(charSequence, "separator");
        i.e(charSequence2, "prefix");
        i.e(charSequence3, "postfix");
        i.e(charSequence4, "truncated");
        sb.append(charSequence2);
        int i3 = 0;
        for (Object obj : collection) {
            i3++;
            if (i3 > 1) {
                sb.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            } else {
                d.b(sb, obj, lVar);
            }
        }
        if (i2 >= 0 && i3 > i2) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String w(Collection collection, String str, String str2, String str3, o oVar, int i2) {
        String str4 = (i2 & 2) != 0 ? "" : str2;
        String str5 = (i2 & 4) != 0 ? "" : str3;
        if ((i2 & 32) != 0) {
            oVar = null;
        }
        i.e(str4, "prefix");
        i.e(str5, "postfix");
        StringBuilder sb = new StringBuilder();
        v(collection, sb, str, str4, str5, -1, "...", oVar);
        String string = sb.toString();
        i.d(string, "toString(...)");
        return string;
    }

    public static Object x(List list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(g.p(list));
    }

    public static ArrayList y(Collection collection, Iterable iterable) {
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
        arrayList.addAll(collection);
        arrayList.addAll(collection2);
        return arrayList;
    }

    public static ArrayList z(List list, Object obj) {
        i.e(list, "<this>");
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(obj);
        return arrayList;
    }
}
