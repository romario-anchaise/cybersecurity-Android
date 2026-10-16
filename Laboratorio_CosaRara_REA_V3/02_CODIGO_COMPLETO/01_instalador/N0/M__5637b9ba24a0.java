// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class M extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        aVar.f();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (aVar.J() != 4) {
            String strD = aVar.D();
            int iB = aVar.B();
            strD.getClass();
            switch (strD) {
                case "dayOfMonth":
                    i4 = iB;
                    break;
                case "minute":
                    i6 = iB;
                    break;
                case "second":
                    i7 = iB;
                    break;
                case "year":
                    i2 = iB;
                    break;
                case "month":
                    i3 = iB;
                    break;
                case "hourOfDay":
                    i5 = iB;
                    break;
            }
        }
        aVar.t();
        return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (calendar == null) {
            bVar.w();
            return;
        }
        bVar.j();
        bVar.u("year");
        bVar.B(calendar.get(1));
        bVar.u("month");
        bVar.B(calendar.get(2));
        bVar.u("dayOfMonth");
        bVar.B(calendar.get(5));
        bVar.u("hourOfDay");
        bVar.B(calendar.get(11));
        bVar.u("minute");
        bVar.B(calendar.get(12));
        bVar.u("second");
        bVar.B(calendar.get(13));
        bVar.t();
    }
}
