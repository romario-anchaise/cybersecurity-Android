// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class z extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f253b;

    public z(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f253b = new ArrayList();
        p028p0.a.a(cls, "watcherClass cannot be null");
        this.f252a = cls;
    }

    public final void a() {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f253b;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((y) arrayList.get(i2)).f251b.incrementAndGet();
            i2++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f253b;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((y) arrayList.get(i2)).onTextChanged(this, 0, length(), length());
            i2++;
        }
    }

    public final y c(Object obj) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f253b;
            if (i2 >= arrayList.size()) {
                return null;
            }
            y yVar = (y) arrayList.get(i2);
            if (yVar.f250a == obj) {
                return yVar;
            }
            i2++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            if (this.f252a == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    public final void e() {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f253b;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((y) arrayList.get(i2)).f251b.decrementAndGet();
            i2++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        y yVarC;
        if (d(obj) && (yVarC = c(obj)) != null) {
            obj = yVarC;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        y yVarC;
        if (d(obj) && (yVarC = c(obj)) != null) {
            obj = yVarC;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        y yVarC;
        if (d(obj) && (yVarC = c(obj)) != null) {
            obj = yVarC;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i2, int i3, Class cls) {
        if (this.f252a != cls) {
            return super.getSpans(i2, i3, cls);
        }
        y[] yVarArr = (y[]) super.getSpans(i2, i3, y.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, yVarArr.length);
        for (int i4 = 0; i4 < yVarArr.length; i4++) {
            objArr[i4] = yVarArr[i4].f250a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i2, int i3, Class cls) {
        if (cls == null || this.f252a == cls) {
            cls = y.class;
        }
        return super.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        y yVarC;
        if (d(obj)) {
            yVarC = c(obj);
            if (yVarC != null) {
                obj = yVarC;
            }
        } else {
            yVarC = null;
        }
        super.removeSpan(obj);
        if (yVarC != null) {
            this.f253b.remove(yVarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i2, int i3, CharSequence charSequence) {
        replace(i2, i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i2, int i3, int i4) {
        if (d(obj)) {
            y yVar = new y(obj);
            this.f253b.add(yVar);
            obj = yVar;
        }
        super.setSpan(obj, i2, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        return new z(this.f252a, this, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        replace(i2, i3, charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence) {
        a();
        super.replace(i2, i3, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    public z(Class cls, z zVar, int i2, int i3) {
        super(zVar, i2, i3);
        this.f253b = new ArrayList();
        p028p0.a.a(cls, "watcherClass cannot be null");
        this.f252a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        a();
        super.replace(i2, i3, charSequence, i4, i5);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i2) {
        super.append(charSequence, obj, i2);
        return this;
    }
}
