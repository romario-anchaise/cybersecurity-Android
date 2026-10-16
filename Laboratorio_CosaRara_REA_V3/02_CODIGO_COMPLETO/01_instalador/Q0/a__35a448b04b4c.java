// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p030q0;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import p018k0.m;
import p018k0.p;
import p018k0.y;
import p018k0.z;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public final class a extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0000a f4017b = new C0000a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f4018a;

    /* JADX INFO: renamed from: q0.a$a, reason: collision with other inner class name */
    public class C0000a implements z {
        @Override // p018k0.z
        public final y b(m mVar, p032r0.a aVar) {
            if (aVar.f4029a == Date.class) {
                return new a(0);
            }
            return null;
        }
    }

    public /* synthetic */ a(int i2) {
        this();
    }

    @Override // p018k0.y
    public final Object a(s0.a aVar) throws IOException {
        Date date;
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        String strH = aVar.H();
        synchronized (this) {
            TimeZone timeZone = this.f4018a.getTimeZone();
            try {
                try {
                    date = new Date(this.f4018a.parse(strH).getTime());
                    this.f4018a.setTimeZone(timeZone);
                } catch (ParseException e2) {
                    throw new p("Failed parsing '" + strH + "' as SQL Date; at path " + aVar.v(true), e2);
                }
            } catch (Throwable th) {
                this.f4018a.setTimeZone(timeZone);
                throw th;
            }
        }
        return date;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            bVar.w();
            return;
        }
        synchronized (this) {
            str = this.f4018a.format((java.util.Date) date);
        }
        bVar.D(str);
    }

    private a() {
        this.f4018a = new SimpleDateFormat("MMM d, yyyy");
    }
}
