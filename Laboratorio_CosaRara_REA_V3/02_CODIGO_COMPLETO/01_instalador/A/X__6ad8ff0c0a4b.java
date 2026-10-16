// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p015j.C0175v;

/* JADX INFO: loaded from: classes.dex */
public abstract class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap f14a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f15b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f16c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final B f17d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final D f18e;

    static {
        new AtomicInteger(1);
        f14a = null;
        f16c = false;
        f17d = new B();
        f18e = new D();
    }

    public static h0 a(View view) {
        if (f14a == null) {
            f14a = new WeakHashMap();
        }
        h0 h0Var = (h0) f14a.get(view);
        if (h0Var != null) {
            return h0Var;
        }
        h0 h0Var2 = new h0(view);
        f14a.put(view, h0Var2);
        return h0Var2;
    }

    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = W.f10d;
        W w2 = (W) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (w2 == null) {
            w2 = new W();
            w2.f11a = null;
            w2.f12b = null;
            w2.f13c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, w2);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = w2.f11a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = W.f10d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (w2.f11a == null) {
                            w2.f11a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = W.f10d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                w2.f11a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    w2.f11a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        View viewA = w2.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (w2.f12b == null) {
                    w2.f12b = new SparseArray();
                }
                w2.f12b.put(keyCode, new WeakReference(viewA));
            }
        }
        return viewA != null;
    }

    public static View.AccessibilityDelegate c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Q.a(view);
        }
        if (f16c) {
            return null;
        }
        if (f15b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f15b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f16c = true;
                return null;
            }
        }
        try {
            Object obj = f15b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f16c = true;
            return null;
        }
    }

    public static String[] d(C0175v c0175v) {
        return Build.VERSION.SDK_INT >= 31 ? T.a(c0175v) : (String[]) c0175v.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void e(View view, int i2) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i3 = Build.VERSION.SDK_INT;
            Object objB = null;
            if (i3 >= 28) {
                tag = P.b(view);
            } else {
                tag = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z2 = ((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (I.a(view) != 0 || z2) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : 2048);
                I.g(accessibilityEventObtain, i2);
                if (z2) {
                    List<CharSequence> text = accessibilityEventObtain.getText();
                    if (i3 >= 28) {
                        objB = P.b(view);
                    } else {
                        Object tag2 = view.getTag(R.id.tag_accessibility_pane_title);
                        if (CharSequence.class.isInstance(tag2)) {
                            objB = tag2;
                        }
                    }
                    text.add((CharSequence) objB);
                    if (G.c(view) == 0) {
                        G.s(view, 1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 != 32) {
                if (view.getParent() != null) {
                    try {
                        I.e(view.getParent(), view, view, i2);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            I.g(accessibilityEventObtain2, i2);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            List<CharSequence> text2 = accessibilityEventObtain2.getText();
            if (i3 >= 28) {
                objB = P.b(view);
            } else {
                Object tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                if (CharSequence.class.isInstance(tag3)) {
                    objB = tag3;
                }
            }
            text2.add((CharSequence) objB);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0009i f(View view, C0009i c0009i) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0009i + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return T.b(view, c0009i);
        }
        InterfaceC0025z interfaceC0025z = (InterfaceC0025z) view.getTag(R.id.tag_on_receive_content_listener);
        A a2 = f17d;
        if (interfaceC0025z == null) {
            if (view instanceof A) {
                a2 = (A) view;
            }
            return a2.a(c0009i);
        }
        C0009i c0009iA = ((D.w) interfaceC0025z).a(view, c0009i);
        if (c0009iA == null) {
            return null;
        }
        if (view instanceof A) {
            a2 = (A) view;
        }
        return a2.a(c0009iA);
    }

    public static void g(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Q.d(view, context, iArr, attributeSet, typedArray, i2, 0);
        }
    }

    public static void h(View view, C0003c c0003c) {
        if (c0003c == null && (c(view) instanceof C0001a)) {
            c0003c = new C0003c();
        }
        if (G.c(view) == 0) {
            G.s(view, 1);
        }
        view.setAccessibilityDelegate(c0003c == null ? null : c0003c.f29b);
    }

    public static void i(View view, CharSequence charSequence) {
        new C(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).d(view, charSequence);
        D d2 = f18e;
        if (charSequence == null) {
            d2.f1a.remove(view);
            view.removeOnAttachStateChangeListener(d2);
            G.o(view.getViewTreeObserver(), d2);
        } else {
            d2.f1a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(d2);
            if (I.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(d2);
            }
        }
    }
}
