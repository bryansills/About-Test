package ninja.bryansills.about;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView linkList = (RecyclerView) findViewById(R.id.link_list);
        linkList.setLayoutManager(new LinearLayoutManager(this));

        List<Link> links = new ArrayList<>();

        links.add(new Link(R.mipmap.ic_launcher_round, R.string.app_name, R.string.app_name));
        links.add(new Link(R.mipmap.ic_launcher_round, R.string.app_name, R.string.app_name));
        links.add(new Link(R.mipmap.ic_launcher_round, R.string.app_name, R.string.app_name));
        links.add(new Link(R.mipmap.ic_launcher_round, R.string.app_name, R.string.app_name));
        links.add(new Link(R.mipmap.ic_launcher_round, R.string.app_name, R.string.app_name));
        links.add(new Link(R.mipmap.ic_launcher_round, R.string.app_name, R.string.app_name));

        linkList.setAdapter(new LinkAdapter(links));

        RecyclerView contactList = (RecyclerView) findViewById(R.id.contact_list);
        contactList.setLayoutManager(new LinearLayoutManager(this));
        contactList.setAdapter(new LinkAdapter(links));
    }

    private class LinkAdapter extends RecyclerView.Adapter {

        private List<Link> links;

        public LinkAdapter(List<Link> links) {
            this.links = links;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_link, parent, false);

            return new LinkViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof LinkViewHolder) {
                LinkViewHolder.bind((LinkViewHolder) holder, links.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return links.size();
        }
    }

    private static class LinkViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView titleText, subText;

        public LinkViewHolder(View v) {
            super(v);

            imageView = (ImageView) v.findViewById(R.id.imageView);
            titleText = (TextView) v.findViewById(R.id.textView);
            subText = (TextView) v.findViewById(R.id.textView2);
        }

        public static void bind(LinkViewHolder holder, Link link) {
            holder.imageView.setImageDrawable(holder.itemView.getResources().getDrawable(link.imageRes));
            holder.titleText.setText(holder.itemView.getResources().getText(link.mainText));
            holder.subText.setText(holder.itemView.getResources().getText(link.subText));
        }
    }
}
