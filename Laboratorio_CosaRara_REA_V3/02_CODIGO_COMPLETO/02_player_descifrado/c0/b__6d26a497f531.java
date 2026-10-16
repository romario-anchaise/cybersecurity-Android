// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c0;

import android.database.Cursor;
import androidx.work.impl.WorkDatabase_Impl;
import g.k;
import java.util.ArrayList;
import p.m;
import y.g;
import y.i;
import y.j;
import y.l;
import y.o;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f397a = m.f("DiagnosticsWrkr");

    public static final String a(l lVar, r rVar, i iVar, ArrayList arrayList) {
        String str;
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            o oVar = (o) obj;
            j jVarH = m0.a.h(oVar);
            String str2 = oVar.f5999a;
            g gVarB = iVar.b(jVarH);
            Integer numValueOf = gVarB != null ? Integer.valueOf(gVarB.f5981c) : null;
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) lVar.f5991c;
            k kVarY = k.y("SELECT name FROM workname WHERE work_spec_id=?", 1);
            if (str2 == null) {
                kVarY.l(1);
            } else {
                kVarY.m(str2, 1);
            }
            workDatabase_Impl.b();
            Cursor cursorM = workDatabase_Impl.m(kVarY);
            try {
                ArrayList arrayList2 = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    arrayList2.add(cursorM.isNull(0) ? null : cursorM.getString(0));
                }
                cursorM.close();
                kVarY.z();
                String strD = i1.i.D(arrayList2, ",", null, 62);
                String strD2 = i1.i.D(rVar.c(str2), ",", null, 62);
                StringBuilder sbK = a0.a.k("\n", str2, "\t ");
                sbK.append(oVar.f6001c);
                sbK.append("\t ");
                sbK.append(numValueOf);
                sbK.append("\t ");
                switch (oVar.f6000b) {
                    case 1:
                        str = "ENQUEUED";
                        break;
                    case 2:
                        str = "RUNNING";
                        break;
                    case 3:
                        str = "SUCCEEDED";
                        break;
                    case 4:
                        str = "FAILED";
                        break;
                    case 5:
                        str = "BLOCKED";
                        break;
                    case 6:
                        str = "CANCELLED";
                        break;
                    default:
                        throw null;
                }
                sbK.append(str);
                sbK.append("\t ");
                sbK.append(strD);
                sbK.append("\t ");
                sbK.append(strD2);
                sbK.append('\t');
                sb.append(sbK.toString());
            } catch (Throwable th) {
                cursorM.close();
                kVarY.z();
                throw th;
            }
        }
        return sb.toString();
    }
}
