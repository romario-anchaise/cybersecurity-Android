// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i;

import android.database.Cursor;
import i1.r;
import j1.f;
import j1.i;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import q2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f2092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f2093d;

    public e(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        abstractSet.getClass();
        this.f2090a = str;
        this.f2091b = map;
        this.f2092c = abstractSet;
        this.f2093d = abstractSet2;
    }

    public static final e a(k.c cVar, String str) {
        Map map;
        Cursor cursorE = cVar.E(new j.a(a0.a.h("PRAGMA table_info(`", str, "`)")));
        try {
            if (cursorE.getColumnCount() <= 0) {
                map = r.f2105c;
                cursorE.close();
            } else {
                int columnIndex = cursorE.getColumnIndex("name");
                int columnIndex2 = cursorE.getColumnIndex("type");
                int columnIndex3 = cursorE.getColumnIndex("notnull");
                int columnIndex4 = cursorE.getColumnIndex("pk");
                int columnIndex5 = cursorE.getColumnIndex("dflt_value");
                f fVar = new f();
                while (cursorE.moveToNext()) {
                    String string = cursorE.getString(columnIndex);
                    String string2 = cursorE.getString(columnIndex2);
                    boolean z2 = cursorE.getInt(columnIndex3) != 0;
                    int i3 = cursorE.getInt(columnIndex4);
                    String string3 = cursorE.getString(columnIndex5);
                    string.getClass();
                    string2.getClass();
                    fVar.put(string, new a(string, string2, z2, i3, string3, 2));
                }
                fVar.b();
                fVar.f2353o = true;
                if (fVar.f2350k > 0) {
                    map = fVar;
                } else {
                    map = f.f2341p;
                    map.getClass();
                }
                cursorE.close();
            }
            Cursor cursorE2 = cVar.E(new j.a(a0.a.h("PRAGMA foreign_key_list(`", str, "`)")));
            try {
                int columnIndex6 = cursorE2.getColumnIndex("id");
                int columnIndex7 = cursorE2.getColumnIndex("seq");
                int columnIndex8 = cursorE2.getColumnIndex("table");
                int columnIndex9 = cursorE2.getColumnIndex("on_delete");
                int columnIndex10 = cursorE2.getColumnIndex("on_update");
                List listJ = y.f.j(cursorE2);
                cursorE2.moveToPosition(-1);
                i iVar = new i();
                while (cursorE2.moveToNext()) {
                    if (cursorE2.getInt(columnIndex7) == 0) {
                        int i4 = cursorE2.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int i5 = columnIndex6;
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj : listJ) {
                            int i6 = columnIndex7;
                            List list = listJ;
                            if (((c) obj).f2082c == i4) {
                                arrayList3.add(obj);
                            }
                            columnIndex7 = i6;
                            listJ = list;
                        }
                        int i7 = columnIndex7;
                        List list2 = listJ;
                        int i8 = 0;
                        for (int size = arrayList3.size(); i8 < size; size = size) {
                            Object obj2 = arrayList3.get(i8);
                            i8++;
                            c cVar2 = (c) obj2;
                            arrayList.add(cVar2.f2084e);
                            arrayList2.add(cVar2.f2085f);
                        }
                        String string4 = cursorE2.getString(columnIndex8);
                        string4.getClass();
                        String string5 = cursorE2.getString(columnIndex9);
                        string5.getClass();
                        String string6 = cursorE2.getString(columnIndex10);
                        string6.getClass();
                        iVar.add(new b(string4, string5, string6, arrayList, arrayList2));
                        columnIndex6 = i5;
                        columnIndex7 = i7;
                        listJ = list2;
                    }
                }
                i iVarB = k.b(iVar);
                cursorE2.close();
                Cursor cursorE3 = cVar.E(new j.a("PRAGMA index_list(`" + str + "`)"));
                try {
                    int columnIndex11 = cursorE3.getColumnIndex("name");
                    int columnIndex12 = cursorE3.getColumnIndex("origin");
                    int columnIndex13 = cursorE3.getColumnIndex("unique");
                    i iVarB2 = null;
                    if (columnIndex11 == -1 || columnIndex12 == -1 || columnIndex13 == -1) {
                        cursorE3.close();
                    } else {
                        i iVar2 = new i();
                        while (cursorE3.moveToNext()) {
                            if ("c".equals(cursorE3.getString(columnIndex12))) {
                                String string7 = cursorE3.getString(columnIndex11);
                                boolean z3 = cursorE3.getInt(columnIndex13) == 1;
                                string7.getClass();
                                d dVarK = y.f.k(cVar, string7, z3);
                                if (dVarK == null) {
                                    cursorE3.close();
                                } else {
                                    iVar2.add(dVarK);
                                }
                            }
                        }
                        iVarB2 = k.b(iVar2);
                        cursorE3.close();
                    }
                    return new e(str, map, iVarB, iVarB2);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        y.f.c(cursorE3, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    y.f.c(cursorE2, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                y.f.c(cursorE, th5);
                throw th6;
            }
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f2090a.equals(eVar.f2090a) || !this.f2091b.equals(eVar.f2091b) || !q1.e.a(this.f2092c, eVar.f2092c)) {
            return false;
        }
        Set set2 = this.f2093d;
        if (set2 == null || (set = eVar.f2093d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.f2092c.hashCode() + ((this.f2091b.hashCode() + (this.f2090a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f2090a + "', columns=" + this.f2091b + ", foreignKeys=" + this.f2092c + ", indices=" + this.f2093d + '}';
    }
}
