// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.widget.ArrayAdapter;

/* JADX INFO: renamed from: f.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0117g extends ArrayAdapter {
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
