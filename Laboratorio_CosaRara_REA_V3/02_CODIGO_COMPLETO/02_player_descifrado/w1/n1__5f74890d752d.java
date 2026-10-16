// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.charset.StandardCharsets;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractCollection f4597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractCollection f4598e;

    public n1(int i3) {
        switch (i3) {
            case 1:
                h2.a aVar = new h2.a(3);
                this.f4597d = new ArrayDeque();
                this.f4598e = new ArrayDeque();
                this.f4595b = new HashMap();
                this.f4594a = 64;
                this.f4596c = aVar;
                break;
            default:
                this.f4596c = new ArrayList();
                this.f4597d = new ArrayList();
                this.f4598e = new ArrayList();
                this.f4595b = new HashMap();
                break;
        }
    }

    public static String c(ArrayDeque arrayDeque) {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = arrayDeque.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            td tdVar = (td) it.next();
            if (!z2) {
                sb.append(',');
            }
            sb.append("{\"gen\":");
            int i3 = tdVar.f5199a;
            h2.g gVar = tdVar.f5203e;
            int i4 = tdVar.f5202d;
            sb.append(i3);
            sb.append(",\"from\":\"");
            sb.append(tdVar.f5200b.name());
            sb.append("\",\"to\":\"");
            sb.append(tdVar.f5201c.name());
            sb.append("\",\"atMs\":");
            sb.append(tdVar.f5205g);
            sb.append(",\"validatedToOnlineMs\":");
            sb.append(tdVar.f5204f);
            if (i4 != 0) {
                sb.append(",\"reason\":\"");
                sb.append(a0.a.v(i4));
                sb.append('\"');
            }
            if (gVar != null) {
                sb.append(",\"disconnect\":");
                sb.append(gVar.m());
            }
            sb.append('}');
            z2 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public synchronized void a(String str) {
        Deque deque = (Deque) this.f4595b.get(str);
        if (deque != null && !deque.isEmpty()) {
            deque.removeFirst();
            if (deque.isEmpty()) {
                this.f4595b.remove(str);
            }
        }
    }

    public synchronized String b() {
        String strC;
        try {
            ArrayDeque arrayDeque = new ArrayDeque();
            Iterator it = ((ArrayDeque) this.f4597d).iterator();
            while (it.hasNext()) {
                arrayDeque.addLast((td) it.next());
                if (c(arrayDeque).getBytes(StandardCharsets.UTF_8).length > 16378) {
                    arrayDeque.removeLast();
                    break;
                }
            }
            if (arrayDeque.isEmpty() && !((ArrayDeque) this.f4597d).isEmpty()) {
                throw new IllegalStateException("single stats event exceeds byte limit");
            }
            for (int i3 = 0; i3 < arrayDeque.size(); i3++) {
                ((ArrayDeque) this.f4597d).removeFirst();
            }
            strC = c(arrayDeque);
            if (!arrayDeque.isEmpty()) {
                ((Deque) this.f4595b.computeIfAbsent(strC, new d2.i(11))).addLast(arrayDeque);
            }
        } catch (Throwable th) {
            throw th;
        }
        return strC;
    }

    public synchronized void d(String str) {
        try {
            Deque deque = (Deque) this.f4595b.get(str);
            if (deque != null && !deque.isEmpty()) {
                Deque deque2 = (Deque) deque.removeFirst();
                if (deque.isEmpty()) {
                    this.f4595b.remove(str);
                }
                Iterator itDescendingIterator = deque2.descendingIterator();
                while (itDescendingIterator.hasNext()) {
                    if (((ArrayDeque) this.f4597d).size() >= this.f4594a) {
                        ((ArrayDeque) this.f4597d).removeLast();
                    }
                    ((ArrayDeque) this.f4597d).addFirst((td) itDescendingIterator.next());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
