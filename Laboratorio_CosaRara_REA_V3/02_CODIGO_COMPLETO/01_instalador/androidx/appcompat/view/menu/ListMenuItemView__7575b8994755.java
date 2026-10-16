// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.view.menu;

import A.G;
import A.X;
import C.h;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.WeakHashMap;
import p007e.a;
import p013i.B;
import p013i.n;
import p013i.p;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements B, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f1281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f1282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f1283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f1284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CheckBox f1285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f1286f;
    public ImageView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f1287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f1288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Drawable f1289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f1290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f1291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Drawable f1293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f1294o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f1295p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1296q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h hVarP = h.p(getContext(), attributeSet, a.f2242r, R.attr.listMenuViewStyle);
        this.f1289j = hVarP.l(5);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        this.f1290k = typedArray.getResourceId(1, -1);
        this.f1292m = typedArray.getBoolean(7, false);
        this.f1291l = context;
        this.f1293n = hVarP.l(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f1294o = typedArrayObtainStyledAttributes.hasValue(0);
        hVarP.r();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f1295p == null) {
            this.f1295p = LayoutInflater.from(getContext());
        }
        return this.f1295p;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1287h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1287h.getLayoutParams();
        rect.top = this.f1287h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    @Override // p013i.B
    public final void c(p pVar) {
        boolean z2;
        int i2;
        String string;
        boolean z3;
        this.f1281a = pVar;
        setVisibility(pVar.isVisible() ? 0 : 8);
        setTitle(pVar.f2964e);
        setCheckable(pVar.isCheckable());
        if (pVar.f2972n.o()) {
            if ((pVar.f2972n.n() ? pVar.f2968j : pVar.f2966h) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        pVar.f2972n.n();
        if (z2) {
            p pVar2 = this.f1281a;
            if (pVar2.f2972n.o()) {
                if ((pVar2.f2972n.n() ? pVar2.f2968j : pVar2.f2966h) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
            i2 = z3 ? 0 : 8;
        }
        if (i2 == 0) {
            TextView textView = this.f1286f;
            p pVar3 = this.f1281a;
            char c2 = pVar3.f2972n.n() ? pVar3.f2968j : pVar3.f2966h;
            if (c2 == 0) {
                string = "";
            } else {
                n nVar = pVar3.f2972n;
                Resources resources = nVar.f2931a.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(nVar.f2931a).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i3 = nVar.n() ? pVar3.f2969k : pVar3.f2967i;
                p.c(sb, i3, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                p.c(sb, i3, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                p.c(sb, i3, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                p.c(sb, i3, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                p.c(sb, i3, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                p.c(sb, i3, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (c2 == '\b') {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (c2 == '\n') {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (c2 != ' ') {
                    sb.append(c2);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                string = sb.toString();
            }
            textView.setText(string);
        }
        if (this.f1286f.getVisibility() != i2) {
            this.f1286f.setVisibility(i2);
        }
        setIcon(pVar.getIcon());
        setEnabled(pVar.isEnabled());
        setSubMenuArrowVisible(pVar.hasSubMenu());
        setContentDescription(pVar.f2975q);
    }

    @Override // p013i.B
    public p getItemData() {
        return this.f1281a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = X.f14a;
        G.q(this, this.f1289j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f1284d = textView;
        int i2 = this.f1290k;
        if (i2 != -1) {
            textView.setTextAppearance(this.f1291l, i2);
        }
        this.f1286f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1293n);
        }
        this.f1287h = (ImageView) findViewById(R.id.group_divider);
        this.f1288i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        if (this.f1282b != null && this.f1292m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1282b.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        View view;
        if (!z2 && this.f1283c == null && this.f1285e == null) {
            return;
        }
        if ((this.f1281a.f2982x & 4) != 0) {
            if (this.f1283c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f1283c = radioButton;
                LinearLayout linearLayout = this.f1288i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f1283c;
            view = this.f1285e;
        } else {
            if (this.f1285e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f1285e = checkBox;
                LinearLayout linearLayout2 = this.f1288i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f1285e;
            view = this.f1283c;
        }
        if (z2) {
            compoundButton.setChecked(this.f1281a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f1285e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f1283c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if ((this.f1281a.f2982x & 4) != 0) {
            if (this.f1283c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f1283c = radioButton;
                LinearLayout linearLayout = this.f1288i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f1283c;
        } else {
            if (this.f1285e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f1285e = checkBox;
                LinearLayout linearLayout2 = this.f1288i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f1285e;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f1296q = z2;
        this.f1292m = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.f1287h;
        if (imageView != null) {
            imageView.setVisibility((this.f1294o || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1281a.f2972n.getClass();
        boolean z2 = this.f1296q;
        if (z2 || this.f1292m) {
            ImageView imageView = this.f1282b;
            if (imageView == null && drawable == null && !this.f1292m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f1282b = imageView2;
                LinearLayout linearLayout = this.f1288i;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f1292m) {
                this.f1282b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f1282b;
            if (!z2) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f1282b.getVisibility() != 0) {
                this.f1282b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1284d.getVisibility() != 8) {
                this.f1284d.setVisibility(8);
            }
        } else {
            this.f1284d.setText(charSequence);
            if (this.f1284d.getVisibility() != 0) {
                this.f1284d.setVisibility(0);
            }
        }
    }
}
