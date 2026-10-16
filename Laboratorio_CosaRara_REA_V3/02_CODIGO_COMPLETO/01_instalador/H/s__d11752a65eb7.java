// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import A.C0005e;
import A.C0023x;
import A.J;
import A.X;
import X0.D;
import X0.InterfaceC0058e;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.L;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.c0;
import androidx.recyclerview.widget.h0;
import androidx.recyclerview.widget.k0;
import androidx.recyclerview.widget.l0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.Executor;
import m1.C0210n;
import m1.InterfaceC0201e;
import m1.InterfaceC0203g;
import m1.InterfaceC0204h;
import m1.O;
import m1.W;

/* JADX INFO: loaded from: classes.dex */
public final class s implements d0.g, p011h.a, InterfaceC0203g, InterfaceC0204h, InterfaceC0058e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f233c;

    public /* synthetic */ s(Object obj, int i2, Object obj2) {
        this.f231a = i2;
        this.f232b = obj;
        this.f233c = obj2;
    }

    public static String m(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    public static boolean o(Editable editable, KeyEvent keyEvent, boolean z2) {
        A[] aArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (aArr = (A[]) editable.getSpans(selectionStart, selectionEnd, A.class)) != null && aArr.length > 0) {
            for (A a2 : aArr) {
                int spanStart = editable.getSpanStart(a2);
                int spanEnd = editable.getSpanEnd(a2);
                if ((z2 && spanStart == selectionStart) || ((!z2 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static int x(int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            i4++;
            if (i4 == i3) {
                i5++;
                i4 = 0;
            } else if (i4 > i3) {
                i5++;
                i4 = 1;
            }
        }
        return i4 + 1 > i3 ? i5 + 1 : i5;
    }

    public boolean A(View view) {
        L l2 = (L) this.f232b;
        int iD = l2.d();
        int iC = l2.c();
        int iB = l2.b(view);
        int iA = l2.a(view);
        k0 k0Var = (k0) this.f233c;
        k0Var.f1984b = iD;
        k0Var.f1985c = iC;
        k0Var.f1986d = iB;
        k0Var.f1987e = iA;
        k0Var.f1983a = 24579;
        return k0Var.a();
    }

    public void B(int i2, int i3) {
        int[] iArr = (int[]) this.f232b;
        if (iArr == null || i2 >= iArr.length) {
            return;
        }
        int i4 = i2 + i3;
        p(i4);
        int[] iArr2 = (int[]) this.f232b;
        System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
        Arrays.fill((int[]) this.f232b, i2, i4, -1);
        ArrayList arrayList = (ArrayList) this.f233c;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h0 h0Var = (h0) ((ArrayList) this.f233c).get(size);
            int i5 = h0Var.f1941a;
            if (i5 >= i2) {
                h0Var.f1941a = i5 + i3;
            }
        }
    }

    public void C(int i2, int i3) {
        int[] iArr = (int[]) this.f232b;
        if (iArr == null || i2 >= iArr.length) {
            return;
        }
        int i4 = i2 + i3;
        p(i4);
        int[] iArr2 = (int[]) this.f232b;
        System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
        int[] iArr3 = (int[]) this.f232b;
        Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.f233c;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h0 h0Var = (h0) ((ArrayList) this.f233c).get(size);
            int i5 = h0Var.f1941a;
            if (i5 >= i2) {
                if (i5 < i4) {
                    ((ArrayList) this.f233c).remove(size);
                } else {
                    h0Var.f1941a = i5 - i3;
                }
            }
        }
    }

    public void D(p041x.f fVar) {
        int i2 = fVar.f4175b;
        Handler handler = (Handler) this.f233c;
        C0005e c0005e = (C0005e) this.f232b;
        if (i2 != 0) {
            handler.post(new D.b(c0005e, i2));
        } else {
            handler.post(new R0.h(c0005e, 5, fVar.f4174a));
        }
    }

    public C0023x E(c0 c0Var, int i2) {
        l0 l0Var;
        C0023x c0023x;
        p021m.i iVar = (p021m.i) this.f232b;
        int iC = iVar.c(c0Var);
        if (iC >= 0 && (l0Var = (l0) iVar.h(iC)) != null) {
            int i3 = l0Var.f1991a;
            if ((i3 & i2) != 0) {
                int i4 = i3 & (~i2);
                l0Var.f1991a = i4;
                if (i2 == 4) {
                    c0023x = l0Var.f1992b;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    c0023x = l0Var.f1993c;
                }
                if ((i4 & 12) == 0) {
                    iVar.f(iC);
                    l0Var.f1991a = 0;
                    l0Var.f1992b = null;
                    l0Var.f1993c = null;
                    l0.f1990d.e(l0Var);
                }
                return c0023x;
            }
        }
        return null;
    }

    public void F(c0 c0Var) {
        l0 l0Var = (l0) ((p021m.i) this.f232b).get(c0Var);
        if (l0Var == null) {
            return;
        }
        l0Var.f1991a &= -2;
    }

    public void G(c0 c0Var) {
        p021m.g gVar = (p021m.g) this.f233c;
        for (int iC = gVar.c() - 1; iC >= 0; iC--) {
            if (c0Var == gVar.d(iC)) {
                Object[] objArr = gVar.f3683c;
                Object obj = objArr[iC];
                Object obj2 = p021m.h.f3685a;
                if (obj == obj2) {
                    break;
                }
                objArr[iC] = obj2;
                gVar.f3681a = true;
                break;
            }
        }
        l0 l0Var = (l0) ((p021m.i) this.f232b).remove(c0Var);
        if (l0Var != null) {
            l0Var.f1991a = 0;
            l0Var.f1992b = null;
            l0Var.f1993c = null;
            l0.f1990d.e(l0Var);
        }
    }

    @Override // p011h.a
    public boolean a(p011h.b bVar, MenuItem menuItem) {
        return ((p011h.a) this.f232b).a(bVar, menuItem);
    }

    @Override // m1.InterfaceC0204h
    public void b(InterfaceC0201e interfaceC0201e, O o2) {
        ((C0210n) this.f233c).f3843a.execute(new n(this, (InterfaceC0204h) this.f232b, o2, 1));
    }

    @Override // p011h.a
    public boolean c(p011h.b bVar, p013i.n nVar) {
        ViewGroup viewGroup = ((p009f.z) this.f233c).f2548A;
        WeakHashMap weakHashMap = X.f14a;
        J.c(viewGroup);
        return ((p011h.a) this.f232b).c(bVar, nVar);
    }

    @Override // m1.InterfaceC0203g
    public Type d() {
        return (Type) this.f232b;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [f.l, java.lang.Object] */
    @Override // p011h.a
    public void e(p011h.b bVar) {
        ((p011h.a) this.f232b).e(bVar);
        p009f.z zVar = (p009f.z) this.f233c;
        if (zVar.f2593w != null) {
            zVar.f2582l.getDecorView().removeCallbacks(zVar.f2594x);
        }
        if (zVar.f2592v != null) {
            A.h0 h0Var = zVar.f2595y;
            if (h0Var != null) {
                h0Var.b();
            }
            A.h0 h0VarA = X.a(zVar.f2592v);
            h0VarA.a(0.0f);
            zVar.f2595y = h0VarA;
            h0VarA.d(new p009f.r(2, this));
        }
        zVar.f2584n.onSupportActionModeFinished(zVar.f2591u);
        zVar.f2591u = null;
        ViewGroup viewGroup = zVar.f2548A;
        WeakHashMap weakHashMap = X.f14a;
        J.c(viewGroup);
        zVar.J();
    }

    @Override // p011h.a
    public boolean f(p011h.b bVar, p013i.n nVar) {
        return ((p011h.a) this.f232b).f(bVar, nVar);
    }

    @Override // X0.InterfaceC0058e
    public void g(b1.j jVar, IOException iOException) {
        try {
            ((InterfaceC0204h) this.f232b).j((m1.y) this.f233c, iOException);
        } catch (Throwable th) {
            W.s(th);
            th.printStackTrace();
        }
    }

    @Override // X0.InterfaceC0058e
    public void h(D d2) {
        InterfaceC0204h interfaceC0204h = (InterfaceC0204h) this.f232b;
        m1.y yVar = (m1.y) this.f233c;
        try {
            try {
                interfaceC0204h.b(yVar, yVar.d(d2));
            } catch (Throwable th) {
                W.s(th);
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            W.s(th2);
            try {
                interfaceC0204h.j(yVar, th2);
            } catch (Throwable th3) {
                W.s(th3);
                th3.printStackTrace();
            }
        }
    }

    @Override // d0.g
    public d0.b i(d0.a aVar) {
        d0.d dVar = (d0.d) ((d0.e) this.f233c).g(aVar);
        if (dVar != null) {
            return new d0.b(dVar.f2202a, dVar.f2203b);
        }
        return null;
    }

    @Override // m1.InterfaceC0204h
    public void j(InterfaceC0201e interfaceC0201e, Throwable th) {
        ((C0210n) this.f233c).f3843a.execute(new n(this, (InterfaceC0204h) this.f232b, th, 2));
    }

    @Override // m1.InterfaceC0203g
    public Object k(m1.y yVar) {
        Executor executor = (Executor) this.f233c;
        return executor == null ? yVar : new C0210n(executor, yVar);
    }

    public void l(c0 c0Var, C0023x c0023x) {
        p021m.i iVar = (p021m.i) this.f232b;
        l0 l0VarA = (l0) iVar.get(c0Var);
        if (l0VarA == null) {
            l0VarA = l0.a();
            iVar.put(c0Var, l0VarA);
        }
        l0VarA.f1993c = c0023x;
        l0VarA.f1991a |= 8;
    }

    public void n() {
        int[] iArr = (int[]) this.f232b;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f233c = null;
    }

    public void p(int i2) {
        int[] iArr = (int[]) this.f232b;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i2, 10) + 1];
            this.f232b = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i2 >= iArr.length) {
            int length = iArr.length;
            while (length <= i2) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f232b = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f232b;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public void q() {
        Iterator it = ((HashMap) this.f233c).values().iterator();
        while (it.hasNext()) {
            androidx.fragment.app.y.a(it.next());
        }
    }

    public View r(int i2, int i3, int i4, int i5) {
        View viewT;
        L l2 = (L) this.f232b;
        int iD = l2.d();
        int iC = l2.c();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            switch (l2.f1720a) {
                case 0:
                    viewT = ((N) l2.f1721b).t(i2);
                    break;
                default:
                    viewT = ((N) l2.f1721b).t(i2);
                    break;
            }
            int iB = l2.b(viewT);
            int iA = l2.a(viewT);
            k0 k0Var = (k0) this.f233c;
            k0Var.f1984b = iD;
            k0Var.f1985c = iC;
            k0Var.f1986d = iB;
            k0Var.f1987e = iA;
            if (i4 != 0) {
                k0Var.f1983a = i4;
                if (k0Var.a()) {
                    return viewT;
                }
            }
            if (i5 != 0) {
                k0Var.f1983a = i5;
                if (k0Var.a()) {
                    view = viewT;
                }
            }
            i2 += i6;
        }
        return view;
    }

    @Override // d0.g
    public void s(d0.a aVar, Bitmap bitmap, Map map) {
        int i2;
        Object objRemove;
        int iX = f1.l.x(bitmap);
        d0.e eVar = (d0.e) this.f233c;
        synchronized (((p022m0.e) eVar.g)) {
            i2 = eVar.f1966b;
        }
        if (iX <= i2) {
            ((d0.e) this.f233c).k(aVar, new d0.d(bitmap, map, iX));
            return;
        }
        d0.e eVar2 = (d0.e) this.f233c;
        eVar2.getClass();
        synchronized (((p022m0.e) eVar2.g)) {
            p010f0.n nVar = (p010f0.n) eVar2.f1970f;
            nVar.getClass();
            objRemove = nVar.f2680a.remove(aVar);
            if (objRemove != null) {
                eVar2.f1967c -= eVar2.l(aVar, objRemove);
            }
        }
        if (objRemove != null) {
            eVar2.c(aVar, objRemove, null);
        }
        ((b1.p) this.f232b).f(aVar, bitmap, map, iX);
    }

    public p022m0.o t(p032r0.a aVar) {
        p022m0.f fVar;
        String str;
        p022m0.o uVar;
        int i2 = 0;
        int i3 = 1;
        Map map = (Map) this.f232b;
        Type type = aVar.f4030b;
        if (map.get(type) != null) {
            throw new ClassCastException();
        }
        Class cls = aVar.f4029a;
        if (map.get(cls) != null) {
            throw new ClassCastException();
        }
        p022m0.o eVar = null;
        if (EnumSet.class.isAssignableFrom(cls)) {
            fVar = new p022m0.f(i2, type);
        } else {
            fVar = cls == EnumMap.class ? new p022m0.f(i3, type) : null;
        }
        if (fVar != null) {
            return fVar;
        }
        p022m0.d.f((List) this.f233c);
        if (Modifier.isAbstract(cls.getModifiers())) {
            uVar = null;
        } else {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(null);
                p028p0.a aVar2 = p028p0.d.f4001a;
                try {
                    declaredConstructor.setAccessible(true);
                    str = null;
                } catch (Exception e2) {
                    str = "Failed making constructor '" + p028p0.d.b(declaredConstructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e2.getMessage() + p028p0.d.e(e2);
                }
                uVar = str != null ? new R0.u(2, str) : new C0005e(22, declaredConstructor);
            } catch (NoSuchMethodException unused) {
                uVar = null;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                eVar = new C0028c(22);
            } else if (Set.class.isAssignableFrom(cls)) {
                eVar = new C0028c(23);
            } else {
                eVar = Queue.class.isAssignableFrom(cls) ? new C0028c(24) : new C0028c(25);
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                eVar = new C0028c(26);
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                eVar = new C0028c(27);
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                eVar = new C0028c(28);
            } else {
                eVar = (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(new p032r0.a(((ParameterizedType) type).getActualTypeArguments()[0]).f4029a)) ? new p022m0.e() : new C0028c(29);
            }
        }
        if (eVar != null) {
            return eVar;
        }
        String strM = m(cls);
        return strM != null ? new R0.u(i3, strM) : new V0.n(cls);
    }

    public String toString() {
        switch (this.f231a) {
            case 12:
                return ((Map) this.f232b).toString();
            default:
                return super.toString();
        }
    }

    @Override // d0.g
    public void u(int i2) {
        int i3;
        if (i2 >= 40) {
            ((d0.e) this.f233c).n(-1);
            return;
        }
        if (10 > i2 || i2 >= 20) {
            return;
        }
        d0.e eVar = (d0.e) this.f233c;
        synchronized (((p022m0.e) eVar.g)) {
            i3 = eVar.f1967c;
        }
        eVar.n(i3 / 2);
    }

    public ArrayList v() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((HashMap) this.f233c).values().iterator();
        while (it.hasNext()) {
            androidx.fragment.app.y.a(it.next());
        }
        return arrayList;
    }

    public List w() {
        ArrayList arrayList;
        if (((ArrayList) this.f232b).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.f232b)) {
            arrayList = new ArrayList((ArrayList) this.f232b);
        }
        return arrayList;
    }

    public boolean y(CharSequence charSequence, int i2, int i3, q qVar) {
        if (qVar.f224c == 0) {
            e eVar = (e) this.f233c;
            I.a aVarC = qVar.c();
            int iA = aVarC.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarC.f5d).getShort(iA + aVarC.f2a);
            }
            eVar.getClass();
            ThreadLocal threadLocal = e.f193b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i2 < i3) {
                sb.append(charSequence.charAt(i2));
                i2++;
            }
            TextPaint textPaint = eVar.f194a;
            String string = sb.toString();
            int i4 = p033t.e.f4107a;
            qVar.f224c = p033t.d.a(textPaint, string) ? 2 : 1;
        }
        return qVar.f224c == 2;
    }

    public void z() {
        ((SparseIntArray) this.f232b).clear();
    }

    public /* synthetic */ s(Object obj, Object obj2, int i2, boolean z2) {
        this.f231a = i2;
        this.f233c = obj;
        this.f232b = obj2;
    }

    public s(int i2, b1.p pVar) {
        this.f231a = 10;
        this.f232b = pVar;
        this.f233c = new d0.e(i2, this);
    }

    public s(int i2) {
        this.f231a = i2;
        switch (i2) {
            case 5:
                this.f232b = new ArrayList();
                this.f233c = new HashMap();
                break;
            case 6:
                this.f232b = new SparseIntArray();
                this.f233c = new SparseIntArray();
                break;
            case 7:
                break;
            case 8:
            default:
                this.f232b = new ArrayList();
                this.f233c = new ArrayList();
                break;
            case 9:
                this.f232b = new p021m.i(0);
                this.f233c = new p021m.g();
                break;
        }
    }

    public s(x xVar, C0028c c0028c, e eVar) {
        this.f231a = 0;
        this.f232b = xVar;
        this.f233c = eVar;
    }

    public s(L l2) {
        this.f231a = 8;
        this.f232b = l2;
        k0 k0Var = new k0();
        k0Var.f1983a = 0;
        this.f233c = k0Var;
    }

    public s(EditText editText) {
        this.f231a = 1;
        this.f232b = editText;
        J.i iVar = new J.i(editText);
        this.f233c = iVar;
        editText.addTextChangedListener(iVar);
        if (J.a.f259b == null) {
            synchronized (J.a.f258a) {
                try {
                    if (J.a.f259b == null) {
                        J.a aVar = new J.a();
                        try {
                            J.a.f260c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, J.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        J.a.f259b = aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        editText.setEditableFactory(J.a.f259b);
    }
}
