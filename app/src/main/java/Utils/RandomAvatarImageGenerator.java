package Utils;

import java.util.Random;

public class RandomAvatarImageGenerator {
    private String[] imagesUrl = {"/bear.png", "/chicken.png", "/dog.png", "/meerkat.png", "/panda.png", "/rabbit.png"};
    private String imageUrl;

    public RandomAvatarImageGenerator() {
        Random ran = new Random();
        int idx = ran.nextInt(6);

        this.imageUrl = imagesUrl[idx];
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
