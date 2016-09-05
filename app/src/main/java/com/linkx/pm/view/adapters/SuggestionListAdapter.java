package com.linkx.pm.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.List;
import com.linkx.pm.R;

public class SuggestionListAdapter extends BindableAdapter<String> {

    public SuggestionListAdapter(Context context) {
        super(context);
    }

    public void update(List<String> suggestions) {
        clear();
        addAll(suggestions);
        notifyDataSetChanged();
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        View view = inflater.inflate(R.layout.list_item_suggestion, null, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(String item, int position, View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.suggestionText.setText(item);

        // TODO
//         view.setOnClickListener(v -> {
//            Activity activity = (Activity) v.getContext();
//            PokemonProfileActivity.launch(activity, PokemonDetail.dummy(pokemonSnippet), Transition.PUSH_RIGHT_TO_LEFT);
//        });
    }

    static class ViewHolder {
        @Bind(R.id.suggestion_text)
        TextView suggestionText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
