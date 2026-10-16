// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i1;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends AbstractList implements List {
    public abstract int a();

    public abstract Object b(int i3);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i3) {
        return b(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
