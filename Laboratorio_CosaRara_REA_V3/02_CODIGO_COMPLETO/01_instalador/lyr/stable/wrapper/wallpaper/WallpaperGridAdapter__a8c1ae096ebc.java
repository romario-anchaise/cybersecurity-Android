// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.wallpaper;

import V.k;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.F;
import androidx.recyclerview.widget.c0;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.ArrayList;
import java.util.List;
import p010f0.h;

/* JADX INFO: loaded from: classes.dex */
final class WallpaperGridAdapter extends F {
    private final List<WallpaperItem> items = new ArrayList();
    private final Listener listener;

    public static final class Holder extends c0 {
        private final TextView caption;
        private final ImageView image;

        public Holder(View view) {
            super(view);
            this.image = (ImageView) view.findViewById(R.id.wallpaperThumb);
            this.caption = (TextView) view.findViewById(R.id.wallpaperCaption);
        }

        public void bind(final WallpaperItem wallpaperItem, final Listener listener) {
            this.caption.setText(wallpaperItem.title);
            V.f fVarImageLoader = WallpaperClient.get(this.itemView.getContext()).imageLoader();
            h hVar = new h(this.itemView.getContext());
            hVar.f2625c = wallpaperItem.thumbUrl;
            hVar.f2632k = Integer.valueOf(R.drawable.bg_wallpaper_placeholder);
            hVar.f2633l = Integer.valueOf(R.drawable.bg_wallpaper_placeholder);
            hVar.f2626d = new p012h0.a(this.image);
            hVar.f2634m = null;
            hVar.f2635n = null;
            hVar.f2636o = null;
            ((k) fVarImageLoader).b(hVar.a());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: lyr.stable.wrapper.wallpaper.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    listener.onWallpaperClick(wallpaperItem);
                }
            });
        }
    }

    public interface Listener {
        void onWallpaperClick(WallpaperItem wallpaperItem);
    }

    public WallpaperGridAdapter(Listener listener) {
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.F
    public int getItemCount() {
        return this.items.size();
    }

    public void submit(List<WallpaperItem> list) {
        this.items.clear();
        if (list != null) {
            this.items.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.F
    public void onBindViewHolder(Holder holder, int i2) {
        holder.bind(this.items.get(i2), this.listener);
    }

    @Override // androidx.recyclerview.widget.F
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wallpaper, viewGroup, false));
    }
}
