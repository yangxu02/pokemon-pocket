package com.linkx.pm.view.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.google.common.base.CaseFormat;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import com.squareup.picasso.Picasso;
import java.util.List;
import javax.annotation.Nullable;
import com.linkx.pm.R;
import com.linkx.pm.data.models.MaterialSource;
import com.linkx.pm.data.models.PokeDex;
import com.linkx.pm.data.models.PokemonAbility;
import com.linkx.pm.data.models.PokemonDetail;
import com.linkx.pm.data.models.PokemonType;

public class DexView extends FrameLayout {
    @Bind(R.id.dex_base_container)
    LinearLayout dexBaseContainer;
    @Bind(R.id.dex_additional_container)
    LinearLayout dexAdditionalContainer;
    @Bind(R.id.pokemon_image)
    ImageView pokemonImageView;
    @Bind(R.id.pokemon_name_text)
    TextView pokemonNameText;
    @Bind(R.id.dash_line)
    View dashLine;

    public DexView(Context context) {
        super(context);
        setup();
    }

    public DexView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public DexView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        inflate(getContext(), R.layout.view_dex, this);
        ButterKnife.bind(this);
        dashLine.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    private <T> String objectsToStr(T[] objs, Function<T, String> converter) {

        StringBuilder builder = new StringBuilder();
        for (T obj : objs) {
            String str = converter.apply(obj);
            if (Strings.isNullOrEmpty(str)) continue;
            builder.append(", ").append(str);
        }
        return builder.length() == 0 ? "" : builder.substring(2);
    }

    private <T> String objectsToStr(List<T> objs, Function<T, String> converter) {

        StringBuilder builder = new StringBuilder();
        for (T obj : objs) {
            String str = converter.apply(obj);
            if (Strings.isNullOrEmpty(str)) continue;
            builder.append(", ").append(str);
        }
        return builder.length() == 0 ? "" : builder.substring(2);
    }


    private String intsToStr(int[] ints) {
        String result = Ints.join(", ", ints);
        return result.length() == 0 ? "" : result.substring(2);
    }

    public void setDexAttr(PokemonDetail pokemonDetail) {
        PokeDex dex = pokemonDetail.dex();
        Context context = getContext();
        Picasso.with(context).load(MaterialSource.PokemonWrapper.imageUrl(pokemonDetail.snippet())).into(pokemonImageView);
        pokemonNameText.setText(pokemonDetail.snippet().name());
        dexBaseContainer.addView(new AttrView(context).setup("Japanese", "" + dex.aliasInJapanese()));
        dexBaseContainer.addView(new AttrView(context).setup("National", "" + dex.national()));
        dexBaseContainer.addView(new AttrView(context).setup("Height", "" + dex.height() + " m"));
        dexBaseContainer.addView(new AttrView(context).setup("Weight", "" + dex.weight() + " kg"));
        String type = objectsToStr(dex.type(), new Function<PokemonType, String>() {
            @Nullable
            @Override
            public String apply(@Nullable PokemonType input) {
                return null == input ? "" : CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, input.name());
            }
        });

        dexAdditionalContainer.addView(new AttrView(context).setup("Type", type));
        dexAdditionalContainer.addView(new AttrView(context).setup("Species", dex.species()));
        String abilities = objectsToStr(dex.abilities(), new Function<PokemonAbility, String>() {
            @Nullable
            @Override
            public String apply(@Nullable PokemonAbility input) {
                return null == input ? "" : input.name();
            }
        });
        dexAdditionalContainer.addView(new AttrView(context).setup("Abilities", "" + abilities));
        String locals = intsToStr(dex.locals());
        dexAdditionalContainer.addView(new AttrView(context).setup("Locals", "" + locals));
    }
}
