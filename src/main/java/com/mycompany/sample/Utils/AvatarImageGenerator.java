package com.mycompany.sample.Utils;

import java.util.List;
import java.util.Random;

public class AvatarImageGenerator {
    private String[] imagesUrl = {
        "/bear.png",
        "/chicken.png",
        "/dog.png",
        "/meerkat.png",
        "/panda.png",
        "/rabbit.png"
    };

    public AvatarImageGenerator() {

    }

    public String getImageUrl() {
        Random random = new Random();
        int index = random.nextInt(imagesUrl.length);
        return imagesUrl[index];
    }

    public List<String> getImageList() {
        return java.util.Arrays.asList(imagesUrl);
    }
}