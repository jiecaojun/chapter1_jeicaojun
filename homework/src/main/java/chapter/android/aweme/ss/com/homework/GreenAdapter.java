package chapter.android.aweme.ss.com.homework;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.security.cert.Extension;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;



public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.VIEW_HOLDER> {

    List<Message> mData;

    public GreenAdapter(List<Message> data) {

        mData=data;

    }



    @NonNull
    @Override
    public VIEW_HOLDER onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item,viewGroup,false);
        VIEW_HOLDER view_Hoder = new VIEW_HOLDER(view);
        Log.d("Text","onCreat");
        return view_Hoder;

    }



    @Override

    public void onBindViewHolder(@NonNull VIEW_HOLDER view_holder, int position) {

        Message message = mData.get(position);
        VIEW_HOLDER.updateUI(message);
    }

    @Override

    public int getItemCount() {
        return 30;
    }

    public static class VIEW_HOLDER extends RecyclerView.ViewHolder implements View.OnClickListener {

        private static TextView tv_name;
        private static TextView tv_message;
        private static TextView tv_time;
        private static chapter.android.aweme.ss.com.homework.widget.CircleImageView tv_icon;


        public VIEW_HOLDER(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView)itemView.findViewById(R.id.tv_title);
            tv_message = (TextView)itemView.findViewById(R.id.tv_description);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_icon = (chapter.android.aweme.ss.com.homework.widget.CircleImageView) itemView.findViewById(R.id.iv_avatar);
        }



        public static void updateUI(Message message) {

            tv_name.setText(message.getTitle());
            tv_message.setText(message.getDescription());
            tv_time.setText(message.getTime());
            tv_icon.setImageResource(message.getIcon());
        }



        @Override
        public void onClick(View v) {
        }
    }
}