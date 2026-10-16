// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p009f.C0114d;
import p009f.C0115e;
import p009f.C0117g;
import p009f.C0118h;
import p009f.DialogC0119i;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2171b;

    public p() {
        this.f2171b = new LinkedHashMap();
    }

    public Object a() {
        int i2 = this.f2170a;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = (Object[]) this.f2171b;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f2170a = i2 - 1;
        return obj;
    }

    public void b() {
        WeakReference weakReference;
        this.f2170a = 0;
        Iterator it = ((LinkedHashMap) this.f2171b).values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                d0.f fVar = (d0.f) p036u0.f.u(arrayList);
                if (((fVar == null || (weakReference = fVar.f2207b) == null) ? null : (Bitmap) weakReference.get()) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    int i4 = i3 - i2;
                    if (((d0.f) arrayList.get(i4)).f2207b.get() == null) {
                        arrayList.remove(i4);
                        i2++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    public DialogC0119i c() {
        C0115e c0115e = (C0115e) this.f2171b;
        DialogC0119i dialogC0119i = new DialogC0119i(c0115e.f2465a, this.f2170a);
        View view = c0115e.f2469e;
        C0118h c0118h = dialogC0119i.f2501e;
        if (view != null) {
            c0118h.f2487n = view;
        } else {
            CharSequence charSequence = c0115e.f2468d;
            if (charSequence != null) {
                c0118h.f2478d = charSequence;
                TextView textView = c0118h.f2485l;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = c0115e.f2467c;
            if (drawable != null) {
                c0118h.f2483j = drawable;
                ImageView imageView = c0118h.f2484k;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c0118h.f2484k.setImageDrawable(drawable);
                }
            }
        }
        if (c0115e.g != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) c0115e.f2466b.inflate(c0118h.f2491r, (ViewGroup) null);
            int i2 = c0115e.f2472i ? c0118h.f2492s : c0118h.f2493t;
            Object obj = c0115e.g;
            ?? c0117g = obj;
            if (obj == null) {
                c0117g = new C0117g(c0115e.f2465a, i2, R.id.text1, null);
            }
            c0118h.f2488o = c0117g;
            c0118h.f2489p = c0115e.f2473j;
            if (c0115e.f2471h != null) {
                alertController$RecycleListView.setOnItemClickListener(new C0114d(c0115e, c0118h));
            }
            if (c0115e.f2472i) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            c0118h.f2479e = alertController$RecycleListView;
        }
        dialogC0119i.setCancelable(true);
        dialogC0119i.setCanceledOnTouchOutside(true);
        dialogC0119i.setOnCancelListener(null);
        dialogC0119i.setOnDismissListener(null);
        p013i.o oVar = c0115e.f2470f;
        if (oVar != null) {
            dialogC0119i.setOnKeyListener(oVar);
        }
        return dialogC0119i;
    }

    public boolean d() {
        return this.f2170a < ((ArrayList) this.f2171b).size();
    }

    public void e(Object obj) {
        int i2 = 0;
        while (true) {
            int i3 = this.f2170a;
            Object[] objArr = (Object[]) this.f2171b;
            if (i2 >= i3) {
                if (i3 < objArr.length) {
                    objArr[i3] = obj;
                    this.f2170a = i3 + 1;
                    return;
                }
                return;
            }
            if (objArr[i2] == obj) {
                throw new IllegalStateException("Already in the pool!");
            }
            i2++;
        }
    }

    public synchronized void f(d0.a aVar, Bitmap bitmap, Map map, int i2) {
        try {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.f2171b;
            Object arrayList = linkedHashMap.get(aVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(aVar, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            d0.f fVar = new d0.f(iIdentityHashCode, new WeakReference(bitmap), map, i2);
            int size = arrayList2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    arrayList2.add(fVar);
                    break;
                }
                d0.f fVar2 = (d0.f) arrayList2.get(i3);
                if (i2 >= fVar2.f2209d) {
                    if (fVar2.f2206a != iIdentityHashCode || fVar2.f2207b.get() != bitmap) {
                        arrayList2.add(i3, fVar);
                        break;
                    } else {
                        arrayList2.set(i3, fVar);
                        break;
                    }
                }
                i3++;
            }
            int i4 = this.f2170a;
            this.f2170a = i4 + 1;
            if (i4 >= 10) {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public p(int i2) {
        if (i2 > 0) {
            this.f2171b = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public p(ArrayList arrayList) {
        this.f2171b = arrayList;
    }

    public p(Context context) {
        int iG = DialogC0119i.g(context, 0);
        this.f2171b = new C0115e(new ContextThemeWrapper(context, DialogC0119i.g(context, iG)));
        this.f2170a = iG;
    }

    public p(int i2, p041x.h[] hVarArr) {
        this.f2170a = i2;
        this.f2171b = hVarArr;
    }
}
