// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f1557a;

    public k(r rVar) {
        this.f1557a = rVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        boolean zEquals = i.class.getName().equals(str);
        r rVar = this.f1557a;
        if (zEquals) {
            i iVar = new i(context, attributeSet);
            iVar.f1555d = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.a.f343b);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
            }
            String string = typedArrayObtainStyledAttributes.getString(1);
            typedArrayObtainStyledAttributes.recycle();
            int id = iVar.getId();
            rVar.g();
            if (classAttribute != null) {
                if (id <= 0) {
                    throw new IllegalStateException(F0.h.e("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                }
                context.getClassLoader();
                rVar.f1582n.a(classAttribute);
                throw null;
            }
            Iterator it = rVar.f1572c.v().iterator();
            if (!it.hasNext()) {
                return iVar;
            }
            it.next().getClass();
            throw new ClassCastException();
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, L.a.f342a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes2.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(1, -1);
        String string2 = typedArrayObtainStyledAttributes2.getString(2);
        typedArrayObtainStyledAttributes2.recycle();
        if (attributeValue != null) {
            try {
                zIsAssignableFrom = d.class.isAssignableFrom(n.b(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id2 = view != null ? view.getId() : 0;
                if (id2 == -1 && resourceId == -1 && string2 == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                if (resourceId != -1) {
                    rVar.g();
                }
                if (string2 != null) {
                    H.s sVar = rVar.f1572c;
                    ArrayList arrayList = (ArrayList) sVar.f232b;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        if (arrayList.get(size) != null) {
                            throw new ClassCastException();
                        }
                    }
                    Iterator it2 = ((HashMap) sVar.f233c).values().iterator();
                    while (it2.hasNext()) {
                        if (it2.next() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
                if (id2 != -1) {
                    rVar.g();
                }
                n nVar = rVar.f1582n;
                context.getClassLoader();
                nVar.a(attributeValue);
                throw null;
            }
        }
        return null;
    }
}
