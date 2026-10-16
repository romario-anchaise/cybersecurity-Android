// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p030q0;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import p018k0.m;
import p018k0.p;
import p018k0.y;
import p018k0.z;

/* JADX INFO: loaded from: classes.dex */
public final class b extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4019b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f4020a;

    public class a implements z {
        @Override // p018k0.z
        public final y b(m mVar, p032r0.a aVar) {
            if (aVar.f4029a == Time.class) {
                return new b(0);
            }
            return null;
        }
    }

    public /* synthetic */ b(int i2) {
        this();
    }

    @Override // p018k0.y
    public final Object a(s0.a aVar) throws IOException {
        Time time;
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        String strH = aVar.H();
        synchronized (this) {
            TimeZone timeZone = this.f4020a.getTimeZone();
            try {
                try {
                    time = new Time(this.f4020a.parse(strH).getTime());
                    this.f4020a.setTimeZone(timeZone);
                } catch (ParseException e2) {
                    throw new p("Failed parsing '" + strH + "' as SQL Time; at path " + aVar.v(true), e2);
                }
            } catch (Throwable th) {
                this.f4020a.setTimeZone(timeZone);
                throw th;
            }
        }
        return time;
    }

    @Override // p018k0.y
    public final void b(s0.b bVar, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            bVar.w();
            return;
        }
        synchronized (this) {
            str = this.f4020a.format((Date) time);
        }
        bVar.D(str);
    }

    private b() {
        this.f4020a = new SimpleDateFormat("hh:mm:ss a");
    }
}
