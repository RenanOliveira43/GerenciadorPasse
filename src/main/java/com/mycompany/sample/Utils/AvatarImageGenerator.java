package com.mycompany.sample.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvatarImageGenerator {
    private List<String> imagesUrl;

    public AvatarImageGenerator() {
        imagesUrl = new ArrayList<>();
        imagesUrl.add("/bear.png");
        imagesUrl.add("/chicken.png");
        imagesUrl.add("/dog.png");
        imagesUrl.add("/meerkat.png");
        imagesUrl.add("/panda.png");
        imagesUrl.add("/rabbit.png");

        Collections.shuffle(imagesUrl);
    }

    public String getImageUrl() {
        if (imagesUrl.isEmpty()) {
            throw new IllegalStateException("No more images available");
        }
        
        return imagesUrl.remove(0);
    }

    public List<String> getImageList() {
        return imagesUrl;
    }
}
