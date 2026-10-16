// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p015j.AbstractC0167q0;
import p015j.C0171t;
import p015j.Q0;
import p015j.g1;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f1098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f1101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f1102f;
    public Object g;

    public y(p pVar, String str, n nVar, B b2, Map map) {
        this.f1097a = 0;
        F0.i.e(pVar, "url");
        F0.i.e(str, "method");
        this.f1099c = pVar;
        this.f1098b = str;
        this.f1100d = nVar;
        this.f1101e = b2;
        this.f1102f = map;
    }

    public static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList c(Context context, int i2) {
        int iC = g1.c(context, R.attr.colorControlHighlight);
        int iB = g1.b(context, R.attr.colorButtonNormal);
        int[] iArr = g1.f3194b;
        int[] iArr2 = g1.f3196d;
        int iB2 = p033t.a.b(iC, i2);
        return new ColorStateList(new int[][]{iArr, iArr2, g1.f3195c, g1.f3198f}, new int[]{iB, iB2, p033t.a.b(iC, i2), i2});
    }

    public static LayerDrawable d(Q0 q1, Context context, int i2) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
        Drawable drawableC = q1.c(context, R.drawable.abc_star_black_48dp);
        Drawable drawableC2 = q1.c(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableC instanceof BitmapDrawable) && drawableC.getIntrinsicWidth() == dimensionPixelSize && drawableC.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableC;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableC.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableC2 instanceof BitmapDrawable) && drawableC2.getIntrinsicWidth() == dimensionPixelSize && drawableC2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableC2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableC2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void g(Drawable drawable, int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterE;
        int[] iArr = AbstractC0167q0.f3268a;
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = C0171t.f3300b;
        }
        PorterDuff.Mode mode2 = C0171t.f3300b;
        synchronized (C0171t.class) {
            porterDuffColorFilterE = Q0.e(i2, mode);
        }
        drawableMutate.setColorFilter(porterDuffColorFilterE);
    }

    public C0056c b() {
        C0056c c0056c = (C0056c) this.g;
        if (c0056c != null) {
            return c0056c;
        }
        C0056c c0056c2 = C0056c.f947n;
        C0056c c0056cL = f1.l.L((n) this.f1100d);
        this.g = c0056cL;
        return c0056cL;
    }

    public ColorStateList e(Context context, int i2) {
        if (i2 == R.drawable.abc_edit_text_material) {
            return f1.l.y(context, R.color.abc_tint_edittext);
        }
        if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
            return f1.l.y(context, R.color.abc_tint_switch_track);
        }
        if (i2 != R.drawable.abc_switch_thumb_material) {
            if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
                return c(context, g1.c(context, R.attr.colorButtonNormal));
            }
            if (i2 == R.drawable.abc_btn_borderless_material) {
                return c(context, 0);
            }
            if (i2 == R.drawable.abc_btn_colored_material) {
                return c(context, g1.c(context, R.attr.colorAccent));
            }
            if (i2 == R.drawable.abc_spinner_mtrl_am_alpha || i2 == R.drawable.abc_spinner_textfield_background_material) {
                return f1.l.y(context, R.color.abc_tint_spinner);
            }
            if (a((int[]) this.f1098b, i2)) {
                return g1.d(context, R.attr.colorControlNormal);
            }
            if (a((int[]) this.f1102f, i2)) {
                return f1.l.y(context, R.color.abc_tint_default);
            }
            if (a((int[]) this.g, i2)) {
                return f1.l.y(context, R.color.abc_tint_btn_checkable);
            }
            if (i2 == R.drawable.abc_seekbar_thumb_material) {
                return f1.l.y(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = g1.d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = g1.f3194b;
            iArr2[0] = g1.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = g1.f3197e;
            iArr2[1] = g1.c(context, R.attr.colorControlActivated);
            iArr[2] = g1.f3198f;
            iArr2[2] = g1.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = g1.f3194b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = g1.f3197e;
            iArr2[1] = g1.c(context, R.attr.colorControlActivated);
            iArr[2] = g1.f3198f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public V.a f() {
        V.a aVar = new V.a(false);
        aVar.f654f = new LinkedHashMap();
        aVar.f650b = (p) this.f1099c;
        aVar.f651c = (String) this.f1098b;
        aVar.f653e = (B) this.f1101e;
        Map map = (Map) this.f1102f;
        aVar.f654f = map.isEmpty() ? new LinkedHashMap() : p036u0.q.s(map);
        aVar.f652d = ((n) this.f1100d).c();
        return aVar;
    }

    public String toString() {
        switch (this.f1097a) {
            case 0:
                StringBuilder sb = new StringBuilder("Request{method=");
                sb.append((String) this.f1098b);
                sb.append(", url=");
                sb.append((p) this.f1099c);
                n nVar = (n) this.f1100d;
                if (nVar.size() != 0) {
                    sb.append(", headers=[");
                    Iterator it = nVar.iterator();
                    int i2 = 0;
                    while (true) {
                        F0.a aVar = (F0.a) it;
                        if (aVar.hasNext()) {
                            Object next = aVar.next();
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                throw new ArithmeticException("Index overflow has happened.");
                            }
                            p034t0.d dVar = (p034t0.d) next;
                            String str = (String) dVar.f4126a;
                            String str2 = (String) dVar.f4127b;
                            if (i2 > 0) {
                                sb.append(", ");
                            }
                            sb.append(str);
                            sb.append(':');
                            sb.append(str2);
                            i2 = i3;
                        } else {
                            sb.append(']');
                        }
                    }
                }
                Map map = (Map) this.f1102f;
                if (!map.isEmpty()) {
                    sb.append(", tags=");
                    sb.append(map);
                }
                sb.append('}');
                String string = sb.toString();
                F0.i.d(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [int[], java.io.Serializable] */
    public y() {
        this.f1097a = 2;
        this.f1099c = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
        this.f1098b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        this.f1100d = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        this.f1101e = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        this.f1102f = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        this.g = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
    }

    public y(a1.d dVar) {
        this.f1097a = 1;
        F0.i.e(dVar, "taskRunner");
        this.f1099c = dVar;
        this.g = e1.h.f2304a;
    }
}
