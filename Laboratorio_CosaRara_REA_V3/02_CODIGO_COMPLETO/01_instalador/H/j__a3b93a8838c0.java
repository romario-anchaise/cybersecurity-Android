// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p011h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import f1.l;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import p007e.a;
import p013i.n;
import p013i.q;
import p015j.AbstractC0167q0;

/* JADX INFO: loaded from: classes.dex */
public final class j extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class[] f2824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f2825f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f2826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f2827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2829d;

    static {
        Class[] clsArr = {Context.class};
        f2824e = clsArr;
        f2825f = clsArr;
    }

    public j(Context context) {
        super(context);
        this.f2828c = context;
        Object[] objArr = {context};
        this.f2826a = objArr;
        this.f2827b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [h.j] */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        ?? r4;
        int i2;
        ?? r6;
        ColorStateList colorStateList;
        int resourceId;
        i iVar = new i(this, menu);
        int eventType = xmlResourceParser.getEventType();
        do {
            r4 = 1;
            i2 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
                break;
            }
            eventType = xmlResourceParser.next();
        } while (eventType != 1);
        boolean z2 = false;
        boolean z3 = false;
        String str = null;
        while (!z2) {
            if (eventType == r4) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType == i2) {
                if (!z3) {
                    String name2 = xmlResourceParser.getName();
                    boolean zEquals = name2.equals("group");
                    j jVar = iVar.f2798E;
                    if (zEquals) {
                        ?? ObtainStyledAttributes = jVar.f2828c.obtainStyledAttributes(attributeSet, a.f2240p);
                        iVar.f2800b = ObtainStyledAttributes.getResourceId(r4, 0);
                        iVar.f2801c = ObtainStyledAttributes.getInt(3, 0);
                        iVar.f2802d = ObtainStyledAttributes.getInt(4, 0);
                        iVar.f2803e = ObtainStyledAttributes.getInt(5, 0);
                        iVar.f2804f = ObtainStyledAttributes.getBoolean(2, r4);
                        iVar.g = ObtainStyledAttributes.getBoolean(0, r4);
                        ObtainStyledAttributes.recycle();
                    } else if (name2.equals("item")) {
                        Context context = jVar.f2828c;
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f2241q);
                        iVar.f2806i = typedArrayObtainStyledAttributes.getResourceId(2, 0);
                        iVar.f2807j = (typedArrayObtainStyledAttributes.getInt(5, iVar.f2801c) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(6, iVar.f2802d) & 65535);
                        iVar.f2808k = typedArrayObtainStyledAttributes.getText(7);
                        iVar.f2809l = typedArrayObtainStyledAttributes.getText(8);
                        iVar.f2810m = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                        String string = typedArrayObtainStyledAttributes.getString(9);
                        iVar.f2811n = string == null ? (char) 0 : string.charAt(0);
                        iVar.f2812o = typedArrayObtainStyledAttributes.getInt(16, 4096);
                        String string2 = typedArrayObtainStyledAttributes.getString(10);
                        iVar.f2813p = string2 == null ? (char) 0 : string2.charAt(0);
                        iVar.f2814q = typedArrayObtainStyledAttributes.getInt(20, 4096);
                        if (typedArrayObtainStyledAttributes.hasValue(11)) {
                            iVar.f2815r = typedArrayObtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
                        } else {
                            iVar.f2815r = iVar.f2803e;
                        }
                        iVar.f2816s = typedArrayObtainStyledAttributes.getBoolean(3, false);
                        iVar.f2817t = typedArrayObtainStyledAttributes.getBoolean(4, iVar.f2804f);
                        iVar.f2818u = typedArrayObtainStyledAttributes.getBoolean(1, iVar.g);
                        iVar.f2819v = typedArrayObtainStyledAttributes.getInt(21, -1);
                        iVar.f2822y = typedArrayObtainStyledAttributes.getString(12);
                        iVar.f2820w = typedArrayObtainStyledAttributes.getResourceId(13, 0);
                        iVar.f2821x = typedArrayObtainStyledAttributes.getString(15);
                        String string3 = typedArrayObtainStyledAttributes.getString(14);
                        boolean z4 = string3 != null;
                        if (z4 && iVar.f2820w == 0 && iVar.f2821x == null) {
                            iVar.f2823z = (q) iVar.a(string3, f2825f, jVar.f2827b);
                        } else {
                            if (z4) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            iVar.f2823z = null;
                        }
                        iVar.f2794A = typedArrayObtainStyledAttributes.getText(17);
                        iVar.f2795B = typedArrayObtainStyledAttributes.getText(22);
                        if (typedArrayObtainStyledAttributes.hasValue(19)) {
                            iVar.f2797D = AbstractC0167q0.b(typedArrayObtainStyledAttributes.getInt(19, -1), iVar.f2797D);
                        } else {
                            iVar.f2797D = null;
                        }
                        if (typedArrayObtainStyledAttributes.hasValue(18)) {
                            if (!typedArrayObtainStyledAttributes.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(18, 0)) == 0 || (colorStateList = l.y(context, resourceId)) == null) {
                                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(18);
                            }
                            iVar.f2796C = colorStateList;
                        } else {
                            iVar.f2796C = null;
                        }
                        typedArrayObtainStyledAttributes.recycle();
                        iVar.f2805h = false;
                        r6 = 1;
                    } else if (name2.equals("menu")) {
                        r6 = 1;
                        iVar.f2805h = true;
                        SubMenu subMenuAddSubMenu = iVar.f2799a.addSubMenu(iVar.f2800b, iVar.f2806i, iVar.f2807j, iVar.f2808k);
                        iVar.b(subMenuAddSubMenu.getItem());
                        b(xmlResourceParser, attributeSet, subMenuAddSubMenu);
                    } else {
                        r6 = 1;
                        str = name2;
                        z3 = true;
                    }
                }
                r6 = r4;
                z2 = z2;
            } else if (eventType != 3) {
                r6 = r4;
                z2 = z2;
            } else {
                String name3 = xmlResourceParser.getName();
                if (z3 && name3.equals(str)) {
                    r6 = r4;
                    z3 = false;
                    str = null;
                } else {
                    if (name3.equals("group")) {
                        iVar.f2800b = 0;
                        iVar.f2801c = 0;
                        iVar.f2802d = 0;
                        iVar.f2803e = 0;
                        iVar.f2804f = r4;
                        iVar.g = r4;
                    } else if (name3.equals("item")) {
                        if (!iVar.f2805h) {
                            q qVar = iVar.f2823z;
                            if (qVar == null || !qVar.f2985a.hasSubMenu()) {
                                iVar.f2805h = r4;
                                iVar.b(iVar.f2799a.add(iVar.f2800b, iVar.f2806i, iVar.f2807j, iVar.f2808k));
                            } else {
                                iVar.f2805h = r4;
                                iVar.b(iVar.f2799a.addSubMenu(iVar.f2800b, iVar.f2806i, iVar.f2807j, iVar.f2808k).getItem());
                            }
                        }
                    } else if (name3.equals("menu")) {
                        ?? r7 = r4;
                        z2 = r7 == true ? 1 : 0;
                        r6 = r7;
                    }
                    r6 = r4;
                    z2 = z2;
                }
            }
            eventType = xmlResourceParser.next();
            r4 = r6;
            i2 = 2;
            z2 = z2;
            z3 = z3;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i2, Menu menu) {
        if (!(menu instanceof n)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f2828c.getResources().getLayout(i2);
                    b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
