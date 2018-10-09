package zendeskigorlibrary.ie.screens.listoftickets.viewadapt;

/*** Created by igor on 03/06/2017. ***/
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import zendeskigorlibrary.ie.R;
import zendeskigorlibrary.ie.model.TicketsResults;
import zendeskigorlibrary.ie.util.UtilReduceStr;

public final class ZendeskListViewAdapter extends RecyclerView.Adapter<ZendeskListViewAdapter.ViewHolder> {

    private static final String NEW_TICKET_STR = "new";
    private static final String OPEN_TICKET_STR = "open";
    private static final String PENDING_TICKET_STR = "pending";

    private final TicketsResults ticketsResults;
    private final Context mContext;

    public ZendeskListViewAdapter(@NonNull TicketsResults ticketsResults, Context context) {
        this.ticketsResults = ticketsResults;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_cell_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        switch (this.ticketsResults.getResults().get(position).getStatus()) {
            case NEW_TICKET_STR:
                holder.statusTextV.setBackgroundColor(Color.parseColor(mContext.getResources().getString(R.string.NEW_TICKET_COLOR ) ));
                holder.statusTextV.setText(mContext.getResources().getString(R.string.SET_CHAR_AS_NEW));
                break;
            case OPEN_TICKET_STR:
                holder.statusTextV.setBackgroundColor(Color.parseColor(mContext.getResources().getString(R.string.OPEN_TICKET_COLOR)));
                holder.statusTextV.setText(mContext.getResources().getString(R.string.SET_CHAR_AS_OPEN));
                break;
            case PENDING_TICKET_STR:
                holder.statusTextV.setBackgroundColor(Color.parseColor(mContext.getResources().getString(R.string.PENDING_TICKET_COLOR)));
                holder.statusTextV.setText(mContext.getResources().getString(R.string.SET_CHAR_AS_PENDING));
                break;
        }

        holder.idTextV.setText("#" + String.valueOf(this.ticketsResults.getResults().get(position).getId()));
        holder.subjectTextV.setText(UtilReduceStr.reduceStr(this.ticketsResults.getResults().get(position).getSubject(), 14, 11));
        holder.descriptionTextV.setText(UtilReduceStr.reduceStr(this.ticketsResults.getResults().get(position).getDescription(), 23, 20));
    }

    @Override
    public int getItemCount() {
        return this.ticketsResults.getResults().size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView statusTextV, idTextV, subjectTextV, descriptionTextV;

        protected ViewHolder(View view) {
            super(view);
            statusTextV = (TextView) view.findViewById(R.id.statusTextV);
            idTextV = (TextView) view.findViewById(R.id.idTextV);
            subjectTextV = (TextView) view.findViewById(R.id.subjectTextV);
            descriptionTextV = (TextView) view.findViewById(R.id.descriptionTextV);
        }

    }
}