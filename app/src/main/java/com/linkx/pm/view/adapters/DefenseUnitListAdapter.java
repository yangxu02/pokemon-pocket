package com.linkx.pm.view.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import com.linkx.pm.R;
import com.linkx.pm.data.models.DefenseUnit;

public class DefenseUnitListAdapter extends BindableAdapter<DefenseUnit> {
    public DefenseUnitListAdapter(Context context, List<DefenseUnit> defenseUnitList) {
        super(context, defenseUnitList);
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        Log.w("POKE", "inflate defense unit:");
        View view = inflater.inflate(R.layout.view_defense_unit, null, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return view;
    }

    private String toPercent(float value) {
        NumberFormat format = DecimalFormat.getPercentInstance();
        format.setMaximumFractionDigits(0);
        return format.format(value);
    }

    @Override
    public void bindView(DefenseUnit defenseUnit, int position, View view) {
        Log.w("POKE", "bind defense unit:" + defenseUnit.toJson());
        final ViewHolder holder = (ViewHolder) view.getTag();
        holder.defenseTypeText.setText(defenseUnit.type().name());
        holder.defenseTypeText.setBackgroundColor(defenseUnit.type().color());
        holder.defenseEffectText.setText(toPercent(defenseUnit.effect()));
    }

    static class ViewHolder {
        @Bind(R.id.defense_type)
        TextView defenseTypeText;
        @Bind(R.id.defense_effect)
        TextView defenseEffectText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
