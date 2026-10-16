// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1522f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f1525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f1527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f1528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f1529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final s f1531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1532q;

    public a(s sVar) {
        n nVar = sVar.f1582n;
        g gVar = sVar.f1580l;
        if (gVar != null) {
            gVar.f1548a.getClassLoader();
        }
        this.f1517a = new ArrayList();
        this.f1530o = false;
        this.f1532q = -1;
        this.f1531p = sVar;
    }

    public final void a(int i2) {
        if (this.g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            ArrayList arrayList = this.f1517a;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((w) arrayList.get(i3)).getClass();
            }
        }
    }

    public final void b(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1523h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1532q);
            printWriter.print(" mCommitted=");
            printWriter.println(false);
            if (this.f1522f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1522f));
            }
            if (this.f1518b != 0 || this.f1519c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1518b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1519c));
            }
            if (this.f1520d != 0 || this.f1521e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1520d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1521e));
            }
            if (this.f1524i != 0 || this.f1525j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1524i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1525j);
            }
            if (this.f1526k != 0 || this.f1527l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1526k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1527l);
            }
        }
        ArrayList arrayList = this.f1517a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = (w) arrayList.get(i2);
            switch (wVar.f1617a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + wVar.f1617a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println((Object) null);
            if (z2) {
                if (wVar.f1618b != 0 || wVar.f1619c != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(wVar.f1618b));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(wVar.f1619c));
                }
                if (wVar.f1620d != 0 || wVar.f1621e != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(wVar.f1620d));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(wVar.f1621e));
                }
            }
        }
    }

    public final void c(ArrayList arrayList, ArrayList arrayList2) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.g) {
            s sVar = this.f1531p;
            if (sVar.f1573d == null) {
                sVar.f1573d = new ArrayList();
            }
            sVar.f1573d.add(this);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1532q >= 0) {
            sb.append(" #");
            sb.append(this.f1532q);
        }
        if (this.f1523h != null) {
            sb.append(" ");
            sb.append(this.f1523h);
        }
        sb.append("}");
        return sb.toString();
    }
}
