package com.example.jangre.barcodehelp;

import java.util.ArrayList;
import java.util.List;

public final class Datas {

    public static List<FoodModel> getData(List<DeserializeModel> mDatas) {
        List<FoodModel> list = new ArrayList<>();

        for (int posPai = 0; posPai < mDatas.size(); posPai++) {
            String posicaoJogador = mDatas.get(posPai).getPosition();
            list.add(new FoodModel(posicaoJogador, "", DeserializeModel.PARENT));

            for (int posFilho = 0; posFilho < mDatas.get(posPai).getFoodName().size(); posFilho++) {
                String nomeJogador = mDatas.get(posPai).getFoodName().get(posFilho).getFood();
                String idadeJogador = mDatas.get(posPai).getFoodName().get(posFilho).getDate();
                list.add(new FoodModel(nomeJogador, idadeJogador, DeserializeModel.CHILD));
            }
        }
        return list;
    }
}
