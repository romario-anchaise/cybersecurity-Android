// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p018k0.p;
import p018k0.y;
import p022m0.i;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0225g extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0223e f3922c = new C0223e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0224f f3923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3924b;

    public C0225g() {
        C0224f c0224f = C0224f.f3921a;
        ArrayList arrayList = new ArrayList();
        this.f3924b = arrayList;
        this.f3923a = c0224f;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (i.f3712a >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        Date dateB;
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        String strH = aVar.H();
        synchronized (this.f3924b) {
            try {
                for (DateFormat dateFormat : this.f3924b) {
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strH);
                            dateFormat.setTimeZone(timeZone);
                        } catch (Throwable th) {
                            dateFormat.setTimeZone(timeZone);
                            throw th;
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
                try {
                    dateB = p026o0.a.b(strH, new ParsePosition(0));
                } catch (ParseException e2) {
                    throw new p("Failed parsing '" + strH + "' as Date; at path " + aVar.v(true), e2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f3923a.getClass();
        return dateB;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.w();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f3924b.get(0);
        synchronized (this.f3924b) {
            str = dateFormat.format(date);
        }
        bVar.D(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.f3924b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
