// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import e2.n1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f1494a = new n1(4);

    static {
        new WeakHashMap();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = ((Map) this.f1494a.f905c).values().iterator();
        while (it.hasNext()) {
            ((e) it.next()).getClass();
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        Iterator it = ((Map) this.f1494a.f905c).values().iterator();
        if (it.hasNext()) {
            ((e) it.next()).getClass();
            throw null;
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n1 n1Var = this.f1494a;
        n1Var.getClass();
        for (Map.Entry entry : ((Map) n1Var.f905c).entrySet()) {
            ((e) entry.getValue()).b(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        n1 n1Var = this.f1494a;
        n1Var.getClass();
        Iterator it = ((Map) n1Var.f905c).values().iterator();
        while (it.hasNext()) {
            ((e) it.next()).getClass();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        n1 n1Var = this.f1494a;
        n1Var.getClass();
        Iterator it = ((Map) n1Var.f905c).values().iterator();
        while (it.hasNext()) {
            ((e) it.next()).d();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        n1 n1Var = this.f1494a;
        if (bundle == null) {
            n1Var.getClass();
            return;
        }
        Iterator it = ((Map) n1Var.f905c).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            new Bundle();
            ((e) entry.getValue()).getClass();
            throw null;
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        n1 n1Var = this.f1494a;
        n1Var.getClass();
        for (e eVar : ((Map) n1Var.f905c).values()) {
            eVar.f1451a = true;
            eVar.d();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        n1 n1Var = this.f1494a;
        n1Var.getClass();
        Iterator it = ((Map) n1Var.f905c).values().iterator();
        while (it.hasNext()) {
            ((e) it.next()).c();
        }
    }
}
